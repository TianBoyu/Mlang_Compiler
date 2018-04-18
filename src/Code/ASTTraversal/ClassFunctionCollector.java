package Code.ASTTraversal;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.ASTTraversal.Scope.ClassScope;
import Code.ASTTraversal.Scope.Scope;
import Code.ASTTraversal.Table.FunctionTable;
import Code.ASTTraversal.Table.TypeTable;

public class ClassFunctionCollector implements ASTTraversal
{
    private ClassScope currentScope;
    private FunctionTable functionTable;
    private TypeTable typeTable;
    ClassFunctionCollector(FunctionTable _functionTable, TypeTable _typeTable)
    {
        functionTable = _functionTable;
        typeTable = _typeTable;
        currentScope = new ClassScope(new ClassType("global", 0));
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
        if(typeTable.containElement(node.getName()))
            throw new RuntimeException("class " + node.getName() + " have already been declared");
        if(!typeTable.addElement(node.getName(), node.getType()))
            throw new RuntimeException("class: " + node.getName() + " declaration failed");
        setCurrentScope(new ClassScope(node.getType()));
        for(FuncDecNode item : node.getMemberFunction())
        {
            visit(item);
        }
    }

    @Override
    public void visit(FuncDecNode node)
    {
        node.setScope(currentScope);
        if(functionTable.containElement(node.getName()))
            throw new RuntimeException("function: " + node.getName() + " have already been declared");
        if(!functionTable.addElement(node.getName(), node))
            throw new RuntimeException("function: " + node.getName() + " declaration failed");
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
    private void setCurrentScope(ClassScope _currentScope)
    {
        currentScope = _currentScope;
    }
}
