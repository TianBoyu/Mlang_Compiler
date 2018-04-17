package Code.AST.Node.ExprNode;

import Code.AST.Object.FuncObject;
import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;
import jdk.nashorn.api.tree.FunctionCallTree;

public class CallExprNode extends ExprNode
{
    public CallExprNode(Position _pos, String name, ExprListNode _param)
    {
        super(_pos);
        func_name = name;
        param = _param;
    }
    public String getFuncName()
    {
        return func_name;
    }
    public ExprListNode getParam() {
        return param;
    }
    private String func_name;
    private ExprListNode param;
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
