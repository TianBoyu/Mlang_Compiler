package Code.IR.IRUnit;

public abstract class Terminator extends IRInstruction
{
    public Terminator(Label label)
    {
        super(label);
    }
}
