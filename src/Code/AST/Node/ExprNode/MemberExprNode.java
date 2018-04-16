package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;

public class MemberExprNode extends ExprNode
{
    public MemberExprNode(Position _pos, ExprNode e, String member)
    {
        super(_pos);
        expr = e;
        member_name = member;
    }
    private ExprNode expr;
    private String member_name;

    public ExprNode getExpr() {
        return expr;
    }

    public String getMember_name() {
        return member_name;
    }
}
