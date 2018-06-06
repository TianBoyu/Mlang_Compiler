package Code.IR.IRUnit.Oprands;

import Code.AST.Tools.Name;
import Code.Translator.StackSlot;

import java.util.HashSet;
import java.util.Set;

public class Register extends IntegerValue
{
    private Name name;
    public Set<Register> neighbors = new HashSet<>();
    public boolean isDeleted = false;
    public boolean isAssigned = false;
    public boolean isInStack = false;
    public int degree = 0;
    public PhysicalRegister physicalRegister;
    public StackSlot stackSlot;

    public Register(Name name)
    {
        this.name = name;
    }

    public Name getName()
    {
        return name;
    }

    public void setPhysicalRegister(PhysicalRegister pr)
    {
        this.physicalRegister = pr;
        this.isAssigned = true;
    }

    @Override
    public String toString()
    {
        return name.toString();
    }
}
