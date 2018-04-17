package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

public class ExprStatNode extends StatNode
{
    public ExprStatNode(Position _pos, ExprNode _expr)
    {
        super(_pos);
        expr = _expr;
    }

    public final ExprNode getExpr() {
        return expr;
    }

    private ExprNode expr;
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
