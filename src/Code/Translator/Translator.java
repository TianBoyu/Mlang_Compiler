package Code.Translator;

import Code.AST.Tools.Name;
import Code.IR.DataSection;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.Immediate;
import Code.IR.IRUnit.Oprands.IntegerValue;
import Code.IR.IRUnit.Oprands.VirtualRegister;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
//TODO

public class Translator implements IRInstTraversal
{
    private IRInstruction entry;
    private DataSection dataSection;
    private Map<Address, StackSlot> addressStackSlotMap;
    private int rsp_position;
    private List<NasmInst> nasmInsts;
    private List<NasmInst> dataInsts;
    private Function currentFunction;
    private String[] parameterRegName = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
    private String[] spareRegName = {"rax", "rbx", "rsp", "rbp", "r10", "r11",
                                    "r12", "r13", "r14", "r15"};
    public Translator(IRInstruction entry, DataSection dataSection)
    {
        this.entry = entry;
        this.dataSection = dataSection;
        rsp_position = 0;
        nasmInsts = new LinkedList<>();
        dataInsts = new LinkedList<>();
        addressStackSlotMap = new HashMap<>();
    }

    public void process()
    {
        processDataSection();
        IRInstruction cur = entry;
        while(cur != null)
        {
            visit(cur);
            cur = cur.getNext();
        }
        removeRedundantInst();
    }

    private void processDataSection()
    {
        for(DataSection.DataPiece piece : dataSection.getDataPieces())
        {
            addDataInst(NasmInst.Instruction.dq, String.valueOf(piece.getLength()), null);
            addDataInst(NasmInst.Instruction.NULL, piece.getName().toString(), null);
            addDataInst(NasmInst.Instruction.db, stringToAscii(piece.getValue()), null);
        }
    }

    public List<NasmInst> getNasmInsts()
    {
        return nasmInsts;
    }

    public List<NasmInst> getDataInsts()
    {
        return dataInsts;
    }

    @Override
    public void visit(IRInstruction inst)
    {
        inst.accept(this);
    }

    @Override
    public void visit(Alloca inst)
    {
        mapAddressToSlot(inst.getDest());
    }

    @Override
    public void visit(BinaryOperation inst)
    {
        if(inst.getLhs() instanceof Immediate)
            addInst(NasmInst.Instruction.mov, inst.getDestReg().toString(),
                    String.valueOf(((Immediate)inst.getLhs()).getValue()));
        else
            addInst(NasmInst.Instruction.mov, inst.getDestReg().toString(), inst.getLhsReg().toString());
        if(inst.getRhs() instanceof Immediate)
            addInst(NasmInst.Instruction.valueOf(inst.getOp().toString()),
                    inst.getDestReg().toString(), String.valueOf(((Immediate)inst.getRhs()).getValue()));
        else
            addInst(NasmInst.Instruction.valueOf(inst.getOp().toString()),
                inst.getDestReg().toString(), inst.getRhsReg().toString());

    }

    @Override
    public void visit(Branch inst)
    {
        //TODO true_label
        addInst(NasmInst.Instruction.jnz, inst.getFalseLabel().toString(), null);
    }

    @Override
    public void visit(Call inst)
    {
        int i = 0; //have you ++i?
        for(IntegerValue value : inst.getParams())
        {
            if(i < 6)
            {
                if(value instanceof Immediate)
                    addInst(NasmInst.Instruction.mov, parameterRegName[i],
                            String.valueOf(((Immediate) value).getValue()));
                else
                    addInst(NasmInst.Instruction.mov, parameterRegName[i],
                            addressStackSlotMap.get(value).toString());
            }
            else
            {
                StackSlot slot = addressStackSlotMap.get(value);
                addInst(NasmInst.Instruction.mov, spareRegName[i - 6], slot.toString());
                addInst(NasmInst.Instruction.push, spareRegName[i - 6], null);
            }
            ++i;
        }
        addInst(NasmInst.Instruction.call, inst.getFunction().toString(), null);
    }

    @Override
    public void visit(Compare inst)
    {
        String dest = inst.getDestReg().toString();
        switch (inst.getCondition())
        {
            case SLT:
            {
                addInst(NasmInst.Instruction.cmovl, dest, "1");
                break;
            }
            case SGT:
            {
                addInst(NasmInst.Instruction.cmovg, dest, "1");
                break;
            }
            case SEQ:
            {
                addInst(NasmInst.Instruction.cmovle, dest, "1");
                break;
            }
            case BEQ:
            {
                addInst(NasmInst.Instruction.cmovge, dest, "1");
                break;
            }
            case EQU:
            {
                addInst(NasmInst.Instruction.cmove, dest, "1");
                break;
            }
            case NEQ:
            {
                addInst(NasmInst.Instruction.cmovne, dest, "1");
                break;
            }
        }
        addInst(NasmInst.Instruction.cmp, dest, "0");
    }

    @Override
    public void visit(Function inst)
    {
        currentFunction = inst;
        addInst(null, inst.getName().toString(), null);
        addInst(NasmInst.Instruction.push, "rbp", null);
        addInst(NasmInst.Instruction.mov, "rbp", "rsp");
        addInst(NasmInst.Instruction.sub, "rsp",
                String.valueOf(inst.getUsedSlotNumber() * 8));
        int i = 0;
        for(Parameter item : inst.getParameter())
        {
            if(item.isAdded()) continue;
            StackSlot slot = mapAddressToSlot(item.getAddress());
            if(i < 6)
                addInst(NasmInst.Instruction.mov, slot.toString(), parameterRegName[i]);
            else
            {
                addInst(NasmInst.Instruction.pop, spareRegName[i - 6], null);
                addInst(NasmInst.Instruction.mov, slot.toString(), spareRegName[i - 6]);
            }
            ++i;
        }
    }

    @Override
    public void visit(Jump inst)
    {
        addInst(NasmInst.Instruction.jmp, inst.getTarget().toString(), null);
    }

    @Override
    public void visit(Label inst)
    {
        addInst(null, inst.toString(), null);
    }

//    @Override
//    public void visit(Load inst)
//    {
//        if(inst.getAddress() != null)
//        {
//            if(!addressStackSlotMap.containsKey(inst.getAddress())) //means it is an address of string
//            {
//                String destReg = inst.getDestReg().toString();
//                addInst(NasmInst.Instruction.mov, destReg, inst.getAddress().getName().toString());
//                StackSlot slot = mapAddressToSlot(inst.getAddress());
//                addInst(NasmInst.Instruction.mov, slot.toString(), destReg);
//            }
//            addInst(NasmInst.Instruction.mov, inst.getDestReg().toString(),
//                    addressStackSlotMap.get(inst.getAddress()).toString());
//        }
//        else //means load an immediate to the register
//        {
//            addInst(NasmInst.Instruction.mov, inst.getDestReg().toString(),
//                    String.valueOf(inst.getValue().getValue()));
//        }
//    }

    @Override
    public void visit(MemCopy inst)
    {
        addInst(NasmInst.Instruction.mov, addressStackSlotMap.get(inst.getFromAddress()).toString(),
                addressStackSlotMap.get(inst.getToAddress()).toString());
    }

    @Override
    public void visit(Move inst)
    {
//        addInst(NasmInst.Instruction.mo)
    }

    @Override
    public void visit(Return inst)
    {
        if(inst.getValueReg() != null)
        {
            addInst(NasmInst.Instruction.mov, inst.getValueReg().toString(),
                    addressStackSlotMap.get(inst.getValue()).toString());
            if(!inst.getValueReg().toString().equals("rax"))
                addInst(NasmInst.Instruction.mov, "rax", inst.getValueReg().toString());
        }
        else
            addInst(NasmInst.Instruction.mov, "rax",
                    String.valueOf(((Immediate)inst.getValue()).getValue()));
        addInst(NasmInst.Instruction.add, "rsp", String.valueOf(currentFunction.getUsedSlotNumber() * 8));
        addInst(NasmInst.Instruction.pop, "rbp", null);
        addInst(NasmInst.Instruction.ret, null, null);
    }

    @Override
    public void visit(Store inst)
    {
        if(inst.getData() instanceof Address)
        {
            StackSlot slot = null;
            if(addressStackSlotMap.containsKey(inst.getData())) //the address is obtained by alloca
                addInst(NasmInst.Instruction.mov, inst.getDataReg().toString(),
                    addressStackSlotMap.get(inst.getData()).toString());
            else //the address is a string
            {
                slot = mapAddressToSlot((Address) inst.getData());
                addInst(NasmInst.Instruction.mov, inst.getDataReg().toString(),
                        ((Address) inst.getData()).getName().toString());
                addInst(NasmInst.Instruction.mov, slot.toString(), inst.getDataReg().toString());
            }
        }
        if(inst.getDataReg() != null)
            addInst(NasmInst.Instruction.mov, addressStackSlotMap.get(inst.getAddress()).toString(), inst.getDataReg().toString());
        else //means store an Immediate
            addInst(NasmInst.Instruction.mov, addressStackSlotMap.get(inst.getAddress()).toString(),
                    String.valueOf(((Immediate)inst.getData()).getValue()));
    }

    private void addInst(NasmInst.Instruction inst, String operand1, String operand2)
    {
        if(inst == null)
            inst = NasmInst.Instruction.NULL;
        if(operand1 == null)
            operand1 = "NULL";
        if(operand2 == null)
            operand2 = "NULL";
        nasmInsts.add(new NasmInst(inst, operand1, operand2));
    }

    private void addDataInst(NasmInst.Instruction inst, String operand1, String operand2)
    {
        if(inst == null)
            inst = NasmInst.Instruction.NULL;
        if(operand1 == null)
            operand1 = "NULL";
        if(operand2 == null)
            operand2 = "NULL";
        dataInsts.add(new NasmInst(inst, operand1, operand2));
    }

    private StackSlot mapAddressToSlot(Address address)
    {
        StackSlot.SlotType type = StackSlot.SlotType.qword;
        StackSlot slot = new StackSlot(rsp_position, rsp_position + 8, type);
        addressStackSlotMap.put(address, slot);
        rsp_position += 8;
        return slot;
    }


    private String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        char[] chars = value.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            sbu.append((int)chars[i]).append(", ");
        }
        sbu.append('0');
        return sbu.toString();
    }

    private void removeRedundantInst()
    {
        for(int i = 0; i < nasmInsts.size(); ++i)
        {
            if(isRedundant(nasmInsts.get(i)))
                nasmInsts.remove(i);
        }
    }

    private boolean isRedundant(NasmInst nasmInst)
    {
        if(nasmInst.getInst() == NasmInst.Instruction.mov &&
                nasmInst.getOperand1().equals(nasmInst.getOperand2()))
            return true;
        return false;
    }

}
