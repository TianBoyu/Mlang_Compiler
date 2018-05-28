package Code.IR.IRUnit.Oprands;

import Code.AST.Tools.Name;

public class VirtualRegister extends Register
{
    public VirtualRegister(Name name)
    {
        super(name);
        isAddress = true;
//        registerMap.put(name, this);
    }

    public VirtualRegister(Name name, boolean isAddress)
    {
        super(name);
        this.isAddress = isAddress;
    }

    private int value;
    private boolean isAddress;
    public int getValue()
    {
        return value;
    }

    @Override
    public Name getName()
    {
        return super.getName();
    }

    @Override
    public String toString()
    {
        return super.toString();
    }
}
