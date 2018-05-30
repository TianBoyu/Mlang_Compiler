package Code.Translator;

import Code.AST.Tools.Name;
import Code.IR.DataSection;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.*;

import java.util.*;
//TODO
//In a function, should pop before sub rsp

public class Translator implements IRInstTraversal
{
    private static final int ARGUMENT_NUMBER = 6;
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
        rsp_position = 8;//cannot begin with 0
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
            if(cur instanceof Function)
            {
                addressStackSlotMap.clear();
                rsp_position = 8;
            }
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
    public void visit(Malloc inst)
    {
        String sizeIntegerValue;
        if(inst.getSize() instanceof Immediate)
        {
            ((Immediate) inst.getSize()).addValue(1);
            sizeIntegerValue = processIntegerValue(inst.getSize(), inst.getSizeReg());
//            ((Immediate) inst.getSize()).addValue(-1);
        }
        else
        {
            sizeIntegerValue = processIntegerValue(inst.getSize(), inst.getSizeReg());
            addInst(NasmInst.Instruction.add, inst.getSizeReg().toString(), "1");
//            addInst(NasmInst.Instruction.sub, inst.getSizeReg().toString(), "1");
        }
        addInst(NasmInst.Instruction.mov, "rdi", sizeIntegerValue);
        addInst(NasmInst.Instruction.call, "malloc", null);
        addInst(NasmInst.Instruction.mov, getStackPos(inst.getReturnAddress()), "rax");
    }

    @Override
    public void visit(BinaryOperation inst)
    {
        if(inst.getOp() == BinaryOperation.BinaryOp.idiv || inst.getOp() == BinaryOperation.BinaryOp.mod)
        {
            visitDivBinaryOp(inst);
            return;
        }
        String leftIntegerValue = processIntegerValue(inst.getLhs(), null);
        addInst(NasmInst.Instruction.mov, inst.getDestReg().toString(), leftIntegerValue);
        String rightIntegerValue = processIntegerValue(inst.getRhs(), inst.getRhsReg());
        addInst(NasmInst.Instruction.valueOf(inst.getOp().toString()),
                inst.getDestReg().toString(), rightIntegerValue);
        addInst(NasmInst.Instruction.mov, processAddress(inst.getDest()), inst.getDestReg().toString());
    }

    private void visitDivBinaryOp(BinaryOperation inst)
    {
        if(inst.getLhs() instanceof Immediate)
        {
            addInst(NasmInst.Instruction.mov, inst.getLhsReg().toString(),
                    String.valueOf(((Immediate) inst.getLhs()).getValue()));
            addInst(NasmInst.Instruction.mov, inst.getDestReg().toString(),
                    inst.getLhsReg().toString());
        }
        else
        {
            addInst(NasmInst.Instruction.mov, inst.getLhsReg().toString(),
                    processAddress((Address)inst.getLhs()));
            addInst(NasmInst.Instruction.mov, inst.getDestReg().toString(), inst.getLhsReg().toString());
        }
        if(inst.getRhs() instanceof Immediate)
        {
            addInst(NasmInst.Instruction.mov, "rdx", "0");
            addInst(NasmInst.Instruction.idiv, String.valueOf(((Immediate) inst.getRhs()).getValue()),
                    null);
        }
        else
        {
            addInst(NasmInst.Instruction.mov, inst.getRhsReg().toString(),
                    processAddress((Address)inst.getRhs()));
            addInst(NasmInst.Instruction.mov, "rdx", "0");
            addInst(NasmInst.Instruction.idiv, inst.getRhsReg().toString(), null);
        }
        addInst(NasmInst.Instruction.mov, processAddress(inst.getDest()),
                inst.getDestReg().toString());
    }

    @Override
    public void visit(Branch inst)
    {
        if(inst.getOp() != null)
        {
            switch (inst.getOp())
            {
                case BEQ:
                    addInst(NasmInst.Instruction.jl, inst.getFalseLabel().toString(), null);
                    break;
                case EQU:
                    addInst(NasmInst.Instruction.jne, inst.getFalseLabel().toString(), null);
                    break;
                case NEQ:
                    addInst(NasmInst.Instruction.je, inst.getFalseLabel().toString(), null);
                    break;
                case SEQ:
                    addInst(NasmInst.Instruction.jg, inst.getFalseLabel().toString(), null);
                    break;
                case SGT:
                    addInst(NasmInst.Instruction.jle, inst.getFalseLabel().toString(), null);
                    break;
                case SLT:
                    addInst(NasmInst.Instruction.jge, inst.getFalseLabel().toString(), null);
                    break;
            }
        }
        else
            addInst(NasmInst.Instruction.jz, inst.getFalseLabel().toString(), null);
    }

    @Override
    public void visit(Call inst)
    {
        int i = 0; //have you ++i?
        int rsp_move = 0;
        for(IntegerValue value : inst.getParams())
        {
            String argumentIntegerValue = processIntegerValue(value, null);
            if(i < ARGUMENT_NUMBER)
            {
                addInst(NasmInst.Instruction.mov, parameterRegName[i], argumentIntegerValue);
            }
            else
            {
                addInst(NasmInst.Instruction.mov, spareRegName[0], argumentIntegerValue);
                addInst(NasmInst.Instruction.push, spareRegName[0], null);
                rsp_move += 8;
                rsp_position -= 8;
            }
            ++i;
        }
        addInst(NasmInst.Instruction.call, inst.getFunction().toString(), null);
        if(rsp_move != 0)
            addInst(NasmInst.Instruction.add, "rsp", String.valueOf(rsp_move));
        addInst(NasmInst.Instruction.mov, processAddress(inst.getDest()), inst.getDestReg().toString());
    }

    @Override
    public void visit(Compare inst)
    {
        String leftIntegerValue;
        String rightIntegerValue;
        leftIntegerValue = processIntegerValue(inst.getLhs(), inst.getLhsReg());
        rightIntegerValue = processIntegerValue(inst.getRhs(), inst.getRhsReg());
        addInst(NasmInst.Instruction.cmp, leftIntegerValue, rightIntegerValue);
    }

    @Override
    public void visit(Function inst)
    {
        currentFunction = inst;
        addInst(null, inst.getName().toString(), null);
        int i = 0;
        addInst(NasmInst.Instruction.push, "rbp", null);
        addInst(NasmInst.Instruction.mov, "rbp", "rsp");
        addInst(NasmInst.Instruction.sub, "rsp",
                String.valueOf(inst.getUsedSlotNumber() * 8));
        int paramNumber = inst.getParameter().size();
        for(Parameter item : inst.getParameter())
        {
//            if(item.isAdded()) continue;
            StackSlot slot = mapAddressToSlot(item.getAddress());
            if(i < ARGUMENT_NUMBER)
                addInst(NasmInst.Instruction.mov, slot.toString(), parameterRegName[i]);
            else
            {
                int paramPos = (paramNumber - i + 1) * 8;
                StackSlot slot1 = new StackSlot(paramPos, StackSlot.SlotType.qword);
                addInst(NasmInst.Instruction.mov, spareRegName[0], slot1.toString());
                addInst(NasmInst.Instruction.mov, slot.toString(), spareRegName[0]);
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

    @Override
    public void visit(MemCopy inst)
    {
        addInst(NasmInst.Instruction.mov, processAddress(inst.getFromAddress()),
                processAddress(inst.getToAddress()));
    }

    @Override
    public void visit(Move inst)
    {
//        addInst(NasmInst.Instruction.mo)
    }

    @Override
    public void visit(Return inst)
    {
        String returnIntegerValue = processIntegerValue(inst.getValue(), inst.getValueReg());
        addInst(NasmInst.Instruction.mov, "rax", returnIntegerValue);
        addInst(NasmInst.Instruction.add, "rsp", String.valueOf(currentFunction.getUsedSlotNumber() * 8));
        addInst(NasmInst.Instruction.pop, "rbp", null);
        addInst(NasmInst.Instruction.ret, null, null);
    }

    @Override
    public void visit(Store inst)
    {
        String storeIntegerValue = processIntegerValue(inst.getData(), inst.getDataReg());
        addInst(NasmInst.Instruction.mov, processAddress((Address) inst.getAddress()), storeIntegerValue);
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

    private String getStackPos(Address address)
    {
        return addressStackSlotMap.get(address).toString();
    }

    private String processIntegerValue(IntegerValue value, PhysicalRegister pr)
    {
        String ret;
        if(value instanceof Address)
        {
            if(!addressStackSlotMap.containsKey(value) && ((Address) value).getBase() == null) //global variable
            {
                StackSlot slot = mapAddressToSlot((Address)value);
                addInst(NasmInst.Instruction.mov, pr.toString(),
                        ((Address)value).getName().toString());
                addInst(NasmInst.Instruction.mov, slot.toString(), pr.toString());
            } // local variable
            if (pr == null)
                ret = processAddress((Address) value);
            else
            {
                addInst(NasmInst.Instruction.mov, pr.toString(), processAddress((Address) value));
                ret = pr.toString();
            }
        }
        else if(value instanceof Immediate)// means the value is an Immediate
        {
            ret = String.valueOf(((Immediate) value).getValue());
        }
        else //virtual register
            ret = pr.toString();
        return ret;
    }

    private String processAddress(Address address)
    {
//        return getStackPos(address);
        if(address.getBase() == null)
            return getStackPos(address);
        else//ArrayType or ClassType
        {
            addInst(NasmInst.Instruction.mov, address.getBaseReg().toString(),
                    processAddress(address.getBase()));
            if(address.getOffset() instanceof Immediate)
                return "qword [" + address.getBaseReg().toString() + " + " +
                        String.valueOf(((Immediate) address.getOffset()).getValue() * 8 + 8) + "]";
            else
            {

                String offset = processIntegerValue(address.getOffset(), address.getOffsetReg());
                addInst(NasmInst.Instruction.add, address.getOffsetReg().toString(), "1");
                return "qword [" + address.getBaseReg().toString() + " + " + offset + " * 8]";
            }
        }
    }

}
