package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

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
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
