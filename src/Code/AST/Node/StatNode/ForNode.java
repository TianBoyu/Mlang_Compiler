package Code.AST.Node.StatNode;

import Code.AST.Tools.Position;

public class ForNode extends StatNode
{
    public ForNode(Position _pos, StatNode b, StatNode e, StatNode u)
    {
        super(_pos);
        begin_condition = b;
        end_condition = e;
        update = u;
    }

    public StatNode getBeginCondition() {
        return begin_condition;
    }

    public StatNode getEndCondition() {
        return end_condition;
    }

    public StatNode getUpdate() {
        return update;
    }

    private StatNode begin_condition;
    private StatNode end_condition;
    private StatNode update;
}
