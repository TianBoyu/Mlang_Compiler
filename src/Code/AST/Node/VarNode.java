package Code.AST.Node;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.*;

public class VarNode extends ASTBaseNode
{
    private Variable var;
    private ExprNode expr;
    public VarNode(Position pos)
    {
        super(pos);
    }
    public Variable getVar()
    {
        return var;
    }
    public ExprNode getExpr()
    {
        return expr;
    }

}
