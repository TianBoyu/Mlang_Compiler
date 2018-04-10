package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;

public class AssginExprNode extends ExprNode
{
    private ExprNode lhs, rhs;
    public AssginExprNode(Position _pos, ExprNode _lhs, ExprNode _rhs)
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
}
