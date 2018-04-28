package Code.AST.Object;

import Code.AST.Node.DeclNode.FuncParamNode;
import Code.AST.Type.Type;

import java.util.List;

public class FuncDecObject extends Object
{
    private List<FuncParamNode> parameter;
    private Type return_type;
    private boolean isConstructor;

    public FuncDecObject(String _name, List<FuncParamNode> _param, Type _type)
    {
        super(_name);
        parameter = _param;
        return_type = _type;
        isConstructor = false;
    }
    public FuncDecObject(String _name, List<FuncParamNode> _param, Type _type, boolean c)
    {
        super(_name);
        parameter = _param;
        return_type = _type;
        isConstructor = c;
    }
    public List<FuncParamNode> getParam()
    {
        return parameter;
    }
    public final Type getReturnType()
    {
        return return_type;
    }


    public void setReturn_type(Type return_type)
    {
        this.return_type = return_type;
    }

    public List<FuncParamNode> getParameter()
    {
        return parameter;
    }

    public boolean isConstructor()
    {
        return isConstructor;
    }
}
