package Code.AST.Node.ExprNode;

import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

public class MemberExprNode extends ExprNode
{
    public MemberExprNode(Position _pos, ExprNode e, String member)
    {
        super(_pos);
        expr = e;
        member_name = Name.getName(member);
        isLvalue = true;
    }
    private ExprNode expr;
    private Name member_name;

    public ExprNode getExpr() {
        return expr;
    }

    public Name getMember_name() {
        return member_name;
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
