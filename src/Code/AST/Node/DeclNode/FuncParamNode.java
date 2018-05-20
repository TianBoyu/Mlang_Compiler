package Code.AST.Node.DeclNode;

import Code.AST.Object.ParameterObject;
import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.AST.Type.Type;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Value.Address;
import Code.SemanticCheck.ASTTraversal;

public class FuncParamNode extends VarDecNode
{
    public FuncParamNode(Position _pos, ParameterObject _param)
    {
        super(_pos, _param, null);
        param = _param;
    }
    private ParameterObject param;

    public ParameterObject getParam()
    {
        return param;
    }


    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
    @Override
    public Address accept(IRTraversal visitor)
    {
        visitor.visit(this);
        return null;
    }

    @Override
    public Type getType()
    {
        return param.getType();
    }

    @Override
    public Name getName()
    {
        return param.getName();
    }
}
