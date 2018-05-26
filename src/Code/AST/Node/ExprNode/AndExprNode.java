package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.Immediate;
import Code.SemanticCheck.ASTTraversal;

public class AndExprNode extends ConditionExprNode
{
    public AndExprNode(Position _pos, ExprNode c1, ExprNode c2)
    {
        super(_pos, c1, c2);
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    @Override
    public Immediate accept(IRTraversal visitor)
    {
        return visitor.visit(this);
    }
}
