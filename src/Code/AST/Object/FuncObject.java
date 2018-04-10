package Code.AST.Object;

import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Type.Type;

public class FuncObject extends Object
{
    private ExprListNode formal_parameter;
    private Type return_type;
    public FuncObject(String _name, ExprListNode _param, Type _type)
    {
        super(_name);
        formal_parameter = _param;
        return_type = _type;
    }
    public final ExprListNode getParam()
    {
        return formal_parameter;
    }
    public final Type getReturnType()
    {
        return return_type;
    }
}
