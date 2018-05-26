package Code.IR.IRUnit.Oprands;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.IRInstruction;

public class IntegerValue extends IRInstruction
{
    public String toString()
    {
        return "IntegerValue";
    }

    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
