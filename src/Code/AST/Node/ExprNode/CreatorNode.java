package Code.AST.Node.ExprNode;

import Code.AST.Tools.Position;
import Code.AST.Type.Type;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

import java.util.List;

public class CreatorNode extends ExprNode
{
    public CreatorNode(Position _pos, Type t, List<ExprNode> exprs, int d)
    {
        super(_pos);
        type = t;
        exprNodes = exprs;
        dimension = d;
    }
    private Type type;
    private List<ExprNode> exprNodes;
    int dimension;
    private  Type exprType;

    @Override
    public Type getExprType()
    {
        return exprType;
    }
    @Override
    public void setExprType(Type exprType)
    {
        this.exprType = exprType;
    }

    public int getDimension()
    {
        return dimension;
    }

    public List<ExprNode> getExprNodes()
    {
        return exprNodes;
    }

    public Type getType()
    {
        return type;
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
