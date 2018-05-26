package Code.IR.Type;

import Code.AST.Tools.Name;

import java.util.ArrayList;
import java.util.List;

public class Class extends IRType
{
    private List<IRType> containTypes;
    private Name name;

    public Class(List<IRType> containTypes, Name name)
    {
        this.containTypes = containTypes;
        this.name = name;
    }
    public Class(Name name)
    {
        containTypes = new ArrayList<>();
        this.name = name;
    }

    @Override
    public String toString()
    {
        return "[struct " +  name.toString() + "]";
    }

    public String toFullInfoString()
    {
        String ret = "struct " + name.toString() + " = type {";
        int i = 0;
        for(IRType item : containTypes)
        {
            if(i != containTypes.size() - 1)
                ret += item.toString() + " ";
            else
                ret += item.toString();
        }
        ret += "}";
        return ret;
    }



    public void addContainType(IRType type)
    {
        containTypes.add(type);
    }
}
