package Code.AST.Node.DeclNode;

import Code.AST.Node.StatNode.StatNode;
import Code.AST.Tools.Position;

public abstract class DeclNode extends StatNode
{
    protected boolean is_func;
    protected boolean isBuiltIn;
    public DeclNode(Position _pos) {
        super(_pos);
        is_func = false;
        isBuiltIn = false;
    }
    public DeclNode(Position _pos,  boolean isBuiltIn)
    {
        super(_pos);
        this.is_func = false;
        this.isBuiltIn = isBuiltIn;
    }
    public boolean isFunction()
    {
        return is_func;
    }

    public boolean isBuiltIn()
    {
        return isBuiltIn;
    }
}
