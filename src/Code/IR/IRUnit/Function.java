package Code.IR.IRUnit;

import Code.AST.Tools.Name;
import Code.IR.BasicBlock;
import Code.IR.Type.*;

import java.util.prefs.BackingStoreException;

public class Function extends IRInstruction
{
    private Name name;
    private IRType ret_type;
//    private Label internal_label;
    private BasicBlock block;

    public Function(Label label, Name name, IRType ret_type, Label internal_label, BasicBlock block)
    {
        super(label);
        this.name = name;
        this.ret_type = ret_type;
        this.block = block;
//        this.internal_label = label;
    }

    @Override
    public String toString()
    {
        return null;
    }
}
