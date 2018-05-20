package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.Address;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.VirtualRegister;
import Code.IR.Type.IRType;

public class getElementPtr extends IRInstruction
{
    private VirtualRegister dest;
    private IRType type;
    private Address baseAddress;
    private IntegerValue pos1;
    private IntegerValue pos2;

    public getElementPtr(Label label, VirtualRegister dest, IRType type, Address baseAddress, IntegerValue pos1, IntegerValue pos2)
    {
        super(label);
        this.dest = dest;
        this.type = type;
        this.baseAddress = baseAddress;
        this.pos1 = pos1;
        this.pos2 = pos2;
    }

    @Override
    public String toString()
    {
        return dest.toString() + " = " + "getElementPtr %" +
                type.toString() + " % " + baseAddress.toString() + " " +
                String.valueOf(pos1) + " " + String.valueOf(pos2);
    }
}
