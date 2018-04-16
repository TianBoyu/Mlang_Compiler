package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Type.Type;

public class NewExprNode extends ExprNode
{
    public NewExprNode(Position _pos, Type _type, ExprListNode _para)
    {
        super(_pos);
        type = _type;
        parameter = _para;
    }
    private Type type;
    private ExprListNode parameter;

    public Type getType() {
        return type;
    }

    public ExprListNode getParameter() {
        return parameter;
    }
}
