package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;

public class IntConstNode extends ConstExprNode
{
    public IntConstNode(Position _pos, int b)
    {
        super(_pos);
        value = b;
    }
    private int value;
    public int getValue()
    {
        return value;
    }
}
