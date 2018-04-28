package Code.AST.Object;

import Code.AST.Type.Type;
import Code.SemanticCheck.Scope.Scope;

public class VarObject extends Object
{
//    private String name;
    private Scope scope;
    private boolean is_global;
    private Type type;
    public VarObject(String _name, boolean _global, Type _type)
    {
        super(_name);
        is_global = _global;
        type = _type;
    }

    public Type getType()
    {
        return type;
    }

    public Scope getScope()
    {
        return scope;
    }

    public void setScope(Scope scope)
    {
        this.scope = scope;
    }

    public void setType(Type type)
    {
        this.type = type;
    }
}
