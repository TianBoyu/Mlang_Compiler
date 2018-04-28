package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;
import Code.SemanticCheck.Scope.Scope;

public class ForNode extends StatNode
{
    public ForNode(Position _pos, ExprNode b, ExprNode e, ExprNode u, StatNode _block)
    {
        super(_pos);
        begin_condition = b;
        end_condition = e;
        update = u;
        block = _block;
    }

    public ExprNode getBeginCondition() {
        return begin_condition;
    }

    public ExprNode getEndCondition() {
        return end_condition;
    }

    public ExprNode getUpdate() {
        return update;
    }

    public StatNode getBlock()
    {
        return block;
    }

    public Scope getExternalScope()
    {
        return ExternalScope;
    }

    public Scope getInternalScope()
    {
        return InternalScope;
    }

    public void setExternalScope(Scope externalScope)
    {
        ExternalScope = externalScope;
    }

    public void setInternalScope(Scope internalScope)
    {
        InternalScope = internalScope;
    }

    private ExprNode begin_condition;
    private ExprNode end_condition;
    private ExprNode update;
    private StatNode block;
    private Scope ExternalScope;
    private Scope InternalScope;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
