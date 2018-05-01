package Code.IR.IRUnit;

import Code.AST.Tools.Name;
import Code.AST.Type.Type;

public class Function extends IRInstruction
{
    private Name name;
    private Type ret_type;
    private Block block;
    private Label label;

    public Function(Label label, Name name, Type ret_type, Block block, Label label1)
    {
        super(label);
        this.name = name;
        this.ret_type = ret_type;
        this.block = block;
        this.label = label1;
    }
}
