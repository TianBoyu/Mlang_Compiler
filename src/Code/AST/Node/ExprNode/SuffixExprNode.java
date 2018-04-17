package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Tools.UnaryOp;
import Code.ASTVisitor.ASTVisitor;

public class SuffixExprNode extends UnaryExprNode
{
    public SuffixExprNode(Position _pos, UnaryOp op, ExprNode exprNode) {
        super(_pos, op, exprNode);
    }
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
