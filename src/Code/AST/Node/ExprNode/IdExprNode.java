package Code.AST.Node.ExprNode;

import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class IdExprNode extends ExprNode
{
    public IdExprNode(Position _pos, String _name)
    {
        super(_pos);
        name = Name.getName(_name);
        isLvalue = true;
    }
    private Name name;
    public Name getName() {
        return name;
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
