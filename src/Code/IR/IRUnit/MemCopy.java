package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;

public class MemCopy extends IRInstruction
{
    private Address from_address;
    private Address to_address;

    public MemCopy(Label label, Address from_address, Address to_address)
    {
        super(label);
        this.from_address = from_address;
        this.to_address = to_address;
    }

    public Address getFromAddress()
    {
        return from_address;
    }

    public Address getToAddress()
    {
        return to_address;
    }

    @Override
    public String toString()
    {
        return "MemCopy " + from_address.toString() + " to " + to_address.toString();
    }

    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
