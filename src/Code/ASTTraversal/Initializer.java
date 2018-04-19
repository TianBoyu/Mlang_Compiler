package Code.ASTTraversal;

import Code.ASTTraversal.Scope.Scope;

public class Initializer
{
    private Scope topLevelScope;
    Initializer(Scope topScope)
    {
        topLevelScope = topScope;
    }
    public void InitializeBuiltInType()
    {

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
