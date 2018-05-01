package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;

public class Alloca extends IRInstruction
{
    private IntegerValue dest;
    private IntegerValue size;

    public Alloca(Label label, IntegerValue dest, IntegerValue size)
    {
        super(label);
        this.dest = dest;
        this.size = size;
    }
}
