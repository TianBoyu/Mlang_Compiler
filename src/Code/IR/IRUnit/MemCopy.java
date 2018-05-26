package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;

public class MemCopy extends IRInstruction
{
    private Address from_address;
    private Address to_address;

    public MemCopy(Label label, Address address1, Address address2)
    {
        super(label);
        this.from_address = address1;
        this.to_address = address2;
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
