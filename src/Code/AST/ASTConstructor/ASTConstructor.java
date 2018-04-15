package Code.AST.ASTConstructor;

import Code.AST.Node.DeclNode.ClassDecNode;
import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Node.DeclNode.VarDecNode;
import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.*;
import Code.AST.Object.FuncObject;
import Code.AST.Object.ParameterObject;
import Code.AST.Object.VarObject;
import Code.AST.Table.TypeTable;
import Code.AST.Tools.LoopBody;
import Code.AST.Tools.Position;
import Code.AST.Type.ArrayType;
import Code.AST.Type.BuiltInType;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.Parser.MlangBaseListener;
import Code.Parser.MlangParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
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
    private TypeTable type_table;
    private ProgNode program;
    private ParseTreeProperty<Object> map = new ParseTreeProperty<>();
    @Override public void enterProgram(MlangParser.ProgramContext ctx) { }
     
    @Override
    public void exitProgram(MlangParser.ProgramContext ctx)
    {
        List<DeclNode> declNodes = new LinkedList<>();
        for(ParserRuleContext parserRuleContext : ctx.getRuleContexts(ParserRuleContext.class))
        {
            DeclNode node = (DeclNode)map.get(parserRuleContext);
            declNodes.add(node);
        }
        program = new ProgNode(new Position(ctx.getStart().getLine()), declNodes);
    }
     
    @Override public void enterClassDecl(MlangParser.ClassDeclContext ctx) { }
     
    @Override public void exitClassDecl(MlangParser.ClassDeclContext ctx)
    {
        List<VarDecNode> varDecNodes = new ArrayList<>();
        List<FuncDecNode> funcDecNodes = new ArrayList<>();
        for(MlangParser.VariableDeclContext item : ctx.variableDecl())
        {
            varDecNodes.add((VarDecNode)map.get(item));
        }
        for(MlangParser.FunctionDeclContext item : ctx.functionDecl())
        {
            funcDecNodes.add((FuncDecNode)map.get(item));
        }
        Position pos = new Position(ctx.getStart().getLine());
        ClassType type = new ClassType(ctx.getText(),4);
        ClassDecNode class_node = new ClassDecNode(pos, type, funcDecNodes, varDecNodes);
        map.put(ctx, class_node);
    }
     
    @Override public void enterFunctionDecl(MlangParser.FunctionDeclContext ctx) { }
     
    @Override public void exitFunctionDecl(MlangParser.FunctionDeclContext ctx)
    {
        List<ExprNode> exprList = new ArrayList<>();
        for(MlangParser.ParameterContext item : ctx.parameter())
        {
            ExprNode node = (ExprNode)map.get(item);
            exprList.add(node);
        }
        BlockNode blockNode = (BlockNode)map.get(ctx.block());
        Position pos = new Position(ctx.getStart().getLine());
        Type ret_type = type_table.getType(ctx.type().getText());
        FuncObject func = new FuncObject(ctx.ID().getText(), new ExprListNode(pos, exprList), ret_type);
        FuncDecNode funcDecNode = new FuncDecNode(pos, func, blockNode);
        map.put(ctx, funcDecNode);
    }

    @Override public void enterVariableDecl(MlangParser.VariableDeclContext ctx) { }
     
    @Override public void exitVariableDecl(MlangParser.VariableDeclContext ctx)
    {
        Position pos = new Position(ctx.getStart().getLine());
        Type type = (Type)map.get(ctx.type());
        String id = ctx.ID().getText();
        ExprNode expr = (ExprNode)map.get(ctx.expression());
        VarObject varObject = new VarObject(id, false, type);
        VarDecNode varDecNode = new VarDecNode(pos, varObject, expr);
        map.put(ctx, varDecNode);
    }
     
    @Override
    public void enterParameter(MlangParser.ParameterContext ctx)
    {

    }
     
    @Override
    public void exitParameter(MlangParser.ParameterContext ctx)
    {
        map.put(ctx, new ParameterObject((Type)map.get(ctx.type()), ctx.ID().getText()));
    }
     
    @Override
    public void enterBuiltInType(MlangParser.BuiltInTypeContext ctx)
    {

    }
     
    @Override
    public void exitBuiltInType(MlangParser.BuiltInTypeContext ctx)
    {
        BuiltInType type;
        switch (ctx.getText())
        {
            case "bool" : type = new BuiltInType("bool", 1);
            case "int"  : type = new BuiltInType("int", 4);
            case "void" : type = new BuiltInType("void", 0);
            case "string": type = new BuiltInType("string", 0);
            default:
                throw new InternalError(ctx.getText() + "is an invalid type");
        }
        map.put(ctx, type);
    }
     
    @Override public void enterUserType(MlangParser.UserTypeContext ctx) { }
     
    @Override public void exitUserType(MlangParser.UserTypeContext ctx)
    {
        ClassType type = new ClassType(ctx.getText(), 4);
        map.put(ctx, type);
    }
    @Override public void enterArrayType(MlangParser.ArrayTypeContext ctx) { }

    @Override public void exitArrayType(MlangParser.ArrayTypeContext ctx) {
        Type baseType;
        ArrayType arrayType;
        if (ctx.builtInType() != null) {
            baseType = (Type) map.get(ctx.builtInType());
            arrayType = new ArrayType(ctx.builtInType().getText(), 4, baseType);
        }
        else {
            baseType = new ClassType(ctx.userType().ID().getText(), 4);
            arrayType = new ArrayType(ctx.userType().ID().getText(), 4, baseType);
        }
        map.put(ctx, arrayType);
    }

    @Override public void enterType(MlangParser.TypeContext ctx) { }
     
    @Override public void exitType(MlangParser.TypeContext ctx)
    {
        Type type;
        if(ctx.builtInType() != null)
            type = (Type)map.get(ctx.builtInType());
        else if(ctx.userType() != null)
            type = (Type)map.get(ctx.userType());
        else type = (Type)map.get(ctx.arrayType());
    }
     
    @Override public void enterBlock(MlangParser.BlockContext ctx) { }
     
    @Override public void exitBlock(MlangParser.BlockContext ctx)
    {
        List<StatNode> statNodes = new ArrayList<>();
        for(MlangParser.StatementContext item : ctx.statement())
        {
            StatNode stat = (StatNode)map.get(item);
            if(stat != null)
                statNodes.add(stat);
        }
        BlockNode blockNode = new BlockNode(new Position(ctx.getStart().getLine()), statNodes);
        map.put(ctx, blockNode);
    }
     
    
    @Override public void enterBlockStat(MlangParser.BlockStatContext ctx) { }

    @Override public void exitBlockStat(MlangParser.BlockStatContext ctx)
    {
        map.put(ctx, map.get(ctx.block()));
    }

    @Override public void enterVarDeclStat(MlangParser.VarDeclStatContext ctx) { }

    @Override public void exitVarDeclStat(MlangParser.VarDeclStatContext ctx)
    {
        map.put(ctx, map.get(ctx.variableDecl()));
    }

    @Override public void enterIfStat(MlangParser.IfStatContext ctx) { }

    @Override public void exitIfStat(MlangParser.IfStatContext ctx)
    {
        IfNode ifNode = new IfNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression()), getStat(ctx.statement(0)), getStat(ctx.statement(1)));
        map.put(ctx, ifNode);
    }

    @Override public void enterForStat(MlangParser.ForStatContext ctx) { }

    @Override public void exitForStat(MlangParser.ForStatContext ctx)
    {
        ForNode forNode = new ForNode(new Position(ctx.getStart().getLine()), getExpr(ctx.init),
                getExpr(ctx.cond), getExpr(ctx.update));
        map.put(ctx, forNode);
    }

    @Override public void enterWhileStat(MlangParser.WhileStatContext ctx) { }

    @Override public void exitWhileStat(MlangParser.WhileStatContext ctx)
    {
        WhileNode whileNode = new WhileNode(new Position(ctx.getStart().getLine()), getExpr(ctx.expression()),
                getStat(ctx.statement()));
        map.put(ctx, whileNode);
    }

    @Override public void enterReturnStat(MlangParser.ReturnStatContext ctx) { }

    @Override public void exitReturnStat(MlangParser.ReturnStatContext ctx) {
        ReturnNode returnNode;
        if (ctx.expression() != null)
        {
            returnNode = new ReturnNode(new Position(ctx.getStart().getLine()), new LoopBody(), getExpr(ctx.expression()));
        }
        else
        {
            returnNode = new ReturnNode(new Position(ctx.getStart().getLine()), new LoopBody(), null);
        }
        map.put(ctx, returnNode);
    }

    @Override public void enterBreakStat(MlangParser.BreakStatContext ctx) { }

    @Override public void exitBreakStat(MlangParser.BreakStatContext ctx)
    {
        BreakNode breakNode = new BreakNode(new Position(ctx.getStart().getLine()), new LoopBody());
        map.put(ctx, breakNode);
    }

    @Override public void enterContinueStat(MlangParser.ContinueStatContext ctx) { }

    @Override public void exitContinueStat(MlangParser.ContinueStatContext ctx)
    {
        ContinueNode continueNode = new ContinueNode(new Position(ctx.getStart().getLine()), new LoopBody());
        map.put(ctx, continueNode);
    }
    @Override public void exitExprStat(MlangParser.ExprStatContext ctx) 
    {
        ExprStatNode exprStatNode = new ExprStatNode(new Position(ctx.getStart().getLine()), (ExprNode)map.get(ctx.expression()));
        map.put(ctx, exprStatNode);
    }

    @Override public void exitActual_parameter(MlangParser.Actual_parameterContext ctx)
    {
        List<ExprNode> exprNodes = new ArrayList<>();
        for(MlangParser.ExpressionContext item : ctx.expression())
        {
            exprNodes.add((ExprNode)map.get(item));
        }
        ExprListNode exprListNode = new ExprListNode(new Position(ctx.getStart().getLine()), exprNodes);
        map.put(ctx, exprNodes);
    }

    @Override public void enterNewExpr(MlangParser.NewExprContext ctx) { }
     
    @Override public void exitNewExpr(MlangParser.NewExprContext ctx) { }
     
    @Override public void enterBoolConstExpr(MlangParser.BoolConstExprContext ctx) { }
     
    @Override public void exitBoolConstExpr(MlangParser.BoolConstExprContext ctx) { }
     
    @Override public void enterThisExpr(MlangParser.ThisExprContext ctx) { }
     
    @Override public void exitThisExpr(MlangParser.ThisExprContext ctx) { }
     
    @Override public void enterNullExpr(MlangParser.NullExprContext ctx) { }
     
    @Override public void exitNullExpr(MlangParser.NullExprContext ctx) { }
     
    @Override public void enterArrayExpr(MlangParser.ArrayExprContext ctx) { }
     
    @Override public void exitArrayExpr(MlangParser.ArrayExprContext ctx) { }
     
    @Override public void enterMemberExpr(MlangParser.MemberExprContext ctx) { }
     
    @Override public void exitMemberExpr(MlangParser.MemberExprContext ctx) { }
     
    @Override public void enterSuffixExpr(MlangParser.SuffixExprContext ctx) { }
     
    @Override public void exitSuffixExpr(MlangParser.SuffixExprContext ctx) { }
     
    @Override public void enterBinaryExpr(MlangParser.BinaryExprContext ctx) { }
     
    @Override public void exitBinaryExpr(MlangParser.BinaryExprContext ctx) { }
     
    @Override public void enterIntConstExpr(MlangParser.IntConstExprContext ctx) { }
     
    @Override public void exitIntConstExpr(MlangParser.IntConstExprContext ctx) { }
     
    @Override public void enterSubExpr(MlangParser.SubExprContext ctx) { }
     
    @Override public void exitSubExpr(MlangParser.SubExprContext ctx) { }
     
    @Override public void enterPrefixExpr(MlangParser.PrefixExprContext ctx) { }
     
    @Override public void exitPrefixExpr(MlangParser.PrefixExprContext ctx) { }
     
    @Override public void enterStringConstExpr(MlangParser.StringConstExprContext ctx) { }
     
    @Override public void exitStringConstExpr(MlangParser.StringConstExprContext ctx) { }
     
    @Override public void enterCallExpr(MlangParser.CallExprContext ctx) { }
     
    @Override public void exitCallExpr(MlangParser.CallExprContext ctx) { }
     
    @Override public void enterOrExprt(MlangParser.OrExprtContext ctx) { }
     
    @Override public void exitOrExprt(MlangParser.OrExprtContext ctx) { }
     
    @Override public void enterAssignExpr(MlangParser.AssignExprContext ctx) { }
     
    @Override public void exitAssignExpr(MlangParser.AssignExprContext ctx) { }
     
    @Override public void enterIdExpr(MlangParser.IdExprContext ctx) { }
     
    @Override public void exitIdExpr(MlangParser.IdExprContext ctx) { }
     
    @Override public void enterAndExpr(MlangParser.AndExprContext ctx) { }
     
    @Override public void exitAndExpr(MlangParser.AndExprContext ctx) { }
    
     
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
     
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
     
    @Override public void visitTerminal(TerminalNode node) { }
     
    @Override public void visitErrorNode(ErrorNode node) { }

    private ExprNode getExpr(MlangParser.ExpressionContext ctx)
    {
        if(ctx == null)
            return null;
        else
            return (ExprNode)map.get(ctx);
    }
    private StatNode getStat(MlangParser.StatementContext ctx)
    {
        if(ctx == null)
            return null;
        else return (StatNode)map.get(ctx);
    }

}
