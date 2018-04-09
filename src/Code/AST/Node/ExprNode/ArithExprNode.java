package Code.AST.Node.ExprNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;

public class ArithExprNode extends ExprNode
{
    public ExprNode lhs, rhs;
    public ArithExprNode(Position pos, ExprNode _lhs, ExprNode _rhs)
    {
        super(pos);
        lhs = _lhs;
        rhs = _rhs;
    }
    public void launchAnswer()
    {
        lhs.launchAnswer();
        rhs.launchAnswer();
    }
}
