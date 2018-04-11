package Code.AST.Type;

import Code.AST.Table.TypeTable;

import java.util.HashMap;
import java.util.Map;

public class Type {
    private String type_name;
    private int type_size;
    public Type(String _name, int _size)
    {
        type_name = _name;
        type_size = _size;
    }
    public String getTypeName()
    {
        return type_name;
    }
    public int getTypeSize()
    {
        return type_size;
    }

}
