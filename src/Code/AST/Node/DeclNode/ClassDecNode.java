package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Tools.Position;
import Code.AST.Type.ClassType;

import java.util.List;

public class ClassDecNode extends ASTBaseNode
{
    ClassType type;
    private List<FuncDecNode> member_function;
    private List<VarDecNode>  member_varible;

    public ClassDecNode(Position pos, ClassType _type, List<FuncDecNode> func, List<VarDecNode> var)
    {
        super(pos);
        type = _type;
        member_function = func;
        member_varible = var;
    }
    public final ClassType getType()
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
}
