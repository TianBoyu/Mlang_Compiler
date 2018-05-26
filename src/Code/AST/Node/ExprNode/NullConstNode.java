package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

public class NullConstNode extends ConstExprNode
{
    public NullConstNode(Position pos)
    {
        super(pos);
        exprType = new BuiltInType("null", 0);
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    @Override
    public IntegerValue accept(IRTraversal visitor)
    {
        return visitor.visit(this);
    }
}
