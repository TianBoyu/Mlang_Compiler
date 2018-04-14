package Code.AST.ASTConstructor;

import Code.AST.Node.DeclNode.ClassDecNode;
import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Node.DeclNode.VarDecNode;
import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.BlockNode;
import Code.AST.Node.StatNode.StatNode;
import Code.AST.Object.FuncObject;
import Code.AST.Object.ParameterObject;
import Code.AST.Object.VarObject;
import Code.AST.Table.TypeTable;
import Code.AST.Tools.Position;
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
     
    @Override public void exitUserType(MlangParser.UserTypeContext ctx) { }
     
    @Override public void enterType(MlangParser.TypeContext ctx) { }
     
    @Override public void exitType(MlangParser.TypeContext ctx) { }
     
    @Override public void enterBlock(MlangParser.BlockContext ctx) { }
     
    @Override public void exitBlock(MlangParser.BlockContext ctx) { }
     
    @Override public void enterStatement(MlangParser.StatementContext ctx) { }
     
    @Override public void exitStatement(MlangParser.StatementContext ctx) { }
     
    @Override public void enterActual_parameter(MlangParser.Actual_parameterContext ctx) { }
     
    @Override public void exitActual_parameter(MlangParser.Actual_parameterContext ctx) { }
     
    @Override public void enterExpression(MlangParser.ExpressionContext ctx) { }
     
    @Override public void exitExpression(MlangParser.ExpressionContext ctx) { }

     
    @Override public void enterEveryRule(ParserRuleContext ctx) { }
     
    @Override public void exitEveryRule(ParserRuleContext ctx) { }
     
    @Override public void visitTerminal(TerminalNode node) { }
     
    @Override public void visitErrorNode(ErrorNode node) { }


}
