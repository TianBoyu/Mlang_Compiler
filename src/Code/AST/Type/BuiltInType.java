package Code.AST.Type;

import Code.Widget.ConstValue;

public class BuiltInType extends Type
{
    public BuiltInType(String _name, int _size)
    {
        super(_name, ConstValue.ADDRESS_WIDTH);
    }
}
