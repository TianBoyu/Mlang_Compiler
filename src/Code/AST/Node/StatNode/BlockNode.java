package Code.AST.Node.StatNode;

import Code.AST.Tools.Position;
import Code.ASTVisitor.ASTVisitor;

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
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
