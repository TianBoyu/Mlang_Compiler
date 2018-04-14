package Code.AST.Node;

import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Tools.Position;

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
}
