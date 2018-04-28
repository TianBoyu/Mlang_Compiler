package Code.AST.Node;

import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Tools.Position;
import Code.SemanticCheck.ASTTraversal;
import Code.SemanticCheck.Scope.Scope;

import java.util.List;

public class ProgNode extends ASTBaseNode
{
    public ProgNode(Position _pos, List<DeclNode> decl)
    {
        super(_pos);
        declares = decl;
    }
    public final List<DeclNode> getDeclares()
    {
        return declares;
    }
    public void addNode(DeclNode decl)
    {
//        System.out.println("here!");
        declares.add(decl);
    }
    public void addNode(List<DeclNode> decl_list)
    {
        for (DeclNode decl : decl_list) {
            addNode(decl);
        }
    }
    private List<DeclNode> declares;
    private Scope scope;

    public Scope getScope()
    {
        return scope;
    }

    public void setScope(Scope scope)
    {
        this.scope = scope;
    }

    @Override
    public void accept(ASTTraversal visitor)
    {
        visitor.visit(this);
    }
}
