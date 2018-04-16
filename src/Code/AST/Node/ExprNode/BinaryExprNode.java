package Code.AST.Node.ExprNode;

import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Position;

public class BinaryExprNode extends ExprNode
{
    public BinaryExprNode(Position _pos, ExprNode _lhs, ExprNode _rhs, BinaryOp _op)
    {
        super(_pos);
        lhs = _lhs;
        rhs = _rhs;
        op = _op;
    }
    public final BinaryOp getOp()
    {
        return op;
    }
    public final ExprNode getLhs()
    {
        return lhs;
    }
    private ExprNode lhs, rhs;
    private BinaryOp op;
}
