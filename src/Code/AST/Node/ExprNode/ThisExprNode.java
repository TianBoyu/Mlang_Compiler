package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class ThisExprNode extends ExprNode
{
    public ThisExprNode(Position _pos, String _name)
    {
        super(_pos);
        name = _name;
    }

    public String getName() {
        return name;
    }
    private String name;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }

}
