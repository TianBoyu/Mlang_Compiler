package Code.IR;

import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.IntegerValue;

import java.util.ArrayList;
import java.util.List;

public class CFGConstructor implements IRInstTraversal
{
    private IRInstruction entry;
    private BasicBlock currentBlock;
    private Label currentLabel;
    private List<BasicBlock> basicBlocks;
    private List<Function> functions;
    private Function currentFunction;
    public CFGConstructor(IRInstruction entry)
    {
        this.entry = entry;
        functions = new ArrayList<>();
        basicBlocks = new ArrayList<>();
    }

    public List<BasicBlock> getBasicBlocks()
    {
        return basicBlocks;
    }

    public void BuildCFG()
    {
        IRInstruction ir = entry;
        while(ir != null)
        {
            visit(ir);
            ir = ir.getNext();
        }
    }

    public List<Function> getFunctions()
    {
        return functions;
    }

    @Override
    public void visit(IRInstruction inst)
    {
        inst.accept(this);
    }

    @Override
    public void visit(Alloca inst)
    {
//        currentBlock.addInstruction(inst);
    }

    @Override
    public void visit(Malloc inst)
    {
        currentBlock.addInstruction(inst);
        addDefVar(inst, inst.getReturnAddress());
        addUseVar(inst, inst.getSize());
    }

    @Override
    public void visit(BinaryOperation inst)
    {
        currentBlock.addInstruction(inst);
        addUseVar(inst, inst.getLhs());
        addUseVar(inst, inst.getRhs());
        addDefVar(inst, inst.getDest());
    }

    @Override
    public void visit(Branch inst)
    {
        BasicBlock true_block = inst.getTrueLabel().getBlock();
        currentBlock.addInstruction(inst);
        currentBlock.addSuccessor(true_block);
        true_block.addPredecessor(true_block);
        BasicBlock false_block = inst.getFalseLabel().getBlock();
        currentBlock.addSuccessor(false_block);
        currentBlock.addPredecessor(false_block);
        currentBlock.setTail(inst);
        enterNewBlock(new BasicBlock());
    }

    @Override
    public void visit(Call inst)
    {
        currentBlock.addInstruction(inst);
        addDefVar(inst, inst.getDest());
        for(IntegerValue value : inst.getParams())
            addUseVar(inst, value);
    }

    @Override
    public void visit(Compare inst)
    {
        currentBlock.addInstruction(inst);
        addUseVar(inst, inst.getLhs());
        addUseVar(inst, inst.getRhs());
        addDefVar(inst, inst.getDest());
    }

    @Override
    public void visit(Function inst)
    {
        currentFunction = inst;
        if(currentBlock == null)
            currentBlock = new BasicBlock();
        currentBlock.addInstruction(inst);
        functions.add(inst);
    }

    @Override
    public void visit(Jump inst)
    {
        BasicBlock block = inst.getTarget().getBlock();
        currentBlock.addInstruction(inst);
        currentBlock.addSuccessor(block);
        block.addPredecessor(currentBlock);
        currentBlock.setTail(inst);
        enterNewBlock(new BasicBlock());
    }

    @Override
    public void visit(Label inst)
    {
//        enterNewBlock(inst.getBlock());
        inst.setBlock(currentBlock);
        currentBlock.setTitle(inst);
//        currentBlock.addInstruction(inst);
    }


    @Override
    public void visit(MemCopy inst)
    {
        currentBlock.addInstruction(inst);
        addUseVar(inst, inst.getFromAddress());
        addDefVar(inst, inst.getToAddress());
    }

    @Override
    public void visit(Move inst)
    {
        currentBlock.addInstruction(inst);
    }

    @Override
    public void visit(Return inst)
    {
        currentBlock.addInstruction(inst);
        currentBlock.setTail(inst);
        if(inst.getValue() != null)
            addUseVar(inst, inst.getValue());
        enterNewBlock(new BasicBlock());
    }

    @Override
    public void visit(Store inst)
    {
        currentBlock.addInstruction(inst);
        addUseVar(inst, inst.getData());
        addDefVar(inst, inst.getAddress());
    }

    private void enterNewBlock(BasicBlock newBlock)
    {
        if(currentBlock != null)
        {
            basicBlocks.add(currentBlock);
            currentFunction.addBasicBlock(currentBlock);
        }
        currentBlock = newBlock;
    }

    private void addUseVar(IRInstruction inst, IntegerValue value)
    {
        if(value instanceof Address)
        {
            if(((Address) value).isGlobal())
                return;
            if(((Address) value).isPointer())
            {
                addUseVar(inst, ((Address) value).getBase());
                addUseVar(inst, ((Address) value).getOffset());
            }
            else if(((Address) value).isGlobal())
                return;
            else
                inst.addUseVar((Address)value);
        }
    }

    private void addDefVar(IRInstruction inst, IntegerValue value)
    {
        if(value instanceof Address)
        {
            if(((Address) value).isPointer())
            {
                addUseVar(inst, ((Address) value).getBase());
                addUseVar(inst, ((Address) value).getOffset());
            }
            else if(((Address) value).isGlobal())
                return;
            else inst.addDefVar((Address)value);
        }
    }


}
