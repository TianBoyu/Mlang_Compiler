package Code.AST.Node.ExprNode;

import Code.AST.Object.BuiltInObject;
import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;

public class ConstExprNode extends ExprNode
{
    private BuiltInType type;
    private BuiltInObject value;
    public ConstExprNode(Position _pos, BuiltInType _type, BuiltInObject _value)
    {
        super(_pos);
        type = _type;
        value = _value;
    }
    public final BuiltInType getType()
    {
        return type;
    }
    public final BuiltInObject getValue()
    {
        return value;
    }
}
