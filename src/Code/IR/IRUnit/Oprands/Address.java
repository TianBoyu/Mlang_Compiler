package Code.IR.IRUnit.Oprands;

import Code.AST.Tools.Name;
import Code.IR.Type.IRType;

public class Address extends IntegerValue
{
    private Name name;
    private IntegerValue offset;
    private IRType irType;
    private boolean isParam = false;
    private int paramPosition;
    public Address(Name name, IRType irType)
    {
        this.name = name;
        this.irType = irType;
        paramPosition = 0;
        if(name.toString().charAt(0) == '_')
            isParam = true;
    }

    public Address(Name name, IntegerValue offset)
    {
        this.name = name;
        this.offset = offset;
        paramPosition = 0;
        if(name.toString().charAt(0) != '_')
            isParam = true;
    }

    public Name getName()
    {
        return name;
    }

    public IRType getIrType()
    {
        return irType;
    }

    public int getParamPosition()
    {
        return paramPosition;
    }

    public boolean isParam()
    {
        return isParam;
    }

    public void setParamPosition(int paramPosition)
    {
        this.paramPosition = paramPosition;
    }

    @Override
    public String toString()
    {
        if(this.offset == null)
            return "[Address " + name.toString() + "]";
        else
            return "[Address " + name.toString() + " + offset " + offset.toString() + " * i64]";
    }
}
