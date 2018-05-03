package Code.AST.Tools;

import java.util.HashMap;
import java.util.Map;

public class Name
{
    private String name;
    private static Map<String, Name> nameDict = new HashMap<>();
    public Name(String text)
    {
        name = text;
    }
    public static Name getName(String name)
    {
        Name s = nameDict.get(name);
        if(s == null)
        {
            s = new Name(name);
            nameDict.put(name, s);
        }
        return s;
    }
    @Override
    public String toString()
    {
        return name;
    }

}
