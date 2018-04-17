package Code.AST.Tools;

public enum UnaryOp {
    POS, NEG, INCRE, DECRE, NOT, BIT_NOT, SUF_INCRE, SUF_DECRE;
    public String toString(UnaryOp op)
    {
        return op.name();
    }
}
