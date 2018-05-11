package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

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
    @Override
    public IntegerValue accept(IRTraversal visitor)
    {
        return visitor.visit(this);
    }
}
