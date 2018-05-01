package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.Register;

public class Load extends IRInstruction
{
    private Register dest;
    private IntegerValue address;

    public Load(Label label, Register dest, IntegerValue address)
    {
        super(label);
        this.dest = dest;
        this.address = address;
    }

    public Register getDest()
    {
        return dest;
    }

    public IntegerValue getAddress()
    {
        return address;
    }
}
