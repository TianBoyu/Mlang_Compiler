package Code.AST.Object;

import Code.AST.Tools.Position;
import Code.AST.Type.Type;

public class ParameterObject extends VarObject
{
    public ParameterObject(String _name, Type _type)
    {
        super(_name, false, _type);
    }
    private Type type;
}