package Code.ASTTraversal;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Tools.Name;
import Code.AST.Tools.UnaryOp;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.ASTTraversal.Scope.Scope;

import java.util.Stack;

public class VariableCollector implements ASTTraversal
{
    private Scope currentScope;
    public Stack<Scope> scopeStack = new Stack<>();
    private ErrorHandler errorHandler;

    public VariableCollector(Scope topScope, ErrorHandler handler)
    {
        setCurrentScope(topScope);
        errorHandler = handler;
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
        if(!currentScope.containsType(node.getReturnType().getTypeName()))
            errorHandler.addError(node.getPosition(),
                    "type " + node.getReturnType().getTypeName() + " is not declared");
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
        visit(node.getValue());
        if(!currentScope.containsType(node.getType().getTypeName()))
            errorHandler.addError(node.getPosition(),
                    "type " + node.getType().getTypeName() + " is not declared");
        node.setType(currentScope.findType(node.getType().getTypeName()));
        if(node.getType() != node.getValue().getExprType())
            errorHandler.addError(node.getPosition(),
                    node.getValue().getExprType().toString() + " cannot be assigned to " + node.getName().toString());
        currentScope.addNode(node);
    }

    @Override
    public void visit(FuncParamNode node)
    {
        if(node == null) return;
        node.setScope(currentScope);
        if(!currentScope.containsType(node.getType().getTypeName()))
            errorHandler.addError(node.getPosition(),
                    "type " + node.getType().getTypeName() + " is not declared");
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
        visit(node.getCond1());
        visit(node.getCond1());
        if(node.getCond1().getExprType().getTypeName() != Name.getName("bool")
                || node.getCond1().getExprType().getTypeName() != Name.getName("bool"))
            errorHandler.addError(node.getPosition(), "condition must be of bool type");
        node.setExprType(node.getCond1().getExprType());
    }

    @Override
    public void visit(ArrayExprNode node)
    {
        visit(node.getIndex());
        if(node.getIndex().getExprType().getTypeName() != Name.getName("int"))
            errorHandler.addError(node.getPosition(), "array index must be an integer"
                    + ", finding " + node.getIndex().getExprType().getTypeName().toString());
        //TODO set Expr type
    }

    @Override
    public void visit(AssignExprNode node)
    {
        if(node == null) return;
        if(!node.getLhs().isLvalue())
            errorHandler.addError(node.getPosition(),
                    "assign operator can only be applied to a left value");
        visit(node.getLhs());
        visit(node.getRhs());
        if(node.getLhs().getExprType().getTypeName() != node.getRhs().getExprType().getTypeName())
            errorHandler.addError(node.getPosition(), "cannot cast from "
                    + node.getLhs().getExprType().getTypeName().toString() + " to "
                    + node.getLhs().getExprType().getTypeName().toString());
    }

    @Override
    public void visit(BinaryExprNode node)
    {
        if(node == null) return;
        visit(node.getLhs());
        visit(node.getRhs());
        if(node.getLhs().getExprType().getTypeName() != node.getRhs().getExprType().getTypeName())
            errorHandler.addError(node.getPosition(), "cannot operate with type "
                    + node.getLhs().getExprType().getTypeName().toString() + " and type "
                    + node.getLhs().getExprType().getTypeName().toString());
        node.setExprType(node.getLhs().getExprType());

    }

    @Override
    public void visit(BoolConstNode node)
    {

    }

    @Override
    public void visit(CallExprNode node)
    {
        if(node == null)return;
        if(!currentScope.containsNode(node.getFuncName()))
            errorHandler.addError(node.getPosition(),
                    "function " + node.getFuncName().toString() + " have not been declared");
        FuncDecNode function = (FuncDecNode)currentScope.findNode(node.getFuncName());
        if(!function.isFunction())
            errorHandler.addError(node.getPosition(),
                    node.getFuncName().toString() + " is not a function");
        visit(node.getParam());
        node.setExprType(function.getReturnType());
        //TODO check param type matches
    }


    @Override
    public void visit(ExprListNode node)
    {
        if(node == null)return;
        for(ExprNode item : node.getExprs())
            visit(item);
    }

    @Override
    public void visit(IdExprNode node)
    {
        if(node == null) return;
        if(!currentScope.containsNode(node.getName()))
            errorHandler.addError(node.getPosition(),
                    node.getName().toString() + "have not been declared");
        VarDecNode var = (VarDecNode)currentScope.findNode(node.getName());
        node.setExprType(var.getType());
    }

    @Override
    public void visit(IntConstNode node)
    {

    }

    @Override
    public void visit(MemberExprNode node)
    {
        //TODO
    }

    @Override
    public void visit(NewExprNode node)
    {
        if(node == null) return;
        visit(node.getParameter());
        if(!currentScope.containsType(node.getType().getTypeName()))
            errorHandler.addError(node.getPosition(),
                    node.getType().getTypeName() + " is not declared");
        node.setType(currentScope.findType(node.getType().getTypeName()));
        node.setExprType(node.getType());
    }

    @Override
    public void visit(NullConstNode node)
    {

    }

    @Override
    public void visit(OrExprNode node)
    {
        if(node == null) return;
        visit(node.getCond1());
        visit(node.getCond1());
        if(node.getCond1().getExprType().getTypeName() != Name.getName("bool")
                || node.getCond1().getExprType().getTypeName() != Name.getName("bool"))
            errorHandler.addError(node.getPosition(), "condition must be of bool type");
        node.setExprType(node.getCond1().getExprType());
    }

    @Override
    public void visit(PrefixExprNode node)
    {
        if(node == null)return;
        if(UnaryOp.changeValue(node.getOp()) && !node.getExprNode().isLvalue())
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + " can only be applied to a left value");
        if(node.getOp() != UnaryOp.NOT && node.getExprType().getTypeName() != Name.getName("int"))
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + "can only be applied to integer");
        node.setExprType(node.getExprNode().getExprType());

    }

    @Override
    public void visit(StringConstNode node)
    {

    }

    @Override
    public void visit(SuffixExprNode node)
    {
        if(node == null)return;
        if(!UnaryOp.isSuffix(node.getOp()))
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + "is a prefix operator");
        if(UnaryOp.changeValue(node.getOp()) && !node.getExprNode().isLvalue())
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + " can only be applied to a left value");
        if(!(node.getExprNode().getExprType().getTypeName() == Name.getName("int")))
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + "can only be applied to integer");
        node.setExprType(node.getExprNode().getExprType());

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
        if(node == null) return;
        for(StatNode item : node.getStatements())
            visit(item);
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
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        visit(node.getBeginCondition());
        visit(node.getEndCondition());
        visit(node.getUpdate());
        visit(node.getBlock());
        exitCurrentScope();
        //TODO type of end condition should be bool
    }

    @Override
    public void visit(IfNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        visit(node.getCondition());
        visit(node.getThen());
        if(node.getElseThen() != null)
            visit(node.getElseThen());
        exitCurrentScope();
    }

    @Override
    public void visit(ReturnNode node)
    {

    }

    @Override
    public void visit(WhileNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        visit(node.getCondition());
        visit(node.getThen());
        exitCurrentScope();
    }

    @Override
    public void visit(ExprStatNode node)
    {
        visit(node.getExpr());
    }

    @Override
    public void visit(Type type)
    {

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
