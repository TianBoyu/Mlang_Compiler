package Code.AST.Tools;


public class LoopBody
{
    public LoopBody(Position b, Position e)
    {
        begin = b;
        end = e;
    }

    public final Position getBegin() {
        return begin;
    }

    public final Position getEnd() {
        return end;
    }

    private Position begin;
    private Position end;
}
