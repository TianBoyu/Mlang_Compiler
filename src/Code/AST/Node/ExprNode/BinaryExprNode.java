package Code.AST.Node.ExprNode;

import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

public class BinaryExprNode extends ExprNode
{
    public BinaryExprNode(Position _pos, ExprNode _lhs, ExprNode _rhs, BinaryOp _op)
    {
        super(_pos);
        lhs = _lhs;
        rhs = _rhs;
        op = _op;
    }
    public BinaryOp getOp()
    {
        return op;
    }
    public ExprNode getLhs()
    {
        return lhs;
    }

    public ExprNode getRhs()
    {
        return rhs;
    }

    private ExprNode lhs, rhs;
    private BinaryOp op;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    @Override
    public IntegerValue accept(IRTraversal visitor)
    {
        return visitor.visit(this);
    }
}
