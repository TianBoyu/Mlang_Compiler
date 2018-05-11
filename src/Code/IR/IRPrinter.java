package Code.IR;

import Code.IR.IRUnit.IRInstruction;
import Code.IR.IRUnit.Label;

import java.io.FileOutputStream;
import java.io.PrintStream;

public class IRPrinter
{
    private IRInstruction entry;
    private FileOutputStream outputStream;
    public IRPrinter(IRInstruction entry, FileOutputStream outputStream)
    {
        this.entry = entry;
        this.outputStream = outputStream;
    }
    public void printIR()
    {
        IRInstruction current = entry;
        PrintStream printStream = new PrintStream(outputStream);
        while(current != null)
        {
            if(current instanceof Label)
            {
                printStream.println("");
                printStream.println(current.toString());
            }
            else
                printStream.println("  " + current.toString());
            current = current.getNext();
        }
    }
}
