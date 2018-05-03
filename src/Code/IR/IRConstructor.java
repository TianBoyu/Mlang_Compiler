package Code.IR;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Type.Type;
import Code.IR.IRUnit.IRInstruction;
import Code.SemanticCheck.ASTTraversal;

public class IRConstructor implements ASTTraversal
{
    private IRInstruction currentInst;
    public IRConstructor(IRInstruction entry)
    {
        currentInst = entry;
    }
    @Override
    public void visit(ProgNode node)
    {
        for(DeclNode item : node.getDeclares())
        {
            if(item instanceof ClassDecNode)
                ((ClassDecNode) item).initTypeSize();
        }
    }

    @Override
    public void visit(DeclNode node)
    {
        if(node == null) return;
        node.accept(this);
    }

    @Override
    public void visit(ClassDecNode node)
    {
        if(node == null) return;
        for(FuncDecNode item : node.getMemberFunction())
            visit(item);
        for(VarDecNode item : node.getMemberVarible())
            visit(item);
    }

    @Override
    public void visit(FuncDecNode node)
    {

    }

    @Override
    public void visit(VarDecNode node)
    {

    }

    @Override
    public void visit(FuncParamNode node)
    {

    }

    @Override
    public void visit(ExprNode node)
    {

    }

    @Override
    public void visit(AndExprNode node)
    {

    }

    @Override
    public void visit(ArrayExprNode node)
    {

    }

    @Override
    public void visit(AssignExprNode node)
    {

    }

    @Override
    public void visit(BinaryExprNode node)
    {

    }

    @Override
    public void visit(BoolConstNode node)
    {

    }

    @Override
    public void visit(CallExprNode node)
    {

    }

    @Override
    public void visit(ExprListNode node)
    {

    }

    @Override
    public void visit(IdExprNode node)
    {

    }

    @Override
    public void visit(IntConstNode node)
    {

    }

    @Override
    public void visit(MemberExprNode node)
    {

    }

    @Override
    public void visit(NewExprNode node)
    {

    }

    @Override
    public void visit(CreatorNode node)
    {

    }

    @Override
    public void visit(NullConstNode node)
    {

    }

    @Override
    public void visit(OrExprNode node)
    {

    }

    @Override
    public void visit(PrefixExprNode node)
    {

    }

    @Override
    public void visit(StringConstNode node)
    {

    }

    @Override
    public void visit(SuffixExprNode node)
    {

    }

    @Override
    public void visit(ThisExprNode node)
    {

    }

    @Override
    public void visit(StatNode node)
    {

    }

    @Override
    public void visit(BlockNode node)
    {

    }

    @Override
    public void visit(BreakNode node)
    {

    }

    @Override
    public void visit(ContinueNode node)
    {

    }

    @Override
    public void visit(ForNode node)
    {

    }

    @Override
    public void visit(IfNode node)
    {

    }

    @Override
    public void visit(ReturnNode node)
    {

    }

    @Override
    public void visit(WhileNode node)
    {

    }

    @Override
    public void visit(ExprStatNode node)
    {

    }

    @Override
    public void visit(Type type) throws Exception
    {

    }

    private void addInst(IRInstruction instruction)
    {
        instruction.setLast(currentInst);
        currentInst.setNext(instruction);
        currentInst = instruction;
    }
}
