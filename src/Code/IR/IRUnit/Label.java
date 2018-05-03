package Code.IR.IRUnit;

import Code.IR.BasicBlock;

public class Label
{
    private BasicBlock block;
    private String name;
    private static int count = 0;

    public Label(String _name, BasicBlock.BlockType blockType)
    {
        block = new BasicBlock(blockType);
        if(_name == null)
            name = String.valueOf(count++);
        else name = _name;
    }

    public BasicBlock getBlock()
    {
        return block;
    }

    public String getName()
    {
        return name;
    }
}
