package Code;

import java.io.FileInputStream;
import java.io.InputStream;

import Code.AST.ASTConstructor.ASTConstructor;
import Code.AST.Node.ProgNode;
import Code.ASTTraversal.*;
import Code.ASTTraversal.Scope.Scope;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import Code.Parser.*;

import static java.lang.System.exit;

public class Boom {
    public static void processTree(String read_file_path, String write_file_path) throws Exception
    {
//        System.out.println("Buliding Parser");
        InputStream is = new FileInputStream(read_file_path);
        ANTLRInputStream input = new ANTLRInputStream(is);
        MlangLexer lexer = new MlangLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MlangParser parser = new MlangParser(tokens);
        ParseTree tree = parser.program();

//        System.out.println("Building AST");
        ParseTreeWalker walker = new ParseTreeWalker();
        ASTConstructor constructor = new ASTConstructor();
        walker.walk(constructor, tree);
//        ASTPrinter printer = new ASTPrinter();
//        printer.PrintAST(constructor.getProgram(), new FileOutputStream(write_file_path));
        checkSemantic(constructor.getProgram());

    }
    public static void checkSemantic(ProgNode program)
    {
        Scope topLevelScope = new Scope(true);
        ErrorHandler handler = new ErrorHandler();
//        Initializer initializer = new Initializer(topLevelScope);
//        initializer.Initialize();
        topLevelScope.Initialize();
        ScopeCollector scopeCollector = new ScopeCollector(topLevelScope, handler);
        scopeCollector.process(program);
        VariableCollector variableCollector = new VariableCollector(topLevelScope, handler);
        variableCollector.process(program);
        SemanticChecker semanticChecker = new SemanticChecker(topLevelScope, handler);
        semanticChecker.process(program);
    }
    public static void main(String[] args) throws Exception
    {
        try
        {
            InputStream is = System.in;
            ANTLRInputStream input = new ANTLRInputStream(is);
            MlangLexer lexer = new MlangLexer(input);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            MlangParser parser = new MlangParser(tokens);
            ParseTree tree = parser.program();

            ParseTreeWalker walker = new ParseTreeWalker();
            ASTConstructor constructor = new ASTConstructor();
            walker.walk(constructor, tree);
            checkSemantic(constructor.getProgram());
        }
        catch (Exception e)
        {
            exit(1);
        }
//        processTree("Test/TestSemantic/test684.mx", null);
    }
}
