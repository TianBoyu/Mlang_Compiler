package Code.IR.IRUnit;

import Code.AST.Tools.Name;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.List;

public class Call extends IRInstruction
{
    private Name functionName;
    private List<IntegerValue> params;
    private VirtualRegister dest;

    private PhysicalRegister destReg;

    public Call(Label label, VirtualRegister dest, Name function, List<IntegerValue> params)
    {
        super(label);
        this.dest = dest;
        this.functionName = function;
        this.params = params;
    }

    public PhysicalRegister getDestReg()
    {
        return destReg;
    }

    public void setDestReg(PhysicalRegister dest_reg)
    {
        this.destReg = dest_reg;
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
    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
