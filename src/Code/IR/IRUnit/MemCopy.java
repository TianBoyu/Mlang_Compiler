package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.Address;
import Code.IR.Type.IRType;

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

    @Override
    public String toString()
    {
        return "MemCopy " + from_address.toString() + " to " + to_address.toString();
    }
}
