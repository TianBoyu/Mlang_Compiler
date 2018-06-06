package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;

import java.io.InputStream;

public class Malloc extends Assign
{
    private IntegerValue size;
    private Address returnAddress;
    private PhysicalRegister sizeReg;
    private PhysicalRegister returnReg;

    public Malloc(Label label, IntegerValue size, Address returnAddress)
    {
        super(label, returnAddress);
        this.size = size;
        this.returnAddress = returnAddress;
    }

    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }

    public IntegerValue getSize()
    {
        return size;
    }

    public Address getReturnAddress()
    {
        return returnAddress;
    }

    public PhysicalRegister getSizeReg()
    {
        return sizeReg;
    }

    public PhysicalRegister getReturnReg()
    {
        return returnReg;
    }

    public void setSizeReg(PhysicalRegister sizeReg)
    {
        this.sizeReg = sizeReg;
    }

    public void setReturnReg(PhysicalRegister returnReg)
    {
        this.returnReg = returnReg;
    }

    @Override
    public String toString()
    {
        return returnAddress.toString() + " = Malloc " + size.toString();
    }
}
