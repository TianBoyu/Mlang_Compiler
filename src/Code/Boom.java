package Code;

import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Code.Parser.*;

public class Boom {
    public static void processTree(String file_path) throws Exception
    {
        InputStream is = new FileInputStream(file_path);
        ANTLRInputStream input = new ANTLRInputStream(is);
        MlangLexer lexer = new MlangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MlangParser parser = new MlangParser(tokens);
        ParseTree tree = parser.prog();

//        System.out.println("LISP:");
//        System.out.println(tree.toStringTree(parser));
//        System.out.println();
        System.out.println("Visitor:");
        EvalVisitor evalByVisitor = new EvalVisitor();
    }
    public static void main(String[] args) throws Exception
    {
        System.out.println("Code.Boom!Compile them all!");
        processTree("Test/TestGrammar/test_declaration.mx");
    }
}
