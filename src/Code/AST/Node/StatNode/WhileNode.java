package Code.AST.Node.StatNode;


import Code.AST.Tools.Position;

public class WhileNode extends StatNode
{
    public WhileNode(Position _pos, ExprStatNode _cond, StatNode t)
    {
        super(_pos);
        condition = _cond;
        then = t;
    }
    public final ExprStatNode getCondition() {
        return condition;
    }
    public final StatNode getThen() {
        return then;
    }

    private ExprStatNode condition;
    private StatNode then;
}
