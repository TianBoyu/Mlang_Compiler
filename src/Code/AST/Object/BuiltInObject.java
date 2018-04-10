package Code.AST.Object;

public class BuiltInObject {
    private String str_value;
    private int int_value;
    private boolean bool_value;
    BuiltInObject(String s)
    {
        str_value = s;
    }
    BuiltInObject(int i)
    {
        int_value = i;
    }
    BuiltInObject(boolean b)
    {
        bool_value = b;
    }
    public final String getStr()
    {
        return str_value;
    }
    public final int getInt()
    {
        return int_value;
    }
    public final boolean getBool()
    {
        return bool_value;
    }
}
