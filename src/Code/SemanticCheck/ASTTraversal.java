package Code.SemanticCheck;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Type.Type;

public interface ASTTraversal
{
    void visit(ProgNode node);

    void visit(DeclNode node);
    void visit(ClassDecNode node);
    void visit(FuncDecNode node);
    void visit(VarDecNode node);
    void visit(FuncParamNode node);

    void visit(ExprNode node);
    void visit(AndExprNode node);
    void visit(ArrayExprNode node);
    void visit(AssignExprNode node);
    void visit(BinaryExprNode node);
    void visit(BoolConstNode node);
    void visit(CallExprNode node);
    void visit(ExprListNode node);
    void visit(IdExprNode node);
    void visit(IntConstNode node);
    void visit(MemberExprNode node);
    void visit(NewExprNode node);
    void visit(CreatorNode node);
    void visit(NullConstNode node);
    void visit(OrExprNode node);
    void visit(PrefixExprNode node);
    void visit(StringConstNode node);
    void visit(SuffixExprNode node);
    void visit(ThisExprNode node);

    void visit(StatNode node);
    void visit(BlockNode node);
    void visit(BreakNode node);
    void visit(ContinueNode node);
    void visit(ForNode node);
    void visit(IfNode node);
    void visit(ReturnNode node);
    void visit(WhileNode node);
    void visit(ExprStatNode node);

    void visit(Type type) throws Exception;
}
