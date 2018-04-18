package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

public class StringConstNode extends ConstExprNode
{
    public StringConstNode(Position _pos, String s)
    {
        super(_pos);
        value = s;
    }
    private String value;

    public String getValue() {
        return value;
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
