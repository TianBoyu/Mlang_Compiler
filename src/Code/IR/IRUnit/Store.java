package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;

public class Store extends Assign
{
    private Address address;
    private IntegerValue data;
    private PhysicalRegister dataReg;

    public Store(Label label, Address address, IntegerValue data)
    {
        super(label, address);
        this.address = address;
        this.data = data;
    }


    public PhysicalRegister getDataReg()
    {
        return dataReg;
    }

    public void setDataReg(PhysicalRegister data_reg)
    {
        this.dataReg = data_reg;
    }

    public Address getAddress()
    {
        return address;
    }

    public IntegerValue getData()
    {
        return data;
    }

    @Override
    public String toString()
    {
        if(data == null)
            return "Store " + "NULL to " + address.toString();
        return "Store " + data.toString() + " to " + address.toString();
    }
    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
