package Code.ASTTraversal.Scope;

import Code.AST.Node.DeclNode.ClassDecNode;
import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Node.StatNode.StatNode;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;

import java.util.*;

public class Scope
{
    private Map<String, DeclNode> scopeNodes = new HashMap<>();
    private Map<String, Type> scopeTypes = new HashMap<>();
    private List<Scope> children = new ArrayList<>();
    private Scope parent;
    private boolean isTop;

    private boolean isFunction;
    private boolean isLoop;

    public Scope(boolean top)
    {
        this.isTop = top;
        isFunction = false;
        isLoop = false;
    }
    public Scope(Scope p)
    {
        this.isTop = false;
        this.parent = p;
        isFunction = false;
        isLoop = false;
    }
    public void addNode(DeclNode node) throws RuntimeException
    {
        if(scopeNodes.containsKey(node.getName()))
        {
            throw new RuntimeException(node.getName() + " have been declared at " + scopeNodes.get(node.getName()).getPosition());
        }
        scopeNodes.put(node.getName(), node);
    }
    public DeclNode findNode(String name) throws RuntimeException
    {
        if(scopeNodes.containsKey(name))
            return scopeNodes.get(name);
        else if(this.isTop)
            throw new RuntimeException(name + " have not been declared");
        else return this.parent.findNode(name);
    }
    private boolean containsNode(String name)
    {
        return scopeNodes.containsKey(name);
    }
    public void addType(ClassDecNode node) throws RuntimeException
    {
        if(scopeTypes.containsKey(node.getName()))
        {
            throw new RuntimeException(node.getName() + " have been declared at "
                    + scopeTypes.get(node.getName()).getClassNode().getPosition());
        }
        scopeTypes.put(node.getName(), new ClassType(node));
    }
    public void addType(Type type) throws RuntimeException
    {
        if(scopeTypes.containsKey(type.getTypeName()))
        {
            throw new RuntimeException(type.getTypeName() + " have been declared at "
                    + scopeTypes.get(type.getTypeName()).getClassNode().getPosition());
        }
        scopeTypes.put(type.getTypeName(), type);
    }
    public Type findType(String name) throws RuntimeException
    {
        if(scopeTypes.containsKey(name))
            return scopeTypes.get(name);
        else if(this.isTop)
            throw new RuntimeException(name + " have not been declared");
        else return this.parent.findType(name);
    }
    private boolean containsType(String name)
    {
        return scopeTypes.containsKey(name);
    }
    public Scope getParent()
    {
        if(this.isTop)
            return this;
        else return this.parent;
    }

    public void setFunction(boolean function)
    {
        isFunction = function;
    }

    public void setLoop(boolean loop)
    {
        isLoop = loop;
    }

    public boolean isFunction()
    {
        return isFunction;
    }

    public boolean isLoop()
    {
        return isLoop;
    }
}