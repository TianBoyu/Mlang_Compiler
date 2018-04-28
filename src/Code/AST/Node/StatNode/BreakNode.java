package Code.AST.Node.StatNode;

import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class BreakNode extends StatNode
{
    public BreakNode(Position _pos)
    {
        super(_pos);
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
