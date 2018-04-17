package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Node.StatNode.StatNode;
import Code.AST.Object.VarObject;
import Code.AST.Tools.*;
import Code.AST.Type.Type;
import Code.ASTVisitor.ASTVisitor;

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
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
