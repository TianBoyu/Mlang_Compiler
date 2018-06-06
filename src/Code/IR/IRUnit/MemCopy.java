package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.PhysicalRegister;

public class MemCopy extends Assign
{
    private Address from_address;
    private Address to_address;
    private PhysicalRegister dataReg;

    public MemCopy(Label label, Address from_address, Address to_address)
    {
        super(label, to_address);
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

    public PhysicalRegister getDataReg()
    {
        return dataReg;
    }

    public void setDataReg(PhysicalRegister dataReg)
    {
        this.dataReg = dataReg;
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
