package Code;
//Boom is the main class

import Code.AST.ASTConstructor.ASTConstructor;
import Code.AST.ASTPrinter;
import Code.AST.Node.ProgNode;
import Code.IR.CFGConstructor;
import Code.IR.DataSection;
import Code.IR.IRConstructor;
import Code.IR.IRPrinter;
import Code.IR.IRUnit.IRInstruction;
import Code.IR.Type.Class;
import Code.Optimizer.GraphColoringAllocator;
import Code.Optimizer.NaiveAllocator;
import Code.Parser.MlangErrorListener;
import Code.Parser.MlangLexer;
import Code.Parser.MlangParser;
import Code.SemanticCheck.ErrorHandler;
import Code.SemanticCheck.FunctionCollector;
import Code.SemanticCheck.Scope.Scope;
import Code.SemanticCheck.ScopeCollector;
import Code.SemanticCheck.SemanticChecker;
import Code.Translator.NasmPrinter;
import Code.Translator.NewTranslator;
import Code.Translator.Translator;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

//TODO
/*
 * Class, Array(done)
 * Global Variable(done)
 * String storage & builtin function(done)
 * semantic check, get Expr Type(ArrayType)(done)
 * substring(done)
 * null(done)
 * memory allocate for multiarray(not done, use too much regs)
 * function use the member variable in its own class
 */


public class Boom {
    //String, Array, Class,
    public static void main(String[] args) throws Exception
    {
        InputStream is = System.in;
        OutputStream out = System.out;
//        InputStream is = new FileInputStream("Test/TestNasm/test925.mx");
//        OutputStream out = new FileOutputStream("Test/TestNasm/test_result.asm");
        ProgNode program = constructAST(is);
//        printAST(program);

        checkSemantic(program);
        IRConstructor constructor = constructIR(program);
//        printIR(constructor);
//        optimizeIR(constructor);
//        translate(constructor, out);
        graphColoring(constructor);
        newTanslate(constructor, out);
    }

    public static ProgNode constructAST(InputStream is) throws Exception
    {
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

        return constructor.getProgram();

    }
    public static void printAST(ProgNode program) throws Exception
    {
        FileOutputStream outputStream = new FileOutputStream("Test/TestSemantic/test_result.txt");
        ASTPrinter printer = new ASTPrinter();
        printer.PrintAST(program, outputStream);
    }
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
    public static IRConstructor constructIR(ProgNode program)
    {
        IRConstructor irConstructor = new IRConstructor(program);
        irConstructor.BuildIR();
        return irConstructor;
    }
    public static void printIR(IRConstructor irConstructor) throws Exception
    {
        FileOutputStream outputStream = new FileOutputStream("Test/TestIR/test_result.txt");
        IRInstruction entry = irConstructor.getEntry();
        List<Class> typeList = irConstructor.getTypes();
        DataSection dataSection = irConstructor.getDataSection();
        IRPrinter irPrinter = new IRPrinter(entry, irConstructor.getInitializeEntry(), outputStream, typeList ,dataSection);
        irPrinter.printIR();
    }
    public static void optimizeIR(IRConstructor irConstructor)
    {
        NaiveAllocator naiveAllocator = new NaiveAllocator(irConstructor.getEntry(), irConstructor.getInitializeEntry());
        naiveAllocator.process();
    }
    public static void translate(IRConstructor irConstructor, OutputStream outputStream)
    {
        Translator translator = new Translator(irConstructor.getEntry(), irConstructor.getInitializeEntry(),
                irConstructor.getDataSection(), irConstructor.getDataZone(), irConstructor.getBssZone());
        translator.process();
        NasmPrinter nasmPrinter = new NasmPrinter(translator.getNasmInsts(), translator.getDataInsts(),
                translator.getDataZoneInsts(), translator.getBssZoneInsts(),
                irConstructor.getGlobalName(), outputStream);
        nasmPrinter.printNasm();
    }
    public static void graphColoring(IRConstructor irConstructor)
    {
        CFGConstructor cfgConstructor = new CFGConstructor(irConstructor.getEntry());
        cfgConstructor.BuildCFG();
        GraphColoringAllocator allocator = new GraphColoringAllocator(irConstructor.getEntry(),
                cfgConstructor.getFunctions());
        allocator.process();
    }
    public static void newTanslate(IRConstructor irConstructor, OutputStream outputStream)
    {
        NewTranslator translator = new NewTranslator(irConstructor.getEntry(), irConstructor.getInitializeEntry(),
                irConstructor.getDataSection(), irConstructor.getDataZone(), irConstructor.getBssZone());
        translator.process();
        NasmPrinter nasmPrinter = new NasmPrinter(translator.getNasmInsts(), translator.getDataInsts(),
                translator.getDataZoneInsts(), translator.getBssZoneInsts(),
                irConstructor.getGlobalName(), outputStream);
        nasmPrinter.printNasm();
    }
}
