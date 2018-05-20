package Code.IR.IRUnit;

import Code.AST.Tools.Name;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.IR.IRUnit.Value.VirtualRegister;
import Code.IR.Type.IRType;

import java.util.List;
import java.util.NavigableMap;

public class Call extends IRInstruction
{
    private Name functionName;
    private List<IntegerValue> params;
    private IntegerValue dest;

    public Call(Label label, IntegerValue dest, Name function, List<IntegerValue> params)
    {
        super(label);
        this.dest = dest;
        this.functionName = function;
        this.params = params;
    }

    public Name getFunction()
    {
        return functionName;
    }

    public List<IntegerValue> getParams()
    {
        return params;
    }

    @Override
    public String toString()
    {
        String ret = "";
        if(this.dest != null)
            ret += dest.toString() + " = ";
        ret += "Call @" + functionName.toString() + paramToString();
        return ret;
    }

    public String paramToString()
    {
        String ret = "(";
        int i = 0;
        for(IntegerValue item : params)
        {
            if(i != params.size() - 1)
                ret += item.toString() + ", ";
            else ret += item.toString();
            i++;
        }
        ret += ")";
        return ret;
    }
}
