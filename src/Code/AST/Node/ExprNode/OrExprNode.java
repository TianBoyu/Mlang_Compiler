package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class OrExprNode extends ConditionExprNode
{
    public OrExprNode(Position _pos, ExprNode c1, ExprNode c2)
    {
        super(_pos, c1, c2);
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
