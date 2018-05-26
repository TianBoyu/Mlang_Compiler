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
    private DataSection dataSection;
    public IRPrinter(IRInstruction entry, FileOutputStream outputStream, List<Class> typeList, DataSection dataSection)
    {
        this.entry = entry;
        this.outputStream = outputStream;
        this.typeList = typeList;
        this.dataSection = dataSection;
    }
    public void printIR()
    {
        IRInstruction current = entry;
        PrintStream printStream = new PrintStream(outputStream);
        printStream.println("__________________________________________");
        printStream.println("===================TEXT===================");
        printStream.println("");
        while(current != null)
        {
            if(current instanceof Label)
            {
                printStream.println("");
                printStream.println("  " + current.toString());
            }
            else if(current instanceof Function)
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
        printStream.println("\n");
        printStream.println("__________________________________________");
        printStream.println("===================DATA===================");
        for(DataSection.DataPiece item : dataSection.getDataPieces())
            printStream.println(item.toString());


    }
}
