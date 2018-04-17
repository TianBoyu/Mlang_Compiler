package Code.ASTVisitor;

import Code.AST.Node.DeclNode.ClassDecNode;
import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Node.DeclNode.VarDecNode;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Type.Type;

public interface ASTVisitor
{
    void visit(ProgNode node);

    void visit(ClassDecNode node);
    void visit(FuncDecNode node);
    void visit(VarDecNode node);

    void visit(ExprNode node);
    void visit(AndExprNode node);
    void visit(ArrayExprNode node);
    void visit(AssignExprNode node);
    void visit(BinaryExprNode node);
    void visit(BoolConstNode node);
    void visit(CallExprNode node);
    void visit(CompareExprNode node);
    void visit(ExprListNode node);
    void visit(IdExprNode node);
    void visit(IntConstNode node);
    void visit(MemberExprNode node);
    void visit(NewExprNode node);
    void visit(NullConstNode node);
    void visit(OrExprNode node);
    void visit(PrefixExprNode node);
    void visit(StringConstNode node);
    void visit(SuffixExprNode node);
    void visit(UnitExprNode node);

    void visit(StatNode node);
    void visit(BlockNode node);
    void visit(BreakNode node);
    void visit(ContinueNode node);
    void visit(ForNode node);
    void visit(IfNode node);
    void visit(ReturnNode node);
    void visit(WhileNode node);

    void visit(Type type);
}
