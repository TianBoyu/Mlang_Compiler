package Code.AST.Type;

public class ArrayType extends Type
{
    private Type basic_type;
    private int dimension;
    public ArrayType(String _name, int dimension, Type _basic)
    {
        super(_name, 1);
//        basic_type = _basic;
        if(dimension == 0)
        {
            this.basic_type = _basic;
        }
        else
        {
            this.basic_type  = new ArrayType(_name, dimension - 1, _basic);
        }
    }

    public final Type getBasic_type()
    {
        return basic_type;
    }

    public int getDimension()
    {
        return dimension;
    }

    public final Type getBaseType()
    {
        Type basic = this.getBasic_type();
        while(basic instanceof ArrayType)
            basic = ((ArrayType) basic).getBasic_type();
        return basic;
    }
}
