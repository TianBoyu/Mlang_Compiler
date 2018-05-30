package Code.IR;

import Code.AST.Tools.Name;
import Code.IR.IRUnit.Oprands.Address;
import Code.IR.IRUnit.Oprands.VirtualRegister;

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

    public Address findAddress(Name name)
    {
        if(addressMap.containsKey(name))
            return addressMap.get(name);
        else
            return this.Parent.findAddress(name);
    }

    public boolean containsAddress(Name name)
    {
        if(addressMap.containsKey(name))
            return true;
        else
            return this.Parent.containsAddress(name);
    }
    public void addAddress(Name name, Address address)
    {
        addressMap.put(name, address);
    }



    public IRScope getParent()
    {
        return Parent;
    }
}
