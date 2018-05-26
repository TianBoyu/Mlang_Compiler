package Code.IR.IRUnit.Oprands;

import Code.AST.Tools.Name;

public class PhysicalRegister extends Register
{
    private boolean isCallerSave;
    private boolean isCalleeSave;
    public PhysicalRegister(Name name)
    {
        super(name);
    }
    public boolean isCallerSave()
    {
        return isCallerSave;
    }

    public boolean isCalleeSave()
    {
        return isCalleeSave;
    }

    @Override
    public String toString()
    {
        return super.getName().toString();
    }
}
