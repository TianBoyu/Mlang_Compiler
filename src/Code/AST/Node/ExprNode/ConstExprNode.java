package Code.AST.Node.ExprNode;

import Code.AST.Object.BuiltInObject;
import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;
import Code.ASTVisitor.ASTVisitor;

public class ConstExprNode extends ExprNode
{
    public ConstExprNode(Position _pos)
    {
        super(_pos);
    }
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
