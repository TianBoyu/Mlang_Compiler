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
import Code.IR.Type.BuiltIn;
import Code.IR.Type.Class;
import Code.IR.Type.IRType;
import jdk.nashorn.api.tree.ImportEntryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

//TODO
/*
 * Class(This
 * Function(FuncParam)
 * FunctionCall(ExprList)
 * Assign(ClassType & ArrayType)
 * Member
 * New(Creator)
 * Array
 */

public class IRConstructor implements IRTraversal
{
    private IRInstruction currentInst;
    private Label currentLabel;
    private Label nextLabel;
    private Stack<Label> nextLabelStack = new Stack<>();
    private IRScope currentIRScope;
    private FunctionScope currentFunction;
    private IRInstruction entry;
    private ProgNode program;
    public IRConstructor(ProgNode progNode)
    {
        this.program = progNode;
        currentFunction = new FunctionScope(new Name("GLOBAL"));
        setNextLabel(new Label("GLOBAL", null));
    }

    public IRInstruction getEntry()
    {
        return entry;
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
        if(node == null) return null;
        for(FuncDecNode item : node.getMemberFunction())
            visit(item);
        for(VarDecNode item : node.getMemberVarible())
            visit(item);
        return null;
    }

    @Override
    public Function visit(FuncDecNode node)
    {
//        currentFunction = new FunctionScope(node.getName());
//        setIRScope(node.getInternalScope().getIRScope());
        visit(node.getBlock());
//        IRType type;
//        if(node.getReturnType() instanceof ClassType)
//        {
//            type = visit(node.getReturnType().getClassNode());
//        }
//        else if(node.getReturnType() instanceof BuiltInType)
//        {
//            switch (node.getReturnType().getTypeName().toString())
//            {
//                case "int": break;
//                case "string": break;
//            }
//        }
        return null;

    }

    @Override
    public Address visit(VarDecNode node)
    {
        Address register = new Address(node.getName());
        addInst(new Alloca(currentLabel, register,  new Immediate(node.getType().getTypeSize())));
        if(node.getValue() != null)
        {
            addInst(new Store(currentLabel, register, visit(node.getValue())));
        }
        return register;
    }

    @Override
    public Address visit(FuncParamNode node)
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
        return null;
    }

    @Override
    public IntegerValue visit(AssignExprNode node)
    {
        if(node.getLhs().getExprType() instanceof BuiltInType)
        {
            addInst(new Store(currentLabel, visit(node.getLhs()), visit(node.getRhs())));
        }
        else
        {
            //memcpy
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
        return null;
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
//        if(!(currentIRScope.containsName(node.getName())))
//        {
//            VirtualRegister register = currentFunction.getRegister();
//            currentIRScope.addRegister(node.getName(), register);
//            addInst(new Load(currentLabel, register, new Address(node.getName())));
//            return register;
//        }
//        return currentIRScope.getRegister(node.getName());
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
        return null;
    }

    @Override
    public IntegerValue visit(NewExprNode node)
    {
        return null;
    }

    @Override
    public IntegerValue visit(CreatorNode node)
    {
        return null;
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

        Label for_label = new Label(null, BasicBlock.BlockType.FOR);
        Label true_label = new Label(null, BasicBlock.BlockType.FOR);
        Label false_label = new Label(null, BasicBlock.BlockType.FOR);

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
        Label true_label = new Label(null, BasicBlock.BlockType.IF);
        Label false_label = new Label(null, BasicBlock.BlockType.ELSE);
        Label end_label = new Label(null, null);
        if(node.getElseThen() == null)
        {
            addInst(new Branch(currentLabel, true_label, end_label, condition));
            addInst(true_label);
            visit(node.getThen());
        }
        else
        {
            addInst(new Branch(currentLabel, true_label, false_label, condition));
            addInst(true_label);
            visit(node.getThen());
            addInst(new Jump(currentLabel, end_label));
            addInst(false_label);
            visit(node.getElseThen());
            addInst(new Jump(currentLabel, end_label));
        }
        addInst(end_label);

        return null;
    }

    @Override
    public IRInstruction visit(ReturnNode node)
    {
//        VirtualRegister register = (VirtualRegister)visit(node.getExprNode());
        IntegerValue integerValue = visit(node.getExprNode());
        addInst(new Return(currentLabel, integerValue));
        return null;
    }

    @Override
    public IRInstruction visit(WhileNode node)
    {
        VirtualRegister condition = (VirtualRegister)visit(node.getCondition());
        Label while_label = new Label(null, BasicBlock.BlockType.WHILE);
        addInst(new Jump(currentLabel, while_label));
        addInst(while_label);
        currentLabel = while_label;
        Label true_label = new Label(null, BasicBlock.BlockType.WHILE);
        Label false_label = new Label(null, null);
        addInst(new Branch(currentLabel, true_label, false_label, condition));
        addInst(true_label);
        visit(node.getThen());
        addInst(new Jump(currentLabel, while_label));
        addInst(false_label);
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
    public void visit(Type type) throws Exception
    {

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
}
