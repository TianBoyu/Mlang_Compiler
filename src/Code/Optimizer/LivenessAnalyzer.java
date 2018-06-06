package Code.Optimizer;

import Code.IR.BasicBlock;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class LivenessAnalyzer
{
    //    List<BasicBlock> basicBlocks;
    private IRInstruction entry;

    public LivenessAnalyzer(IRInstruction entry)
    {
        this.entry = entry;
    }

    public void process()
    {
        IRInstruction cur = entry;
        while(cur != null)
        {
            if(cur instanceof Function)
                livenessAnalyze((Function) cur);
            cur = cur.getNext();
        }
    }

    public void livenessAnalyze(Function function)
    {
        resetInOut(function);
        List<BasicBlock> basicBlocks = function.getBasicBlocks();
        boolean change = true;
        while(change)
        {
            change = false;
            Set<VirtualRegister> liveIn = new HashSet<>();
            Set<VirtualRegister> liveOut = new HashSet<>();
            for(int index = basicBlocks.size() - 1; index >= 0; --index)
            {
                for(IRInstruction instruction = basicBlocks.get(index).getTail();
                    instruction != null;
                    instruction = instruction.getLast())
                {
                    liveIn.clear();
                    liveOut.clear();
                    liveIn.addAll(instruction.liveOut);
                    liveIn.removeAll(instruction.defVar);
                    liveIn.addAll(instruction.useVar);

                    if(instruction instanceof Branch && !((Branch) instruction).isTransferBranch)
                    {
                        //the next inst's livein
                        liveOut.addAll(((Branch) instruction).getTrueLabel().getBlock().getHead().liveIn);
                        liveOut.addAll(((Branch) instruction).getFalseLabel().getBlock().getHead().liveIn);
                    }
                    else if(instruction instanceof Jump)
                    {
                        liveOut.addAll(((Jump) instruction).getTarget().getBlock().getHead().liveIn);
                    }
                    else if(!(instruction instanceof Return))
                    {
                        liveOut.addAll(instruction.getNext().liveIn);
                    }
                    if(liveIn.equals(instruction.liveIn) && liveOut.equals(instruction.liveOut))
                        continue;
                    change = true;
                    instruction.liveIn.clear();
                    instruction.liveIn.addAll(liveIn);
                    instruction.liveOut.clear();
                    instruction.liveOut.addAll(liveOut);
                }
            }
        }
    }

    private void resetInOut(Function function)
    {
        for(BasicBlock block : function.getBasicBlocks())
        {
            for(IRInstruction instruction : block.getInstructions())
            {
                instruction.liveIn.clear();
                instruction.liveOut.clear();
            }
        }
    }


}
