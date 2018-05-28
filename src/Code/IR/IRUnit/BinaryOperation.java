package Code.IR.IRUnit;


import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;
import Code.IR.IRUnit.Oprands.Register;

public class BinaryOperation extends IRInstruction
{
    private BinaryOp op;
    private Address dest;
    private IntegerValue lhs;
    private IntegerValue rhs;

    private PhysicalRegister destReg;
    private PhysicalRegister lhsReg;
    private PhysicalRegister rhsReg;

    public enum BinaryOp
    {
        add, sub, imul, idivq, mod,
        shl, shr, and, or, xor,
        neg, not
    }
    public BinaryOperation(Label label, BinaryOp _op, Address reg, IntegerValue left, IntegerValue right)
    {
        super(label);
        op = _op;
        dest = reg;
        lhs = left;
        rhs = right;
    }

    public PhysicalRegister getDestReg()
    {
        return destReg;
    }

    public void setDestReg(PhysicalRegister dest_reg)
    {
        this.destReg = dest_reg;
    }

    public PhysicalRegister getLhsReg()
    {
        return lhsReg;
    }

    public void setLhsReg(PhysicalRegister source_reg)
    {
        this.lhsReg = source_reg;
    }

    public PhysicalRegister getRhsReg()
    {
        return rhsReg;
    }

    public void setRhsReg(PhysicalRegister rhsReg)
    {
        this.rhsReg = rhsReg;
    }

    public BinaryOp getOp()
    {
        return op;
    }

    public Address getDest()
    {
        return dest;
    }

    public IntegerValue getLhs()
    {
        return lhs;
    }

    public IntegerValue getRhs()
    {
        return rhs;
    }

    @Override
    public String toString()
    {
        return dest.toString() + " = " + lhs.toString() + " " + op.toString() + " " + rhs.toString();
    }
    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
