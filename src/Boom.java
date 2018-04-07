import java.io.FileInputStream;
import java.io.InputStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;


public class Boom {
    public static void processTree(String file_path) throws Exception
    {
        InputStream is = new FileInputStream(file_path);
        ANTLRInputStream input = new ANTLRInputStream(is);


    }
    public static void main(String[] args)
    {
        System.out.println("Boom!Compile them all!");
    }
}
