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
    private Stack<IRScope>  irScopeStack = new Stack<>();
    private FunctionScope   currentFunctionScope;
    private ClassDecNode    currentClass;
    
    private Function        currentFunction;
    private boolean isHeapAllocate = false;

    private boolean isInitializeInst = false;

    private boolean isMemberFunction = false;
    private Label nextJumpLabel;
    private Label nextEndLoopLabel;
    private Stack<Label> jumpLabelStack = new Stack<>();
    private Stack<Label> endLoopLabelStack = new Stack<>();

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
        currentFunctionScope = new FunctionScope(Name.getName("GLOBAL"));
        currentLabel = globalLabel;
        setJumpLabel(globalLabel);
        setEndLoopLabel(globalLabel);
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
        String name = node.getName().toString();
        if(node.getName() == Name.getName("ch") || node.getName() == Name.getName("dx"))
            name += "_mine";
        Address address = new Address(Name.getName(name), true);
        if(node.getValue() == null) //bssZone
        {
            bssZone.addData(name, null);
        }
        else //dataZone
        {
            if(node.getType() instanceof BuiltInType)
            {
                if(node.getValue() instanceof IntConstNode)
                {
                    Immediate value = (Immediate) visit(node.getValue());
                    dataZone.addData(name, String.valueOf(value.getValue()), "dq");
                }
                else
                {
                    isInitializeInst = true;
                    IntegerValue value = visit(node.getValue());
                    addInst(new Store(currentLabel, address, value));
                    bssZone.addData(name, null);
                    isInitializeInst = false;
                }
            }
            else// if(node.getType() instanceof ArrayType or ClassType
            {
                isHeapAllocate = true;
                isInitializeInst = true;
//                address = new Address(node.getName(), true);
//                addInst(new Malloc(currentLabel, new Immediate(8), address));
                IntegerValue value = visit(node.getValue());
                addInst(new MemCopy(currentLabel, (Address) value, address));
                bssZone.addData(name, null);
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
        setIRScope(node.getInternalScope().getIRScope());
        if(node == null) return null;
        for(VarDecNode item : node.getMemberVarible())
        {
//            visit(item);
            String name = node.getName().toString() + "_" + item.getName();
            Address address = new Address(Name.getName(name), convertType(item.getType()));
            address.setMember(true);
            address.setMemberNumber(item.getMemberNumber());
            currentIRScope.addAddress(item.getName(), address);
            classType.addContainType (convertType(item.getType()));
        }
        isMemberFunction = true;
        for(FuncDecNode item : node.getMemberFunction())
            visit(item);
        isMemberFunction = false;
        addType(classType);
        currentClass = null;
        exitIRScope();
        return null;
    }

    @Override
    public Function visit(FuncDecNode node)
    {
        IRType type = visit(node.getReturnType());
        List<Parameter> params = new ArrayList<>();
        setIRScope(node.getInternalScope().getIRScope());
        currentFunctionScope = new FunctionScope(node.getName());
        currentFunctionScope.setFuncDecNode(node);
        if(currentClass != null)
            params.add(new Parameter(new Class(currentClass.getName()), Name.getName("null") ,
                    new Address(Name.getName("null"), new BuiltIn()), true));
        for(FuncParamNode item : node.getParameter())
        {
            Address address = new Address(item.getName(), convertType(item.getType()));
            currentFunctionScope.increSlotNumber();
            params.add(new Parameter(convertType(item.getType()), item.getName(), address));
            currentIRScope.addAddress(item.getName(), address);
        }
        Name name = FunctionRename(node.getName());
//        visitFormalParameter(node.getParameter());
        Function function = new Function(currentLabel, name, type, params, 0);
        addInst(function);
        currentFunction = function;
        visit(node.getBlock());
        exitIRScope();
        function.setUsedSlotNumber(currentFunctionScope.getUsedSlotNumber());
        addInst(new Return(currentLabel, null));
        return null;
    }

    private Name FunctionRename(Name origin_name)
    {
        Name new_name = currentClass == null? origin_name :
                Name.getName("__" + currentClass.getName().toString() + "__" + origin_name.toString());
        return new_name;
    }

    private Name FunctionRename(FuncDecNode node)
    {
        Name newName = node.getClassDecNode() == null ? node.getName() :
                Name.getName("__" + node.getClassDecNode().getName().toString() +
                        "__" + node.getName().toString());
        return newName;
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
        String name = node.getName().toString();
        if(node.getName() == Name.getName("ch") || node.getName() == Name.getName("dx"))
            name += "_ch";
        Address address = new Address(Name.getName(name), irType);
        addInst(new Alloca(currentLabel, address, irType));
        currentFunctionScope.increSlotNumber();

        currentIRScope.addAddress(node.getName(), address);
        if(node.getValue() != null)
        {
            IntegerValue right = visit(node.getValue());
            addInst(new Store(currentLabel, address, right));
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
        Label midTrueLabel = new Label(null);
        Label trueLabel = new Label(null);
        Label falseLabel = new Label(null);
        Label endLabel = new Label(null);

        IntegerValue lhs = visit(node.getCond1());
//        Compare.Condition lhsOp = null;
//        if(node.getCond1() instanceof BinaryExprNode)
//            lhsOp = convertOp(((BinaryExprNode) node.getCond1()).getOp());
        addInst(new Compare(currentLabel, Compare.Condition.NEQ,
                new Address(currentFunctionScope.getRegister().getName(), new BuiltIn()),
                lhs, new Immediate(0)));
        addInst(new Branch(currentLabel, midLabel, falseLabel, lhs));
//        addInst(midTrueLabel);
//        addInst(new Jump(currentLabel, trueLabel));
        addInst(midLabel);
        IntegerValue rhs = visit(node.getCond2());
        Compare.Condition rhsOp = null;
        if(node.getCond2() instanceof BinaryExprNode)
            rhsOp = convertOp(((BinaryExprNode) node.getCond2()).getOp());
//        addInst(new Branch(currentLabel, nextTrueLabel, nextFalseLabel, rhs, rhsOp));
        Address returnAddress = new Address(currentFunctionScope.getRegister().getName(), new BuiltIn());
        addInst(new Alloca(currentLabel, returnAddress, new BuiltIn()));
        currentFunctionScope.increSlotNumber();
//        addInst(new Branch(currentLabel, trueLabel, falseLabel, rhs, rhsOp));
        addInst(new Compare(currentLabel, Compare.Condition.NEQ,
                new Address(currentFunctionScope.getRegister().getName(), new BuiltIn()),
                rhs, new Immediate(0)));
        addInst(new Branch(currentLabel, trueLabel, falseLabel, returnAddress));
        storeCompareResult(returnAddress, trueLabel, falseLabel, endLabel);
        return returnAddress;
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

        right = visit(node.getRhs());
        addInst(new Store(currentLabel, left, right));
        return null;
    }

    @Override
    public IntegerValue visit(BinaryExprNode node)
    {
         if(node.getLhs().getExprType().getTypeName() == Name.getName("string"))
            return dealStringOperation(node);
//        VirtualRegister dest = currentFunctionScope.getRegister();
        IntegerValue left = visit(node.getLhs());
        IntegerValue right = visit(node.getRhs());
        VirtualRegister dest = currentFunctionScope.getRegister();
        IRType irType = new BuiltIn();
        Address address = new Address(dest.getName(), irType);
        addInst(new Alloca(currentLabel, address, irType));
        currentFunctionScope.increSlotNumber();
        currentIRScope.addAddress(dest.getName(), address);

        addBinaryInst(address, left, right, node.getOp());
        return address;
    }

    private IntegerValue dealStringOperation(BinaryExprNode node)
    {
        //TODO
        Address address = new Address(currentFunctionScope.getRegister().getName(), new BuiltIn());
        addInst(new Alloca(currentLabel, address, new BuiltIn()));
        currentFunctionScope.increSlotNumber();
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
//        if(BinaryOp.isCompare(node.getOp()))
//        {
////            addInst(new Compare(currentLabel, Compare.Condition.BEQ, address, address, new Immediate(0)));
////            addInst(new Branch(currentLabel, nextTrueLabel, nextFalseLabel, address, Compare.Condition.SGT));
//
//        }
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
            Label trueLabel = new Label(null);
            Label falseLabel = new Label(null);
            Label endLabel = new Label(null);
            addInst(new Branch(currentLabel, trueLabel, falseLabel, dest, condition));
            storeCompareResult(dest, trueLabel, falseLabel, endLabel);
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
        VirtualRegister register = currentFunctionScope.getRegister();
        IRType irType = new BuiltIn();
        Address address = null;
        if(node.getFunction().getReturnType() != null &&
                node.getFunction().getReturnType().getTypeName() != Name.getName("void"))
        {
            address = new Address(register.getName(), irType);
            addInst(new Alloca(currentLabel, address, irType));
            currentFunctionScope.increSlotNumber();
            currentIRScope.addAddress(register.getName(), address);
        }

        List<IntegerValue> params = new ArrayList<>();
        if(node.getFunction().getClassDecNode() != null)
            params.add(currentFunction.getParameter().get(0).getAddress());
        for(ExprNode item : node.getParam().getExprs())
        {
            params.add(visit(item));
        }
        addInst(new Call(currentLabel, address, FunctionRename(node.getFunction()), params));
//        addInst(new Call(currentLabel, address, node.getFuncName(), params));
        return address;
    }

    private IntegerValue visitMemberCall(CallExprNode node, Address classAddress)
    {
        VirtualRegister register = currentFunctionScope.getRegister();
        IRType irType = new BuiltIn();
        Address address = null;
        if(node.getFunction().getReturnType() != null &&
                node.getFunction().getReturnType().getTypeName() != Name.getName("void"))
        {
            address = new Address(register.getName(), irType);
            addInst(new Alloca(currentLabel, address, irType));
            currentFunctionScope.increSlotNumber();
            currentIRScope.addAddress(register.getName(), address);
        }
        List<IntegerValue> params = new ArrayList<>();
        for(ExprNode item : node.getParam().getExprs())
        {
            if(params.size() == 0)
                params.add(classAddress);
            else
                params.add(visit(item));
        }
        addInst(new Call(currentLabel, address, node.getFuncName(), params));
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
        Address address = currentIRScope.findAddress(node.getName());
        if(!address.isMember())
            return address;
        Address baseAddress = currentFunction.getParameter().get(0).getAddress();
        Address memberAddress = new Address(address.getName(), baseAddress, new Immediate(address.getMemberNumber()));
        return memberAddress;
    }

    @Override
    public Immediate visit(IntConstNode node)
    {
        if(node == null) return null;
//        addInst(new Load(currentLabel, currentFunctionScope.getRegister(), new Immediate(node.getValue())));
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
//            ret = visit(node.getFunctionCall());
            ret = visitMemberCall(node.getFunctionCall(), base);
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
            Address address = new Address(currentFunctionScope.getRegister().getName(), irType);
            addInst(new Alloca(currentLabel, address, new Immediate(8)));
            currentFunctionScope.increSlotNumber();
            addInst(new Malloc(currentLabel, new Immediate(node.getExprType().getTypeSize()), address));
            return address;
        }
        else if(node.getDimension() == 1) //one dimension array
        {
            IRType irType = convertType(node.getType());
            Address address = new Address(currentFunctionScope.getRegister().getName(), irType);
            addInst(new Alloca(currentLabel, address, new BuiltIn()));
            currentFunctionScope.increSlotNumber();
            IntegerValue value = visit(node.getExprNodes().get(0));
            addInst(new Malloc(currentLabel,value,address));
            addInst(new Store(currentLabel, new Address(Name.getName(address.getName().toString() + "_size"),
                    address, new Immediate(-1)), value));
            return address;
        }
        else //multi dimension array
        {
//            throw new RuntimeException("cannot be here now");
            Address address = new Address(currentFunctionScope.getRegister().getName(), convertType(node.getType()));
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
            currentFunctionScope.increSlotNumber();
            addInst(new Alloca(currentLabel, address, new BuiltIn()));
        }
        addInst(new Malloc(currentLabel, size, address));
        addInst(new Store(currentLabel, new Address(Name.getName(address.getName().toString() + "_size"),
                address, new Immediate(-1)), size));
        Label trueLabel = new Label(null);
        Label falseLabel = new Label(null);
        Address offset = new Address(currentFunctionScope.getRegister().getName(), new BuiltIn());
        //TODO
        //should not open in stack
        addInst(new Alloca(currentLabel, offset, new BuiltIn()));
        currentFunctionScope.increSlotNumber();
        //TODO
        addInst(new Store(currentLabel, offset, new Immediate(0)));
        if(node.size() != 0)
        {
            addInst(trueLabel);
            Address address1 = new Address(currentFunctionScope.getRegister().getName(),
                    address, offset);
            memoryAllocate(node, type, false, address1);
            Address compareDest = new Address(currentFunctionScope.getRegister().getName(), new BuiltIn());
            addInst(new Alloca(currentLabel, compareDest, new BuiltIn()));
            currentFunctionScope.increSlotNumber();
            addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.add,
                    offset, offset, new Immediate(1)));
            addInst(new Compare(currentLabel, Compare.Condition.SEQ, compareDest, offset, size));
            addInst(new Branch(currentLabel, trueLabel, falseLabel, compareDest, Compare.Condition.SEQ));
            addInst(new Jump(currentLabel, trueLabel));
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
        Label midTrueLabel = new Label(null);
        Label trueLabel = new Label(null);
        Label falseLabel = new Label(null);
        Label endLabel = new Label(null);

        IntegerValue lhs = visit(node.getCond1());
//        Compare.Condition lhsOp = null;
//        if(node.getCond1() instanceof BinaryExprNode)
//            lhsOp = convertOp(((BinaryExprNode) node.getCond1()).getOp());
        addInst(new Compare(currentLabel, Compare.Condition.NEQ,
                new Address(currentFunctionScope.getRegister().getName(), new BuiltIn()),
                lhs, new Immediate(0)));
        addInst(new Branch(currentLabel, trueLabel, midLabel, lhs));
        addInst(midTrueLabel);
        addInst(new Jump(currentLabel, trueLabel));
        addInst(midLabel);
        IntegerValue rhs = visit(node.getCond2());
        Compare.Condition rhsOp = null;
        if(node.getCond2() instanceof BinaryExprNode)
            rhsOp = convertOp(((BinaryExprNode) node.getCond2()).getOp());
        Address returnAddress = new Address(currentFunctionScope.getRegister().getName(), new BuiltIn());
        addInst(new Alloca(currentLabel, returnAddress, new BuiltIn()));
        currentFunctionScope.increSlotNumber();
//        addInst(new Branch(currentLabel, trueLabel, falseLabel, rhs, rhsOp));
        addInst(new Compare(currentLabel, Compare.Condition.NEQ,
                new Address(currentFunctionScope.getRegister().getName(), new BuiltIn()),
                rhs, new Immediate(0)));
        addInst(new Branch(currentLabel, trueLabel, falseLabel, returnAddress));
        storeCompareResult(returnAddress, trueLabel, falseLabel, endLabel);
        return returnAddress;
    }

    @Override
    public IntegerValue visit(PrefixExprNode node)
    {
        if(isCompareCondition(node.getExprNode()))
            return visitNotCondition(node);
        IntegerValue value = visit(node.getExprNode());
        VirtualRegister register = currentFunctionScope.getRegister();
        Address address = new Address(register.getName(), new BuiltIn());
        switch (node.getOp())
        {
            case NEG:
                addInst(new Alloca(currentLabel, address, new BuiltIn()));
                currentFunctionScope.increSlotNumber();
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.neg, address,
                        value, null));
                return address;
            case NOT:
                addInst(new Alloca(currentLabel, address, new BuiltIn()));
                currentFunctionScope.increSlotNumber();
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.xor, address,
                        value, new Immediate(1)));
                return address;
            case BIT_NOT:
                addInst(new Alloca(currentLabel, address, new BuiltIn()));
                currentFunctionScope.increSlotNumber();
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.not, address,
                        value, null));
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

    private IntegerValue visitNotCondition(PrefixExprNode node)
    {
        IntegerValue value = visit(node.getExprNode());
        VirtualRegister register = currentFunctionScope.getRegister();
        //return address
        //store a 1 or a 0
        Address address = new Address(register.getName(), new BuiltIn());
        //the node.getOp must be not
        if(node.getOp() != UnaryOp.NOT)
            throw new RuntimeException("should not be here");
        addInst(new Alloca(currentLabel, address, new BuiltIn()));
        addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.xor,
                address, address, new Immediate(1)));
        return address;
    }

    @Override
    public IntegerValue visit(StringConstNode node)
    {
        //TODO
        //Address type
//        if(node.getValue().equals("\\n"))
//            node.setValue("\n");
        node.setValue(processString(node.getValue()));
        String name = dataSection.addData(node.getValue());
        return new Address(Name.getName(name), new BuiltIn());
    }

    private String processString(String data)
    {
        StringBuilder builder = new StringBuilder();
        char[] charArray = data.toCharArray();
        int length = data.length();
        boolean jump = false;
        for (int i = 0; i < length; ++i)
        {
            if(jump)
            {
                jump = false;
                continue;
            }
            if(charArray[i] == '\\')
            {
                jump = true;
                if(charArray[i + 1] == 'n')
                    builder.append('\n');
                else if(charArray[i + 1] == '"')
                    builder.append('\"');
                else if(charArray[i + 1] == '\\')
                    builder.append('\\');
            }
            else builder.append(charArray[i]);
        }
        return builder.toString();
    }

    @Override
    public IntegerValue visit(SuffixExprNode node)
    {
        IntegerValue value = visit(node.getExprNode());
        VirtualRegister new_reg = currentFunctionScope.getRegister();
        VirtualRegister origin_reg = currentFunctionScope.getRegister();
        IRType irType;
        irType = new BuiltIn();

        Address origin_address = new Address(origin_reg.getName(), irType);

        addInst(new Alloca(currentLabel, origin_address, irType));
        currentFunctionScope.increSlotNumber();
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
        Address address = currentFunction.getParameter().get(0).getAddress();
        return address;
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
        IRInstruction inst = new Jump(currentLabel, nextEndLoopLabel);
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
        setJumpLabel(jumpLabel);
        setEndLoopLabel(falseLabel);

        IntegerValue endCondition = null;
        if(node.getBeginCondition() != null)
            visit(node.getBeginCondition());
        addInst(conditionLabel);
        if(node.getEndCondition() != null)
            endCondition = visit(node.getEndCondition());
        if(endCondition != null)
        {
            addInst(new Compare(currentLabel, Compare.Condition.NEQ,
                    new Address(currentFunctionScope.getRegister().getName(), new BuiltIn()),
                    endCondition, new Immediate(0)));
            addInst(new Branch(currentLabel, trueLabel, falseLabel, endCondition));
        }
        addInst(trueLabel);
        visit(node.getBlock());
        addInst(jumpLabel);
        visit(node.getUpdate());
        addInst(new Jump(currentLabel, conditionLabel));
        addInst(falseLabel);

        exitJumpLabel();
        exitEndLoopLabel();
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

        IntegerValue condition = visit(node.getCondition());
        addInst(new Compare(currentLabel, Compare.Condition.NEQ,
                new Address(currentFunctionScope.getRegister().getName(), new BuiltIn()),
                condition, new Immediate(0)));
        addInst(new Branch(currentLabel, trueLabel, falseLabel, condition));
        addInst(trueLabel);
        visit(node.getThen());
        addInst(new Jump(currentLabel, endLabel));
        addInst(falseLabel);
        if(node.getElseThen() != null)
            visit(node.getElseThen());
        addInst(new Jump(currentLabel, endLabel));
        addInst(endLabel);

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
        setJumpLabel(conditionLabel);
        setEndLoopLabel(falseLabel);

        addInst(conditionLabel);
        IntegerValue endCondition = null;
        if(node.getCondition() != null)
            endCondition = visit(node.getCondition());
        if(endCondition != null)
        {
            addInst(new Compare(currentLabel, Compare.Condition.NEQ,
                    new Address(currentFunctionScope.getRegister().getName(), new BuiltIn()),
                    endCondition, new Immediate(0)));
            addInst(new Branch(currentLabel, trueLabel, falseLabel, endCondition));
        }
        addInst(trueLabel);
        visit(node.getThen());
        addInst(new Jump(conditionLabel, conditionLabel));
        addInst(falseLabel);

        exitIRScope();
        exitEndLoopLabel();
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
        irScopeStack.push(irScope);
    }

    private void exitIRScope()
    {
        irScopeStack.pop();
        this.currentIRScope = currentIRScope.getParent();
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

    private void setEndLoopLabel(Label label)
    {
        nextEndLoopLabel = label;
        endLoopLabelStack.push(label);
    }

    private void exitEndLoopLabel()
    {
        endLoopLabelStack.pop();
        nextEndLoopLabel = endLoopLabelStack.peek();
    }

    private boolean isCondition(ExprNode node)
    {
        return  (isCompareCondition(node)
                || (node instanceof UnaryExprNode &&
                        ((UnaryExprNode) node).getOp() == UnaryOp.NOT));

    }

    private boolean isCompareCondition(ExprNode node)
    {
        return (node instanceof ConditionExprNode)
                || (node instanceof BinaryExprNode &&
                BinaryOp.isCompare(((BinaryExprNode) node).getOp()));
    }
//    private VirtualRegister getRegisterValue(IntegerValue value)
//    {
//        if(value instanceof Address)
//        {
//            VirtualRegister register = currentFunctionScope.getRegister();
//            addInst(new Load(currentLabel, register, (Address)value));
//            return register;
//        }
//        else if(value instanceof Immediate)
//        {
//            VirtualRegister register = currentFunctionScope.getRegister();
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
//            VirtualRegister register = currentFunctionScope.getRegister();
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

    private void storeCompareResult(Address address, Label trueLabel, Label falseLabel, Label endLabel)
    {
        addInst(trueLabel);
        addInst(new Store(currentLabel, address, new Immediate(1)));
        addInst(new Jump(currentLabel, endLabel));
        addInst(falseLabel);
        addInst(new Store(currentLabel, address, new Immediate(0)));
        addInst(endLabel);
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
