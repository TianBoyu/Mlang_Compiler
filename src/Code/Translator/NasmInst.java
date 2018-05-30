package Code.Translator;

import java.util.List;

public class NasmInst
{
    public enum Instruction
    {
        mov, push, pop, call, ret, db, dq,
        resq, resb,

        add, sub, imul, xor, or, and, inc, dec,
        neg, not, shl, shr, idiv,

        jz, jnz, jmp, je, jne, jg, jge, jl, jle,

        cmp, cmove, cmovne, cmovl, cmovg, cmovge, cmovle,

        NULL
    }
    private Instruction inst;
    private String operand1;
    private String operand2;

    public NasmInst(Instruction inst, String operand1, String operand2)
    {
        this.inst = inst;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    public Instruction getInst()
    {
        return inst;
    }

    public String getOperand1()
    {
        return operand1;
    }

    public String getOperand2()
    {
        return operand2;
    }

    public String toString()
    {
        String ret = "";
        if(inst != Instruction.NULL)
            ret += inst.toString() + "  ";
        if(!operand1.equals("NULL"))
            ret += operand1;
        if(!operand2.equals("NULL"))
            ret += ",  " + operand2;
        return ret;
    }
}
