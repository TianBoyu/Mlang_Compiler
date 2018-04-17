package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

public class ForNode extends StatNode
{
    public ForNode(Position _pos, ExprNode b, ExprNode e, ExprNode u, StatNode _block)
    {
        super(_pos);
        begin_condition = b;
        end_condition = e;
        update = u;
        block = _block;
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

    public StatNode getBlock()
    {
        return block;
    }

    private ExprNode begin_condition;
    private ExprNode end_condition;
    private ExprNode update;
    private StatNode block;
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
