package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

import java.util.List;

public class ExprListNode extends ExprNode
{
    private List<ExprNode> exprs;
    public ExprListNode(Position _pos, List<ExprNode> _expr)
    {
        super(_pos);
        exprs = _expr;
    }
    public void addExpr(ExprNode node)
    {
        exprs.add(node);
    }

    public List<ExprNode> getExprs()
    {
        return exprs;
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
