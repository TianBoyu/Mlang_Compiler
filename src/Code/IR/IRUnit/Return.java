package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;

public class Return extends Terminator
{
    private IntegerValue value;
    public Return(Label label, IntegerValue value)
    {
        super(label);
        this.value = value;
    }

    @Override
    public String toString()
    {
        return "Return " + value.toString();
    }
}
