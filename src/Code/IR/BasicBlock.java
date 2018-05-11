package Code.IR;

import Code.AST.Node.StatNode.BlockNode;
import Code.IR.IRUnit.IRInstruction;

import java.util.List;

public class BasicBlock
{
    public enum BlockType
    {
        IF, WHILE, FOR, ELSE
    }
    private IRInstruction head;
    private IRInstruction tail;
    private BlockType blockType;
    private List<IRInstruction> instructions;

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

    public BasicBlock(List<IRInstruction> instructions)
    {
        this.instructions = instructions;
        this.head = instructions.get(0);
        this.tail = instructions.get(instructions.size() - 1);
    }


    public BlockType getBlockType()
    {
        return blockType;
    }

    public void setBlockType(BlockType blockType)
    {
        this.blockType = blockType;
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
