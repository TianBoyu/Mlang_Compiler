package Code.AST.Node.DeclNode;

import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;
import Code.AST.Type.ClassType;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.IRInstruction;
import Code.IR.Type.BuiltIn;
import Code.IR.Type.Class;
import Code.SemanticCheck.ASTTraversal;
import Code.SemanticCheck.Scope.Scope;
import Code.Widget.ConstValue;

import java.util.List;

public class ClassDecNode extends DeclNode
{
    ClassType type;
    private List<FuncDecNode> member_function;
    private List<VarDecNode>  member_varible;
    private Scope internal_scope;
    private int size;

    public ClassDecNode(Position pos, ClassType _type, List<FuncDecNode> func, List<VarDecNode> var)
    {
        super(pos);
        type = _type;
        member_function = func;
        member_varible = var;
        size = -1;
    }
    public ClassType getType()
    {
        return type;
    }
    public void setType(ClassType t)
    {
        type = t;
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
    @Override
    public IRInstruction accept(IRTraversal visitor)
    {
        visitor.visit(this);
        return null;
    }
    public void initTypeSize()
    {
        if(this.size != -1)
            return;
        this.size = ConstValue.ADDRESS_WIDTH * member_varible.size();
    }

    public int getSize()
    {
        return this.size;
    }
}
