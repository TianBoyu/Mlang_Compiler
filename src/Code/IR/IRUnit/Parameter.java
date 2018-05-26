package Code.IR.IRUnit;

import Code.AST.Tools.Name;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.Type.IRType;

public class Parameter
{
    private IRType irType;
    private Name name;
    private Address address;
    private boolean isAdded;//a function in a class should be added(a ptr of its class type)

    public Parameter(IRType irType, Name name, Address address)
    {
        this.irType = irType;
        this.name = name;
        this.address = address;
        isAdded = false;
    }

    public Parameter(IRType irType, Name name, Address address, boolean isAdded)
    {
        this.irType = irType;
        this.name = name;
        this.isAdded = isAdded;
        this.address = address;
    }

    public IRType getIrType()
    {
        return irType;
    }

    public Name getName()
    {
        return name;
    }

    public boolean isAdded()
    {
        return isAdded;
    }

    public Address getAddress()
    {
        return address;
    }
}
