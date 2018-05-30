package Code.IR.IRUnit.Oprands;

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

    public void addValue(int v)
    {
        value += v;
    }

    @Override
    public String toString()
    {
        return "Immediate " + String.valueOf(value);
    }
}
