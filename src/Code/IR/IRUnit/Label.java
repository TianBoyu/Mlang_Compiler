package Code.IR.IRUnit;

import Code.IR.BasicBlock;
import Code.IR.IRInstTraversal;

public class Label extends IRInstruction
{
    private BasicBlock block;
    private String name;
    private static int count = 0;

    public Label(String _name)
    {
        block = new BasicBlock();
        if(_name == null)
            name = String.valueOf(count++);
        else name = _name;
    }


    public void setBlock(BasicBlock block)
    {
        this.block = block;
    }

    public BasicBlock getBlock()
    {
        return block;
    }

    public String getName()
    {
        return name;
    }

    public void addInst(IRInstruction inst)
    {
        block.addInstruction(inst);
    }

    @Override
    public String toString()
    {
        return "label" + name;
    }

    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
