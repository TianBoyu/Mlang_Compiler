package Code.AST.Object;

import Code.AST.Tools.Position;
import Code.AST.Type.Type;

public class ParameterObject extends Object
{
    public ParameterObject(Type _type, String _name)
    {
        super(_name);
        type = _type;
    }
    private Type type;
}
