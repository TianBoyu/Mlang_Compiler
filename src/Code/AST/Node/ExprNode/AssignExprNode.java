package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

public class AssignExprNode extends ExprNode
{
    private ExprNode lhs, rhs;
    public AssignExprNode(Position _pos, ExprNode _lhs, ExprNode _rhs)
    {
        super(_pos);
        lhs = _lhs;
        rhs = _rhs;
    }
    public final ExprNode getLhs()
    {
        return lhs;
    }
    public final ExprNode getRhs()
    {
        return rhs;
    }
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
