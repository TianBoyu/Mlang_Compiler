package Code.SemanticCheck;

import Code.AST.Tools.Position;

import java.util.ArrayList;
import java.util.List;

public class ErrorHandler
{
//    private List<Pair<Position, String>> errors = new ArrayList<>();
    public void addError(Position pos, String reason)
    {
//        errors.add(new Pair<>(pos, reason));
        throw new RuntimeException("Line " + pos.getLineNum() + ": " + reason);
    }
}
