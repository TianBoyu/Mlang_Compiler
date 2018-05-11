package Code.IR.IRUnit;

public class Jump extends Terminator
{
    private Label target;

    public Jump(Label label, Label target)
    {
        super(label);
        this.target = target;
    }

    @Override
    public String toString()
    {
        return "Jump " + target.toString();
    }
}
