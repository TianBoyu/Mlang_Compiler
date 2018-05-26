package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Tools.UnaryOp;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;

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
    @Override
    public IntegerValue accept(IRTraversal visitor)
    {
        return visitor.visit(this);
    }
}
