package Code.AST.Tools;

public class Position
{
    private int line_num;
    public Position(int num)
    {
        line_num = num;
    }
    public final int getLineNum()
    {
        return line_num;
    }
    public final String getInfor()
    {
        String infor = "line: " + line_num;
        return infor;
    }
}
