package Code.IR;

import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Tools.Name;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.Vector;

public class FunctionScope
{
    private Vector<VirtualRegister> registerMap = new Vector<VirtualRegister>(1);
    private int currentNumber = 0;
    private Name name;
    private FuncDecNode funcDecNode;
    private int usedSlotNumber = 0;
    public FunctionScope(Name name)
    {
        this.name = name;
    }
    public VirtualRegister getRegister()
    {
        VirtualRegister register = new VirtualRegister(Name.getName("%r" + String.valueOf(currentNumber++)));
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

    public int getUsedSlotNumber()
    {
        return usedSlotNumber;
    }

    public void increSlotNumber()
    {
        ++usedSlotNumber;
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
