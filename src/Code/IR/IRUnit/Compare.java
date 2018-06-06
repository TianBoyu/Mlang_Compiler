package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;
import Code.IR.IRUnit.Oprands.VirtualRegister;

public class Compare extends Assign
{
    public enum Condition
    {
        SLT, SGT, SEQ, BEQ, EQU, NEQ;
    }
    private Condition condition;
    private IntegerValue lhs;
    private IntegerValue rhs;
    private Address dest;
    private PhysicalRegister lhsReg;
    private PhysicalRegister rhsReg;
    private PhysicalRegister destReg;

    public Compare(Label label, Condition condition, Address dest, IntegerValue lhs, IntegerValue rhs)
    {
        super(label, dest);
        this.condition = condition;
        this.dest = dest;
        this.lhs = lhs;
        this.rhs = rhs;
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

    public PhysicalRegister getDestReg()
    {
        return destReg;
    }

    public void setDestReg(PhysicalRegister destReg)
    {
        this.destReg = destReg;
    }

    public PhysicalRegister getLhsReg()
    {
        return lhsReg;
    }

    public void setLhsReg(PhysicalRegister sourceReg)
    {
        this.lhsReg = sourceReg;
    }

    public PhysicalRegister getRhsReg()
    {
        return rhsReg;
    }

    public void setRhsReg(PhysicalRegister rhsReg)
    {
        this.rhsReg = rhsReg;
    }

    public Condition getCondition()
    {
        return condition;
    }

    @Override
    public String toString()
    {
        String ret = "";
        if(dest != null)
            ret += dest.toString() + " = ";
        if(lhs != null)
            ret += lhs.toString() + " ";
        ret += condition.toString() + " ";
        if(rhs != null)
            ret += rhs.toString();
        return ret;
//        return dest.toString() + " = " + lhs.toString() + " " + condition.toString() + " " + rhs.toString();
    }
    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
