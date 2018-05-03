package Code.AST.Type;

import Code.AST.Node.DeclNode.ClassDecNode;
import Code.AST.Tools.Name;

public class Type {
    private Name type_name;
    protected int type_size;
    public Type(String _name, int _size)
    {
        type_name = Name.getName(_name);
        type_size = _size;
    }
    public Name getTypeName()
    {
        return type_name;
    }
    public int getTypeSize()
    {
        return type_size;
    }
    public ClassDecNode getClassNode()
    {
        return null;
    }
    public static boolean equal(Type a, Type b)
    {
        return (a.getTypeName() == b.getTypeName())
                || (!(a instanceof BuiltInType) && b.getTypeName() == Name.getName("null"));
    }

}
