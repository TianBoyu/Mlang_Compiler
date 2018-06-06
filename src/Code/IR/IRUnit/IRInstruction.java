package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public abstract class IRInstruction
{
    private Label label;
    private IRInstruction next;
    private IRInstruction last;
    public Set<VirtualRegister> liveIn = new HashSet<>();
    public Set<VirtualRegister> liveOut = new HashSet<>();

    public Set<VirtualRegister> defVar = new HashSet<>();
    public Set<VirtualRegister> useVar = new HashSet<>();

    public IRInstruction(Label label, IRInstruction next, IRInstruction last)
    {
        this.label = label;
        this.next = next;
        this.last = last;
    }

    public IRInstruction(Label label)
    {
        this.label = label;
    }
    public IRInstruction(){}

    public Label getLabel()
    {
        return label;
    }

    public IRInstruction getNext()
    {
        return next;
    }

    public IRInstruction getLast()
    {
        return last;
    }

    public void addDefVar(VirtualRegister register)
    {
        defVar.add(register);
    }
    public void addUseVar(VirtualRegister register)
    {
        useVar.add(register);
    }

    public void setNext(IRInstruction next)
    {
        this.next = next;
    }

    public void setLast(IRInstruction last)
    {
        this.last = last;
    }

    public abstract String toString();

    public abstract void accept(IRInstTraversal visitor);
}
