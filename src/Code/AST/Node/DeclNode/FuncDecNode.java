package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Node.StatNode.BlockNode;
import Code.AST.Object.FuncObject;
import Code.AST.Tools.Position;
import Code.AST.Type.Type;

public class FuncDecNode extends ASTBaseNode
{
    private FuncObject function;
    private ExprListNode formal_param;
    private BlockNode block;

    public FuncDecNode(Position pos, FuncObject _function, ExprListNode _param, BlockNode _block)
    {
        super(pos);
        function = _function;
        formal_param = _param;
        block = _block;
    }
    public FuncObject getFunction()
    {
        return function;
    }
    public final ExprListNode getParam()
    {
        return formal_param;
    }
    public final BlockNode getBlock()
    {
        return block;
    }
}
