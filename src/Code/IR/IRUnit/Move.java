package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.Register;

public class Move extends IRInstruction
{
    private Register dest;
    private Register data;
//    private String name;

    public Move(Label label, Register dest, Register data)
    {
        super(label);
        this.dest = dest;
        this.data = data;
    }

    @Override
    public String toString()
    {
        return dest.toString() + " = Move " + data.toString();
    }
}
