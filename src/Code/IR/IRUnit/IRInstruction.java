package Code.IR.IRUnit;

public abstract class IRInstruction
{
    private Label label;
    private IRInstruction next;
    private IRInstruction last;

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

    public void setNext(IRInstruction next)
    {
        this.next = next;
    }

    public void setLast(IRInstruction last)
    {
        this.last = last;
    }
}
