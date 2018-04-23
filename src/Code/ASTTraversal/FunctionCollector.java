package Code.ASTTraversal;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Name;
import Code.AST.Tools.UnaryOp;
import Code.AST.Type.ArrayType;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.ASTTraversal.Scope.Scope;

import java.util.List;
import java.util.Stack;

public class FunctionCollector implements ASTTraversal
{
    private Scope currentScope;
    public Stack<Scope> scopeStack = new Stack<>();
    private ErrorHandler errorHandler;

    public FunctionCollector(Scope topScope, ErrorHandler handler)
    {
//        setCurrentScope(topScope);
        errorHandler = handler;
    }
    public void process(ProgNode progNode)
    {
        visit(progNode);
    }
    @Override
    public void visit(ProgNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getScope());
        for(DeclNode item : node.getDeclares())
            visit(item);
        node.setScope(currentScope);
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
        node.setInternalScope(currentScope);
        exitCurrentScope();
    }

    @Override
    public void visit(FuncDecNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        //TODO array type
        try
        {
            visit(node.getReturnType());
        }
        catch (Exception e)
        {
            errorHandler.addError(node.getPosition(), e.getMessage());
        }
//        if(!currentScope.containsType(node.getReturnType().getTypeName()))
//            errorHandler.addError(node.getPosition(),
//                    "type " + node.getReturnType().getTypeName() + " is not declared");
        if(!(node.getReturnType() instanceof ArrayType))
            node.setReturnType(currentScope.findType(node.getReturnType().getTypeName()));
        for(FuncParamNode item : node.getParameter())
            visit(item);
        node.getExternalScope().addNode(node);
        node.setInternalScope(currentScope);
        exitCurrentScope();
    }

    @Override
    public void visit(VarDecNode node)
    {

    }

    @Override
    public void visit(FuncParamNode node)
    {
        if(node == null) return;
        node.setScope(currentScope);
        try
        {
            visit(node.getType());
        }
        catch(Exception e)
        {
            errorHandler.addError(node.getPosition(), e.getMessage());
        }
//        if(!currentScope.containsType(node.getType().getTypeName()))
//            errorHandler.addError(node.getPosition(),
//                    "type " + node.getType().getTypeName() + " is not declared");
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
        //TODO
        if(node == null) return;
        visit(node.getExpr());
        visit(node.getMemberExpr());
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
        //TODO
    }

    @Override
    public void visit(StatNode node)
    {
        if(node == null) return;
        node.accept(this);
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
        if(type instanceof ArrayType)
        {
            if(!currentScope.containsNode(((ArrayType) type).getBaseType().getTypeName()))
            {
                throw new RuntimeException(((ArrayType) type).getBaseType().getTypeName().toString()
                        + " have not been declared");
            }
        }
        if(!currentScope.containsType(type.getTypeName()))
            throw new RuntimeException(type.getTypeName().toString() + " have not been declared");
    }
    private void setCurrentScope(Scope _currentScope)
    {
        currentScope = _currentScope;
        scopeStack.push(_currentScope);
    }
    private void exitCurrentScope()
    {
        currentScope = currentScope.getParent();
        scopeStack.pop();
    }
}
