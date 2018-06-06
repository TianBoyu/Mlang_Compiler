package Code.IR.IRUnit;

import Code.IR.IRUnit.Oprands.Address;

public abstract class Assign extends IRInstruction
{
    private Address dest;

    public Assign(Label label, Address dest)
    {
        super(label);
        this.dest = dest;
    }

    public Address getDest()
    {
        return dest;
    }

    public void setDest(Address dest)
    {
        this.dest = dest;
    }
}
