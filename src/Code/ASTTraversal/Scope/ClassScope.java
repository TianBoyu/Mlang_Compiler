package Code.ASTTraversal.Scope;

import Code.AST.Type.ClassType;
import Code.AST.Type.Type;

public class ClassScope extends Scope
{
    private ClassType classType;
    public ClassScope(ClassType type)
    {
        classType = type;
    }

    public ClassType getClassType()
    {
        return classType;
    }

    public void setClassType(ClassType classType)
    {
        this.classType = classType;
    }
}
