package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Tools.Position;

public abstract class DeclNode extends ASTBaseNode implements Name
{
    public DeclNode(Position _pos) {
        super(_pos);
    }
}
