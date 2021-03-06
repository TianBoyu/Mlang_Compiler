package Code.SemanticCheck;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Name;
import Code.AST.Tools.Position;
import Code.AST.Tools.UnaryOp;
import Code.AST.Type.ArrayType;
import Code.AST.Type.BuiltInType;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.SemanticCheck.Scope.Scope;

import java.util.List;
import java.util.Stack;

//TODO Constructors
public class SemanticChecker implements ASTTraversal
{
    private Scope currentScope;
    private Stack<Scope> scopeStack = new Stack<>();
    private ErrorHandler errorHandler;
    private FuncDecNode currentFunction;
    private ClassDecNode currentClass;
    private boolean isMember;

    public SemanticChecker(Scope topScope, ErrorHandler handler)
    {
        errorHandler = handler;
    }
    public void process(ProgNode progNode)
    {
        visit(progNode);
    }
    @Override
    public void visit(ProgNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getScope());
        if(!currentScope.containsNode(Name.getName("main")) ||
                !currentScope.findNode(Name.getName("main")).isFunction())
            errorHandler.addError(new Position(0), "no main function");
        if(((FuncDecNode)currentScope.findNode(Name.getName("main"))).getReturnType().getTypeName() != Name.getName("int"))
            errorHandler.addError(node.getPosition(),
                    "the function 'main' should return an integer");
        for(DeclNode item : node.getDeclares())
            visit(item);
        node.setScope(currentScope);
    }

    @Override
    public void visit(DeclNode node)
    {
        if(node == null) return;
        node.accept(this);
    }

    @Override
    public void visit(ClassDecNode node)
    {
        if(node == null) return;
        currentClass = node;
        setCurrentScope(node.getInternalScope());
        for(VarDecNode item : node.getMemberVarible())
            visit(item);
        for(FuncDecNode item : node.getMemberFunction())
            visit(item);
        node.setInternalScope(currentScope);
        exitCurrentScope();
        currentClass = null;
    }

    @Override
    public void visit(FuncDecNode node)
    {
        if(node == null) return;
        currentFunction = node;
        setCurrentScope(node.getInternalScope());
        node.setClassDecNode(currentClass);
        if(node.isConstructor() && (node.getName() != currentClass.getName()))
            errorHandler.addError(node.getPosition(), "name of the constructor should be the name of the class");
        for(FuncParamNode item : node.getParameter())
            visit(item);
        visit(node.getBlock());
        node.setInternalScope(currentScope);
        exitCurrentScope();
        currentFunction = null;
    }

    @Override
    public void visit(VarDecNode node)
    {
        if(node == null) return;
        node.setScope(currentScope);
        visit(node.getValue());
        if(!(currentScope.isClass()))
        {
            if (node == null) return;
            try
            {
                visit(node.getType());
            } catch (Exception e)
            {
                errorHandler.addError(node.getPosition(), e.getMessage());
            }
            currentScope.addNode(node);
        }
        if(node.getType() instanceof ClassType)
            node.setType(currentScope.findType(node.getType().getTypeName()));
        if(node.getValue() == null) return;
        if(node.getValue().getExprType().getTypeName() != Name.getName("null"))
        {
            if(node.getType() instanceof ArrayType)
            {
                if(!(node.getValue().getExprType() instanceof ArrayType))
                    errorHandler.addError(node.getPosition(), "type mismatch");
                else if(node.getValue().getExprType().getTypeName() != node.getType().getTypeName())
                    errorHandler.addError(node.getPosition(), "type mismatch");
                else if(((ArrayType) node.getType()).getDimension() != ((ArrayType) node.getValue().getExprType()).getDimension())
                    errorHandler.addError(node.getPosition(), "type mismatch");
            }
            else if (node.getType().getTypeName() != node.getValue().getExprType().getTypeName())
                errorHandler.addError(node.getPosition(), "cannot cast from "
                        + node.getType().getTypeName().toString() + " to "
                        + node.getValue().getExprType().getTypeName().toString());
        }
        else
        {
            if(node.getType() instanceof BuiltInType)
                errorHandler.addError(node.getPosition(), "null cannot be assigned to built in type");
        }
    }

    @Override
    public void visit(FuncParamNode node)
    {

    }

    @Override
    public void visit(ExprNode node)
    {
        if(node == null) return;
        node.accept(this);
    }

    @Override
    public void visit(AndExprNode node)
    {
        if(node == null) return;
        visit(node.getCond1());
        visit(node.getCond2());
        if(node.getCond1().getExprType().getTypeName() != Name.getName("bool")
                || node.getCond2().getExprType().getTypeName() != Name.getName("bool"))
            errorHandler.addError(node.getPosition(), "condition must be of bool type");
        node.setExprType(node.getCond1().getExprType());
    }

    @Override
    public void visit(ArrayExprNode node)
    {
        visit(node.getArray());
        visit(node.getIndex());
        if(!(node.getIndex().getExprType() instanceof BuiltInType) || node.getIndex().getExprType().getTypeName() != Name.getName("int"))
            errorHandler.addError(node.getPosition(), "array index must be an integer");
        if(!(node.getArray().getExprType() instanceof ArrayType))
            errorHandler.addError(node.getPosition(),
                    "'[]' can not be applied to non-array element");
//        node.setType(currentScope.findType(node.getType().getTypeName()));
//        if(node.getArray().getExprType() instanceof ArrayType)
        if(((ArrayType)node.getArray().getExprType()).getDimension() > 1)
            node.setExprType(((ArrayType)node.getArray().getExprType()).getBasic_type());
        else
            node.setExprType(currentScope.findType(((ArrayType)node.getArray().getExprType()).getBasic_type().getTypeName()));
        //TODO set Expr type
    }

    @Override
    public void visit(AssignExprNode node)
    {
        if(node == null) return;
        if(!node.getLhs().isLvalue())
            errorHandler.addError(node.getPosition(),
                    "assign operator can only be applied to a left value");
        visit(node.getLhs());
        visit(node.getRhs());
        if(node.getRhs().getExprType().getTypeName() != Name.getName("null"))
        {
            if(node.getLhs().getExprType() instanceof ArrayType)
            {
                if(!(node.getRhs().getExprType() instanceof ArrayType))
                    errorHandler.addError(node.getPosition(), "type mismatch");
                else if(node.getRhs().getExprType().getTypeName() != node.getLhs().getExprType().getTypeName())
                    errorHandler.addError(node.getPosition(), "type mismatch");
                else if(((ArrayType) node.getLhs().getExprType()).getDimension() != ((ArrayType) node.getRhs().getExprType()).getDimension())
                    errorHandler.addError(node.getPosition(), "type mismatch");
            }
            else if(node.getRhs().getExprType() instanceof ArrayType)
            {
                if(!(node.getLhs().getExprType() instanceof ArrayType))
                    errorHandler.addError(node.getPosition(), "type mismatch");
            }
            else if (node.getLhs().getExprType().getTypeName() != node.getRhs().getExprType().getTypeName())
                errorHandler.addError(node.getPosition(), "cannot cast from "
                        + node.getLhs().getExprType().getTypeName().toString() + " to "
                        + node.getRhs().getExprType().getTypeName().toString());
        }
        else
        {
            if(node.getLhs().getExprType() instanceof BuiltInType)
                errorHandler.addError(node.getPosition(), "null cannot be assigned to built in type");
        }
    }

    @Override
    public void visit(BinaryExprNode node)
    {
        if(node == null) return;
        visit(node.getLhs());
        visit(node.getRhs());
        if(node.getLhs().getExprType().getTypeName() != node.getRhs().getExprType().getTypeName())
        {
            if(!((node.getOp() == BinaryOp.EQU || node.getOp() == BinaryOp.NEQ)&&
                    (node.getLhs().getExprType().getTypeName() == Name.getName("null")
                    || node.getRhs().getExprType().getTypeName() == Name.getName("null"))))
                errorHandler.addError(node.getPosition(), "cannot operate with type "
                        + node.getLhs().getExprType().getTypeName().toString() + " and type "
                        + node.getRhs().getExprType().getTypeName().toString());
        }
        if(BinaryOp.isArith(node.getOp()) && node.getLhs().getExprType().getTypeName() != Name.getName("int"))
        {
            if(!((node.getOp() == BinaryOp.ADD || BinaryOp.isCompare(node.getOp()))
                    && node.getLhs().getExprType().getTypeName() == Name.getName("string")))
            {
                errorHandler.addError(node.getPosition(),
                        "type " + node.getLhs().getExprType().getTypeName().toString() + " cannot operate");
            }
        }
        if(BinaryOp.isCompare(node.getOp()))
            node.setExprType(new Type("bool", 1));
        else
            node.setExprType(node.getLhs().getExprType());
    }

    @Override
    public void visit(BoolConstNode node)
    {

    }

    @Override
    public void visit(CallExprNode node)
    {
        if(node == null)return;
        if(!currentScope.containsNode(node.getFuncName()))
            errorHandler.addError(node.getPosition(),
                    "function " + node.getFuncName().toString() + " have not been declared");
        FuncDecNode function = (FuncDecNode)currentScope.findNode(node.getFuncName());
        if(!function.isFunction())
            errorHandler.addError(node.getPosition(),
                    node.getFuncName().toString() + " is not a function");
        visit(node.getParam());
        node.setExprType(function.getReturnType());
        node.setFunction(function);
        checkParameterMatch(function, node);
    }
    private void checkParameterMatch(FuncDecNode decl, CallExprNode call)
    {
        if(decl.getParameter().size() != call.getParam().getExprs().size())
            errorHandler.addError(call.getPosition(),
                    "wrong number of parameters");
        List<FuncParamNode> formal_params = decl.getParameter();
        List<ExprNode> actual_params = call.getParam().getExprs();
        for(int i = 1; i < decl.getParameter().size(); ++i)
        {
            if(!Type.equal(formal_params.get(i).getType(), actual_params.get(i).getExprType()))
                errorHandler.addError(call.getPosition(),
                        "required type " + formal_params.get(i).getType().getTypeName()
                                + " finding " + actual_params.get(i).getExprType().getTypeName());
        }
    }

    private void visitMemberCall(CallExprNode node, Scope scope)
    {
        if(node == null)return;
        if(!scope.containsNode(node.getFuncName()))
            errorHandler.addError(node.getPosition(),
                    "function " + node.getFuncName().toString() + " have not been declared");
        FuncDecNode function = (FuncDecNode)scope.findNode(node.getFuncName());
        if(!function.isFunction())
            errorHandler.addError(node.getPosition(),
                    node.getFuncName().toString() + " is not a function");
        visit(node.getParam());
        node.setExprType(function.getReturnType());
        node.setFunction(function);
        checkParameterMatch(function, node);
    }

    @Override
    public void visit(ExprListNode node)
    {
        if(node == null)return;
        for(ExprNode item : node.getExprs())
            visit(item);
    }

    @Override
    public void visit(IdExprNode node)
    {
        if(node == null) return;
        if(!currentScope.containsNode(node.getName()))
            errorHandler.addError(node.getPosition(),
                    node.getName().toString() + " have not been declared");
        VarDecNode var = (VarDecNode)currentScope.findNode(node.getName());
        node.setExprType(var.getType());
    }

    @Override
    public void visit(IntConstNode node)
    {

    }

    @Override
    public void visit(MemberExprNode node)
    {
        if(node == null) return;
        visit(node.getExpr());
        if(!(node.getExpr().getExprType() instanceof ClassType))
        {
            if(node.getExpr().getExprType() instanceof ArrayType
                    && node.isFunctionCall()
                    && node.getFunctionCall().getFuncName() == Name.getName("size"))
            {
                visit(node.getFunctionCall());
                node.setExprType(new BuiltInType("int", 4));
            }
            else if (node.getExpr().getExprType().getTypeName() == Name.getName("string")
                && node.isFunctionCall()
                && isStringBuiltIn(node.getFunctionCall().getFuncName()))
            {
                visit(node.getFunctionCall());
                FuncDecNode func = (FuncDecNode)currentScope.findNode(node.getName());
                node.setExprType(func.getReturnType());
            }
            else
            {
                errorHandler.addError(node.getPosition(), "wrong usage of '.'");
            }
            return;
        }
        Scope scope = currentScope.findType(node.getExpr().getExprType().getTypeName()).getClassNode().getInternalScope();
        if(!scope.containsNode(node.getName()))
        {
            errorHandler.addError(node.getPosition(), node.getName().toString() + " have not been declared");
        }
        if(node.isFunctionCall())
        {
            FuncDecNode func = (FuncDecNode)scope.findNode(node.getName());
            node.setExprType(func.getReturnType());
            visit(node.getFunctionCall().getParam());
            checkParameterMatch(func, node.getFunctionCall());
            visitMemberCall(node.getFunctionCall(),
                    node.getExpr().getExprType().getClassNode().getInternalScope());
            node.getFunctionCall().setFunction(func);
        }
        else
        {
            node.setExprType(((VarDecNode)scope.findNode(node.getName())).getType());
        }


    }

    @Override
    public void visit(NewExprNode node)
    {
        if(node == null) return;
        visit(node.getCreatorNode());
        node.setExprType(node.getCreatorNode().getExprType());
    }

    @Override
    public void visit(CreatorNode node)
    {
        if(node == null) return;
        for(ExprNode item : node.getExprNodes())
            visit(item);
        if(!currentScope.containsType(node.getType().getTypeName()))
        {
            errorHandler.addError(node.getPosition(),
                    node.getType().getTypeName().toString() + " is not declared");
        }
        if(node.getDimension() == 0)
        {
            node.setExprType(currentScope.findType(node.getType().getTypeName()));
        }
        else
        {
            node.setExprType(new ArrayType(node.getType(), node.getDimension()));
        }
    }

    @Override
    public void visit(NullConstNode node)
    {

    }

    @Override
    public void visit(OrExprNode node)
    {
        if(node == null) return;
        visit(node.getCond1());
        visit(node.getCond2());
        if(node.getCond1().getExprType().getTypeName() != Name.getName("bool")
                || node.getCond2().getExprType().getTypeName() != Name.getName("bool"))
            errorHandler.addError(node.getPosition(), "condition must be of bool type");
        node.setExprType(node.getCond1().getExprType());
    }

    @Override
    public void visit(PrefixExprNode node)
    {
        if(node == null)return;
        if(UnaryOp.changeValue(node.getOp()) && !node.getExprNode().isLvalue())
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + " can only be applied to a left value");
        visit(node.getExprNode());
        if(node.getOp() != UnaryOp.NOT && node.getExprNode().getExprType().getTypeName() != Name.getName("int"))
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + "can only be applied to integer");
        node.setExprType(node.getExprNode().getExprType());
    }

    @Override
    public void visit(StringConstNode node)
    {

    }

    @Override
    public void visit(SuffixExprNode node)
    {
        if(node == null)return;
        visit(node.getExprNode());
        if(!UnaryOp.isSuffix(node.getOp()))
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + "is a prefix operator");
        if(UnaryOp.changeValue(node.getOp()) && !node.getExprNode().isLvalue())
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + " can only be applied to a left value");
        visit(node.getExprNode());
        if(!(node.getExprNode().getExprType().getTypeName() == Name.getName("int")))
            errorHandler.addError(node.getPosition(),
                    node.getOp().toString() + "can only be applied to integer");
        node.setExprType(node.getExprNode().getExprType());
    }

    @Override
    public void visit(ThisExprNode node)
    {
        if(currentClass == null)
            errorHandler.addError(node.getPosition(), "'this' should be in a class");
        node.setExprType(currentClass.getType());
    }

    @Override
    public void visit(StatNode node)
    {
        if(node == null) return;
        node.accept(this);
    }

    @Override
    public void visit(BlockNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getScope());
        for(StatNode item : node.getStatements())
            visit(item);
        exitCurrentScope();
    }

    @Override
    public void visit(BreakNode node)
    {
        if(!currentScope.isLoop())
//            throw new RuntimeException("'break' must be in a loop");
            errorHandler.addError(node.getPosition(), "'break' must be in a loop");

    }

    @Override
    public void visit(ContinueNode node)
    {
        if(!currentScope.isLoop())
//            throw new RuntimeException("'break' must be in a loop");
            errorHandler.addError(node.getPosition(), "'continue' must be in a loop");
    }

    @Override
    public void visit(ForNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        visit(node.getBeginCondition());
        visit(node.getEndCondition());
        if(node.getEndCondition() != null)
        {
            if (node.getEndCondition().getExprType().getTypeName() != Name.getName("bool"))
                errorHandler.addError(node.getPosition(),
                        "end condition should be of bool type");
        }
        visit(node.getUpdate());
        visit(node.getBlock());
        node.setInternalScope(currentScope);
        exitCurrentScope();
    }

    @Override
    public void visit(IfNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        visit(node.getCondition());
        if(node.getCondition().getExprType().getTypeName() != Name.getName("bool"))
            errorHandler.addError(node.getPosition(),
                    "conditions in if statement must be of bool type");
        visit(node.getThen());
        if(node.getElseThen() != null)
            visit(node.getElseThen());
        node.setInternalScope(currentScope);
        exitCurrentScope();
    }

    @Override
    public void visit(ReturnNode node)
    {
        if(node == null) return;
        if(!currentScope.isFunction())
            errorHandler.addError(node.getPosition(), "'return' must be in a function");
        if(node.getExprNode() == null) return;
        if(currentFunction.isConstructor() && node.getExprNode() != null)
        {
            errorHandler.addError(node.getPosition(), "cannot return any value in constructors");
        }
        visit(node.getExprNode());
        if(!Type.equal(currentFunction.getReturnType(), node.getExprNode().getExprType()))
            errorHandler.addError(node.getPosition(),
                    "function " + currentFunction.getName().toString() + " should not return a "
                    +node.getExprNode().getExprType().getTypeName().toString());
    }

    @Override
    public void visit(WhileNode node)
    {
        if(node == null) return;
        setCurrentScope(node.getInternalScope());
        visit(node.getCondition());
        if(node.getCondition().getExprType().getTypeName() != Name.getName("bool"))
            errorHandler.addError(node.getPosition(),
                    "conditions in while statement must be of bool type");
        visit(node.getThen());
        node.setInternalScope(currentScope);
        exitCurrentScope();
    }

    @Override
    public void visit(ExprStatNode node)
    {
        if(node == null) return;
        visit(node.getExpr());
    }

    @Override
    public void visit(Type type)
    {
        if(type instanceof ArrayType)
        {
            if(!currentScope.containsType(((ArrayType) type).getBaseType().getTypeName()))
            {
                throw new RuntimeException("type " + ((ArrayType) type).getBaseType().getTypeName().toString()
                        + " have not been declared");
            }
        }
        if(!currentScope.containsType(type.getTypeName()))
            throw new RuntimeException("type " + type.getTypeName().toString() + " have not been declared");
    }
    private void setCurrentScope(Scope _currentScope)
    {
        currentScope = _currentScope;
        scopeStack.push(_currentScope);
    }
    private void exitCurrentScope()
    {
//        currentScope = currentScope.getParent();
        scopeStack.pop();
        currentScope = scopeStack.peek();
    }
    private boolean isStringBuiltIn(Name name)
    {
        return (name == Name.getName("length")
                || name == Name.getName("substring")
                || name == Name.getName("parseInt")
                || name == Name.getName("ord"));
    }
}
