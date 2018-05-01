package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;

public class Compare extends IRInstruction
{
    enum Condition
    {
        SLT, SGT, SEQ, BEQ, EQU, NEQ;
    }
    private Condition condition;
    private IntegerValue lhs;
    private IntegerValue rhs;
    private IntegerValue dest;

    public Compare(Label label, Condition condition, IntegerValue lhs, IntegerValue rhs)
    {
        super(label);
        this.condition = condition;
        this.lhs = lhs;
        this.rhs = rhs;
    }
}
