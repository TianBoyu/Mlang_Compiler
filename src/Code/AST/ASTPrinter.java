package Code.AST;

import Code.AST.Node.DeclNode.ClassDecNode;
import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Node.DeclNode.VarDecNode;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Tools.BinaryOp;
import Code.AST.Type.Type;
import Code.ASTVisitor.ASTVisitor;

import javax.swing.text.TabableView;
import java.io.FileOutputStream;
import java.io.PrintStream;

public class ASTPrinter implements ASTVisitor
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
        System.out.println("Wow! We enter into a new program! Let's see what've the fool coded");
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
//        node.getDeclares().stream().forEachOrdered(this::visit);
    }

    @Override
    public void visit(ClassDecNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + "Class: " + node.getName());
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
        printStream.println(indent.toString() + "Function: " + node.getName());
        Tab();
        if(node.getFunction().getReturnType() != null) visit(node.getFunction().getReturnType());
        visit(node.getFunction().getParam());
        visit(node.getBlock());
        BackSpace();
    }

    @Override
    public void visit(VarDecNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + "Varible: " + node.getName());
        Tab();
        visit(node.getVar().getType());
        BackSpace();
    }

    @Override
    public void visit(ExprNode node)
    {
        if(node == null) return;
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
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getOp().toString(node.getOp()));
        Tab();
        visit(node.getLhs());
        visit(node.getRhs());
        BackSpace();
    }

    @Override
    public void visit(BoolConstNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "value = " + node.getValue());
    }

    @Override
    public void visit(CallExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getFuncName());
        Tab();
        visit(node.getParam());
        BackSpace();
    }

    @Override
    public void visit(CompareExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getOp().toString(node.getOp()));
        Tab();
        visit(node.getLhs());
        visit(node.getRhs());
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
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "ID name: " + node.getName());
    }

    @Override
    public void visit(IntConstNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "value = " + node.getValue());
    }

    @Override
    public void visit(MemberExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "member name = " +node.getMember_name());
        Tab();
        visit(node.getExpr());
        BackSpace();
    }

    @Override
    public void visit(NewExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
        Tab();
        visit(node.getType());
        visit(node.getParameter());
        BackSpace();
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
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getOp().toString(node.getOp()));
        Tab();
        visit(node.getExprNode());
        BackSpace();
    }

    @Override
    public void visit(StringConstNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + "value = " + node.getValue());
    }

    @Override
    public void visit(SuffixExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getOp().toString(node.getOp()));
        Tab();
        visit(node.getExprNode());
        BackSpace();
    }

    @Override
    public void visit(UnitExprNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getName());
    }

    @Override
    public void visit(StatNode node)
    {
        if(node == null) return;
        printStream.println(indent.toString() + node.getClass().getSimpleName());
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
        printStream.println(indent.toString() + node.getClass().getSimpleName() + node.getTypeName());
    }
}
