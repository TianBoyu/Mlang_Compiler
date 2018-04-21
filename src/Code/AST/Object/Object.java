package Code.AST.Object;

import Code.AST.Tools.Name;

public class Object
{
    private Name name;
    public Object(String _name)
    {
        name = Name.getName(_name);
    }

    public Name getName() {
        return name;
    }
}
