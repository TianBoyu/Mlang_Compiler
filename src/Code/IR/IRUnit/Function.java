package Code.IR.IRUnit;

import Code.AST.Node.DeclNode.FuncParamNode;
import Code.AST.Tools.Name;
import Code.IR.BasicBlock;
import Code.IR.IRInstTraversal;
import Code.IR.Type.*;

import java.util.List;

public class Function extends IRInstruction
{
    private Name name;
    private IRType ret_type;
    private List<Parameter> parameter;
    private BasicBlock block;
    private int usedSlotNumber;

    public Function(Label label, Name name, IRType ret_type, List<Parameter> parameter, int usedSlotNumber)
    {
        super(label);
        this.name = name;
        this.ret_type = ret_type;
        this.parameter = parameter;
        this.usedSlotNumber = usedSlotNumber;
    }

    public List<Parameter> getParameter()
    {
        return parameter;
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
        for(Parameter item : parameter)
        {
            if(i != parameter.size() - 1)
                ret += item.getIrType().toString() + ", ";
            else ret += item.getIrType().toString();
            ++i;
        }
        ret += ")";
        return ret;
    }

    public Name getName()
    {
        return name;
    }

    public int getUsedSlotNumber()
    {
        return usedSlotNumber;
    }

    public void setUsedSlotNumber(int usedSlotNumber)
    {
        this.usedSlotNumber = usedSlotNumber;
    }

    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
