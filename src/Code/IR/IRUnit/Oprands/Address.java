package Code.IR.IRUnit.Oprands;

import Code.AST.Tools.Name;
import Code.IR.Type.IRType;

public class Address extends VirtualRegister
{
    private Name name;
    private IntegerValue offset;
    private IRType irType;
    public Address(Name name, IRType irType)
    {
        super(name, true);
        this.name = name;
        this.irType = irType;
    }

    public Address(Name name, IntegerValue offset)
    {
        super(name);
        this.name = name;
        this.offset = offset;
    }

    public Name getName()
    {
        return name;
    }

    public IRType getIrType()
    {
        return irType;
    }


    @Override
    public String toString()
    {
        if(this.offset == null)
            return "[" + name.toString() + "]";
        else
            return "[Address " + name.toString() + " + offset " + offset.toString() + " * i64]";
    }
}
