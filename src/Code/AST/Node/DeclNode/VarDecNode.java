package Code.AST.Node.DeclNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Object.VarObject;
import Code.AST.Tools.*;
import Code.ASTTraversal.ASTTraversal;

public class VarDecNode extends DeclNode
{
    public VarDecNode(Position _pos, VarObject _var, ExprNode v)
    {
        super(_pos);
        var = _var;
        value = v;
    }
    public final VarObject getVar()
    {
        return var;
    }
    public final ExprNode getValue()
    {
        return value;
    }
    public String getName()
    {
        return var.getName();
    }
    private VarObject var;
    private ExprNode value;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
