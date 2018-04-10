package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;

import java.util.List;

public class ExprListNode extends ExprNode
{
    private List<ExprNode> expr;
    public ExprListNode(Position _pos, List<ExprNode> _expr)
    {
        super(_pos);
        expr = _expr;
    }
}
