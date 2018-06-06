package Code.IR;

import Code.AST.Node.StatNode.BlockNode;
import Code.IR.IRUnit.IRInstruction;
import Code.IR.IRUnit.Label;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BasicBlock
{
    private IRInstruction head;
    private IRInstruction tail;
    private List<IRInstruction> instructions;
    private Label title;
    private Set<BasicBlock> successors = new HashSet<>();
    private Set<BasicBlock> predecessors = new HashSet<>();
    private Set<VirtualRegister> livingVirtualRegisters = new HashSet<>();

    public BasicBlock(IRInstruction head, IRInstruction tail)
    {
        this.head = head;
        this.tail = tail;
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


    public IRInstruction getHead()
    {
        return head;
    }

    public IRInstruction getTail()
    {
        return tail;
    }

    public Label getTitle()
    {
        return title;
    }

    public void setTitle(Label title)
    {
        this.title = title;
    }

    public void setHead(IRInstruction head)
    {
        this.head = head;
    }

    public void setTail(IRInstruction tail)
    {
        this.tail = tail;
    }


    public List<IRInstruction> getInstructions()
    {
        return instructions;
    }

    public void addInstruction(IRInstruction instruction)
    {
        if(this.instructions.size() == 0)
            this.head = instruction;
        this.instructions.add(instruction);
    }

    public void addSuccessor(BasicBlock successor)
    {
        this.successors.add(successor);
    }

    public void addLivingReg(VirtualRegister register)
    {
        this.livingVirtualRegisters.add(register);
    }

    public void addPredecessor(BasicBlock predecessor)
    {
        this.predecessors.add(predecessor);
    }

}
