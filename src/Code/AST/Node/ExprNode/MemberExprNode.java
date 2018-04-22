package Code.AST.Node.ExprNode;

import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

public class MemberExprNode extends ExprNode
{
    public MemberExprNode(Position _pos, ExprNode e, ExprNode member)
    {
        super(_pos);
        expr = e;
//        member_name = Name.getName(member);
        member_expr = member;
        isLvalue = true;
    }
    private ExprNode expr;
    private ExprNode member_expr;

    public ExprNode getExpr() {
        return expr;
    }

    public ExprNode getMemberExpr() {
        return member_expr;
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
