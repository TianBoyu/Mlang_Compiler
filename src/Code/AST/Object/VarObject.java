package Code.AST.Object;

import Code.AST.Type.Type;

public class VarObject extends Object
{
    private boolean is_global;
    private Type type;
    public VarObject(String _name, boolean _global, Type _type)
    {
        super(_name);
        is_global = _global;
        type = _type;
    }
}
