package Code.AST.Type;

import Code.AST.Node.DeclNode.ClassDecNode;

public class ClassType extends Type
{
    private ClassDecNode classNode;
    public ClassType(String _name, int _size)
    {
        super(_name, _size);
    }
    public ClassType(ClassDecNode node)
    {
        super(node.getName().toString(), 4);
        classNode = node;
    }
    @Override
    public ClassDecNode getClassNode()
    {
        return classNode;
    }
}
