package Code.AST.Node.ExprNode;

import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Position;

public class CompareExprNode extends ExprNode
{
    private ExprNode lhs;
    private ExprNode rhs;
    private BinaryOp op;
    CompareExprNode(Position _pos, ExprNode _lhs, ExprNode _rhs, BinaryOp _op)
    {
        super(_pos);
        lhs = _lhs;
        rhs = _rhs;
        op  = _op;
    }
    public final ExprNode getLhs()
    {
        return lhs;
    }
    public final ExprNode getRhs()
    {
        return rhs;
    }
    public final BinaryOp getOp()
    {
        return op;
    }
}
