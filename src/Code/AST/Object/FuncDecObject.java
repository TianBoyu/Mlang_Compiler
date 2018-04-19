package Code.AST.Object;

import Code.AST.Node.DeclNode.FuncParamNode;
import Code.AST.Type.Type;
import Code.ASTTraversal.Scope.Scope;

import java.util.List;

public class FuncDecObject extends Object
{
    private List<FuncParamNode> parameter;
    private Type return_type;

    public FuncDecObject(String _name, List<FuncParamNode> _param, Type _type)
    {
        super(_name);
        parameter = _param;
        return_type = _type;
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
}
