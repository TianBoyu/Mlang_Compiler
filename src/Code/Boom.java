package Code;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import Code.AST.ASTConstructor.ASTConstructor;
import Code.AST.ASTPrinter;
import Code.AST.Node.ProgNode;
import Code.ASTTraversal.*;
import Code.ASTTraversal.Scope.Scope;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Code.Parser.*;

public class Boom {
    public static void checkSemantic(ProgNode program)
    {
        Scope topLevelScope = new Scope(true);
        ErrorHandler handler = new ErrorHandler();
        topLevelScope.Initialize();
        ScopeCollector scopeCollector = new ScopeCollector(topLevelScope, handler);
        scopeCollector.process(program);
        FunctionCollector functionCollector = new FunctionCollector(topLevelScope, handler);
        functionCollector.process(program);
        SemanticChecker semanticChecker = new SemanticChecker(topLevelScope, handler);
        semanticChecker.process(program);
    }
    public static void printAST(ProgNode program) throws Exception
    {
        FileOutputStream outputStream = new FileOutputStream("Test/TestSemantic/test_result.txt");
        ASTPrinter printer = new ASTPrinter();
        printer.PrintAST(program, outputStream);
    }
    public static void main(String[] args) throws Exception
    {
        InputStream is = System.in;
//        InputStream is = new FileInputStream("Test/TestSemantic/test_whatever.mx");
        ANTLRInputStream input = new ANTLRInputStream(is);
        MlangLexer lexer = new MlangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MlangParser parser = new MlangParser(tokens);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        ASTConstructor constructor = new ASTConstructor();
        walker.walk(constructor, tree);

//        printAST(constructor.getProgram());

        checkSemantic(constructor.getProgram());
    }
}
