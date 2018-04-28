package Code.AST;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Type.Type;
import Code.SemanticCheck.ASTTraversal;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class ASTPrinter implements ASTTraversal
{
    private StringBuilder indent = new StringBuilder();
    private PrintStream printStream;
    private void Tab()
    {
        indent.append("  ");
    }
    private void BackSpace()
    {
        indent.delete(indent.length() - 2, indent.length());
    }

    public void PrintAST(ProgNode program, FileOutputStream outputStream)
    {
        printStream = new PrintStream(outputStream);
        visit(program);
    }
    @Override
    public void visit(ProgNode node)
    {
//        System.out.println("Wow! We enter into a new program! Let's see what've the fool coded");
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
//        node.getDeclares().stream().forEachOrdered(this::visit);
        for(DeclNode item : node.getDeclares())
            visit(item);
        BackSpace();
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
        printStream.println(indent.toString() + "*ClassDeclaration: " + node.getName());
        Tab();
        for(FuncDecNode item : node.getMemberFunction())
            visit(item);
        for(VarDecNode item : node.getMemberVarible())
            visit(item);
        BackSpace();
    }

    @Override
    public void visit(FuncDecNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + "*FunctionDeclaration: " + node.getName());
        Tab();
        if(node.getFunction().getReturnType() != null) visit(node.getFunction().getReturnType());
        if(node.getFunction().getParam() != null)
        {
            for (FuncParamNode item : node.getFunction().getParam())
                visit(item);
        }
        visit(node.getBlock());
        BackSpace();
    }

    @Override
    public void visit(CreatorNode node)
    {

    }

    @Override
    public void visit(VarDecNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + "*VariableDeclaration: " + node.getName());
        Tab();
        visit(node.getVar().getType());
        if(node.getValue() != null)
            visit(node.getValue());
        BackSpace();
    }

    @Override
    public void visit(FuncParamNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName()
         + " Type: " + node.getParam().getType().getTypeName() + "    Name: " + node.getParam().getName());
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
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getCond1());
        visit(node.getCond2());
        BackSpace();
    }

    @Override
    public void visit(ArrayExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getArray());
        visit(node.getIndex());
        BackSpace();
    }

    @Override
    public void visit(AssignExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getLhs());
        visit(node.getRhs());
        BackSpace();
    }

    @Override
    public void visit(BinaryExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  Op: " + node.getOp().toString(node.getOp()));
        Tab();
        visit(node.getLhs());
        visit(node.getRhs());
        BackSpace();
    }

    @Override
    public void visit(BoolConstNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  value = " + node.getValue());
    }

    @Override
    public void visit(CallExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  Function Name: " + node.getFuncName());
        Tab();
        visit(node.getParam());
        BackSpace();
    }


    @Override
    public void visit(ExprListNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        for(ExprNode item : node.getExprs())
        {
            visit(item);
        }
        BackSpace();
    }

    @Override
    public void visit(IdExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  ID name: " + node.getName());
    }

    @Override
    public void visit(ExprStatNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getExpr());
        BackSpace();
    }

    @Override
    public void visit(IntConstNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  value = " + node.getValue());
    }

    @Override
    public void visit(MemberExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getExpr());
        BackSpace();
    }

    @Override
    public void visit(NewExprNode node)
    {
//        if(node == null) return;
//        printStream.println(indent.toString() + node.getClass().getSimpleName());
//        Tab();
//        visit(node.getType());
//        visit(node.getParameter());
//        BackSpace();
    }

    @Override
    public void visit(NullConstNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
    }

    @Override
    public void visit(OrExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getCond1());
        visit(node.getCond2());
        BackSpace();
    }

    @Override
    public void visit(PrefixExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  Op: " + node.getOp().toString(node.getOp()));
        Tab();
        visit(node.getExprNode());
        BackSpace();
    }

    @Override
    public void visit(StringConstNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  value = " + node.getValue());
    }

    @Override
    public void visit(SuffixExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "  Op: " + node.getOp().toString(node.getOp()));
        Tab();
        visit(node.getExprNode());
        BackSpace();
    }

    @Override
    public void visit(ThisExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getName());
    }

    @Override
    public void visit(StatNode node)
    {
        if(node == null) return;
//        printStream.println(indent.toString() + node.getClass().getSimpleName());
        node.accept(this);
    }

    @Override
    public void visit(BlockNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        for(StatNode item : node.getStatements())
        {
            visit(item);
        }
        BackSpace();
    }

    @Override
    public void visit(BreakNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
    }

    @Override
    public void visit(ContinueNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
    }

    @Override
    public void visit(ForNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getBeginCondition());
        visit(node.getEndCondition());
        visit(node.getUpdate());
        visit(node.getBlock());
        BackSpace();
    }

    @Override
    public void visit(IfNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getCondition());
        visit(node.getThen());
        if(node.getElseThen() != null) visit(node.getElseThen());
        BackSpace();
    }

    @Override
    public void visit(ReturnNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
    }

    @Override
    public void visit(WhileNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getCondition());
        visit(node.getThen());
        BackSpace();
    }

    @Override
    public void visit(Type node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + ": " + node.getTypeName());
    }
}
