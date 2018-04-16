package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;

public class ArrayExprNode extends ExprNode
{
    public ArrayExprNode(Position _pos, ExprNode _array, ExprNode _index)
    {
        super(_pos);
        array = _array;
        index = _index;
    }
    private ExprNode array;
    private ExprNode index;

    public ExprNode getArray() {
        return array;
    }

    public ExprNode getIndex() {
        return index;
    }
}
