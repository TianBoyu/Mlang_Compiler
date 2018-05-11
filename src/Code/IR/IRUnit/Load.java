package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.Address;
import Code.IR.IRUnit.Value.Immediate;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.Register;

public class Load extends IRInstruction
{
    private Register dest;
    private Address address;
    private Immediate value;

    public Load(Label label, Register dest, Address address)
    {
        super(label);
        this.dest = dest;
        this.address = address;
    }

    public Load(Label label, Register dest, Immediate value)
    {
        super(label);
        this.dest = dest;
        this.value = value;
    }

    public Register getDest()
    {
        return dest;
    }

    public Address getAddress()
    {
        return address;
    }

    @Override
    public String toString()
    {
        if(this.address != null)
            return dest.toString() + " = Load " + address.toString();
        else return dest.toString() + " = Load " + value.toString();
    }
}
