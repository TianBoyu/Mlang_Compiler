package Code.AST.Node.DeclNode;

import Code.AST.Node.StatNode.BlockNode;
import Code.AST.Object.FuncDecObject;
import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;
import Code.ASTTraversal.Scope.ClassScope;
import Code.ASTTraversal.Scope.Scope;

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
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    public void setScope(ClassScope scope)
    {
        function.setScope(scope);
    }
}
