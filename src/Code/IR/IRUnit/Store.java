package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;

public class Store extends IRInstruction
{
    private IntegerValue address;
    private IntegerValue data;
    private PhysicalRegister dataReg;

    public Store(Label label, IntegerValue address, IntegerValue data)
    {
        super(label);
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

    public IntegerValue getAddress()
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
        return "Store " + data.toString() + " to " + address.toString();
    }
    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
