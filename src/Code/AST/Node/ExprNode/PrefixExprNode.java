package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Tools.UnaryOp;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

public class PrefixExprNode extends UnaryExprNode
{
    public PrefixExprNode(Position _pos, UnaryOp op, ExprNode exprNode) {
        super(_pos, op, exprNode);
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
