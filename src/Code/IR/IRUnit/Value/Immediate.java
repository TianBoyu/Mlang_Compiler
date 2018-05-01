package Code.IR.IRUnit.Value;

public class Immediate extends IntegerValue
{
    private int value;

    public Immediate(int value)
    {
        this.value = value;
    }

    public int getValue()
    {
        return value;
    }
}
