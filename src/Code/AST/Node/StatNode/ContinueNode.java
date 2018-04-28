package Code.AST.Node.StatNode;

import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class ContinueNode extends StatNode
{
    public ContinueNode(Position _pos)
    {
        super(_pos);
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
