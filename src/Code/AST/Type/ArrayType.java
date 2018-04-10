package Code.AST.Type;

public class ArrayType extends Type
{
    private Type basic_type;
    public ArrayType(String _name, int _size, Type _basic)
    {
        super(_name, _size);
        basic_type = _basic;
    }
    public final Type getBasic_type()
    {
        return basic_type;
    }
}
