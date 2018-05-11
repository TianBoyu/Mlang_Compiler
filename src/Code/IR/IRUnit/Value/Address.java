package Code.IR.IRUnit.Value;

import Code.AST.Tools.Name;

public class Address extends IntegerValue
{
    private Name name;
    public Address(Name name)
    {
        this.name = name;
    }

    public Name getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        return "Address " + name.toString();
    }
}
