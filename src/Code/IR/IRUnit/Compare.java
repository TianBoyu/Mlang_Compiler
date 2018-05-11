package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.VirtualRegister;

public class Compare extends IRInstruction
{
    public enum Condition
    {
        SLT, SGT, SEQ, BEQ, EQU, NEQ;
    }
    private Condition condition;
    private IntegerValue lhs;
    private IntegerValue rhs;
    private VirtualRegister dest;

    public Compare(Label label, Condition condition, VirtualRegister dest, IntegerValue lhs, IntegerValue rhs)
    {
        super(label);
        this.condition = condition;
        this.dest = dest;
        this.lhs = lhs;
        this.rhs = rhs;
    }

    @Override
    public String toString()
    {
        return dest.toString() + " = " + lhs.toString() + " " + condition.toString() + " " + rhs.toString();
    }
}
