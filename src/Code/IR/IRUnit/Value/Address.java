package Code.IR.IRUnit.Value;

import Code.AST.Tools.Name;

public class Address extends IntegerValue
{
    private Name name;
    private IntegerValue offset;
    public Address(Name name)
    {
        this.name = name;
    }

    public Address(Name name, IntegerValue offset)
    {
        this.name = name;
        this.offset = offset;
    }

    public Name getName()
    {
        return name;
    }

    @Override
    public String toString()
    {
        if(this.offset == null)
            return "[Address " + name.toString() + "]";
        else
            return "[Address " + name.toString() + " + offset " + offset.toString() + " * i64 ]";
    }
}
