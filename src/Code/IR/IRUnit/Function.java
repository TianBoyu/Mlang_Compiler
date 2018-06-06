package Code.IR.IRUnit;

import Code.AST.Node.DeclNode.FuncParamNode;
import Code.AST.Tools.Name;
import Code.IR.BasicBlock;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.PhysicalRegister;
import Code.IR.Type.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Function extends IRInstruction
{
    private Name name;
    private IRType ret_type;
    private List<Parameter> parameter;
    private List<BasicBlock> basicBlocks = new ArrayList<>();
    private int usedSlotNumber;
    public Set<PhysicalRegister> usedRegs = new HashSet<>();

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

    public List<BasicBlock> getBasicBlocks()
    {
        return basicBlocks;
    }

    public void setBasicBlocks(List<BasicBlock> basicBlocks)
    {
        this.basicBlocks = basicBlocks;
    }

    public void addBasicBlock(BasicBlock basicBlock)
    {
        this.basicBlocks.add(basicBlock);
    }

    public Name getName()
    {
        return name;
    }

    public int getUsedSlotNumber()
    {
        return usedSlotNumber;
    }

    public void addUsedSlotNumber(int value)
    {
        this.usedSlotNumber += value;
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
