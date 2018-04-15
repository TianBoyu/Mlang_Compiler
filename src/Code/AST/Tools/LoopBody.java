package Code.AST.Tools;


public class LoopBody
{
    public LoopBody(Position b, Position e)
    {
        begin = b;
        end = e;
    }
    public LoopBody()
    {

    }

    public final Position getBegin() {
        return begin;
    }
    public final Position getEnd() {
        return end;
    }

    public void setBegin(Position begin) {
        this.begin = begin;
    }

    public void setEnd(Position end) {
        this.end = end;
    }

    private Position begin;
    private Position end;
}
