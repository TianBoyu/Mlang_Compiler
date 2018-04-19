package Code.ASTTraversal;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.ASTTraversal.Scope.Scope;

import java.util.Stack;

public class VariableCollector implements ASTTraversal
{
    private Scope currentScope;
    public Stack<Scope> scopeStack = new Stack<>();

    public VariableCollector(Scope topScope)
    {
        currentScope = topScope;
        scopeStack.push(currentScope);
    }
    @Override
    public void visit(ProgNode node)
    {
        if(node == null) return;
        for(DeclNode item : node.getDeclares())
            visit(item);
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
        setCurrentScope(node.getInternalScope());
        for(FuncDecNode item : node.getMemberFunction())
            visit(item);
        for(VarDecNode item : node.getMemberVarible()   )
            visit(item);
        exitCurrentScope();
    }

    @Override
    public void visit(FuncDecNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        node.setReturnType(currentScope.findType(node.getReturnType().getTypeName()));
        for(FuncParamNode item : node.getParameter())
            visit(item);
        visit(node.getBlock());
        exitCurrentScope();
    }

    @Override
    public void visit(VarDecNode node)
    {
        if(node == null) return;
        node.setScope(currentScope);
        node.setType(currentScope.findType(node.getType().getTypeName()));
        currentScope.addNode(node);
    }

    @Override
    public void visit(FuncParamNode node)
    {
        if(node == null) return;
        node.setScope(currentScope);
        node.setType(currentScope.findType(node.getType().getTypeName()));
        currentScope.addNode(node);
    }

    @Override
    public void visit(ExprNode node)
    {
        if(node == null) return;
        node.accept(this);
    }

    @Override
    public void visit(AndExprNode node)
    {
        if(node == null) return;

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
    public void visit(CompareExprNode node)
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
    public void visit(UnitExprNode node)
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
    public void visit(Type type)
    {

    }
    private void setCurrentScope(Scope _currentScope)
    {
        currentScope = _currentScope;
    }
    private void exitCurrentScope()
    {
        currentScope = currentScope.getParent();
    }
}
