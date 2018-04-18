package Code.AST.Node.StatNode;


import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

public class WhileNode extends StatNode
{
    public WhileNode(Position _pos, ExprNode _cond, StatNode t)
    {
        super(_pos);
        condition = _cond;
        then = t;
    }
    public final ExprNode getCondition() {
        return condition;
    }
    public final StatNode getThen() {
        return then;
    }

    private ExprNode condition;
    private StatNode then;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
