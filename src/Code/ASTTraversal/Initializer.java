package Code.ASTTraversal;

import Code.AST.Type.BuiltInType;
import Code.ASTTraversal.Scope.Scope;

public class Initializer
{
    private Scope topLevelScope;
    public Initializer(Scope topScope)
    {
        topLevelScope = topScope;
    }
    public void InitializeBuiltInType()
    {
        topLevelScope.addType(new BuiltInType("int", 4));
        topLevelScope.addType(new BuiltInType("bool", 1));
        topLevelScope.addType(new BuiltInType("string", 1));
    }
    public void InitializeBuiltInFunction()
    {

    }
    public void Initialize()
    {
        InitializeBuiltInType();
        InitializeBuiltInFunction();
    }
}
