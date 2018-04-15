package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.LoopBody;
import Code.AST.Tools.Position;

public class ReturnNode extends StatNode
{
    public ReturnNode(Position _pos, LoopBody _loop, ExprNode e)
    {
        super(_pos);
        loop = _loop;
        exprNode = e;
    }
    private LoopBody loop;
    private ExprNode exprNode;

    public ExprNode getExprNode() {
        return exprNode;
    }
}
