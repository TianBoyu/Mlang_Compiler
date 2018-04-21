package Code.AST.Tools;

public enum UnaryOp {
    POS, NEG, INCRE, DECRE, NOT, BIT_NOT, SUF_INCRE, SUF_DECRE;
    public String toString(UnaryOp op)
    {
        return op.name();
    }
    public static boolean changeValue(UnaryOp op)
    {
        return (op == INCRE || op == DECRE || op == SUF_DECRE || op == SUF_INCRE);
    }
    public static boolean isSuffix(UnaryOp op)
    {
        return (op == SUF_INCRE || op == SUF_DECRE);
    }

}
