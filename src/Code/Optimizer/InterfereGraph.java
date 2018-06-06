package Code.Optimizer;

import Code.IR.BasicBlock;
import Code.IR.IRUnit.Function;
import Code.IR.IRUnit.IRInstruction;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.Register;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.Stack;

public class InterfereGraph
{
    public Set<VirtualRegister> registerGraph = new HashSet<>();
    public Stack<Register> registerStack = new Stack<>();
    private Set<VirtualRegister> firedRegisters = new HashSet<>();
    private static final int  REGISTER_NUMBER = 1;

    public void init(Function function)
    {
        registerGraph.clear();
        registerStack.clear();
        firedRegisters.clear();

        for(BasicBlock block : function.getBasicBlocks())
        {
            for(IRInstruction instruction : block.getInstructions())
            {
                registerGraph.addAll(instruction.useVar);
                registerGraph.addAll(instruction.defVar);
            }
        }
    }

    public void addEdge(Register a, Register b)
    {
        if(a == b)
            return;
        a.neighbors.add(b);
        b.neighbors.add(a);
    }

    public void removeRegister(Register register)
    {
        for(Register neighbor : register.neighbors)
        {
            if(!neighbor.isDeleted && neighbor instanceof VirtualRegister &&
                    !((Address)neighbor).isPointer())
            {
                --neighbor.degree;
                if(neighbor.degree < 1)
                    firedRegisters.add((VirtualRegister) neighbor);
            }
        }
        register.isDeleted = true;
        registerStack.push(register);
        registerGraph.remove(register);
    }

    public void simplify()
    {
        while(!registerGraph.isEmpty())
        {
            while(!firedRegisters.isEmpty())
            {
                Iterator<VirtualRegister> iter = firedRegisters.iterator();
                VirtualRegister register = iter.next();
                removeRegister(register);
                firedRegisters.remove(register);
            }
            Iterator<VirtualRegister> iter = registerGraph.iterator();

            if(iter.hasNext()) removeRegister(iter.next());
            else break;
        }
    }

    public void updateDegree()
    {
        for(Register reg : registerGraph)
        {
            reg.degree = reg.neighbors.size();
            if(reg.degree < 1 && reg instanceof Address && !((Address)reg).isPointer())
                firedRegisters.add((Address)reg);
        }
    }

}
