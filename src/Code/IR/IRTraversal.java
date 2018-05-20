package Code.IR;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Type.Type;
import Code.IR.IRUnit.Function;
import Code.IR.IRUnit.IRInstruction;
import Code.IR.IRUnit.Value.Address;
import Code.IR.IRUnit.Value.Immediate;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.Type.Class;
import Code.IR.Type.IRType;

public interface IRTraversal
{
    void visit(ProgNode node);

    IRInstruction visit(DeclNode node);
    IRInstruction visit(ClassDecNode node);
    Function visit(FuncDecNode node);
    Address visit(VarDecNode node);
    IRType visit(FuncParamNode node);

    IntegerValue visit(ExprNode node);
    Immediate    visit(AndExprNode node);
    IntegerValue visit(ArrayExprNode node);
    IntegerValue visit(AssignExprNode node);
    IntegerValue visit(BinaryExprNode node);
    IntegerValue visit(BoolConstNode node);
    IntegerValue visit(CallExprNode node);
    IntegerValue visit(ExprListNode node);
    IntegerValue visit(IdExprNode node);
    Immediate    visit(IntConstNode node);
    IntegerValue visit(MemberExprNode node);
    IntegerValue visit(NewExprNode node);
    IntegerValue visit(CreatorNode node);
    IntegerValue visit(NullConstNode node);
    IntegerValue visit(OrExprNode node);
    IntegerValue visit(PrefixExprNode node);
    IntegerValue visit(StringConstNode node);
    IntegerValue visit(SuffixExprNode node);
    IntegerValue visit(ThisExprNode node);

    IRInstruction visit(StatNode node);
    IRInstruction visit(BlockNode node);
    IRInstruction visit(BreakNode node);
    IRInstruction visit(ContinueNode node);
    IRInstruction visit(ForNode node);
    IRInstruction visit(IfNode node);
    IRInstruction visit(ReturnNode node);
    IRInstruction visit(WhileNode node);
    IRInstruction visit(ExprStatNode node);

    IRType visit(Type type);
}
