package Code.IR.IRUnit;

import Code.AST.Tools.Name;
import Code.IR.BasicBlock;
import Code.IR.Type.*;

import java.util.List;

public class Function extends IRInstruction
{
    private Name name;
    private IRType ret_type;
    private List<IRType> parameter;
    private BasicBlock block;

    public Function(Label label, Name name, IRType ret_type, List<IRType> parameter)
    {
        super(label);
        this.name = name;
        this.ret_type = ret_type;
        this.parameter = parameter;
    }

    @Override
    public String toString()
    {
        return "define " + ret_type.toString() + " @" + name.toString() + paramToString();
    }

    public String paramToString()
    {
        String ret = "(";
        int i = 0;
        for(IRType item : parameter)
        {
            if(i != parameter.size() - 1)
                ret += item.toString() + ", ";
            else ret += item.toString();
            ++i;
        }
        ret += ")";
        return ret;
    }
}
