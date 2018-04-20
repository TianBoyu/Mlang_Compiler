package Code.AST.Object;

import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Type.Type;

public class FuncObject extends Object
{
    private ExprListNode parameter;
    private Type return_type;
    public FuncObject(String _name, ExprListNode _param, Type _type)
    {
        super(_name);
        parameter = _param;
        return_type = _type;
    }
    public final ExprListNode getParam()
    {
        return parameter;
    }
    public final Type getReturnType()
    {
        return return_type;
    }
}
