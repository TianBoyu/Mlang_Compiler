package Code.IR.IRUnit.Value;

public class Register extends IntegerValue
{
    private String name;

    public Register(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }
}
