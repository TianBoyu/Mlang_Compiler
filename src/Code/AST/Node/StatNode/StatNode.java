package Code.AST.Node.StatNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.IRInstruction;

public abstract class StatNode extends ASTBaseNode
{
    public StatNode(Position _pos)
    {
        super(_pos);
    }
    public Name getName()
    {
        return Name.getName("Stat");
    }

    @Override
    public IRInstruction accept(IRTraversal visitor)
    {
        return null;
    }
}
