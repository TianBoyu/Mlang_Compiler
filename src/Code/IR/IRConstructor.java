package Code.IR;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Name;
import Code.AST.Tools.UnaryOp;
import Code.AST.Type.*;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.*;
import Code.IR.Type.Array;
import Code.IR.Type.BuiltIn;
import Code.IR.Type.Class;
import Code.IR.Type.IRType;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO
/*
 * OrExprNode(just like AndExpr)
 * Class(This
 */

public class IRConstructor implements IRTraversal
{
    private IRInstruction   currentInst;
    private IRInstruction   initializeGlobalInst;
    private Label           currentLabel;
    private IRScope         currentIRScope;
    private FunctionScope   currentFunction;
    private ClassDecNode    currentClass;
    private boolean isHeapAllocate = false;

    private boolean isInitializeInst = false;

    private boolean isVarForCond = false;
    private Label nextTrueLabel;
    private Label nextFalseLabel;
    private Label nextJumpLabel;
    private Stack<Label> trueLabelStack = new Stack<>();
    private Stack<Label> falseLabelStack = new Stack<>();
    private Stack<Label> jumpLabelStack = new Stack<>();

//    private boolean isReturned = false;
//    private Address addressForCond;
//    private boolean isVarForFond;

    private IRInstruction entry;
    private IRInstruction initializeEntry;
    private ProgNode program;
    private List<Class> types = new ArrayList<>();
    private DataSection dataSection = new DataSection();
    private DataSection dataZone = new DataSection();
    private DataSection bssZone = new DataSection();
    private List<Name> globalName = new ArrayList<>();

    public IRConstructor(ProgNode progNode)
    {
        this.program = progNode;
        Label globalLabel = new Label("GLOBAL");
        currentFunction = new FunctionScope(Name.getName("GLOBAL"));
        currentLabel = globalLabel;
        setTrueLabel(globalLabel);
        setFalseLabel(globalLabel);
        setJumpLabel(globalLabel);
    }

    public IRInstruction getEntry()
    {
        return entry;
    }

    public IRInstruction getInitializeEntry()
    {
        return initializeEntry;
    }

    public List<Class> getTypes()
    {
        return types;
    }

    public DataSection getDataSection()
    {
        return dataSection;
    }

    public DataSection getDataZone()
    {
        return dataZone;
    }

    public DataSection getBssZone()
    {
        return bssZone;
    }

    public List<Name> getGlobalName()
    {
        return globalName;
    }

    public void BuildIR()
    {
        visit(program);
    }

    @Override
    public void visit(ProgNode node)
    {
        setIRScope(node.getScope().getIRScope());
        for(Name name : node.getScope().getScopeNodes().keySet())
        {
            if(!node.getScope().getScopeNodes().get(name).isBuiltIn())
                globalName.add(name);
        }
        for(DeclNode item : node.getDeclares())
        {
            if(item instanceof VarDecNode)
            {
                addGlobalVariable((VarDecNode) item);
                continue;
            }
            visit(item);
            if(item instanceof FuncDecNode)
            {
                if(((FuncDecNode) item).getReturnType().getTypeName() == Name.getName("void"))
                {
                    addInst(new Return(currentLabel, null));
                }
            }
        }
    }

    private void addGlobalVariable(VarDecNode node)
    {
        //only support int and one-dim array now
        Address address = new Address(node.getName(), true);
        if(node.getValue() == null) //bssZone
        {
            bssZone.addData(node.getName().toString(), null);
        }
        else //dataZone
        {
            if(node.getType() instanceof BuiltInType)
            {
                Immediate value = (Immediate) visit(node.getValue());
                dataZone.addData(node.getName().toString(), String.valueOf(value.getValue()), "dq");
            }
            else// if(node.getType() instanceof ArrayType or ClassType
            {
                isHeapAllocate = true;
                isInitializeInst = true;
//                address = new Address(node.getName(), true);
//                addInst(new Malloc(currentLabel, new Immediate(8), address));
                IntegerValue value = visit(node.getValue());
                addInst(new MemCopy(currentLabel, (Address) value, address));
                bssZone.addData(node.getName().toString(), null);
                isInitializeInst = false;
                isHeapAllocate = false;
                address.setPointer(true);
            }

        }
        currentIRScope.addAddress(node.getName(), address);
    }

    @Override
    public IRInstruction visit(DeclNode node)
    {
        if(node == null) return null;
        return node.accept(this);
    }

    @Override
    public IRInstruction visit(ClassDecNode node)
    {
        currentClass = node;
        Class classType = new Class(node.getName());
        if(node == null) return null;
        for(FuncDecNode item : node.getMemberFunction())
            visit(item);
        for(VarDecNode item : node.getMemberVarible())
        {
//            visit(item);
            classType.addContainType(convertType(item.getType()));
        }
        addType(classType);
        currentClass = null;
        return null;
    }

    @Override
    public Function visit(FuncDecNode node)
    {
        IRType type = visit(node.getReturnType());
        List<Parameter> params = new ArrayList<>();
        setIRScope(node.getInternalScope().getIRScope());
        currentFunction = new FunctionScope(node.getName());
        currentFunction.setFuncDecNode(node);
        if(currentClass != null)
            params.add(new Parameter(new Class(currentClass.getName()), Name.getName("null") ,
                    new Address(Name.getName("null"), new BuiltIn()), true));
        for(FuncParamNode item : node.getParameter())
        {
            Address address = new Address(item.getName(), convertType(item.getType()));
            currentFunction.increSlotNumber();
            params.add(new Parameter(convertType(item.getType()), item.getName(), address));
            currentIRScope.addAddress(item.getName(), address);
        }
        Name name = FunctionRename(node.getName());
//        visitFormalParameter(node.getParameter());
        Function function = new Function(currentLabel, name, type, params, 0);
        addInst(function);
        visit(node.getBlock());
        exitIRScope();
        function.setUsedSlotNumber(currentFunction.getUsedSlotNumber());
        return null;
    }

    private Name FunctionRename(Name origin_name)
    {
        Name new_name = currentClass == null? origin_name :
                Name.getName("__" + currentClass.getName().toString() + "__" + origin_name.toString());
        return new_name;
    }

//    private void visitFormalParameter(List<FuncParamNode> parameters)
//    {
//        int i = 0;
//        for(FuncParamNode node : parameters)
//        {
//            Address address = new Address(Name.getName("_para_" + node.getName().toString()),
//                                          convertType(node.getType()));
//            address.setParamPosition(i++);
//            currentIRScope.addAddress(node.getName(), address);
//        }
//    }

    @Override
    public Address visit(VarDecNode node)
    {
        IRType irType = convertType(node.getType());
        Address address = new Address(node.getName(), irType);
        addInst(new Alloca(currentLabel, address, irType));
        currentFunction.increSlotNumber();

        currentIRScope.addAddress(node.getName(), address);
        if(node.getValue() != null)
        {
            if(isCondition(node.getValue()))
            {
                isVarForCond = true;
                Label trueLabel = new Label(null);
                Label falseLabel = new Label(null);
                Label endLabel = new Label(null);
                setTrueLabel(trueLabel);
                setFalseLabel(falseLabel);
                IntegerValue right = visit(node.getValue());
//                addInst(new Branch(currentLabel, trueLabel, falseLabel, right));
                addInst(trueLabel);
                currentLabel = trueLabel;
                addInst(new Store(currentLabel, address, new Immediate(1)));
                addInst(new Jump(currentLabel, endLabel));
                addInst(falseLabel);
                addInst(new Store(currentLabel, address, new Immediate(0)));
//                addInst(new Jump(currentLabel, endLabel));
                addInst(endLabel);
                isVarForCond = false;
                exitTrueLabel();
                exitFalseLabel();
//                addInst(new Compare(currentLabel, condition, dest, dest, new Immediate(0)));
            }
            else
            {
                IntegerValue right = visit(node.getValue());
                addInst(new Store(currentLabel, address, right));
            }
        }
        return address;
    }

    @Override
    public IRType visit(FuncParamNode node)
    {
        return null;
    }

    @Override
    public IntegerValue visit(ExprNode node)
    {
        if(node == null) return null;
        return (IntegerValue) node.accept(this);
    }

    @Override
    public IntegerValue visit(AndExprNode node)
    {
        if(node == null) return null;
        Label midLabel = new Label(null);

        IntegerValue lhs = visit(node.getCond1());
        Compare.Condition lhsOp = null;
        if(node.getCond1() instanceof BinaryExprNode)
            lhsOp = convertOp(((BinaryExprNode) node.getCond1()).getOp());
        addInst(new Branch(currentLabel, midLabel, nextFalseLabel, lhs, lhsOp));
        addInst(midLabel);
        IntegerValue rhs = visit(node.getCond2());
        Compare.Condition rhsOp = null;
        if(node.getCond2() instanceof BinaryExprNode)
            rhsOp = convertOp(((BinaryExprNode) node.getCond2()).getOp());
        addInst(new Branch(currentLabel, nextTrueLabel, nextFalseLabel, rhs, rhsOp));
        return rhs;
    }

    @Override
    public IntegerValue visit(ArrayExprNode node)
    {
        //should return address
        IntegerValue index = visit(node.getIndex());
        Address array = (Address)visit(node.getArray());
        return new Address(array.getName(), array, index);
    }

    @Override
    public IntegerValue visit(AssignExprNode node)
    {
        IntegerValue left = visit(node.getLhs());
        IntegerValue right;
//        right = visit(node.getRhs());
        if(isCondition(node.getRhs()))
        {
            isVarForCond = true;
            Label trueLabel = new Label(null);
            Label falseLabel = new Label(null);
            Label endLabel = new Label(null);
            setFalseLabel(falseLabel);
            setTrueLabel(trueLabel);
            right = visit(node.getRhs());
//            addInst(new Branch(currentLabel, trueLabel, falseLabel, right));
            addInst(trueLabel);
            currentLabel = trueLabel;
            addInst(new Store(currentLabel, left, new Immediate(1)));
            addInst(new Jump(currentLabel, endLabel));
            addInst(falseLabel);
            addInst(new Store(currentLabel, left, new Immediate(0)));
            addInst(endLabel);
            isVarForCond = false;
            exitTrueLabel();
            exitFalseLabel();
        }
        else
        {
            right = visit(node.getRhs());
            addInst(new Store(currentLabel, left, right));
        }
        return null;
    }

    @Override
    public IntegerValue visit(BinaryExprNode node)
    {
        if(node.getLhs().getExprType().getTypeName() == Name.getName("string"))
            return dealStringOperation(node);
//        VirtualRegister dest = currentFunction.getRegister();
        IntegerValue left = visit(node.getLhs());
        IntegerValue right = visit(node.getRhs());
        VirtualRegister dest = currentFunction.getRegister();
        IRType irType = new BuiltIn();
        Address address = new Address(dest.getName(), irType);
        addInst(new Alloca(currentLabel, address, irType));
        currentFunction.increSlotNumber();
        currentIRScope.addAddress(dest.getName(), address);

        addBinaryInst(address, left, right, node.getOp());
        return address;
    }

    private IntegerValue dealStringOperation(BinaryExprNode node)
    {
        //TODO
        Address address = new Address(currentFunction.getRegister().getName(), new BuiltIn());
        addInst(new Alloca(currentLabel, address, new BuiltIn()));
        currentFunction.increSlotNumber();
        List<IntegerValue> parameter = new ArrayList<>();
        parameter.add(visit(node.getLhs()));
        parameter.add(visit(node.getRhs()));
        switch (node.getOp())
        {
            case ADD:
                addInst(new Call(currentLabel, address, Name.getName("Str_ADD"), parameter));
                break;
            case EQU:
                addInst(new Call(currentLabel, address, Name.getName("Str_EQ"), parameter));
                break;
            case SLT:
                addInst(new Call(currentLabel, address, Name.getName("Str_LT"), parameter));
                break;
            case SGT:
                addInst(new Call(currentLabel, address, Name.getName("Str_GT"), parameter));
                break;
            case SEQ:
                addInst(new Call(currentLabel, address, Name.getName("Str_LE"), parameter));
                break;
            case BEQ:
                addInst(new Call(currentLabel, address, Name.getName("Str_GE"), parameter));
                break;
        }
        return address;
    }

    private void addBinaryInst(Address dest, IntegerValue left, IntegerValue right, BinaryOp op)
    {
        if(BinaryOp.isCompare(op))
        {
            Compare.Condition condition;
            switch(op)
            {
                case SLT:
                    condition = Compare.Condition.SLT;
                    break;
                case SGT:
                    condition = Compare.Condition.SGT;
                    break;
                case SEQ:
                    condition = Compare.Condition.SEQ;
                    break;
                case BEQ:
                    condition = Compare.Condition.BEQ;
                    break;
                case EQU:
                    condition = Compare.Condition.EQU;
                    break;
                case NEQ:
                    condition = Compare.Condition.NEQ;
                    break;
                default: condition = null; break;
            }
            addInst(new Compare(currentLabel, condition, dest, left, right));
            addInst(new Branch(currentLabel, nextTrueLabel, nextFalseLabel, dest, condition));
        }
        else
        {
            BinaryOperation.BinaryOp binaryOp;
            switch (op)
            {
                case ADD: binaryOp = BinaryOperation.BinaryOp.add; break;
                case MIN: binaryOp = BinaryOperation.BinaryOp.sub; break;
                case MUL: binaryOp = BinaryOperation.BinaryOp.imul; break;
                case DIV: binaryOp = BinaryOperation.BinaryOp.idiv; break;
                case L_SHIFT: binaryOp = BinaryOperation.BinaryOp.shl; break;
                case R_SHIFT: binaryOp = BinaryOperation.BinaryOp.shr; break;
                case MOD: binaryOp = BinaryOperation.BinaryOp.mod; break;
                case BIT_AND: binaryOp = BinaryOperation.BinaryOp.and; break;
                case BIT_OR: binaryOp = BinaryOperation.BinaryOp.or; break;
                case BIT_XOR: binaryOp = BinaryOperation.BinaryOp.xor; break;
                default: binaryOp = null; break;
            }
            addInst(new BinaryOperation(currentLabel, binaryOp, dest, left, right));
        }
    }

    @Override
    public IntegerValue visit(BoolConstNode node)
    {
        if(node.getValue())
            return new Immediate(1);
        else return new Immediate(0);
    }

    @Override
    public IntegerValue visit(CallExprNode node)
    {
        //should assign a register to the return value
//        Address address = new Address(currentFunction.getRegister().getName());
//        addInst(new Alloca(currentLabel, address, convertType(node.getFunction().getReturnType())));
        VirtualRegister register = currentFunction.getRegister();
        IRType irType = new BuiltIn();
        Address address = null;
        if(node.getFunction().getReturnType() != null &&
                node.getFunction().getReturnType().getTypeName() != Name.getName("void"))
        {
            address = new Address(register.getName(), irType);
            addInst(new Alloca(currentLabel, address, irType));
            currentFunction.increSlotNumber();
            currentIRScope.addAddress(register.getName(), address);
        }

        List<IntegerValue> params = new ArrayList<>();
        for(ExprNode item : node.getParam().getExprs())
        {
            params.add(visit(item));
        }
        addInst(new Call(currentLabel, address, FunctionRename(node.getFuncName()), params));
        return address;
    }

    @Override
    public IntegerValue visit(ExprListNode node)
    {
        return null;
    }

    @Override
    public IntegerValue visit(IdExprNode node)
    {
        if(node == null) return null;
//        if(currentIRScope.containsAddress(node.getName()))
        return currentIRScope.findAddress(node.getName());
    }

    @Override
    public Immediate visit(IntConstNode node)
    {
        if(node == null) return null;
//        addInst(new Load(currentLabel, currentFunction.getRegister(), new Immediate(node.getValue())));
        return new Immediate(node.getValue());
    }

    @Override
    public IntegerValue visit(MemberExprNode node)
    {
        //should return address
        IntegerValue ret;
        if(node == null) return null;
        Address base = (Address)visit(node.getExpr());
        if(node.isFunctionCall())
        {
            if(node.getExpr().getExprType() instanceof ClassType)
            {
                Name name = node.getExpr().getExprType().getTypeName();
                node.getFunctionCall().setFunctionName(Name.getName("__" + name.toString() + "__" + node.getFunctionCall().getFuncName()));
            }
            node.getFunctionCall().addParam(node.getExpr(), 0);
            ret = visit(node.getFunctionCall());
        }
        else
        {
            VarDecNode var = (VarDecNode)node.getExpr().getExprType().getClassNode().getInternalScope().findNode(node.getName());
            int offset = var.getMemberNumber();
            ret = new Address(node.getName(), base, new Immediate(offset));
        }

        return ret;
    }

    @Override
    public IntegerValue visit(NewExprNode node)
    {
        if(node == null) return null;
        return visit(node.getCreatorNode());
//        return null;
    }

    @Override
    public IntegerValue visit(CreatorNode node)
    {
        if(node == null)
            return null;
        if(node.getDimension() == 0)//class
        {
//            throw new RuntimeException("cannot be here now");
            IRType irType = convertType(node.getExprType());
            Address address = new Address(currentFunction.getRegister().getName(), irType);
            addInst(new Alloca(currentLabel, address, new Immediate(8)));
            currentFunction.increSlotNumber();
            addInst(new Malloc(currentLabel, new Immediate(node.getExprType().getTypeSize()), address));
            return address;
        }
        else if(node.getDimension() == 1) //one dimension array
        {
            IRType irType = convertType(node.getType());
            Address address = new Address(currentFunction.getRegister().getName(), irType);
            addInst(new Alloca(currentLabel, address, new BuiltIn()));
            currentFunction.increSlotNumber();
            IntegerValue value = visit(node.getExprNodes().get(0));
            addInst(new Malloc(currentLabel,value,address));
            addInst(new Store(currentLabel, new Address(Name.getName(address.getName().toString() + "_size"),
                    address, new Immediate(-1)), value));
            return address;
        }
        else //multi dimension array
        {
//            throw new RuntimeException("cannot be here now");
            Address address = new Address(currentFunction.getRegister().getName(), convertType(node.getType()));
            memoryAllocate(node.getExprNodes(), node.getType(), true, address);
            return address;
        }
    }

    private Address memoryAllocate(List<ExprNode> node, Type type, boolean isTop, Address address)
    {
        IRType irType = node.size() == 0 ? new BuiltIn() : convertType(type);
        IntegerValue size = visit(node.get(0));
        node.remove(0);
        if(isTop)
        {
            currentFunction.increSlotNumber();
            addInst(new Alloca(currentLabel, address, new BuiltIn()));
        }
        addInst(new Malloc(currentLabel, size, address));
        addInst(new Store(currentLabel, new Address(Name.getName(address.getName().toString() + "_size"),
                address, new Immediate(-1)), size));
        Label trueLabel = new Label(null);
        Label falseLabel = new Label(null);
        Address offset = new Address(currentFunction.getRegister().getName(), new BuiltIn());
        //TODO
        //should not open in stack
        addInst(new Alloca(currentLabel, offset, new BuiltIn()));
        currentFunction.increSlotNumber();
        //TODO
        addInst(new Store(currentLabel, offset, new Immediate(0)));
        if(node.size() != 0)
        {
            addInst(trueLabel);
            Address address1 = new Address(currentFunction.getRegister().getName(),
                    address, offset);
            memoryAllocate(node, type, false, address1);
            Address compareDest = new Address(currentFunction.getRegister().getName(), new BuiltIn());
            addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.add,
                    offset, offset, new Immediate(1)));
            addInst(new Compare(currentLabel, Compare.Condition.SEQ, compareDest, offset, size));
            addInst(new Branch(currentLabel, trueLabel, falseLabel, compareDest, Compare.Condition.SEQ));
            addInst(falseLabel);
        }
        return address;
    }

    @Override
    public IntegerValue visit(NullConstNode node)
    {
        return null;
    }

    @Override
    public IntegerValue visit(OrExprNode node)
    {
        if(node == null) return null;
        Label midLabel = new Label(null);

        IntegerValue lhs = visit(node.getCond1());
        Compare.Condition lhsOp = null;
        if(node.getCond1() instanceof BinaryExprNode)
            lhsOp = convertOp(((BinaryExprNode) node.getCond1()).getOp());
        addInst(new Branch(currentLabel, nextTrueLabel, midLabel, lhs, lhsOp));
        addInst(midLabel);
        IntegerValue rhs = visit(node.getCond2());
        Compare.Condition rhsOp = null;
        if(node.getCond2() instanceof BinaryExprNode)
            rhsOp = convertOp(((BinaryExprNode) node.getCond2()).getOp());
        addInst(new Branch(currentLabel, nextTrueLabel, nextFalseLabel, rhs, rhsOp));
        return rhs;
    }

    @Override
    public IntegerValue visit(PrefixExprNode node)
    {
        IntegerValue value = visit(node.getExprNode());
        VirtualRegister register = currentFunction.getRegister();
        Address address = new Address(register.getName(), new BuiltIn());
        switch (node.getOp())
        {
            case NEG:
                addInst(new Alloca(currentLabel, address, new BuiltIn()));
                currentFunction.increSlotNumber();
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.neg, address,
                        value, null));
                return address;
            case NOT:
                addInst(new Alloca(currentLabel, address, new BuiltIn()));
                currentFunction.increSlotNumber();
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.xor, address,
                        value, new Immediate(1)));
                return address;
            case BIT_NOT:
                addInst(new Alloca(currentLabel, address, new BuiltIn()));
                currentFunction.increSlotNumber();
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.not, address,
                        value, new Immediate(-1)));
                return address;
            case POS:
                return value;
            case DECRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.sub, (Address) value,
                        value, new Immediate(1)));
//                addInst(new Store(currentLabel, value, register));
                return value;
            case INCRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.add, (Address) value,
                        value, new Immediate(1)));
//                addInst(new Store(currentLabel, value, register));
                return value;
        }
//        return register;
        throw new RuntimeException("you should not be here");
    }

    @Override
    public IntegerValue visit(StringConstNode node)
    {
        //TODO
        //Address type
        String name = dataSection.addData(node.getValue());
        return new Address(Name.getName(name), new BuiltIn());
    }

    @Override
    public IntegerValue visit(SuffixExprNode node)
    {
        IntegerValue value = visit(node.getExprNode());
        VirtualRegister new_reg = currentFunction.getRegister();
        VirtualRegister origin_reg = currentFunction.getRegister();
        IRType irType;
        irType = new BuiltIn();

        Address origin_address = new Address(origin_reg.getName(), irType);

        addInst(new Alloca(currentLabel, origin_address, irType));
        currentFunction.increSlotNumber();
        currentIRScope.addAddress(origin_reg.getName(), origin_address);
        addInst(new Store(currentLabel, origin_address, value));

        switch(node.getOp())
        {
            case SUF_DECRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.sub,
                        (Address) value, value, new Immediate(1)));
                return origin_address;
            case SUF_INCRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.add,
                        (Address) value, value, new Immediate(1)));
                return origin_address;
        }
        throw new RuntimeException("you should not be here");
    }

    @Override
    public IntegerValue visit(ThisExprNode node)
    {
        //TODO
        return null;
    }

    @Override
    public IRInstruction visit(StatNode node)
    {
        if(node == null) return null;
        return node.accept(this);
    }

    @Override
    public IRInstruction visit(BlockNode node)
    {
//        List<IRInstruction> block = new ArrayList<>();
        setIRScope(node.getScope().getIRScope());
        for(StatNode item : node.getStatements())
        {
//            block.add(visit(item));
            visit(item);
        }
        exitIRScope();
//        return new BasicBlock(block);
        return null;
    }

    @Override
    public IRInstruction visit(BreakNode node)
    {
        IRInstruction inst = new Jump(currentLabel, nextFalseLabel);
        addInst(inst);
        return inst;
    }

    @Override
    public IRInstruction visit(ContinueNode node)
    {
        IRInstruction inst = new Jump(currentLabel, nextJumpLabel);
        addInst(inst);
        return inst;
    }

    @Override
    public IRInstruction visit(ForNode node)
    {
        setIRScope(node.getInternalScope().getIRScope());

        Label trueLabel = new Label(null);
        Label falseLabel = new Label(null);
        Label conditionLabel = new Label(null);
        Label jumpLabel = new Label(null);
        setTrueLabel(trueLabel);
        setFalseLabel(falseLabel);
        setJumpLabel(jumpLabel);

        if(node.getBeginCondition() != null)
            visit(node.getBeginCondition());
        addInst(conditionLabel);
        if(node.getEndCondition() != null)
            visit(node.getEndCondition());
        addInst(trueLabel);
        visit(node.getBlock());
        addInst(jumpLabel);
        visit(node.getUpdate());
        addInst(new Jump(currentLabel, conditionLabel));
        addInst(falseLabel);

        exitTrueLabel();
        exitFalseLabel();
        exitJumpLabel();
        exitIRScope();

        return null;
    }

    @Override
    public IRInstruction visit(IfNode node)
    {
        setIRScope(node.getInternalScope().getIRScope());
        Label trueLabel = new Label(null);
        Label falseLabel = new Label(null);
        Label endLabel = new Label(null);
        setTrueLabel(trueLabel);
        setFalseLabel(falseLabel);

        IntegerValue condition = visit(node.getCondition());
        if(!(node.getCondition() instanceof BinaryExprNode) &&
                !(node.getCondition() instanceof ConditionExprNode))
        {
            addInst(new Compare(currentLabel, Compare.Condition.EQU,
                    new Address(currentFunction.getRegister().getName(), new BuiltIn()),
                    condition, new Immediate(0)));
            addInst(new Branch(currentLabel, trueLabel, falseLabel, condition));
        }
        addInst(trueLabel);
        visit(node.getThen());
        addInst(new Jump(currentLabel, endLabel));
        addInst(falseLabel);
        if(node.getElseThen() != null)
            visit(node.getElseThen());
        addInst(new Jump(currentLabel, endLabel));
        addInst(endLabel);

        exitTrueLabel();
        exitFalseLabel();
        exitIRScope();
        return null;
    }

    @Override
    public IRInstruction visit(ReturnNode node)
    {
        IntegerValue integerValue = visit(node.getExprNode());
        addInst(new Return(currentLabel, integerValue));
        return null;
    }

    @Override
    public IRInstruction visit(WhileNode node)
    {
        setIRScope(node.getInternalScope().getIRScope());
        Label trueLabel = new Label(null);
        Label falseLabel = new Label(null);
        Label conditionLabel = new Label(null);
        setTrueLabel(trueLabel);
        setFalseLabel(falseLabel);
        setJumpLabel(conditionLabel);

        addInst(conditionLabel);
        if(node.getCondition() != null)
            visit(node.getCondition());
        addInst(trueLabel);
        visit(node.getThen());
        addInst(new Jump(conditionLabel, conditionLabel));
        addInst(falseLabel);

        exitIRScope();
        exitTrueLabel();
        exitFalseLabel();
        exitJumpLabel();
        return null;
    }

    @Override
    public IRInstruction visit(ExprStatNode node)
    {
        if(node == null) return null;
        visit(node.getExpr());
        return null;
    }

    @Override
    public IRType visit(Type type)
    {
        return convertType(type);
    }

    private void addInst(IRInstruction instruction)
    {
        if(isInitializeInst)
        {
            addInitailizeInst(instruction);
            return;
        }
        if(currentInst == null)
        {
            currentInst = instruction;
            entry = instruction;
            return;
        }
        instruction.setLast(currentInst);
        currentInst.setNext(instruction);
        currentInst = instruction;
        currentLabel.addInst(instruction);
    }
    private void addInitailizeInst(IRInstruction instruction)
    {
        if(initializeGlobalInst == null)
        {
            initializeGlobalInst = instruction;
            initializeEntry = instruction;
            return;
        }
        instruction.setLast(initializeGlobalInst);
        initializeGlobalInst.setNext(instruction);
        initializeGlobalInst = instruction;
//        currentLabel.addInst(instruction);
    }

    private void addType(Class classType)
    {
        types.add(classType);
    }

    private void setIRScope(IRScope irScope)
    {
        this.currentIRScope = irScope;
    }

    private void exitIRScope()
    {
        this.currentIRScope = currentIRScope.getParent();
    }

    private void setTrueLabel(Label label)
    {
        nextTrueLabel = label;
        trueLabelStack.push(label);
    }

    private void exitTrueLabel()
    {
        trueLabelStack.pop();
        nextTrueLabel = trueLabelStack.peek();
    }

    private void setFalseLabel(Label label)
    {
        nextFalseLabel = label;
        falseLabelStack.push(label);
    }

    private void exitFalseLabel()
    {
        falseLabelStack.pop();
        nextFalseLabel = falseLabelStack.peek();
    }

    private void setJumpLabel(Label label)
    {
        nextJumpLabel = label;
        jumpLabelStack.push(label);
    }

    private void exitJumpLabel()
    {
        jumpLabelStack.pop();
        nextJumpLabel = jumpLabelStack.peek();
    }

    private boolean isCondition(ExprNode node)
    {
        return ((node instanceof ConditionExprNode)
                || (node instanceof BinaryExprNode &&
                        BinaryOp.isCompare(((BinaryExprNode) node).getOp()))
                || (node instanceof UnaryExprNode &&
                        ((UnaryExprNode) node).getOp() == UnaryOp.NOT));

    }
//    private VirtualRegister getRegisterValue(IntegerValue value)
//    {
//        if(value instanceof Address)
//        {
//            VirtualRegister register = currentFunction.getRegister();
//            addInst(new Load(currentLabel, register, (Address)value));
//            return register;
//        }
//        else if(value instanceof Immediate)
//        {
//            VirtualRegister register = currentFunction.getRegister();
//            addInst(new Load(currentLabel, register, (Immediate)value));
//            return register;
//        }
//        else if(value instanceof VirtualRegister)
//        {
//            return (VirtualRegister)value;
//        }
//        else throw new RuntimeException("invalid operand");
//    }

//    private IntegerValue parseIfAddress(IntegerValue value)
//    {
//        if(value instanceof Address)
//        {
//            VirtualRegister register = currentFunction.getRegister();
//            addInst(new Load(currentLabel, register, (Address)value));
//            return register;
//        }
//        else return value;
//    }

    private Compare.Condition convertOp(BinaryOp op)
    {
        Compare.Condition condition;
        switch(op)
        {
            case SLT: condition = Compare.Condition.SLT; break;
            case SGT: condition = Compare.Condition.SGT; break;
            case SEQ: condition = Compare.Condition.SEQ; break;
            case BEQ: condition = Compare.Condition.BEQ; break;
            case EQU: condition = Compare.Condition.EQU; break;
            case NEQ: condition = Compare.Condition.NEQ; break;
            default: condition = null; break;
        }
        return condition;
    }

    private IRType convertType(Type type)
    {
        //CAN OPTIMIZE
        //By building a map instead of new
        IRType irType;
        if(type instanceof BuiltInType)
            irType = new BuiltIn();
        else if(type instanceof ClassType)
            irType = new Class(type.getTypeName());
        else
        {
            irType = new Array(convertType(((ArrayType) type).getBasic_type()), null);
        }
        return irType;
    }

}
