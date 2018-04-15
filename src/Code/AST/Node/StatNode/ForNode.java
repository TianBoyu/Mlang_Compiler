package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;

public class ForNode extends StatNode
{
    public ForNode(Position _pos, ExprNode b, ExprNode e, ExprNode u)
    {
        super(_pos);
        begin_condition = b;
        end_condition = e;
        update = u;
    }

    public ExprNode getBeginCondition() {
        return begin_condition;
    }

    public ExprNode getEndCondition() {
        return end_condition;
    }

    public ExprNode getUpdate() {
        return update;
    }

    private ExprNode begin_condition;
    private ExprNode end_condition;
    private ExprNode update;
}
