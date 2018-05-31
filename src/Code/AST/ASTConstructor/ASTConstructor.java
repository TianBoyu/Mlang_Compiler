package Code.AST.ASTConstructor;

import Code.AST.Node.DeclNode.*;
import Code.AST.Node.ExprNode.*;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Object.FuncDecObject;
import Code.AST.Object.ParameterObject;
import Code.AST.Object.VarObject;
import Code.AST.Tools.BinaryOp;
import Code.AST.Tools.Position;
import Code.AST.Tools.UnaryOp;
import Code.AST.Type.ArrayType;
import Code.AST.Type.BuiltInType;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.Parser.MlangBaseListener;
import Code.Parser.MlangParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTreeProperty;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ASTConstructor extends MlangBaseListener
{
    public ASTConstructor()
    {

    }

    public ProgNode getProgram()
    {
        return program;
    }

//    private TypeTable type_table;
    private ProgNode program;
    private ParseTreeProperty<Object> map = new ParseTreeProperty<>();


    @Override
    public void exitProgram(MlangParser.ProgramContext ctx)
    {
        List<DeclNode> declNodes = new LinkedList<>();
        for (ParserRuleContext parserRuleContext : ctx.getRuleContexts(ParserRuleContext.class))
        {
            DeclNode node = (DeclNode) map.get(parserRuleContext);
            declNodes.add(node);
        }
        program = new ProgNode(new Position(ctx.getStart().getLine()), declNodes);
    }


    @Override
    public void exitClassDecl(MlangParser.ClassDeclContext ctx)
    {
        List<VarDecNode> varDecNodes = new ArrayList<>();
        List<FuncDecNode> funcDecNodes = new ArrayList<>();
        for (MlangParser.VariableDeclContext item : ctx.variableDecl())
        {
            varDecNodes.add((VarDecNode) map.get(item));
        }
        for (MlangParser.FunctionDeclContext item : ctx.functionDecl())
        {
            funcDecNodes.add((FuncDecNode) map.get(item));
        }
        Position pos = new Position(ctx.getStart().getLine());
        ClassType type = new ClassType(ctx.ID().getText(), 4);
        ClassDecNode class_node = new ClassDecNode(pos, type, funcDecNodes, varDecNodes);
        map.put(ctx, class_node);
    }

    @Override
    public void exitFunctionDecl(MlangParser.FunctionDeclContext ctx)
    {
        List<FuncParamNode> paras = new ArrayList<>();
        if(ctx.formal_parameter() != null)
        {
            for (MlangParser.ParameterContext item : ctx.formal_parameter().parameter())
            {
                paras.add((FuncParamNode)map.get(item));
            }
        }
        BlockNode blockNode = (BlockNode) map.get(ctx.block());
        Position pos = new Position(ctx.getStart().getLine());
        Type ret_type;
        FuncDecObject func;
        if(ctx.type() != null)
        {
            ret_type = (Type)map.get(ctx.type());
            func = new FuncDecObject(ctx.ID().getText(), paras, ret_type);
        }
        else
        {
            ret_type = new Type(ctx.ID().getText(), 4);
            func = new FuncDecObject(ctx.ID().getText(), paras, ret_type, true);
        }
        FuncDecNode funcDecNode = new FuncDecNode(pos, func, blockNode);
        map.put(ctx, funcDecNode);
    }

    @Override
    public void exitVariableDecl(MlangParser.VariableDeclContext ctx)
    {
        Position pos = new Position(ctx.getStart().getLine());
        Type type = (Type)map.get(ctx.type());
        String id = ctx.ID().getText();
        ExprNode expr = (ExprNode) map.get(ctx.expression());
        VarObject varObject = new VarObject(id, false, type);
        VarDecNode varDecNode = new VarDecNode(pos, varObject, expr);
        map.put(ctx, varDecNode);
    }

    @Override
    public void exitParameter(MlangParser.ParameterContext ctx)
    {
        map.put(ctx, new FuncParamNode(new Position(ctx.getStart().getLine()),
                new ParameterObject(ctx.ID().getText(), (Type) map.get(ctx.type()))));
    }

    @Override
    public void exitBuiltInType(MlangParser.BuiltInTypeContext ctx)
    {
        BuiltInType type;
        switch (ctx.getText())
        {
            case "bool":
                type = new BuiltInType("bool", 1);
                break;
            case "int":
                type = new BuiltInType("int", 4);
                break;
            case "void":
                type = new BuiltInType("void", 0);
                break;
            case "string":
                type = new BuiltInType("string", 0);
                break;
            default:
                throw new InternalError(ctx.getText() + "is an invalid type");
        }
        map.put(ctx, type);
    }

    @Override
    public void exitUserType(MlangParser.UserTypeContext ctx)
    {
        ClassType type = new ClassType(ctx.getText(), 4);
        map.put(ctx, type);
    }

    @Override
    public void exitArrayType(MlangParser.ArrayTypeContext ctx)
    {
        Type baseType;
        ArrayType arrayType;
        int dimension = getBracketNumber(ctx.getText());
        if (ctx.builtInType() != null)
        {
            baseType = (Type) map.get(ctx.builtInType());
            arrayType = new ArrayType(ctx.builtInType().getText(), dimension, baseType);
        }
        else
        {
            baseType = new ClassType(ctx.userType().ID().getText(), 4);
            arrayType = new ArrayType(ctx.userType().ID().getText(), dimension, baseType);
        }
        map.put(ctx, arrayType);
    }

    @Override
    public void exitType(MlangParser.TypeContext ctx)//TODO
    {
        Type type;
        if (ctx.builtInType() != null)
            type = (BuiltInType) map.get(ctx.builtInType());
        else if (ctx.userType() != null)
            type = (ClassType) map.get(ctx.userType());
        else type = (ArrayType) map.get(ctx.arrayType());
        map.put(ctx, type);
    }

    @Override
    public void exitBlock(MlangParser.BlockContext ctx)
    {
        List<StatNode> statNodes = new ArrayList<>();
        for (MlangParser.StatementContext item : ctx.statement())
        {
//            System.out.println(item.getText());
            StatNode stat = (StatNode) map.get(item);
            if (stat != null)
                statNodes.add(stat);
        }
        BlockNode blockNode = new BlockNode(new Position(ctx.getStart().getLine()), statNodes);
        map.put(ctx, blockNode);
    }

    @Override
    public void exitBlockStat(MlangParser.BlockStatContext ctx)
    {
        map.put(ctx, map.get(ctx.block()));
    }

    @Override
    public void exitVarDeclStat(MlangParser.VarDeclStatContext ctx)
    {
        map.put(ctx, map.get(ctx.variableDecl()));
    }

    @Override
    public void exitIfStat(MlangParser.IfStatContext ctx)
    {
        IfNode ifNode = new IfNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression()),
                getStat(ctx.statement(0)), getStat(ctx.statement(1)));
        map.put(ctx, ifNode);
    }
    @Override
    public void exitForStat(MlangParser.ForStatContext ctx)
    {
        ForNode forNode = new ForNode(new Position(ctx.getStart().getLine()), getExpr(ctx.init),
                getExpr(ctx.cond), getExpr(ctx.update), getStat(ctx.statement()));
//        System.out.println(ctx.statement().getText());
        map.put(ctx, forNode);
    }

    @Override
    public void exitWhileStat(MlangParser.WhileStatContext ctx)
    {
        WhileNode whileNode = new WhileNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression()),
                getStat(ctx.statement()));
        map.put(ctx, whileNode);
    }

    @Override
    public void exitReturnStat(MlangParser.ReturnStatContext ctx)
    {
        ReturnNode returnNode;
        if (ctx.expression() != null)
        {
            returnNode = new ReturnNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression()));
        } else
        {
            returnNode = new ReturnNode(new Position(ctx.getStart().getLine()), null);
        }
        map.put(ctx, returnNode);
    }

    @Override
    public void exitBreakStat(MlangParser.BreakStatContext ctx)
    {
        BreakNode breakNode = new BreakNode(new Position(ctx.getStart().getLine()));
        map.put(ctx, breakNode);
    }

    @Override
    public void exitContinueStat(MlangParser.ContinueStatContext ctx)
    {
        ContinueNode continueNode = new ContinueNode(new Position(ctx.getStart().getLine()));
        map.put(ctx, continueNode);
    }

    @Override
    public void exitExprStat(MlangParser.ExprStatContext ctx)
    {
        ExprStatNode exprStatNode = new ExprStatNode(new Position(ctx.getStart().getLine()), (ExprNode) map.get(ctx.expression()));
        map.put(ctx, exprStatNode);
    }

    @Override
    public void exitActual_parameter(MlangParser.Actual_parameterContext ctx)
    {
        List<ExprNode> exprNodes = new ArrayList<>();
        for (MlangParser.ExpressionContext item : ctx.expression())
        {
            exprNodes.add((ExprNode) map.get(item));
        }
        ExprListNode exprListNode = new ExprListNode(new Position(ctx.getStart().getLine()), exprNodes);
        map.put(ctx, exprListNode);
    }

    @Override
    public void exitNewExpr(MlangParser.NewExprContext ctx)
    {
        CreatorNode creatorNode = (CreatorNode)map.get(ctx.creator());
        map.put(ctx, new NewExprNode(new Position(ctx.getStart().getLine()), creatorNode));
    }

    @Override
    public void exitWrongCreator(MlangParser.WrongCreatorContext ctx)
    {
        throw new RuntimeException("wrong construction of array");
    }

    @Override
    public void exitArrayCreator(MlangParser.ArrayCreatorContext ctx)
    {
        Type type;
        if(ctx.userType() != null)
//            type = new Type(ctx.userType().ID().getText(), -1);
            type = (Type)map.get(ctx.userType());
        else
            type = (Type)map.get(ctx.builtInType());
//            type = new Type(ctx.builtInType().getText(), -1);
        List<ExprNode> exprs = new LinkedList<>();
        for(MlangParser.ExpressionContext item : ctx.expression())
            exprs.add((ExprNode)map.get(item));
        int dimension = getBracketNumber(ctx.getText());
        map.put(ctx ,new CreatorNode(new Position(ctx.getStart().getLine()), type, exprs, dimension));
    }

    @Override
    public void exitNonArrayCreator(MlangParser.NonArrayCreatorContext ctx)
    {
        Type type = new Type(ctx.userType().ID().getText(), 1);
        map.put(ctx, new CreatorNode(new Position(ctx.getStart().getLine()), type, new ArrayList<>(), 0));
    }

    @Override
    public void exitBoolConstExpr(MlangParser.BoolConstExprContext ctx)
    {
        boolean value = ctx.FALSE() == null;
        BoolConstNode node = new BoolConstNode(new Position(ctx.getStart().getLine()), value);
        map.put(ctx, node);
    }

    @Override
    public void exitThisExpr(MlangParser.ThisExprContext ctx)
    {
        ThisExprNode thisExprNode = new ThisExprNode(new Position(ctx.getStart().getLine()), "this");
        map.put(ctx, thisExprNode);
    }

    @Override
    public void exitNullExpr(MlangParser.NullExprContext ctx)
    {
        NullConstNode nullConstNode = new NullConstNode(new Position(ctx.getStart().getLine()));
        map.put(ctx, nullConstNode);
    }

    @Override
    public void exitArrayExpr(MlangParser.ArrayExprContext ctx)
    {
        ArrayExprNode arrayExprNode = new ArrayExprNode(new Position(ctx.getStart().getLine()),
                getExpr(ctx.expression(0)),
                getExpr(ctx.expression(1)));
        map.put(ctx, arrayExprNode);
    }

    @Override
    public void exitMemberExpr(MlangParser.MemberExprContext ctx)
    {
        MemberExprNode memberExprNode;
        if(ctx.functionCall() != null)
            memberExprNode = new MemberExprNode(new Position(ctx.getStart().getLine()),
                getExpr(ctx.expression()), (CallExprNode)map.get(ctx.functionCall()));
        else
            memberExprNode = new MemberExprNode(new Position(ctx.getStart().getLine()),
                    getExpr(ctx.expression()), ctx.ID().getText());
        map.put(ctx, memberExprNode);
    }

    @Override
    public void exitSuffixExpr(MlangParser.SuffixExprContext ctx)
    {
        UnaryOp op;
        switch (ctx.op.getText())
        {
            case "++":
                op = UnaryOp.SUF_INCRE;
                break;
            case "--":
                op = UnaryOp.SUF_DECRE;
                break;
            default:
                throw new InternalError("Invalid suffix op" + ctx.op.getText());
        }
        SuffixExprNode suffixExprNode = new SuffixExprNode(new Position(ctx.getStart().getLine()), op,
                (ExprNode) map.get(ctx.expression()));
        map.put(ctx, suffixExprNode);
    }

    @Override
    public void exitBinaryExpr(MlangParser.BinaryExprContext ctx)
    {
        BinaryOp op;
        if(ctx.op == null)
            System.out.println(1);
        switch (ctx.op.getText())
        {
            case "+":
                op = BinaryOp.ADD;
                break;
            case "-":
                op = BinaryOp.MIN;
                break;
            case "*":
                op = BinaryOp.MUL;
                break;
            case "/":
                op = BinaryOp.DIV;
                break;
            case "%":
                op = BinaryOp.MOD;
                break;
            case "&":
                op = BinaryOp.BIT_AND;
                break;
            case "^":
                op = BinaryOp.BIT_XOR;
                break;
            case "|":
                op = BinaryOp.BIT_OR;
                break;
            case ">>":
                op = BinaryOp.R_SHIFT;
                break;
            case "<<":
                op = BinaryOp.L_SHIFT;
                break;
            case "<":
                op = BinaryOp.SLT;
                break;
            case "<=":
                op = BinaryOp.SEQ;
                break;
            case ">":
                op = BinaryOp.SGT;
                break;
            case ">=":
                op = BinaryOp.BEQ;
                break;
            case "==":
                op = BinaryOp.EQU;
                break;
            case "!=":
                op = BinaryOp.NEQ;
                break;
            default:
                throw new InternalError("Invalid binary op" + ctx.op.getText());
        }
        BinaryExprNode node = new BinaryExprNode(new Position(ctx.getStart().getLine()),
                getExpr(ctx.expression(0)), getExpr(ctx.expression(1)), op);
        map.put(ctx, node);
    }

    @Override
    public void exitIntConstExpr(MlangParser.IntConstExprContext ctx)
    {
        int value = Integer.valueOf(ctx.getText());
        IntConstNode intConstNode = new IntConstNode(new Position(ctx.getStart().getLine()), value);
        map.put(ctx, intConstNode);
    }

    @Override
    public void exitSubExpr(MlangParser.SubExprContext ctx)
    {
        map.put(ctx, getExpr(ctx.expression()));
    }

    @Override
    public void exitPrefixExpr(MlangParser.PrefixExprContext ctx)
    {
        UnaryOp op;
        switch (ctx.op.getText())
        {
            case "++":
                op = UnaryOp.INCRE;
                break;
            case "--":
                op = UnaryOp.DECRE;
                break;
            case "~":
                op = UnaryOp.BIT_NOT;
                break;
            case "!":
                op = UnaryOp.NOT;
                break;
            case "+":
                op = UnaryOp.POS;
                break;
            case "-":
                op = UnaryOp.NEG;
                break;
            default:
                throw new InternalError("Invalid prefix op" + ctx.op.getText());
        }
        PrefixExprNode prefixExprNode = new PrefixExprNode(new Position(ctx.getStart().getLine()),
                op, (ExprNode) map.get(ctx.expression()));
        map.put(ctx, prefixExprNode);
    }

    @Override
    public void exitStringConstExpr(MlangParser.StringConstExprContext ctx)
    {
        String value = ctx.getText().substring(1, ctx.getText().length() - 1);
        map.put(ctx, new StringConstNode(new Position(ctx.getStart().getLine()), value));
    }

    @Override
    public void exitCallExpr(MlangParser.CallExprContext ctx)
    {
        List<ExprNode> params = new ArrayList<>();
        if(ctx.functionCall().actual_parameter() != null)
        {
            for (MlangParser.ExpressionContext item : ctx.functionCall().actual_parameter().expression())
            {
                params.add((ExprNode) map.get(item));
            }
        }
        map.put(ctx, new CallExprNode(new Position(ctx.getStart().getLine()), ctx.functionCall().ID().getText(),
                new ExprListNode(new Position(ctx.getStart().getLine()), params)));
    }

    @Override
    public void exitFunctionCall(MlangParser.FunctionCallContext ctx)
    {
        List<ExprNode> params = new ArrayList<>();
        if(ctx.actual_parameter() != null)
        {
            for (MlangParser.ExpressionContext item : ctx.actual_parameter().expression())
            {
                params.add((ExprNode) map.get(item));
            }
        }
        map.put(ctx, new CallExprNode(new Position(ctx.getStart().getLine()), ctx.ID().getText(),
                new ExprListNode(new Position(ctx.getStart().getLine()), params)));
    }

    @Override
    public void exitOrExpr(MlangParser.OrExprContext ctx)
    {
        map.put(ctx, new OrExprNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression(0)),
                getExpr(ctx.expression(1))));
    }

    @Override
    public void exitAssignExpr(MlangParser.AssignExprContext ctx)
    {
        map.put(ctx, new AssignExprNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression(0)),
                getExpr(ctx.expression(1))));
    }

    @Override
    public void exitIdExpr(MlangParser.IdExprContext ctx)
    {
        map.put(ctx, new IdExprNode(new Position(ctx.getStart().getLine()), ctx.getText()));
    }

    @Override
    public void exitAndExpr(MlangParser.AndExprContext ctx)
    {
        map.put(ctx, new AndExprNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression(0)),
                getExpr(ctx.expression(1))));
    }

    @Override
    public void visitErrorNode(ErrorNode node)
    {
        throw new RuntimeException(node.getText());
    }

    private ExprNode getExpr(MlangParser.ExpressionContext ctx)
    {
        if (ctx == null)
            return null;
        else
            return (ExprNode) map.get(ctx);
    }

    private StatNode getStat(MlangParser.StatementContext ctx)
    {
        if (ctx == null)
            return null;
        else return (StatNode) map.get(ctx);
    }

    private int getBracketNumber(String s)
    {
        int num = 0;
        for(int i = 0; i < s.length(); ++i)
        {
            if(s.charAt(i) == '[')
                ++num;
        }
        return num;
    }

}
