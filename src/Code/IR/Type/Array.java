package Code.IR.Type;

import Code.IR.IRUnit.Value.IntegerValue;

public class Array extends IRType
{
    private IRType baseType;
    private IntegerValue size;

    public Array(IRType baseType, IntegerValue size)
    {
        this.baseType = baseType;
        this.size = size;
    }

    @Override
    public String toString()
    {
        if(size != null)
            return "[" + baseType.toString() + " * " + size.toString() + "]";
        else return "[ArrayType: " + baseType.toString() + "[] ]";
    }
}
