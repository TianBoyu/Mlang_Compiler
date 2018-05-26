package Code.Translator;

import Code.AST.Tools.Name;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.List;

public class NasmPrinter
{
    private List<NasmInst> nasmInsts;
    private List<Name> globalNames;
    private OutputStream outputStream;


    public NasmPrinter(List<NasmInst> nasmInsts, List<Name> globalNames, OutputStream outputStream)
    {
        this.nasmInsts = nasmInsts;
        this.globalNames = globalNames;
        this.outputStream = outputStream;
    }

    public void printNasm()
    {
        PrintStream printStream = new PrintStream(outputStream);
//        printStream.println("default rel\n");
        String indent = "       ";
        for(Name name : globalNames)
        {
            printStream.println("global    " + name.toString());
        }
        printStream.println("section .text\n");
        for(NasmInst item : nasmInsts)
        {
            if(item.getInst() == NasmInst.Instruction.NULL) //means inst is a label
                printStream.println(item.toString() + ":");
            else
                printStream.println(indent + item.toString());
        }
        printStream.println("\n\nsection .data\n");
        printStream.println("section .bss\n");
    }

}
