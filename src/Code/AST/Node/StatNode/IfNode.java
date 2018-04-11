package Code.AST.Node.StatNode;

import Code.AST.Tools.Position;

public class IfNode extends StatNode
{
    public IfNode(Position _pos, ExprStatNode _cond, StatNode t, StatNode e)
    {
        super(_pos);
        condition = _cond;
        then = t;
        else_then = e;
    }

    public final ExprStatNode getCondition() {
        return condition;
    }
    public final StatNode getThen() {
        return then;
    }
    public final StatNode getElseThen() {
        return else_then;
    }

    private ExprStatNode condition;
    private StatNode then;
    private StatNode else_then;
}
