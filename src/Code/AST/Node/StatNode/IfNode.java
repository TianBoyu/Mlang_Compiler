package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

public class IfNode extends StatNode
{
    public IfNode(Position _pos, ExprNode _cond, StatNode t, StatNode e)
    {
        super(_pos);
        condition = _cond;
        then = t;
        else_then = e;
    }

    public final ExprNode getCondition() {
        return condition;
    }
    public final StatNode getThen() {
        return then;
    }
    public final StatNode getElseThen() {
        return else_then;
    }

    private ExprNode condition;
    private StatNode then;
    private StatNode else_then;
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
