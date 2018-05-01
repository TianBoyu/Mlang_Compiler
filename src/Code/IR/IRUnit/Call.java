package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;

import java.util.List;

public class Call extends IRInstruction
{
    private Function function;
    private List<IntegerValue> params;

    public Call(Label label, Function function, List<IntegerValue> params)
    {
        super(label);
        this.function = function;
        this.params = params;
    }

    public Function getFunction()
    {
        return function;
    }

    public List<IntegerValue> getParams()
    {
        return params;
    }
}
