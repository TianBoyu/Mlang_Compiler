package Code.AST.Node.StatNode;

import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.IRInstruction;
import Code.SemanticCheck.ASTTraversal;
import Code.SemanticCheck.Scope.Scope;

public class IfNode extends StatNode
{
    public IfNode(Position _pos, ExprNode _cond, StatNode t, StatNode e)
    {
        super(_pos);
        condition = _cond;
        then = t;
        else_then = e;
    }

    public final ExprNode getCondition() {
        return condition;
    }
    public final StatNode getThen() {
        return then;
    }
    public final StatNode getElseThen() {
        return else_then;
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
    private StatNode else_then;
    private Scope ExternalScope;
    private Scope InternalScope;
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
