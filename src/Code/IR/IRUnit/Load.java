package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.*;

public class Load extends IRInstruction
{
    private VirtualRegister dest;
    private Address address;
    private Immediate value;
    private PhysicalRegister destReg;
    private PhysicalRegister sourceReg; //Used when the address is a parameter

    public Load(Label label, VirtualRegister dest, Address address)
    {
        super(label);
        this.dest = dest;
        this.address = address;
    }

    public Load(Label label, VirtualRegister dest, Immediate value)
    {
        super(label);
        this.dest = dest;
        this.value = value;
    }

    public PhysicalRegister getDestReg()
    {
        return destReg;
    }

    public void setDestReg(PhysicalRegister dest_reg)
    {
        this.destReg = dest_reg;
    }

    public PhysicalRegister getSourceReg()
    {
        return sourceReg;
    }

    public void setSourceReg(PhysicalRegister sourceReg)
    {
        this.sourceReg = sourceReg;
    }

    public VirtualRegister getDest()
    {
        return dest;
    }

    public Address getAddress()
    {
        return address;
    }

    public Immediate getValue()
    {
        return value;
    }

    @Override
    public String toString()
    {
        if(this.address != null)
            return dest.toString() + " = Load " + address.toString();
        else return dest.toString() + " = Load " + value.toString();
    }
    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }


}
