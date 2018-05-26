package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

public class ConstExprNode extends ExprNode
{
    public ConstExprNode(Position _pos)
    {
        super(_pos);
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    @Override
    public IntegerValue accept(IRTraversal visitor)
    {
        return visitor.visit(this);
    }
}
