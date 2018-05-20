package Code.AST.Node.DeclNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Object.VarObject;
import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.AST.Type.Type;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Value.Address;
import Code.SemanticCheck.ASTTraversal;
import Code.SemanticCheck.Scope.Scope;

public class VarDecNode extends DeclNode
{
    public VarDecNode(Position _pos, VarObject _var, ExprNode v)
    {
        super(_pos);
        var = _var;
        value = v;
        this.isMember = false;
        this.memberNumber = 0;
    }
    public final VarObject getVar()
    {
        return var;
    }
    public final ExprNode getValue()
    {
        return value;
    }
    @Override
    public Name getName()
    {
        return var.getName();
    }
    private VarObject var;
    private ExprNode value;
    private boolean isMember;
    private int memberNumber;
    public void setScope(Scope scope)
    {
        var.setScope(scope);
    }
    public Scope getScope()
    {
        return var.getScope();
    }
    public void setType(Type type)
    {
        var.setType(type);
    }
    public Type getType()
    {
        return var.getType();
    }

    public boolean isMember()
    {
        return isMember;
    }

    public void setMember(boolean member)
    {
        isMember = member;
    }

    public int getMemberNumber()
    {
        return memberNumber;
    }

    public void setMemberNumber(int memberNumber)
    {
        this.memberNumber = memberNumber;
    }

    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    @Override
    public Address accept(IRTraversal visitor)
    {
        return visitor.visit(this);
    }
}
