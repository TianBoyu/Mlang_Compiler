package Code.IR.IRUnit;

import Code.IR.IRUnit.Value.IntegerValue;

public class Branch extends Terminator
{
    private Label true_label;
    private Label false_label;
    private IntegerValue condition;

    public Branch(Label label, Label true_label, Label false_label, IntegerValue condition)
    {
        //condition branch
        super(label);
        this.true_label = true_label;
        this.false_label = false_label;
        this.condition = condition;
    }


    public Label getTrue_label()
    {
        return true_label;
    }

    public Label getFalse_label()
    {
        return false_label;
    }

    public IntegerValue getCondition()
    {
        return condition;
    }

    @Override
    public String toString()
    {
        return "Branch " + condition.toString() + " true: " + true_label.toString() + " false: " + false_label.toString();
    }
}
