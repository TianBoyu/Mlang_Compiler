package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class ConstExprNode extends ExprNode
{
    public ConstExprNode(Position _pos)
    {
        super(_pos);
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
