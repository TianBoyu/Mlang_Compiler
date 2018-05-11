package Code.SemanticCheck.Scope;

import Code.AST.Node.DeclNode.*;
import Code.AST.Object.FuncDecObject;
import Code.AST.Object.ParameterObject;
import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.AST.Type.BuiltInType;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.IR.IRScope;
import Code.IR.Type.IRType;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Scope
{
    private Map<Name, DeclNode> scopeNodes = new HashMap<>();
    private Map<Name, Type> scopeTypes = new HashMap<>();
    private List<Scope> children = new ArrayList<>();
    private Scope parent;
    private boolean isTop;

    private boolean isFunction;
    private boolean isLoop;
    private boolean isClass;

    private IRScope irScope;

    public Scope(boolean top)
    {
        this.isTop = top;
        isFunction = false;
        isLoop = false;
        this.parent = this;
        isClass = false;

        irScope = new IRScope(top);
    }
    public Scope(Scope p)
    {
        this.isTop = false;
        this.parent = p;
        isFunction = false;
        isLoop = false;
        isClass = false;

        this.irScope = new IRScope(p.getIRScope());
    }
    public void addNode(DeclNode node) throws RuntimeException
    {
        if(scopeNodes.containsKey(node.getName()))
        {
            throw new RuntimeException(node.getName().toString() + " have been declared at Line " + scopeNodes.get(node.getName()).getPosition().getLineNum());
        }
        if(!node.isFunction() && ((VarDecNode)node).getType().getTypeName() == Name.getName("void"))
        {
            throw new RuntimeException("void can only be return type of a function");
        }
        scopeNodes.put(node.getName(), node);
    }
    public DeclNode findNode(Name name) throws RuntimeException
    {
        if(scopeNodes.containsKey(name))
            return scopeNodes.get(name);
        else if(this.isTop)
            throw new RuntimeException(name + " have not been declared");
        else return this.parent.findNode(name);
    }
    public boolean containsNode(Name name)
    {
        if(scopeNodes.containsKey(name))
            return true;
        else if(this.isTop)
            return false;
        else return this.parent.containsNode(name);
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
    public Type findType(Name name) throws RuntimeException
    {
        if(scopeTypes.containsKey(name))
            return scopeTypes.get(name);
        else if(this.isTop)
            throw new RuntimeException(name + " have not been declared");
        else return this.parent.findType(name);
    }
    public boolean containsType(Name name)
    {
        if(scopeTypes.containsKey(name))
            return true;
        else if(this.isTop)
            return false;
        else return this.parent.containsType(name);
    }
    public Scope getParent()
    {
        if(this.isTop)
            return this;
        else return this.parent;
    }

    public IRScope getIRScope()
    {
        return irScope;
    }

    public void setFunction(boolean function)
    {
        isFunction = function;
    }

    public void setLoop(boolean loop)
    {
        isLoop = loop;
    }

    public void setClass(boolean c)
    {
        isClass = c;
    }

    public boolean isFunction()
    {
        return isFunction;
    }

    public boolean isLoop()
    {
        return isLoop;
    }

    public boolean isTop()
    {
        return isTop;
    }

    public boolean isClass()
    {
        return isClass;
    }

    public void InitializeBuiltInType()
    {
        addType(new BuiltInType("int", 4));
        addType(new BuiltInType("bool", 1));
        addType(new BuiltInType("string", 1));
        addType(new BuiltInType("void", 0));
    }
    public void InitializeBuiltInFunction()
    {
        addNode(new FuncDecNode(new Position(0),
                                new FuncDecObject("getInt", new ArrayList<>(), new BuiltInType("int", 4)),
                                null));
        List<FuncParamNode> paras = new ArrayList<>();
        paras.add(new FuncParamNode(new Position(0), new ParameterObject("a", new Type("string", 0))));
        addNode(new FuncDecNode(new Position(0),
                                new FuncDecObject("print", paras, new BuiltInType("void", 0)),
                                null));
        addNode(new FuncDecNode(new Position(0),
                                new FuncDecObject("println", paras, new BuiltInType("void", 0)),
                                null));
        addNode(new FuncDecNode(new Position(0),
                                new FuncDecObject("getString", new ArrayList<>(), new BuiltInType("string", 0)),
                                null));
        paras.clear();
        paras.add(new FuncParamNode(new Position(0), new ParameterObject("a", new Type("int", 4))));
        addNode(new FuncDecNode(new Position(0),
                                new FuncDecObject("toString", paras, new BuiltInType("string", 4)),
                                null));
        addNode(new FuncDecNode(new Position(0),
                                new FuncDecObject("size", new ArrayList<>(), new BuiltInType("int", 4)),
                                null));
        addNode(new FuncDecNode(new Position(0),
                new FuncDecObject("length", new ArrayList<>(), new BuiltInType("int", 4)),
                null));
        paras.clear();
        paras.add(new FuncParamNode(new Position(0), new ParameterObject("left", new Type("int", 4))));
        paras.add(new FuncParamNode(new Position(0), new ParameterObject("right", new Type("int", 4))));
        addNode(new FuncDecNode(new Position(0),
                new FuncDecObject("substring", paras, new BuiltInType("string", 4)),
                null));
        addNode(new FuncDecNode(new Position(0),
                new FuncDecObject("parseInt", new ArrayList<>(), new BuiltInType("int", 4)),
                null));
        paras.clear();
        paras.add(new FuncParamNode(new Position(0), new ParameterObject("pos", new Type("int", 4))));
        addNode(new FuncDecNode(new Position(0),
                new FuncDecObject("ord", paras, new BuiltInType("int", 4)),
                null));
    }

    public void Initialize()
    {
        InitializeBuiltInType();
        InitializeBuiltInFunction();
    }
}
