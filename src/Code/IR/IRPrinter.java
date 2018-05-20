package Code.IR;

import Code.IR.IRUnit.Function;
import Code.IR.IRUnit.IRInstruction;
import Code.IR.IRUnit.Label;
import Code.IR.Type.Class;

import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.List;

public class IRPrinter
{
    private IRInstruction entry;
    private FileOutputStream outputStream;
    private List<Class> typeList;
    public IRPrinter(IRInstruction entry, FileOutputStream outputStream, List<Class> typeList)
    {
        this.entry = entry;
        this.outputStream = outputStream;
        this.typeList = typeList;
    }
    public void printIR()
    {
        IRInstruction current = entry;
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("__________________________________________");
        printStream.println("========IntermediateRepresentation========");
        printStream.println("");
        while(current != null)
        {
            if(current instanceof Label || current instanceof Function)
            {
                printStream.println("");
                printStream.println(current.toString());
            }
            else
                printStream.println("  " + current.toString());
            current = current.getNext();
        }
        printStream.println("\n");
        printStream.println("__________________________________________");
        printStream.println("===================TYPE===================");
        for(Class item : typeList)
            printStream.println(item.toFullInfoString());
    }
}
