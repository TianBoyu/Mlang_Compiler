package Code.AST.Tools;

import Code.AST.Type.Type;

public class Variable
{
    private boolean is_global;
    private String name;
    private Type type;
    public Variable(boolean _is_global, String _name)
    {
        is_global = _is_global;
        name = _name;
    }
    public String getName()
    {
        return name;
    }
    public boolean isGlobal()
    {
        return is_global;
    }
}
