package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Type.Type;
import Code.ASTTraversal.ASTTraversal;

public class NewExprNode extends ExprNode
{
    public NewExprNode(Position _pos, CreatorNode c)
    {
        super(_pos);
        creatorNode = c;
    }
    private CreatorNode creatorNode;

    public CreatorNode getCreatorNode()
    {
        return creatorNode;
    }

    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
