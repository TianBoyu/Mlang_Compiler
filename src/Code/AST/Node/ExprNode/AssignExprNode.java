package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

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
