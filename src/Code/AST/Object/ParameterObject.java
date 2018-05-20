package Code.AST.Object;

import Code.AST.Type.Type;

public class ParameterObject extends VarObject
{
    public ParameterObject(String _name, Type _type)
    {
        super(_name, false, _type);

    }

    @Override
    public Type getType()
    {
        return super.getType();
    }
}
