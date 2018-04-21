package Code.AST.Node.ExprNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Tools.Position;
import Code.AST.Type.Type;

public abstract class ExprNode extends ASTBaseNode
{
    public ExprNode(Position pos)
    {
        super(pos);
        isLvalue = false;
    }
    protected boolean isLvalue;
    protected Type exprType;

    public boolean isLvalue()
    {
        return isLvalue;
    }

    public void setExprType(Type exprType)
    {
        this.exprType = exprType;
    }

    public Type getExprType()
    {
        return exprType;
    }
}
