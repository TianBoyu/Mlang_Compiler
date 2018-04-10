package Code.AST.Node.ExprNode;

import Code.AST.Object.FuncObject;
import Code.AST.Tools.Position;
import jdk.nashorn.api.tree.FunctionCallTree;

public class CallExprNode extends ExprNode
{
    private FuncObject function;
    private ExprListNode actual_parameter;
    public CallExprNode(Position _pos, FuncObject _func, ExprListNode _param)
    {
        super(_pos);
        function = _func;
        actual_parameter = _param;
    }
    public final FuncObject getFunction()
    {
        return function;
    }
    public final ExprListNode getActualParameter()
    {
        return actual_parameter;
    }
}
