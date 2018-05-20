package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.Address;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.VirtualRegister;
import Code.IR.Type.IRType;

public class Alloca extends IRInstruction
{
    private Address dest;
    private IntegerValue size;
    private IRType type;

    public Alloca(Label label, Address dest, IntegerValue size)
    {
        super(label);
        this.dest = dest;
        this.size = size;
    }

    public Alloca(Label label, Address dest, IRType type)
    {
        super(label);
        this.dest = dest;
        this.type = type;
    }

    @Override
    public String toString()
    {
        if(this.size != null)
            return (dest.toString() + " = " + "alloca " + size.toString());
        else
            return (dest.toString() + " = " + "alloca " + type.toString());
    }
}
