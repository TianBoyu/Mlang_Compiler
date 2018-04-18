package Code.ASTTraversal.Table;

import Code.AST.Type.Type;

import java.util.HashMap;
import java.util.Map;

public class TypeTable
{
    public static Map<String, Type> type_table = new HashMap<>();
    public boolean addElement(String k, Type v)
    {
        if(type_table.containsKey(k))
        {
            System.out.println("already have the type" + k);
            return false;
        }
        else {
            type_table.put(k, v);
            return true;
        }
    }
    public Type findElement(String k)
    {
        return type_table.get(k);
    }
    public boolean containElement(String k)
    {
        return type_table.containsKey(k);
    }
}
