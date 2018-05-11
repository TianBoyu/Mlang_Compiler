package Code.IR.Type;

import java.util.List;

public class Class extends IRType
{
    public Class(List<IRType> containTypes, String name)
    {
        this.containTypes = containTypes;
        this.name = name;
    }

    private List<IRType> containTypes;
    private String name;
}
