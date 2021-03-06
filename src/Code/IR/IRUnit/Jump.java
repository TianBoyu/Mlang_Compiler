package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;

public class Jump extends Terminator
{
    private Label target;

    public Jump(Label label, Label target)
    {
        super(label);
        this.target = target;
    }

    public Label getTarget()
    {
        return target;
    }

    @Override
    public String toString()
    {
        return "Jump " + target.toString();
    }

    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
