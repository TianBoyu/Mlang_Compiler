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
    private boolean isPointer = false;//only works with global variable
    private boolean isMember = false;
    private int memberNumber = -1;

    private PhysicalRegister baseReg;
    private PhysicalRegister offsetReg;

    public Address(Name name, IRType irType)
    {
        super(name, true);
        this.name = name;
        this.irType = irType;
        this.isGlobal = false;
    }

    public Address(Name name, Address base, IntegerValue offset)
    {
        super(name);
        this.name = name;
        this.base = base;
        this.offset = offset;
        this.isGlobal = false;
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

    public void setGlobal(boolean global)
    {
        isGlobal = global;
    }

    public boolean isPointer()
    {
        return isPointer;
    }

    public void setPointer(boolean pointer)
    {
        isPointer = pointer;
    }

    public boolean isMember()
    {
        return isMember;
    }

    public void setMember(boolean member)
    {
        isMember = member;
    }

    public int getMemberNumber()
    {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber)
    {
        this.memberNumber = memberNumber;
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
        String ret = "[Address_" + name.toString() + ":";
        if(base != null)
            ret += base.toString();
        if(offset != null)
            ret += "+offset " + offset.toString() + "*i64";
        ret += "]";
        return ret;
    }
}
