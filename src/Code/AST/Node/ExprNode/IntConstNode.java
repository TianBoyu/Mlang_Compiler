package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.Immediate;
import Code.SemanticCheck.ASTTraversal;

public class IntConstNode extends ConstExprNode
{
    public IntConstNode(Position _pos, int b)
    {
        super(_pos);
        value = b;
        exprType = new BuiltInType("int", 1);
    }
    private int value;
    public int getValue()
    {
        return value;
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
