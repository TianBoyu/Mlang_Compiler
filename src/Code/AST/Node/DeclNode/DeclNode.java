package Code.AST.Node.DeclNode;

import Code.AST.Node.StatNode.StatNode;
import Code.AST.Tools.Position;

public abstract class DeclNode extends StatNode
{
    protected boolean is_func;
    public DeclNode(Position _pos) {
        super(_pos);
        is_func = false;
    }
    public boolean isFunction()
    {
        return is_func;
    }
}
