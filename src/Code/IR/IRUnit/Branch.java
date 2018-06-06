package Code.IR.IRUnit;

import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.PhysicalRegister;

public class Branch extends Terminator
{
    private Label trueLabel;
    private Label falseLabel;
    private IntegerValue condition;
    private Compare.Condition op;
    public boolean isTransferBranch = true;

    private PhysicalRegister conditionReg;

    public Branch(Label label, Label true_label, Label false_label, IntegerValue condition)
    {
        //condition branch
        super(label);
        this.trueLabel = true_label;
        this.falseLabel = false_label;
        this.condition = condition;
    }

    public Branch(Label label, Label true_label, Label false_label, IntegerValue condition, boolean isTransferBranch)
    {
        //condition branch
        super(label);
        this.trueLabel = true_label;
        this.falseLabel = false_label;
        this.condition = condition;
        this.isTransferBranch = isTransferBranch;
    }

    public Branch(Label label, Label true_label, Label false_label, IntegerValue condition, Compare.Condition op)
    {
        //condition branch
        super(label);
        this.trueLabel = true_label;
        this.falseLabel = false_label;
        this.condition = condition;
        this.op = op;
    }

    public Branch(Label label, Label true_label, Label false_label,
                  IntegerValue condition, Compare.Condition op, boolean isTransferBranch)
    {
        //condition branch
        super(label);
        this.trueLabel = true_label;
        this.falseLabel = false_label;
        this.condition = condition;
        this.op = op;
        this.isTransferBranch = isTransferBranch;
    }


    public Compare.Condition getOp()
    {
        return op;
    }

    public PhysicalRegister getConditionReg()
    {
        return conditionReg;
    }

    public void setConditionReg(PhysicalRegister condition_reg)
    {
        this.conditionReg = condition_reg;
    }

    public Label getTrueLabel()
    {
        return trueLabel;
    }

    public Label getFalseLabel()
    {
        return falseLabel;
    }

    public IntegerValue getCondition()
    {
        return condition;
    }

    @Override
    public String toString()
    {
        String ret = "Branch ";
        if(condition != null)
            ret += condition.toString();
        ret += " true: " + trueLabel.toString() +
                " false: " + falseLabel.toString();
        return ret;
    }
    @Override
    public void accept(IRInstTraversal visitor)
    {
        visitor.visit(this);
    }
}
