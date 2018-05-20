package Code.IR;

import Code.AST.Node.StatNode.BlockNode;
import Code.IR.IRUnit.IRInstruction;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

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
    private Set<BasicBlock> successors = new HashSet<>();
    private Set<BasicBlock> predecessors = new HashSet<>();


    public BasicBlock(IRInstruction head, IRInstruction tail, BlockType blockType)
    {
        this.head = head;
        this.tail = tail;
        this.blockType = blockType;
        this.instructions = new ArrayList<>();
    }
    public BasicBlock()
    {
        instructions = new ArrayList<>();
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

    public void setHead(IRInstruction head)
    {
        this.head = head;
    }

    public void setTail(IRInstruction tail)
    {
        this.tail = tail;
    }

    public void addInstruction(IRInstruction instruction)
    {
        this.instructions.add(instruction);
    }

    public void addSuccessor(BasicBlock successor)
    {
        this.successors.add(successor);
    }

    public void addPredecessor(BasicBlock predecessor)
    {
        this.predecessors.add(predecessor);
    }

}
