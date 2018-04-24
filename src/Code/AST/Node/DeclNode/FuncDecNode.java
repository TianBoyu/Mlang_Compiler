package Code.AST.Node.DeclNode;

import Code.AST.Node.StatNode.BlockNode;
import Code.AST.Node.StatNode.StatNode;
import Code.AST.Object.FuncDecObject;
import Code.AST.Object.ParameterObject;
import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;
import Code.AST.Type.Type;
import Code.ASTTraversal.ASTTraversal;
import Code.ASTTraversal.Scope.Scope;

import java.util.ArrayList;
import java.util.List;

public class FuncDecNode extends DeclNode
{
    private FuncDecObject function;
    private BlockNode block;
    private Scope external_scope;
    private Scope internal_scope;

    public FuncDecNode(Position pos, FuncDecObject _function, BlockNode _block)
    {
        super(pos);
        function = _function;
        block = _block;
        is_func = true;
    }
    public FuncDecNode(String builtin_name)
    {
        super(new Position(0));
        function = new FuncDecObject(builtin_name, new ArrayList<>(), new BuiltInType("int", 4));
        block = null;
        is_func = true;
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
    public Name getName()
    {
        return function.getName();
    }
    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    public void setExternalScope(Scope scope)
    {
        external_scope = scope;
    }
    public void setInternalScope(Scope scope)
    {
        internal_scope = scope;
    }

    public Scope getExternalScope()
    {
        return external_scope;
    }

    public Scope getInternalScope()
    {
        return internal_scope;
    }

    public void setReturnType(Type type)
    {
        function.setReturn_type(type);
    }
    public Type getReturnType()
    {
        return function.getReturnType();
    }
    public boolean isConstructor()
    {
        return function.isConstructor();
    }
    public List<FuncParamNode> getParameter()
    {
        return function.getParameter();
    }
}
