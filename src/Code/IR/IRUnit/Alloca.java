package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.Address;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.VirtualRegister;

public class Alloca extends IRInstruction
{
    private Address dest;
    private IntegerValue size;

    public Alloca(Label label, Address dest, IntegerValue size)
    {
        super(label);
        this.dest = dest;
        this.size = size;
    }

    @Override
    public String toString()
    {
        return (dest + " = " + "alloca " + size.toString());
    }
}
