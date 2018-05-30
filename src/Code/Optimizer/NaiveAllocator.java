package Code.Optimizer;

import Code.AST.Tools.Name;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.*;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NaiveAllocator extends RegisterAllocator implements IRInstTraversal
{
    private IRInstruction entry;
    private Map<VirtualRegister, PhysicalRegister> registerMap = new HashMap<>();
    private List<PhysicalRegister> physicalRegisters;
    private String[] registerNames = {"rax", "rcx", "rdx", "rbx", "rsi", "rdi",
            "r8",  "r9",  "r10", "r11", "r12", "r13", "r14", "r15"};
    private String[] parameterRegNames = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
    private boolean[] isAvailable;
    public NaiveAllocator(IRInstruction entry)
    {
        this.entry = entry;
        physicalRegisters = new ArrayList<>(16);
//        isAvailable = new HashMap<>();
        isAvailable = new boolean[16];
        initRegisterList();
    }

    public void process()
    {
        IRInstruction cur = entry;
        while(cur != null)
        {
            visit(cur);
            cur = cur.getNext();
        }
    }

    @Override
    public void visit(IRInstruction inst)
    {
        resetAvailable();
        registerMap.clear();
        inst.accept(this);
    }

    @Override
    public void visit(Alloca inst) {
    }

    @Override
    public void visit(Malloc inst)
    {
        inst.setReturnReg(physicalRegisters.get(0));
        isAvailable[0] = false;
        if(inst.getSize() instanceof VirtualRegister)
            inst.setSizeReg(getPhysicalRegister((VirtualRegister) inst.getSize()));
    }

    @Override
    public void visit(BinaryOperation inst)
    {
        //const value folded
        if(inst.getOp() == BinaryOperation.BinaryOp.idiv)
        {
            inst.setDestReg(physicalRegisters.get(0));
            isAvailable[0] = false;
        }
        else if(inst.getOp() == BinaryOperation.BinaryOp.mod)
        {
            inst.setOp(BinaryOperation.BinaryOp.idiv);
            inst.setDestReg(physicalRegisters.get(2));
            isAvailable[2] = false;
        }
        else
        {
            PhysicalRegister destPr = getPhysicalRegister(inst.getDest());
            inst.setDestReg(destPr);
        }

        if(inst.getLhs() instanceof VirtualRegister)
        {
            PhysicalRegister lhsPr;
            if(inst.getOp() == BinaryOperation.BinaryOp.idiv)
            {
                lhsPr = physicalRegisters.get(0);
                isAvailable[0] = false;
            }
            else
                lhsPr = getPhysicalRegister((VirtualRegister) inst.getLhs());
            inst.setLhsReg(lhsPr);
        }
        if(inst.getRhs() instanceof VirtualRegister)
        {
            PhysicalRegister rhsPr = getPhysicalRegister((VirtualRegister) inst.getRhs());
            inst.setRhsReg(rhsPr);
        }
    }

    @Override
    public void visit(Branch inst)
    {

    }

    @Override
    public void visit(Call inst)
    {
        for(IntegerValue parameter : inst.getParams())
        {
            if(parameter instanceof VirtualRegister)
                allocRegisterForAddress((VirtualRegister) parameter);
        }
        PhysicalRegister destPr = physicalRegisters.get(0);
        inst.setDestReg(destPr);
        isAvailable[0] = false;
    }

    @Override
    public void visit(Compare inst)
    {
        PhysicalRegister destPr = getPhysicalRegister(inst.getDest());
        inst.setDestReg(destPr);
        if(inst.getLhs() instanceof VirtualRegister)
        {
            PhysicalRegister lhsPr = getPhysicalRegister((VirtualRegister) inst.getLhs());
            inst.setLhsReg(lhsPr);
        }
        if(inst.getRhs() instanceof VirtualRegister)
        {
            PhysicalRegister rhsPr = getPhysicalRegister((VirtualRegister) inst.getRhs());
            inst.setRhsReg(rhsPr);
        }
    }

    @Override
    public void visit(Function inst)
    {

    }

    @Override
    public void visit(Jump inst)
    {

    }

    @Override
    public void visit(Label inst)
    {

    }

    @Override
    public void visit(MemCopy inst)
    {

    }

    @Override
    public void visit(Move inst)
    {
        //TODO
        //because we do not have move instructions now
    }

    @Override
    public void visit(Return inst)
    {
        if(inst.getValue() instanceof VirtualRegister)
        {
            PhysicalRegister pr = getPhysicalRegister((VirtualRegister) inst.getValue());
            inst.setValueReg(pr);
        }
    }

    @Override
    public void visit(Store inst)
    {
        if(inst.getAddress() instanceof VirtualRegister)
            allocRegisterForAddress((VirtualRegister) inst.getAddress());
        if(inst.getData() instanceof VirtualRegister)
        {
            PhysicalRegister pr = getPhysicalRegister((VirtualRegister) inst.getData());
            inst.setDataReg(pr);
        }
    }

    private void initRegisterList()
    {
         //R0  R1  R2  R3  R4  R5  R6  R7  R8  R9  R10  R11  R12  R13  R14  R15
         //rax rcx rdx rbx rsp rbp rsi rdi
        for(String name : registerNames)
        {
            physicalRegisters.add(new PhysicalRegister(Name.getName(name)));
        }
        resetAvailable();

    }

    private void resetAvailable()
    {
        for(int i = 0; i < 16; ++i)
            isAvailable[i] = true;
    }


    private void allocRegisterForAddress(VirtualRegister vr)
    {
        if(vr instanceof Address)
        {
            if(((Address) vr).getBase() != null)
            {
                PhysicalRegister basePr = getAvailablePhysicalRegister();
                ((Address) vr).setBaseReg(basePr);
                if (!(((Address) vr).getOffset() instanceof Immediate))
                {
                    PhysicalRegister offsetPr = getAvailablePhysicalRegister();
                    ((Address) vr).setOffsetReg(offsetPr);
                }
            }
        }
    }
    private PhysicalRegister getPhysicalRegister(VirtualRegister vr)
    {
        allocRegisterForAddress(vr);
        if(registerMap.containsKey(vr))
            return registerMap.get(vr);
        else
        {
            PhysicalRegister pr = getAvailablePhysicalRegister();
            registerMap.put(vr, pr);
            return pr;
        }
    }

    private PhysicalRegister getAvailablePhysicalRegister()
    {
        int i = 0;
        while(true)
        {
            if(!isAvailable[i])
                ++i;
            else break;
        }
        isAvailable[i] = false;
        return physicalRegisters.get(i);
    }

}
