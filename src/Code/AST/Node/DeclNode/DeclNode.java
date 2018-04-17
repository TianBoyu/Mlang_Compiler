package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Node.StatNode.StatNode;
import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

public abstract class DeclNode extends StatNode implements Name
{
    public DeclNode(Position _pos) {
        super(_pos);
    }

}
