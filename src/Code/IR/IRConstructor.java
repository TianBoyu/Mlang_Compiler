package Code.IR;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Name;
import Code.AST.Type.ArrayType;
import Code.AST.Type.BuiltInType;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.*;
import Code.IR.Type.Array;
import Code.IR.Type.BuiltIn;
import Code.IR.Type.Class;
import Code.IR.Type.IRType;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO
/*
 * Class(This
 */

public class IRConstructor implements IRTraversal
{
    private IRInstruction   currentInst;
    private Label           currentLabel;
    private IRScope         currentIRScope;
    private FunctionScope   currentFunction;
    private ClassDecNode    currentClass;

    private Label nextLabel;
    private Stack<Label> nextLabelStack = new Stack<>();
    private IRInstruction entry;
    private ProgNode program;
    private List<Class> types = new ArrayList<>();
    private DataSection dataSection = new DataSection();
    private List<Name> globalName = new ArrayList<>();

    public IRConstructor(ProgNode progNode)
    {
        this.program = progNode;
        currentFunction = new FunctionScope(Name.getName("GLOBAL"));
        currentLabel = new Label("GLOBAL");
        setNextLabel(new Label("GLOBAL"));
    }

    public IRInstruction getEntry()
    {
        return entry;
    }

    public List<Class> getTypes()
    {
        return types;
    }

    public DataSection getDataSection()
    {
        return dataSection;
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
//            if(item instanceof ClassDecNode)
//                ((ClassDecNode) item).initTypeSize();
            visit(item);
        }
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

    private void visitFormalParameter(List<FuncParamNode> parameters)
    {
        int i = 0;
        for(FuncParamNode node : parameters)
        {
            Address address = new Address(Name.getName("_para_" + node.getName().toString()),
                                          convertType(node.getType()));
            address.setParamPosition(i++);
            currentIRScope.addAddress(node.getName(), address);
        }
    }

    @Override
    public Address visit(VarDecNode node)
    {
        IRType irType = convertType(node.getType());
        Address address = new Address(node.getName(), irType);
        addInst(new Alloca(currentLabel, address,  irType));
        currentFunction.increSlotNumber();
        currentIRScope.addAddress(node.getName(), address);
        if(node.getValue() != null)
        {
            IntegerValue right = visit(node.getValue());
            if(right instanceof Address)
            {
                VirtualRegister register = currentFunction.getRegister();
                addInst(new Load(currentLabel, register, (Address)right));
                addInst(new Store(currentLabel, address, register));
            }
            else if(right instanceof Register)
            {
                addInst(new Store(currentLabel, address, right));
            }
            else
            {
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
    public Immediate visit(AndExprNode node)
    {
        if(node == null) return null;
        Immediate lhs = (Immediate)visit(node.getCond1());
        Immediate rhs = (Immediate)visit(node.getCond2());
        return new Immediate(lhs.getValue() == 1 && rhs.getValue() == 1 ? 1:0);
    }

    @Override
    public IntegerValue visit(ArrayExprNode node)
    {
        //should return address
        IntegerValue index = visit(node.getIndex());
        Address array = (Address)visit(node.getArray());
        return new Address(array.getName(), index);
    }

    @Override
    public IntegerValue visit(AssignExprNode node)
    {
        IntegerValue left = visit(node.getLhs());
        IntegerValue right = visit(node.getRhs());
        if(right instanceof Address)
        {
            if(node.getRhs().getExprType() instanceof BuiltInType)
            {
                VirtualRegister register = currentFunction.getRegister();
                addInst(new Load(currentLabel, register, (Address) right));
                addInst(new Store(currentLabel, left, register));
            }
            else
            {
                addInst(new MemCopy(currentLabel, (Address)right, (Address)left));
            }
        }
        else if(right instanceof Register)
        {
            addInst(new Store(currentLabel, left, right));
        }
        return null;
    }

    @Override
    public IntegerValue visit(BinaryExprNode node)
    {
        if(node.getLhs() instanceof StringConstNode)
            return dealStringOperation(node);
        //if left operand is an Immediate or Address, load it into a register
        VirtualRegister left = getRegisterValue(visit(node.getLhs()));
        //if right operand is an Address, load it into a register, don't do that if Immediate
        IntegerValue right = parseIfAddress(visit(node.getRhs()));
        VirtualRegister dest = left;
        addBinaryInst(dest, left, right, node.getOp());
        return dest;
    }

    private IntegerValue dealStringOperation(BinaryExprNode node)
    {
        //TODO
        return null;
    }

    private void addBinaryInst(VirtualRegister dest, VirtualRegister left, IntegerValue right, BinaryOp op)
    {
        if(BinaryOp.isCompare(op))
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
            addInst(new Compare(currentLabel, condition, dest, left, right));
        }
        else
        {
            BinaryOperation.BinaryOp binaryOp;
            switch (op)
            {
                case ADD: binaryOp = BinaryOperation.BinaryOp.add; break;
                case MIN: binaryOp = BinaryOperation.BinaryOp.sub; break;
                case MUL: binaryOp = BinaryOperation.BinaryOp.imul; break;
                case DIV: binaryOp = BinaryOperation.BinaryOp.idivq; break;
                case L_SHIFT: binaryOp = BinaryOperation.BinaryOp.shl; break;
                case R_SHIFT: binaryOp = BinaryOperation.BinaryOp.shr; break;
                case MOD: binaryOp = BinaryOperation.BinaryOp.idivq; break;
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
        List<IntegerValue> params = new ArrayList<>();
        for(ExprNode item : node.getParam().getExprs())
        {
            params.add(visit(item));
        }
        addInst(new Call(currentLabel, register, FunctionRename(node.getFuncName()), params));
//        if(node.getFunction().getReturnType() instanceof BuiltInType)
//            return getRegisterValue(address);
//        else return address;
        return register;
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
            Name name = node.getExpr().getExprType().getTypeName();
            node.getFunctionCall().setFunctionName(Name.getName("__" + name.toString() + "__" + node.getFunctionCall().getFuncName()));
            ret = visit(node.getFunctionCall());
        }
        else
        {
            VarDecNode var = (VarDecNode)node.getExpr().getExprType().getClassNode().getInternalScope().findNode(node.getName());
            int offset = var.getMemberNumber();
            ret = new Address(base.getName(), new Immediate(offset));
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
        IRType irType = convertType(node.getType());
        Address address = new Address(currentFunction.getRegister().getName(), irType);
        currentIRScope.addAddress(address.getName(), address);
        addInst(new Alloca(currentLabel, address, irType));
        currentFunction.increSlotNumber();
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
        Immediate lhs = (Immediate)visit(node.getCond1());
        Immediate rhs = (Immediate)visit(node.getCond2());
        return new Immediate(lhs.getValue() == 1 || rhs.getValue() == 1 ? 1 : 0);
    }

    @Override
    public IntegerValue visit(PrefixExprNode node)
    {
        VirtualRegister register = getRegisterValue(visit(node.getExprNode()));
        switch (node.getOp())
        {
            case NEG:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.neg, register,
                        register, new Immediate(0)));
                break;
            case NOT:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.xor, register,
                        register, new Immediate(1)));
                break;
            case BIT_NOT:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.not, register,
                        register, new Immediate(-1)));
                break;
            case POS:
                return register;
            case DECRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.sub, register,
                        register, new Immediate(1)));
                break;
            case INCRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.add, register,
                        register, new Immediate(1)));
                break;
        }
        return register;
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
        IntegerValue register = getRegisterValue(visit(node.getExprNode()));
        VirtualRegister new_reg = currentFunction.getRegister();
        switch(node.getOp())
        {
            case SUF_DECRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.sub,
                        new_reg, register, new Immediate(1)));
                return register;
            case SUF_INCRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.add,
                        new_reg, register, new Immediate(1)));
                return register;
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
//        return new BasicBlock(block);
        return null;
    }

    @Override
    public IRInstruction visit(BreakNode node)
    {
        IRInstruction inst = new Jump(currentLabel, nextLabel);
        addInst(inst);
        return inst;
    }

    @Override
    public IRInstruction visit(ContinueNode node)
    {
        IRInstruction inst = new Jump(currentLabel, currentLabel);
        addInst(inst);
        return inst;
    }

    @Override
    public IRInstruction visit(ForNode node)
    {
        setIRScope(node.getInternalScope().getIRScope());

        if(node.getBeginCondition() != null)
            visit(node.getBeginCondition());

        Label for_label = new Label(null);
        Label true_label = new Label(null);
        Label false_label = new Label(null);

        addInst(new Jump(currentLabel, for_label));
        currentLabel = for_label;

        addInst(for_label);
        VirtualRegister reg = (VirtualRegister) visit(node.getEndCondition());
        IRInstruction branch = new Branch(currentLabel, true_label, false_label, reg);
        addInst(branch);

        addInst(true_label);
        currentLabel = true_label;
        setNextLabel(false_label);
        visit(node.getBlock());
        visit(node.getUpdate());
        addInst(new Jump(currentLabel, for_label));

        addInst(false_label);
        currentLabel = false_label;
        exitNextLabel();

        return null;
    }

    @Override
    public IRInstruction visit(IfNode node)
    {
        setIRScope(node.getInternalScope().getIRScope());

        VirtualRegister condition = (VirtualRegister)visit(node.getCondition());
        Label true_label = new Label(null);
        Label false_label = new Label(null);
        Label end_label = new Label(null);
        if(node.getElseThen() == null)
        {
            addInst(new Branch(currentLabel, true_label, end_label, condition));
            addInst(true_label);
            currentLabel = true_label;
            visit(node.getThen());
        }
        else
        {
            addInst(new Branch(currentLabel, true_label, false_label, condition));
            addInst(true_label);
            currentLabel = true_label;
            visit(node.getThen());
            addInst(new Jump(currentLabel, end_label));
            addInst(false_label);
            currentLabel = false_label;
            visit(node.getElseThen());
            addInst(new Jump(currentLabel, end_label));
        }
        addInst(end_label);
        currentLabel = end_label;

        return null;
    }

    @Override
    public IRInstruction visit(ReturnNode node)
    {
        IntegerValue integerValue = visit(node.getExprNode());
        if(integerValue instanceof Immediate)
            addInst(new Return(currentLabel, integerValue));
        else if(currentFunction.getFuncDecNode().getReturnType() instanceof BuiltInType)
            addInst(new Return(currentLabel, getRegisterValue(integerValue)));
        else
            addInst(new Return(currentLabel, integerValue));
        return null;
    }

    @Override
    public IRInstruction visit(WhileNode node)
    {
        setIRScope(node.getInternalScope().getIRScope());

        Label while_label = new Label(null);
        addInst(new Jump(currentLabel, while_label));
        addInst(while_label);
        currentLabel = while_label;
        VirtualRegister condition = (VirtualRegister)visit(node.getCondition());

        Label true_label = new Label(null);
        Label false_label = new Label(null);

        addInst(new Branch(currentLabel, true_label, false_label, condition));
        addInst(true_label);
        currentLabel = true_label;
        visit(node.getThen());
        addInst(new Jump(currentLabel, while_label));
        addInst(false_label);
        currentLabel = false_label;
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

    private void setNextLabel(Label label)
    {
        nextLabel = label;
        nextLabelStack.push(label);
    }

    private void exitNextLabel()
    {
        nextLabelStack.pop();
        nextLabel = nextLabelStack.peek();
    }

    private VirtualRegister getRegisterValue(IntegerValue value)
    {
        if(value instanceof Address)
        {
            VirtualRegister register = currentFunction.getRegister();
            addInst(new Load(currentLabel, register, (Address)value));
            return register;
        }
        else if(value instanceof Immediate)
        {
            VirtualRegister register = currentFunction.getRegister();
            addInst(new Load(currentLabel, register, (Immediate)value));
            return register;
        }
        else if(value instanceof VirtualRegister)
        {
            return (VirtualRegister)value;
        }
        else throw new RuntimeException("invalid operand");
    }

    private IntegerValue parseIfAddress(IntegerValue value)
    {
        if(value instanceof Address)
        {
            VirtualRegister register = currentFunction.getRegister();
            addInst(new Load(currentLabel, register, (Address)value));
            return register;
        }
        else return value;
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
            irType = new Array(convertType(((ArrayType)type).getBasic_type()), null);
        return irType;
    }

}
