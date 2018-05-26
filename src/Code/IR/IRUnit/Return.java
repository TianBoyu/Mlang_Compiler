package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;

public class Return extends Terminator
{
    private IntegerValue value;
    private PhysicalRegister valueReg;
    public Return(Label label, IntegerValue value)
    {
        super(label);
        this.value = value;
    }

    public IntegerValue getValue()
    {
        return value;
    }

    public void setValue(IntegerValue value)
    {
        this.value = value;
    }

    public PhysicalRegister getValueReg()
    {
        return valueReg;
    }

    public void setValueReg(PhysicalRegister value_reg)
    {
        this.valueReg = value_reg;
    }

    @Override
    public String toString()
    {
        return "Return " + value.toString();
    }

    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
