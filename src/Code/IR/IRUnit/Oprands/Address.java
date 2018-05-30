package Code.IR.IRUnit.Oprands;

import Code.AST.Tools.Name;
import Code.IR.Type.IRType;

public class Address extends VirtualRegister
{
    private Name name;
    private Address base;
    private IntegerValue offset;
    private IRType irType;
    private boolean isGlobal = false;

    private PhysicalRegister baseReg;
    private PhysicalRegister offsetReg;

    public Address(Name name, IRType irType)
    {
        super(name, true);
        this.name = name;
        this.irType = irType;
    }

    public Address(Name name, Address base, IntegerValue offset)
    {
        super(name);
        this.name = name;
        this.base = base;
        this.offset = offset;
    }

    public Address(Name name, boolean isGlobal) //global variable
    {
        super(name);
        this.name = name;
        this.isGlobal = isGlobal;
    }

    public boolean isGlobal()
    {
        return isGlobal;
    }

    public Name getName()
    {
        return name;
    }

    public PhysicalRegister getBaseReg()
    {
        return baseReg;
    }

    public void setBaseReg(PhysicalRegister baseReg)
    {
        this.baseReg = baseReg;
    }

    public PhysicalRegister getOffsetReg()
    {
        return offsetReg;
    }

    public void setOffsetReg(PhysicalRegister offsetReg)
    {
        this.offsetReg = offsetReg;
    }

    public Address getBase()
    {
        return base;
    }

    public IRType getIrType()
    {
        return irType;
    }

    public IntegerValue getOffset()
    {
        return offset;
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
