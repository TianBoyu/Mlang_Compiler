package Code.AST.Node.DeclNode;

import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.AST.Type.ClassType;
import Code.ASTTraversal.ASTTraversal;
import Code.ASTTraversal.Scope.Scope;

import java.util.List;

public class ClassDecNode extends DeclNode
{
    ClassType type;
    private List<FuncDecNode> member_function;
    private List<VarDecNode>  member_varible;
    private Scope internal_scope;

    public ClassDecNode(Position pos, ClassType _type, List<FuncDecNode> func, List<VarDecNode> var)
    {
        super(pos);
        type = _type;
        member_function = func;
        member_varible = var;
    }
    public ClassType getType()
    {
        return type;
    }
    public List<FuncDecNode> getMemberFunction()
    {
        return member_function;
    }
    public List<VarDecNode> getMemberVarible()
    {
        return member_varible;
    }

    public void setInternalScope(Scope internal_scope)
    {
        this.internal_scope = internal_scope;
    }

    public Scope getInternalScope()
    {
        return internal_scope;
    }

    @Override
    public Name getName()
    {
        return type.getTypeName();
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
