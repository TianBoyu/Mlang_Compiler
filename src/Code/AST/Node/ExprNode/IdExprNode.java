package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

public class IdExprNode extends ExprNode
{
    public IdExprNode(Position _pos, String _name)
    {
        super(_pos);
        name = _name;
    }
    String name;
    public String getName() {
        return name;
    }
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
