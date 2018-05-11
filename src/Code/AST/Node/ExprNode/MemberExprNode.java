package Code.AST.Node.ExprNode;

import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.IR.IRTraversal;
import Code.IR.IRUnit.Value.IntegerValue;
import Code.SemanticCheck.ASTTraversal;

public class MemberExprNode extends ExprNode
{
    public MemberExprNode(Position _pos, ExprNode e, CallExprNode c)
    {
        super(_pos);
        expr = e;
        functionCall = c;
        isLvalue = true;
        isFunctionCall = true;
    }
    public MemberExprNode(Position _pos, ExprNode e, String _id)
    {
        super(_pos);
        expr = e;
        id = _id;
        isLvalue = true;
        isFunctionCall = false;
    }

    private ExprNode expr;
    private CallExprNode functionCall;
    private String id;
    private boolean isFunctionCall;

    public ExprNode getExpr() {
        return expr;
    }

    public CallExprNode getFunctionCall()
    {
        return functionCall;
    }

    public String getId()
    {
        return id;
    }

    public boolean isFunctionCall()
    {
        return isFunctionCall;
    }

    public Name getName()
    {
        if(this.isFunctionCall)
            return functionCall.getFuncName();
        else return Name.getName(id);
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
