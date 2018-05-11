package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.IRInstruction;
import Code.SemanticCheck.ASTTraversal;

public class ExprStatNode extends StatNode
{
    public ExprStatNode(Position _pos, ExprNode _expr)
    {
        super(_pos);
        expr = _expr;
    }

    public final ExprNode getExpr() {
        return expr;
    }

    private ExprNode expr;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    @Override
    public IRInstruction accept(IRTraversal visitor)
    {
        visitor.visit(this);
        return null;
    }
}
