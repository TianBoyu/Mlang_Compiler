package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Node.StatNode.BlockNode;
import Code.AST.Object.FuncObject;
import Code.AST.Tools.Position;
import Code.AST.Type.Type;

public class FuncDecNode extends DeclNode
{
    private FuncObject function;
    private BlockNode block;

    public FuncDecNode(Position pos, FuncObject _function, BlockNode _block)
    {
        super(pos);
        function = _function;
        block = _block;
    }
    public FuncObject getFunction()
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
}
