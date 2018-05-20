package Code;
//Boom is the main class

import Code.AST.ASTConstructor.ASTConstructor;
import Code.AST.ASTPrinter;
import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Node.ProgNode;
import Code.IR.IRConstructor;
import Code.IR.IRPrinter;
import Code.IR.IRUnit.IRInstruction;
import Code.IR.Type.Class;
import Code.Parser.MlangErrorListener;
import Code.Parser.MlangLexer;
import Code.Parser.MlangParser;
import Code.SemanticCheck.ErrorHandler;
import Code.SemanticCheck.FunctionCollector;
import Code.SemanticCheck.Scope.Scope;
import Code.SemanticCheck.ScopeCollector;
import Code.SemanticCheck.SemanticChecker;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.List;

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
    public static void printIR(ProgNode program) throws Exception
    {
        FileOutputStream outputStream = new FileOutputStream("Test/TestIR/test_result.txt");
        IRConstructor irConstructor = new IRConstructor(program);
        irConstructor.BuildIR();
        IRInstruction entry = irConstructor.getEntry();
        List<Class> typeList = irConstructor.getTypes();
        IRPrinter irPrinter = new IRPrinter(entry, outputStream, typeList);
        irPrinter.printIR();
    }

    public static void main(String[] args) throws Exception
    {
//        InputStream is = System.in;
        InputStream is = new FileInputStream("Test/TestIR/test_if.mx");
        ANTLRInputStream input = new ANTLRInputStream(is);
        MlangLexer lexer = new MlangLexer(input);
        lexer.addErrorListener(MlangErrorListener.INSTANCE);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        MlangParser parser = new MlangParser(tokens);
        parser.addErrorListener(MlangErrorListener.INSTANCE);
        ParseTree tree = parser.program();

        ParseTreeWalker walker = new ParseTreeWalker();
        ASTConstructor constructor = new ASTConstructor();
        walker.walk(constructor, tree);

        checkSemantic(constructor.getProgram());
        printIR(constructor.getProgram());
    }
}
