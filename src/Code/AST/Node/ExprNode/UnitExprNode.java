package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

public class UnitExprNode extends ExprNode
{
    public UnitExprNode(Position _pos, String _name)
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
