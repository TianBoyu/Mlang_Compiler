package Code.Optimizer;

import Code.IR.IRUnit.IRInstruction;

public class UselessJumpRemover
{
    private IRInstruction entry;

    public UselessJumpRemover(IRInstruction entry)
    {
        this.entry = entry;
    }

    public void process()
    {

    }
}
