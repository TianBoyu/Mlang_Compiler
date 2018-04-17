package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Node.StatNode.BlockNode;
import Code.AST.Object.FuncDecObject;
import Code.AST.Object.FuncObject;
import Code.AST.Tools.Position;
import Code.AST.Type.Type;
import Code.ASTVisitor.ASTVisitor;

public class FuncDecNode extends DeclNode
{
    private FuncDecObject function;
    private BlockNode block;

    public FuncDecNode(Position pos, FuncDecObject _function, BlockNode _block)
    {
        super(pos);
        function = _function;
        block = _block;
    }
    public FuncDecObject getFunction()
    {
        return function;
    }
    public BlockNode getBlock()
    {
        return block;
    }

    @Override
    public String getName()
    {
        return function.getName();
    }
    @Override
    public void accept(ASTVisitor visitor)
    {
        visitor.visit(this);
    }
}
