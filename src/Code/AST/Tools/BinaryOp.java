package Code.AST.Tools;

public enum BinaryOp
{
    ADD, MIN, MUL, DIV, MOD, L_SHIFT, R_SHIFT, BIT_AND, BIT_OR, BIT_XOR,
    SLT, SGT, SEQ, BEQ, EQU, NEQ;

    public String toString(BinaryOp op)
    {
        return op.name();
    }
    public static boolean isArith(BinaryOp op)
    {
        return (op != EQU && op != NEQ);
    }
    public static boolean isCompare(BinaryOp op)
    {
        return (op == SLT || op == SGT || op ==SEQ || op == BEQ || op == EQU || op == NEQ);
    }

}
