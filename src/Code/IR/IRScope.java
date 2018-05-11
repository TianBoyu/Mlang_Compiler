package Code.IR;

import Code.AST.Tools.Name;
import Code.IR.IRUnit.Value.Address;
import Code.IR.IRUnit.Value.VirtualRegister;

import java.util.HashMap;
import java.util.Map;

public class IRScope
{
    private Map<Name, VirtualRegister> registerMap = new HashMap<>();
    private Map<Name, Address> addressMap = new HashMap<>();
    private boolean isTop;
    private IRScope Parent;

    public IRScope(boolean isTop)
    {
        this.isTop = isTop;
    }

    public IRScope(IRScope parent)
    {
        this.isTop = false;
        Parent = parent;
    }

    public void addRegister(Name name, VirtualRegister virtualRegister)
    {
        //TODO
        registerMap.put(name, virtualRegister);
    }
    public VirtualRegister getRegister(Name name)
    {
        if(registerMap.containsKey(name))
            return registerMap.get(name);
        else return Parent.getRegister(name);
    }
    public boolean containsName(Name name)
    {
        if(registerMap.containsKey(name))
            return true;
        else if(this.isTop)
            return false;
        else return Parent.containsName(name);
    }

    public IRScope getParent()
    {
        return Parent;
    }
}
