package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;

public abstract class ConditionExprNode extends ExprNode
{
    public ConditionExprNode(Position _pos, ExprNode c1, ExprNode c2)
    {
        super(_pos);
        cond1 = c1;
        cond2 = c2;
    }
    private ExprNode cond1;
    private ExprNode cond2;
    public ExprNode getCond1() {
        return cond1;
    }
    public ExprNode getCond2() {
        return cond2;
    }

}
