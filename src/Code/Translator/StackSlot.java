package Code.Translator;

public class StackSlot
{
    public enum SlotType
    {
        dword, qword
    }

    private int beginPos;
    private int endPos;
    private SlotType type;
    private int paramPos;

    public StackSlot(int begin_pos, int end_pos, SlotType type)
    {
        this.beginPos = begin_pos;
        this.endPos = end_pos;
        this.type = type;
        paramPos = -1;
    }
    public StackSlot(int paramPos, SlotType type)
    {
        this.paramPos = paramPos;
        this.type = type;
    }

    public int getBeginPos()
    {
        return beginPos;
    }

    public int getEndPos()
    {
        return endPos;
    }

    @Override
    public String toString()
    {
        if(this.paramPos == -1)
            return type.toString() + " [rbp-" + String.valueOf(beginPos) + "]";
        else
            return type.toString() + " [rbp+" + String.valueOf(paramPos) + "]";
    }
}
