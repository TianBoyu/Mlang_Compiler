package Code.IR.IRUnit;

public class Block
{
    enum BlockType
    {
        FUNC, IF, WHILE, FOR
    }
    private IRInstruction head;
    private IRInstruction tail;
    private BlockType blockType;

    public Block(IRInstruction head, IRInstruction tail, BlockType blockType)
    {
        this.head = head;
        this.tail = tail;
        this.blockType = blockType;
    }

    public BlockType getBlockType()
    {
        return blockType;
    }

    public IRInstruction getHead()
    {
        return head;
    }

    public IRInstruction getTail()
    {
        return tail;
    }
}
