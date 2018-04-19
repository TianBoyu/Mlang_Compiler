package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Tools.UnaryOp;

public abstract class UnaryExprNode extends ExprNode
{
    public UnaryExprNode(Position _pos, UnaryOp _op, ExprNode e)
    {
        super(_pos);
        op = _op;
        exprNode = e;
    }
    private UnaryOp op;
    private ExprNode exprNode;

    public UnaryOp getOp()
    {
        return op;
    }

    public ExprNode getExprNode()
    {
        return exprNode;
    }
}