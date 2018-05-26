package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.VirtualRegister;
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

    @Override
    public void accept(IRInstTraversal visitor)
    {
        throw new RuntimeException("can't reach here");
    }
}
