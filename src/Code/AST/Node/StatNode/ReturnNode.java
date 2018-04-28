package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;

public class ReturnNode extends StatNode
{
    public ReturnNode(Position _pos, ExprNode e)
    {
        super(_pos);
        exprNode = e;
    }
    private ExprNode exprNode;

    public ExprNode getExprNode() {
        return exprNode;
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
