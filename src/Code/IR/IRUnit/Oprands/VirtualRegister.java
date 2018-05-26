package Code.IR.IRUnit.Oprands;

import Code.AST.Tools.Name;

public class VirtualRegister extends Register
{
    public VirtualRegister(Name name)
    {
        super(name);
//        registerMap.put(name, this);
    }

    private int value;
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
