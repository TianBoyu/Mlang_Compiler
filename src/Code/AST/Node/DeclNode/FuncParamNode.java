package Code.AST.Node.DeclNode;

import Code.AST.Object.ParameterObject;
import Code.AST.Tools.Position;
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
}
