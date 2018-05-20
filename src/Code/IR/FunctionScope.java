package Code.IR;

import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Tools.Name;
import Code.IR.IRUnit.Function;
import Code.IR.IRUnit.Value.VirtualRegister;

import java.util.HashMap;
import java.util.Map;
import java.util.Vector;

public class FunctionScope
{
    private Vector<VirtualRegister> registerMap = new Vector<VirtualRegister>(1);
    private int currentNumber = 0;
    private Name name;
    private FuncDecNode funcDecNode;
    public FunctionScope(Name name)
    {
        this.name = name;
    }
    public VirtualRegister getRegister()
    {
        VirtualRegister register = new VirtualRegister(new Name("_r" + String.valueOf(currentNumber++)));
        registerMap.addElement(register);
        return register;
    }
    public VirtualRegister getRegister(int number)
    {
        return registerMap.elementAt(number);
    }

    public int getCurrentNumber()
    {
        return currentNumber;
    }

    public FuncDecNode getFuncDecNode()
    {
        return funcDecNode;
    }

    public void setFuncDecNode(FuncDecNode funcDecNode)
    {
        this.funcDecNode = funcDecNode;
    }

    public Name getName()
    {
        return name;
    }
}
