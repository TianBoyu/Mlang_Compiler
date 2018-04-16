package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;

public class IdExprNode extends ExprNode
{
    public IdExprNode(Position _pos, String _name)
    {
        super(_pos);
        name = _name;
    }
    String name;
    public String getName() {
        return name;
    }
}
