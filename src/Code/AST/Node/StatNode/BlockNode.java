package Code.AST.Node.StatNode;

import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;
import Code.SemanticCheck.Scope.Scope;

import java.util.List;

public class BlockNode extends StatNode
{
    public BlockNode(Position _pos, List<StatNode> _stat)
    {
        super(_pos);
        statements = _stat;
    }
    public final List<StatNode> getStatements() {
        return statements;
    }
    private List<StatNode> statements;
    private Scope scope;
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }

    public Scope getScope()
    {
        return scope;
    }

    public void setScope(Scope scope)
    {
        this.scope = scope;
    }
}
