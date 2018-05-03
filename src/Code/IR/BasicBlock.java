package Code.IR;

import Code.AST.Node.StatNode.BlockNode;
import Code.IR.IRUnit.IRInstruction;

public class BasicBlock
{
    public enum BlockType
    {
        FUNC, IF, WHILE, FOR
    }
    private IRInstruction head;
    private IRInstruction tail;
    private BlockType blockType;

    public BasicBlock(IRInstruction head, IRInstruction tail, BlockType blockType)
    {
        this.head = head;
        this.tail = tail;
        this.blockType = blockType;
    }
    public BasicBlock(BlockType blockType)
    {
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
