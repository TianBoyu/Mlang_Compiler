package Code.AST.Node;

import Code.AST.Tools.*;
import Code.SemanticCheck.ASTTraversal;

public abstract class ASTBaseNode
{
    private Position position;
    public ASTBaseNode()
    {
        position = new Position(0);
    }
    public ASTBaseNode(Position pos)
    {
        position = pos;
    }
    public Position getPosition()
    {
        return position;
    }
    public abstract void accept(ASTTraversal visitor);
}
