package Code.AST.Node.StatNode;

import Code.AST.Tools.LoopBody;
import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

public class BreakNode extends StatNode
{
    public BreakNode(Position _pos, LoopBody _loop)
    {
        super(_pos);
        loop = _loop;
    }
    private LoopBody loop;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
