package Code.ASTTraversal.Table;

import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Object.FuncDecObject;
import Code.AST.Type.Type;

import java.util.HashMap;
import java.util.Map;

public class FunctionTable
{
    public static Map<String, FuncDecNode> func_table = new HashMap<>();
    public boolean addElement(String k, FuncDecNode v)
    {
        if(func_table.containsKey(k))
        {
            System.out.println("already have the type" + k);
            return false;
        }
        else {
            func_table.put(k, v);
            return true;
        }
    }
    public FuncDecNode findElement(String k)
    {
        return func_table.get(k);
    }
    public boolean containElement(String k)
    {
        return func_table.containsKey(k);
    }
}
