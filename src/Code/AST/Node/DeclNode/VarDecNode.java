package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Object.VarObject;
import Code.AST.Tools.*;
import Code.AST.Type.Type;

public class VarDecNode extends ASTBaseNode
{
    private VarObject var;
    private ExprNode value;
    public final VarObject getVar()
    {
        return var;
    }
    public final ExprNode getValue()
    {
        return value;
    }
}
