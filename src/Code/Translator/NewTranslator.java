package Code.Translator;

import Code.AST.Tools.Name;
import Code.IR.DataSection;
import Code.IR.IRInstTraversal;
import Code.IR.IRUnit.*;
import Code.IR.IRUnit.Oprands.*;

import java.util.*;

public class NewTranslator implements IRInstTraversal
{
    private static final int ARGUMENT_NUMBER = 6;
    private IRInstruction entry;
    private IRInstruction initializeEntry;
    private DataSection dataSection;
    private DataSection dataZone;
    private DataSection bssZone;
    private String[] paramRegNames = {"rdi", "rsi", "rdx", "rcx", "r8", "r9"};
    private String[] spareRegNames = { "r15", "r14", "r13", "r12", "r11", "r10"};
//    private String[] spareRegNames = {"r15", "r14", "r13"};
    private List<PhysicalRegister> sparePhysicalRegs = new ArrayList<>();
    private List<PhysicalRegister> paramPhysicalRegs = new ArrayList<>();
    private int rspPosition;
    private boolean isInitialzeInst = false;
    private Function currentFunction;

    private List<NasmInst> nasmInsts;
    private List<NasmInst> dataInsts;
    private List<NasmInst> dataZoneInsts;
    private List<NasmInst> bssZoneInsts;
    private List<NasmInst> initializeInsts;

    private Map<Address, StackSlot> addressStackSlotMap = new HashMap<>();

    public NewTranslator(IRInstruction entry, IRInstruction initializeEntry, DataSection dataSection, DataSection dataZone, DataSection bssZone)
    {
        this.entry = entry;
        this.initializeEntry = initializeEntry;
        this.dataSection = dataSection;
        this.dataZone = dataZone;
        this.bssZone = bssZone;
        rspPosition = 8;
        nasmInsts = new LinkedList<>();
        dataInsts = new LinkedList<>();
        dataZoneInsts = new LinkedList<>();
        bssZoneInsts = new LinkedList<>();
        initializeInsts = new LinkedList<>();
        initPhysicalRegs();
    }

    public void process()
    {
        processDataSection();
        processDataZone();
        processBssZone();
        processInitialInst();
        IRInstruction cur = entry;
        while(cur != null)
        {
            if(cur instanceof Function)
                enterNewFunction();
            visit(cur);
            if (cur instanceof Function && ((Function) cur).getName() == Name.getName("main"))
            {
                for (NasmInst inst : initializeInsts)
                    nasmInsts.add(inst);
            }
            cur = cur.getNext();
        }
        removeRedundantInst();
    }

    private void initSpareRegs()
    {
        for(String name : spareRegNames)
            sparePhysicalRegs.add(new PhysicalRegister(Name.getName(name)));
    }

    public List<NasmInst> getNasmInsts()
    {
        return nasmInsts;
    }

    public List<NasmInst> getDataInsts()
    {
        return dataInsts;
    }

    public List<NasmInst> getDataZoneInsts()
    {
        return dataZoneInsts;
    }

    public List<NasmInst> getBssZoneInsts()
    {
        return bssZoneInsts;
    }

    public List<NasmInst> getInitializeInsts()
    {
        return initializeInsts;
    }

    private void processInitialInst()
    {
        IRInstruction cur = initializeEntry;
        isInitialzeInst = true;
        while(cur != null)
        {
            visit(cur);
            cur = cur.getNext();
        }
        isInitialzeInst = false;
    }

    private void processDataSection()
    {
        for(DataSection.DataPiece piece : dataSection.getDataPieces())
        {
            addDataInst(dataInsts, NasmInst.Instruction.dq, String.valueOf(piece.getLength()), null);
            addDataInst(dataInsts, NasmInst.Instruction.NULL, piece.getName().toString(), null);
            addDataInst(dataInsts, NasmInst.Instruction.db, stringToAscii(piece.getStrValue()), null);
        }
    }

    private void processDataZone()
    {
        for(DataSection.DataPiece piece : dataZone.getDataPieces())
        {
            addDataInst(dataZoneInsts, NasmInst.Instruction.NULL, piece.getName().toString(), null);
            addDataInst(dataZoneInsts, NasmInst.Instruction.dq, piece.getOtherValue(), null);
        }
    }

    private void processBssZone()
    {
        for(DataSection.DataPiece piece: bssZone.getDataPieces())
        {
            addDataInst(bssZoneInsts, NasmInst.Instruction.NULL, piece.getName().toString(), null);
            addDataInst(bssZoneInsts, NasmInst.Instruction.resq, "1", null);
        }
    }

    private void enterNewFunction()
    {
        rspPosition = 8;
    }

    @Override
    public void visit(IRInstruction inst)
    {
        if(inst == null) return;
        inst.accept(this);
    }

    @Override
    public void visit(Alloca inst)
    {

    }

    @Override
    public void visit(Malloc inst)
    {
        String sizeValue = null;
        if(inst.getSize() instanceof Immediate)
        {
            sizeValue = String.valueOf((((Immediate) inst.getSize()).getValue() + 1) * 8);
            addInst(NasmInst.Instruction.mov, "rdi", sizeValue);
        }
        else
        {
            sizeValue = processIntegerValue(inst.getSize());
            PhysicalRegister pr = getSpareRegisters();
            addInst(NasmInst.Instruction.mov, pr.toString(), sizeValue);
            addInst(NasmInst.Instruction.add, pr.toString(), "1");
            addInst(NasmInst.Instruction.imul, pr.toString(), "8");
            addInst(NasmInst.Instruction.mov, "rdi" , pr.toString());
        }
        calleeSave();
        addInst(NasmInst.Instruction.call, "malloc", null);
        calleeRestore();
        addInst(NasmInst.Instruction.mov, processIntegerValue(inst.getReturnAddress()), "rax");
    }

    @Override
    public void visit(BinaryOperation inst)
    {
        String left = getValueByRegister(inst.getLhs());
        String right = null;
        if(inst.getRhs() != null)
            right = getValueByRegister(inst.getRhs());
        String dest = processIntegerValue(inst.getDest());
        String destReg = null;
        if(inst.getDest().isAssigned)
            destReg = dest;
        else
            destReg = getSpareRegisters().toString();
        if(inst.getOp() == BinaryOperation.BinaryOp.sal || inst.getOp() == BinaryOperation.BinaryOp.sar)
        {
            addInst(NasmInst.Instruction.mov, "rcx", right);
            right = "cl";
        }
        if(inst.getOp() == BinaryOperation.BinaryOp.mod || inst.getOp() == BinaryOperation.BinaryOp.idiv)
        {
            addInst(NasmInst.Instruction.mov, "rax", left);
            if(inst.getOp() == BinaryOperation.BinaryOp.mod)
                destReg = "rdx";
            else destReg = "rax";
            if(inst.getRhs() instanceof Immediate)
            {
                PhysicalRegister pr = getSpareRegisters();
                addInst(NasmInst.Instruction.mov, pr.toString(), right);
                right = pr.toString();
            }
            addInst(NasmInst.Instruction.mov, "rdx", "0");
            addInst(NasmInst.Instruction.idiv, right, null);
            addInst(NasmInst.Instruction.mov, dest, destReg);
//            if(inst.getDest().stackSlot != null)
//                addInst(NasmInst.Instruction.mov, inst.getDest().stackSlot.toString(), dest);
//            if(inst.getDest().isGlobal())
//                addInst(NasmInst.Instruction.mov, "qword["+inst.getDest().getName().toString()+"]", dest);
            return;
        }
        addInst(NasmInst.Instruction.mov, destReg, left);
        addInst(NasmInst.Instruction.valueOf(inst.getOp().toString()), destReg, right);
        addInst(NasmInst.Instruction.mov, dest, destReg);
//        if(inst.getDest().stackSlot != null)
//            addInst(NasmInst.Instruction.mov, inst.getDest().stackSlot.toString(), destReg);
//        if(inst.getDest().isGlobal())
//            addInst(NasmInst.Instruction.mov, "qword["+inst.getDest().getName().toString()+"]", dest);
    }

    @Override
    public void visit(Branch inst)
    {
        if(inst.getCondition() == null)
        {
            addInst(NasmInst.Instruction.jmp, inst.getTrueLabel().toString(), null);
            return;
        }
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
//        calleeSave();
        int paramNumber = inst.getParams().size();
//        saveParameter(paramNumber);
        int i = 0;
        int rspMove = 0;
        calleeSave();
        for(IntegerValue value : inst.getParams())
        {
            String parameter = processIntegerValue(value);
            if(i < ARGUMENT_NUMBER)
                addInst(NasmInst.Instruction.mov, paramRegNames[i], parameter);
            else
            {
                parameter = getValueByRegister(value);
                addInst(NasmInst.Instruction.push, parameter, null);
                rspMove += 8;
            }
            ++i;
        }
        addInst(NasmInst.Instruction.call, inst.getFunction().toString(), null);
        if(rspMove != 0)
            addInst(NasmInst.Instruction.add, "rsp", String.valueOf(rspMove));
        calleeRestore();
        if(inst.getDest() != null)
            addInst(NasmInst.Instruction.mov, processIntegerValue(inst.getDest()), "rax");
    }

    private void saveParameter(int paramNumber)
    {
        for(int i = 0; i < paramNumber; ++i)
        {
            if(i >= 6) break;
            addInst(NasmInst.Instruction.push, paramRegNames[i], null);
        }
    }
    private void restoreParameter(int paramNumber)
    {
        int t = paramNumber <= 6 ? paramNumber : 6;
        for(int i = t - 1; i >= 0; --i)
        {
            addInst(NasmInst.Instruction.pop, paramRegNames[i], null);
        }
    }

    @Override
    public void visit(Compare inst)
    {
        String left = getValueByRegister(inst.getLhs());
        String right = null;
        if(inst.getRhs() != null)
            right = getValueByRegister(inst.getRhs());
        else right = "0";
        if(inst.getLhs() instanceof Immediate)
        {
            PhysicalRegister pr = getSpareRegisters();
            addInst(NasmInst.Instruction.mov, pr.toString(), left);
            left = pr.toString();
        }
        addInst(NasmInst.Instruction.cmp, left, right);
    }

    @Override
    public void visit(Function inst)
    {
        currentFunction = inst;
        addInst(null, inst.getName().toString(), null);
        addInst(NasmInst.Instruction.push, "rbp", null);
        addInst(NasmInst.Instruction.mov, "rbp", "rsp");
        if(inst.getUsedSlotNumber() % 2 != 0)
            inst.addUsedSlotNumber(1);
        addInst(NasmInst.Instruction.sub, "rsp",
                String.valueOf(inst.getUsedSlotNumber() * 8));//should not do so much
        int paramNumber = inst.getParameter().size();
        int i = 0;
        for(Parameter item : inst.getParameter())
        {
            String p = processIntegerValue(item.getAddress());
            if(i < ARGUMENT_NUMBER)
                addInst(NasmInst.Instruction.mov, p, paramRegNames[i]);
            else
            {
                int paramPos = (paramNumber - i + 1) * 8;
                StackSlot slot1 = new StackSlot(paramPos, StackSlot.SlotType.qword);
                if(item.getAddress().isAssigned)
                    addInst(NasmInst.Instruction.mov, item.getAddress().getPhysicalRegister().toString(),
                            slot1.toString());
                else
                {
                    PhysicalRegister pr = getSpareRegisters();
                    addInst(NasmInst.Instruction.mov, pr.toString(), slot1.toString());
                    addInst(NasmInst.Instruction.mov, item.getAddress().stackSlot.toString(), pr.toString());
                }
            }
            ++i;
        }
    }

    private void calleeSave(Set<PhysicalRegister> calleeSavePhysicalRegs)
    {
        List<PhysicalRegister> physicalRegisters = new ArrayList<>(calleeSavePhysicalRegs);
        for(PhysicalRegister pr : physicalRegisters)
            addInst(NasmInst.Instruction.push, pr.toString(), null);
    }
    private void calleeRestore(Set<PhysicalRegister> calleeSavePhysicalRegs)
    {
        List<PhysicalRegister> physicalRegisters = new ArrayList<>(calleeSavePhysicalRegs);
        for(int i = calleeSavePhysicalRegs.size() - 1; i >= 0; --i)
            addInst(NasmInst.Instruction.pop,physicalRegisters.get(i).toString(), null);
    }
    private void calleeSave()
    {
        if(currentFunction != null)
            calleeSave(currentFunction.usedRegs);
    }
    private void calleeRestore()
    {
        if(currentFunction != null)
            calleeRestore(currentFunction.usedRegs);
    }


    @Override
    public void visit(Jump inst)
    {
        addInst(NasmInst.Instruction.jmp, inst.getTarget().toString(), null);
    }

    @Override
    public void visit(Label inst)
    {
        addInst(null, inst.toString(), "label!");
    }

    @Override
    public void visit(MemCopy inst)
    {
        addInst(NasmInst.Instruction.mov, processIntegerValue(inst.getToAddress()),
                getValueByRegister(inst.getFromAddress()));
    }

    @Override
    public void visit(Move inst)
    {

    }

    @Override
    public void visit(Return inst)
    {
        if(inst.getValue() != null)
            addInst(NasmInst.Instruction.mov, "rax", processIntegerValue(inst.getValue()));
        addInst(NasmInst.Instruction.add, "rsp", String.valueOf(currentFunction.getUsedSlotNumber() * 8));
        addInst(NasmInst.Instruction.pop, "rbp", null);
        addInst(NasmInst.Instruction.ret, null, null);
    }

    @Override
    public void visit(Store inst)
    {
        if(inst.getData() != null)
        {
            String right = getValueByRegister(inst.getData());
            addInst(NasmInst.Instruction.mov, processIntegerValue(inst.getAddress()), right);
        }
    }

    private void addInst(NasmInst inst)
    {
        nasmInsts.add(inst);
    }

    private void addInst(NasmInst.Instruction inst, String operand1, String operand2)
    {
        if(isInitialzeInst)
        {
            addDataInst(initializeInsts, inst, operand1, operand2);
            return;
        }
        if(inst == null)
            inst = NasmInst.Instruction.NULL;
        if(operand1 == null)
            operand1 = "NULL";
        if(operand2 == null)
            operand2 = "NULL";
        nasmInsts.add(new NasmInst(inst, operand1, operand2));
    }

    private void addDataInst(List<NasmInst> insts, NasmInst.Instruction inst, String operand1, String operand2)
    {
        if(inst == null)
            inst = NasmInst.Instruction.NULL;
        if(operand1 == null)
            operand1 = "NULL";
        if(operand2 == null)
            operand2 = "NULL";
        insts.add(new NasmInst(inst, operand1, operand2));
    }

    private String processIntegerValue(IntegerValue value)
    {
        if(value instanceof Immediate)
            return String.valueOf(((Immediate) value).getValue());
        if(value instanceof Address && ((Address) value).getBase() != null)
            return processMemoryAddress((Address) value);
        if(value instanceof Address && ((Address) value).isStringConst())
            return ((Address) value).getName().toString();
        Register register = (Register)value;
        if(((Address)register).isGlobal())
            return "qword[" + register.getName().toString() + "]";
        if(register.isAssigned)
            return register.getPhysicalRegister().toString();
        if(register.stackSlot != null)
            return register.stackSlot.toString();
        StackSlot slot = mapAddressToSlot((Address) register);
        register.stackSlot = slot;
        return slot.toString();
    }

    private PhysicalRegister getSpareRegisters()
    {
        for(int i = 0; i < sparePhysicalRegs.size(); ++i)
        {
            if(!sparePhysicalRegs.get(i).isUsed)
            {
                sparePhysicalRegs.get(i).isUsed = true;
                return sparePhysicalRegs.get(i);
            }
        }
        for(int i = 1; i < sparePhysicalRegs.size(); ++i)
            sparePhysicalRegs.get(i).isUsed = false;
        return sparePhysicalRegs.get(0);
    }

    private void initPhysicalRegs()
    {
        for(String name : paramRegNames)
            paramPhysicalRegs.add(new PhysicalRegister(Name.getName(name)));
        for(String name : spareRegNames)
            sparePhysicalRegs.add(new PhysicalRegister(Name.getName(name)));
    }

    private String getValueByRegister(IntegerValue value)
    {
        if(value instanceof Immediate)
            return String.valueOf(((Immediate) value).getValue());
        if(value instanceof Address && ((Address) value).getBase() != null)
        {
            String left = processMemoryAddress((Address) value);
            PhysicalRegister pr1 = getSpareRegisters();
            addInst(NasmInst.Instruction.mov, pr1.toString(), left);
            return pr1.toString();
        }
        Register register = (Register)value;
        if(register instanceof Address && ((Address) register).isStringConst())
        {
            PhysicalRegister pr = getSpareRegisters();
            addInst(NasmInst.Instruction.mov, pr.toString(), register.getName().toString());
            return pr.toString();
        }
        if(((Address)register).isGlobal())
        {
            PhysicalRegister pr = getSpareRegisters();
            addInst(NasmInst.Instruction.mov, pr.toString(),
                    "qword[" + register.getName().toString()+ "]");
            return pr.toString();
        }
        if(register.isAssigned)
            return register.getPhysicalRegister().toString();
        if(register.stackSlot != null)
        {
            PhysicalRegister pr = getSpareRegisters();
            addInst(NasmInst.Instruction.mov, pr.toString(), register.stackSlot.toString());
            return pr.toString();
        }
        StackSlot slot = mapAddressToSlot((Address) register);
        PhysicalRegister pr = getSpareRegisters();
        register.stackSlot = slot;
        addInst(NasmInst.Instruction.mov, pr.toString(), slot.toString());
        return pr.toString();
    }
    private String processMemoryAddress(Address address)
    {
        String base = getValueByRegister(address.getBase());
        if(address.getOffset() instanceof Immediate)
            return "qword [" + base.toString() + " + " +
                    String.valueOf(((Immediate) address.getOffset()).getValue() * 8 + 8) + "]";
        else
        {
            String offset = getValueByRegister(address.getOffset());
            PhysicalRegister pr = getSpareRegisters();
            addInst(NasmInst.Instruction.mov, pr.toString(), offset);
            addInst(NasmInst.Instruction.add, pr.toString(), "1");
            return "qword [" + base + " + " + pr.toString() +" * 8]";
        }
    }

    private StackSlot mapAddressToSlot(Address address)
    {
        StackSlot.SlotType type = StackSlot.SlotType.qword;
        StackSlot slot = new StackSlot(rspPosition, rspPosition + 8, type);
        addressStackSlotMap.put(address, slot);
        rspPosition += 8;
        return slot;
    }

    private String stringToAscii(String value)
    {
        StringBuffer sbu = new StringBuffer();
        if(value.equals("\\n"))
            return String.valueOf(10);
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
            if(i != nasmInsts.size() - 1 && noUseJump(nasmInsts.get(i), nasmInsts.get(i + 1)))
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

    private boolean noUseJump(NasmInst nasmInst1, NasmInst nasmInst2)
    {
        if(nasmInst1.getInst() == NasmInst.Instruction.jmp &&
                nasmInst2.getInst() == null && nasmInst2.getOperand2().equals("label!") &&
                nasmInst1.getOperand1().equals(nasmInst2.getOperand1()))
            return true;
        return false;
    }

}
