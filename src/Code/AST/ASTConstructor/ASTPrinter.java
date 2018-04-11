package Code.AST.ASTConstructor;

import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Node.ProgNode;

public class ASTPrinter
{
    public void PrintAST(ProgNode program)
    {
        for(DeclNode decl:program.getDeclares())
        {
            System.out.println(decl.getName());
        }
    }
}
