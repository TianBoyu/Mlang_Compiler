package Code.AST.Node.DeclNode;

import Code.AST.Node.ASTBaseNode;
import Code.AST.Object.ParameterObject;
import Code.AST.Tools.Position;
import Code.ASTTraversal.ASTTraversal;

public class FuncParamNode extends ASTBaseNode
{
    public FuncParamNode(Position _pos, ParameterObject _param)
    {
        super(_pos);
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
