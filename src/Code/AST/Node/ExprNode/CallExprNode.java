package Code.AST.Node.ExprNode;

import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class CallExprNode extends ExprNode
{
    public CallExprNode(Position _pos, String name, ExprListNode _param)
    {
        super(_pos);
        func_name = Name.getName(name);
        param = _param;
    }
    public Name getFuncName()
    {
        return func_name;
    }
    public ExprListNode getParam() {
        return param;
    }

    private Name func_name;
//    private ExprNode function;
    private ExprListNode param;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
