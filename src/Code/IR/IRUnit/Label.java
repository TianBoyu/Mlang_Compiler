package Code.IR.IRUnit;

public class Label
{
    private Block block;
    private String name;
    private static int count = 0;

    public Label(Block block, String _name)
    {
        this.block = block;
        if(_name == null)
            name = String.valueOf(count++);
        else name = _name;
    }

    public Block getBlock()
    {
        return block;
    }

    public String getName()
    {
        return name;
    }
}
