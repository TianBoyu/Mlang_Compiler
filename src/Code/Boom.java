package Code;

import java.io.FileInputStream;
import java.io.InputStream;

import Code.AST.ASTConstructor.ASTConstructor;
import Code.AST.ASTConstructor.ASTPrinter;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Code.Parser.*;

public class Boom {
    public static void processTree(String file_path) throws Exception
    {
        System.out.println("Buliding Parser");
        InputStream is = new FileInputStream(file_path);
        ANTLRInputStream input = new ANTLRInputStream(is);
        MlangLexer lexer = new MlangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MlangParser parser = new MlangParser(tokens);
        ParseTree tree = parser.prog();

        System.out.println("Building AST");
        ParseTreeWalker walker = new ParseTreeWalker();
        ASTConstructor constructor = new ASTConstructor();
        walker.walk(constructor, tree);
        ASTPrinter printer = new ASTPrinter();
        printer.PrintAST(constructor.getProgram());
    }
    public static void main(String[] args) throws Exception
    {
        System.out.println("Code.Boom!Compile them all!");
        processTree("Test/TestGrammar/test_all.mx");
    }
}
