package Code.AST.Type;

import Code.AST.Node.DeclNode.ClassDecNode;

public class ClassType extends Type
{
    private ClassDecNode classNode;
    public ClassType(String _name, int _size)
    {
        super(_name, -1);
    }
    public ClassType(ClassDecNode node)
    {
        super(node.getName().toString(), -1);
        classNode = node;
    }
    @Override
    public ClassDecNode getClassNode()
    {
        return classNode;
    }
    @Override
    public int getTypeSize()
    {
        if(this.classNode.getSize() == -1)
        {
            this.classNode.initTypeSize();
        }
        this.type_size = this.classNode.getSize();
        return this.type_size;
    }
}
