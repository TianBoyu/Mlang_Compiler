package Code.IR.IRUnit;


import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.Register;

public class BinaryOperation extends IRInstruction
{
    public enum BinaryOp
    {
        ADD, SUB, MUL, DIV, MOD,
        SHL, SHR, AND, OR, XOR
    }
    public BinaryOperation(Label label, BinaryOp _op, Register reg, IntegerValue left, IntegerValue right)
    {
        super(label);
        op = _op;
        dest = reg;
        lhs = left;
        rhs = right;
    }
    private BinaryOp op;
    private Register dest;
    private IntegerValue lhs;
    private IntegerValue rhs;

    @Override
    public String toString()
    {
        return dest.toString() + " = " + lhs.toString() + " " + op.toString() + " " + rhs.toString();
    }
}
