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
import Code.IR.IRUnit.Value.*;
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
    public IRConstructor(ProgNode progNode)
    {
        this.program = progNode;
        currentFunction = new FunctionScope(new Name("GLOBAL"));
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

    public void BuildIR()
    {
        visit(program);
    }

    @Override
    public void visit(ProgNode node)
    {
        setIRScope(node.getScope().getIRScope());
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
        List<IRType> params = new ArrayList<>();
        if(currentClass != null)
            params.add(new Class(currentClass.getName()));
        for(FuncParamNode item : node.getParameter())
            params.add(convertType(item.getType()));
        Name name = FunctionRename(node.getName());
        addInst(new Function(currentLabel, name, type, params));
        currentFunction = new FunctionScope(node.getName());
        currentFunction.setFuncDecNode(node);
        setIRScope(node.getInternalScope().getIRScope());
//        visitFormalParameter(node.getParameter());
        visit(node.getBlock());
        exitIRScope();
        return null;
    }

    private Name FunctionRename(Name origin_name)
    {
        Name new_name = currentClass == null? origin_name :
                new Name("__" + currentClass.getName().toString() + "__" + origin_name.toString());
        return new_name;
    }

    private void visitFormalParameter(List<FuncParamNode> parameters)
    {
//        for(FuncParamNode item : parameters)
//        {
//            VirtualRegister register = currentFunction.getRegister();
//            Address param = new Address(item.getName());
//            addInst(new Alloca(currentLabel, param, new Immediate(item.getType().getTypeSize())));
//            addInst(new Store(currentLabel, param, register));
//        }
    }

    @Override
    public Address visit(VarDecNode node)
    {
        Address address = new Address(node.getName());
        addInst(new Alloca(currentLabel, address,  convertType(node.getType())));
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
        VirtualRegister dest = currentFunction.getRegister();
        if(BinaryOp.isCompare(node.getOp()))
        {
            Compare.Condition condition;
            switch (node.getOp())
            {
                case SLT: condition = Compare.Condition.SLT; break;
                case SGT: condition = Compare.Condition.SGT; break;
                case SEQ: condition = Compare.Condition.SEQ; break;
                case BEQ: condition = Compare.Condition.BEQ; break;
                case EQU: condition = Compare.Condition.EQU; break;
                case NEQ: condition = Compare.Condition.NEQ; break;
                default: condition = null; break;
            }
            addInst(new Compare(currentLabel, condition, dest, getRegisterValue(visit(node.getLhs())),
                    getRegisterValue(visit(node.getRhs()))));
        }
        else
        {
            BinaryOperation.BinaryOp op;
            switch (node.getOp())
            {
                case ADD: op = BinaryOperation.BinaryOp.ADD; break;
                case MIN: op = BinaryOperation.BinaryOp.SUB; break;
                case MUL: op = BinaryOperation.BinaryOp.MUL; break;
                case DIV: op = BinaryOperation.BinaryOp.DIV; break;
                case L_SHIFT: op = BinaryOperation.BinaryOp.SHL; break;
                case R_SHIFT: op = BinaryOperation.BinaryOp.SHR; break;
                case MOD: op = BinaryOperation.BinaryOp.MOD; break;
                case BIT_AND: op = BinaryOperation.BinaryOp.AND; break;
                case BIT_OR: op = BinaryOperation.BinaryOp.OR; break;
                case BIT_XOR: op = BinaryOperation.BinaryOp.XOR; break;
                default: op = null; break;
            }
            addInst(new BinaryOperation(currentLabel, op, dest, getRegisterValue(visit(node.getLhs())),
                    getRegisterValue(visit(node.getRhs()))));
        }
        return dest;
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
        Address address = new Address(currentFunction.getRegister().getName());
        addInst(new Alloca(currentLabel, address, convertType(node.getFunction().getReturnType())));
        List<IntegerValue> params = new ArrayList<>();
        for(ExprNode item : node.getParam().getExprs())
        {
            params.add(visit(item));
        }
        addInst(new Call(currentLabel, address, FunctionRename(node.getFuncName()), params));
        if(node.getFunction().getReturnType() instanceof BuiltInType)
            return getRegisterValue(address);
        else return address;
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
        return new Address(node.getName());
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
            node.getFunctionCall().setFunctionName(new Name("__" + name.toString() + "__" + node.getFunctionCall().getFuncName()));
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
        Address address = new Address(currentFunction.getRegister().getName());
        addInst(new Alloca(currentLabel, address, convertType(node.getType())));
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
        VirtualRegister register = currentFunction.getRegister();
        switch (node.getOp())
        {
            case NEG:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.SUB, register,
                        new Immediate(0), getRegisterValue(visit(node.getExprNode()))));
                break;
            case NOT:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.XOR, register,
                        new Immediate(1), getRegisterValue(visit(node.getExprNode()))));
                break;
            case BIT_NOT:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.XOR, register,
                        new Immediate(-1), getRegisterValue(visit(node.getExprNode()))));
                break;
            case POS:
                return getRegisterValue(visit(node.getExprNode()));
            case DECRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.SUB, register,
                        new Immediate(1), getRegisterValue(visit(node.getExprNode()))));
                break;
            case INCRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.ADD, register,
                        new Immediate(1), getRegisterValue(visit(node.getExprNode()))));
                break;
        }
        return register;
    }

    @Override
    public IntegerValue visit(StringConstNode node)
    {
        //TODO
        return null;
    }

    @Override
    public IntegerValue visit(SuffixExprNode node)
    {
        IntegerValue register = getRegisterValue(visit(node.getExprNode()));
        VirtualRegister new_reg = currentFunction.getRegister();
        switch(node.getOp())
        {
            case SUF_DECRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.SUB,
                        new_reg, register, new Immediate(1)));
                return register;
            case SUF_INCRE:
                addInst(new BinaryOperation(currentLabel, BinaryOperation.BinaryOp.SUB,
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
        if(currentFunction.getFuncDecNode().getReturnType() instanceof BuiltInType)
            addInst(new Return(currentLabel, getRegisterValue(integerValue)));
        else
            addInst(new Return(currentLabel, integerValue));
        return null;
    }

    @Override
    public IRInstruction visit(WhileNode node)
    {
        VirtualRegister condition = (VirtualRegister)visit(node.getCondition());
        Label while_label = new Label(null);
        addInst(new Jump(currentLabel, while_label));

        addInst(while_label);
        currentLabel = while_label;

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

    private IntegerValue getRegisterValue(IntegerValue value)
    {
        if(value instanceof Address)
        {
            VirtualRegister register = currentFunction.getRegister();
            addInst(new Load(currentLabel, register, (Address) value));
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
