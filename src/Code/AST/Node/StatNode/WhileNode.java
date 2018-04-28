package Code.AST.Node.StatNode;


import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;
import Code.SemanticCheck.Scope.Scope;

public class WhileNode extends StatNode
{
    public WhileNode(Position _pos, ExprNode _cond, StatNode t)
    {
        super(_pos);
        condition = _cond;
        then = t;
    }
    public final ExprNode getCondition() {
        return condition;
    }
    public final StatNode getThen() {
        return then;
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

    private ExprNode condition;
    private StatNode then;
    private Scope ExternalScope;
    private Scope InternalScope;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
