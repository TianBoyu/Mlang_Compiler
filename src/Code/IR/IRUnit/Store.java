package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;

public class Store extends IRInstruction
{
    private IntegerValue address;
    private IntegerValue data;

    public Store(Label label, IntegerValue address, IntegerValue data)
    {
        super(label);
        this.address = address;
        this.data = data;
    }

    public IntegerValue getAddress()
    {
        return address;
    }

    public IntegerValue getData()
    {
        return data;
    }
}
