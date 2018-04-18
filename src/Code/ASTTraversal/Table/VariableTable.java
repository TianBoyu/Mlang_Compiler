package Code.ASTTraversal.Table;

import Code.AST.Node.DeclNode.VarDecNode;

import java.util.HashMap;
import java.util.Map;

public class VariableTable
{
    public static Map<String, VarDecNode> var_table = new HashMap<>();
    public boolean addElement(String k, VarDecNode v)
    {
        if(var_table.containsKey(k))
        {
            System.out.println("already have the type" + k);
            return false;
        }
        else {
            var_table.put(k, v);
            return true;
        }
    }
    public VarDecNode findElement(String k)
    {
        return var_table.get(k);
    }
    public boolean containElement(String k)
    {
        return var_table.containsKey(k);
    }
}
