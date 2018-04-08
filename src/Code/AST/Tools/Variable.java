package Code.AST.Tools;

public class Variable
{
    private boolean is_global;
    private String name;
    private Types type;
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
