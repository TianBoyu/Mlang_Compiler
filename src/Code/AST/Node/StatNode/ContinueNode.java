package Code.AST.Node.StatNode;

import Code.AST.Tools.LoopBody;
import Code.AST.Tools.Position;

public class ContinueNode extends StatNode
{
    public ContinueNode(Position _pos, LoopBody _loop)
    {
        super(_pos);
        loop = _loop;
    }
    private LoopBody loop;
}
