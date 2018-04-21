package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;
import Code.ASTTraversal.ASTTraversal;

public class BoolConstNode extends ConstExprNode
{
    public BoolConstNode(Position _pos, boolean b)
    {
        super(_pos);
        value = b;
        exprType = new BuiltInType("bool", 1);
    }
    private boolean value;
    public boolean getValue()
    {
        return value;
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
