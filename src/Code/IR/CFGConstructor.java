package Code.IR;

import Code.IR.IRUnit.*;

public class CFGConstructor implements IRInstTraversal
{
    private IRInstruction entry;
    private BasicBlock currentBlock;
    private Label currentLabel;
    public CFGConstructor(IRInstruction entry)
    {
        this.entry = entry;

    }

    public void BuildCFG()
    {
        IRInstruction ir = entry;
        while(ir != null)
        {
            visit(ir);
        }
    }

    @Override
    public void visit(IRInstruction inst)
    {
        inst.accept(this);
    }

    @Override
    public void visit(Alloca inst)
    {
    }

    @Override
    public void visit(BinaryOperation inst)
    {
    }

    @Override
    public void visit(Branch inst)
    {
        BasicBlock true_block = inst.getTrueLabel().getBlock();
        currentBlock.addSuccessor(true_block);
        true_block.addPredecessor(true_block);
        BasicBlock false_block = inst.getFalseLabel().getBlock();
        currentBlock.addSuccessor(false_block);
        currentBlock.addPredecessor(false_block);

    }

    @Override
    public void visit(Call inst)
    {
        //currentBlock.addInstruction(inst);
    }

    @Override
    public void visit(Compare inst)
    {
        //currentBlock.addInstruction(inst);
    }

    @Override
    public void visit(Function inst)
    {

    }

    @Override
    public void visit(Jump inst)
    {
        BasicBlock block = inst.getTarget().getBlock();
        currentBlock.addSuccessor(block);
        block.addPredecessor(currentBlock);
    }

    @Override
    public void visit(Label inst)
    {
        currentBlock = inst.getBlock();
    }

    @Override
    public void visit(Load inst)
    {
        //currentBlock.addInstruction(inst);
    }

    @Override
    public void visit(MemCopy inst)
    {
        //currentBlock.addInstruction(inst);
    }

    @Override
    public void visit(Move inst)
    {
    }

    @Override
    public void visit(Return inst)
    {

    }

    @Override
    public void visit(Store inst)
    {
    }

    private BasicBlock getNewBlock()
    {
        BasicBlock block = new BasicBlock();
        return block;
    }


}
