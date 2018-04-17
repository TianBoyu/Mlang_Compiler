package Code.AST.Node.StatNode;

import Code.AST.Tools.LoopBody;
import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

public class ContinueNode extends StatNode
{
    public ContinueNode(Position _pos, LoopBody _loop)
    {
        super(_pos);
        loop = _loop;
    }
    private LoopBody loop;
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
