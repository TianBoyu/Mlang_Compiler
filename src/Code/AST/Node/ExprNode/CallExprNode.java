package Code.AST.Node.ExprNode;

import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

public class CallExprNode extends ExprNode
{
    public CallExprNode(Position _pos, String name, ExprListNode _param)
    {
        super(_pos);
        func_name = Name.getName(name);
        param = _param;
    }
    public Name getFuncName()
    {
        return func_name;
    }
    public ExprListNode getParam() {
        return param;
    }

    public FuncDecNode getFunction()
    {
        return function;
    }

    public void setFunction(FuncDecNode function)
    {
        this.function = function;
    }

    private Name func_name;
//    private ExprNode function;
    private ExprListNode param;
    private FuncDecNode function;

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

    public void setFunctionName(Name name)
    {
        this.func_name = name;
    }
}
