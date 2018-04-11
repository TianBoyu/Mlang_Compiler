package Code.AST.ASTConstructor;

import Code.AST.Node.DeclNode.ClassDecNode;
import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Node.DeclNode.FuncDecNode;
import Code.AST.Node.DeclNode.VarDecNode;
import Code.AST.Node.ExprNode.ExprListNode;
import Code.AST.Node.ExprNode.ExprNode;
import Code.AST.Node.ProgNode;
import Code.AST.Node.StatNode.BlockNode;
import Code.AST.Object.FuncObject;
import Code.AST.Object.VarObject;
import Code.AST.Table.TypeTable;
import Code.AST.Tools.Position;
import Code.AST.Type.ClassType;
import Code.AST.Type.Type;
import Code.Parser.MlangBaseListener;
import Code.Parser.MlangParser;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTConstructor extends MlangBaseListener
{
    public ASTConstructor()
    {
        type_table = new TypeTable();
    }
    public ProgNode getProgram()
    {
        return program;
    }
    private ProgNode program;
    private TypeTable type_table;
    @Override
    public void enterProg(MlangParser.ProgContext ctx)
    {
        System.out.println("come into Program");
        program = new ProgNode(new Position(ctx.getStart().getLine()), new ArrayList<>());
    }
    @Override
    public void exitProg(MlangParser.ProgContext ctx) {

    }
    @Override
    public void enterClass_def(MlangParser.Class_defContext ctx)
    {
        System.out.println("ClassDef");
        Position pos = new Position(ctx.getStart().getLine());
        ClassType type = new ClassType(ctx.getText(),4);
        List<FuncDecNode> func_list = new ArrayList<>();
        List<VarDecNode>  var_list  = new ArrayList<>();
        ClassDecNode class_node = new ClassDecNode(pos, type, func_list, var_list);
        program.addNode(class_node);
    }
    @Override public void exitClass_def(MlangParser.Class_defContext ctx) { }

    @Override
    public void enterFunc_def(MlangParser.Func_defContext ctx)
    {
        System.out.println("FunctionDef");
        Position pos = new Position(ctx.getStart().getLine());
        Type ret_type = type_table.getType(ctx.class_type().getText());
        ExprListNode param = new ExprListNode(pos, new ArrayList<>());
        FuncObject func = new FuncObject(ctx.id().getText(), param, ret_type);
        BlockNode block = new BlockNode(pos, new ArrayList<>());
        FuncDecNode func_node = new FuncDecNode(pos, func, block);
        program.addNode(func_node);
    }
    @Override public void exitFunc_def(MlangParser.Func_defContext ctx) { }

    @Override
    public void enterVar_dec(MlangParser.Var_decContext ctx)
    {
        System.out.println("VarDeclare");
        Position pos = new Position(ctx.getStart().getLine());
        boolean is_global = false;
        Type type = type_table.getType(ctx.ID().getText());
        VarObject var = new VarObject(ctx.ID().getText(), is_global, type);
        ExprNode expr = new ExprNode(pos);
        VarDecNode var_node = new VarDecNode(pos, var, expr);
        program.addNode(var_node);
    }

    @Override public void exitVar_dec(MlangParser.Var_decContext ctx) { }

    @Override public void enterBlock(MlangParser.BlockContext ctx) { }

    @Override public void exitBlock(MlangParser.BlockContext ctx) { }

    @Override public void enterStat(MlangParser.StatContext ctx) { }

    @Override public void exitStat(MlangParser.StatContext ctx) { }

    @Override public void enterCond_stat(MlangParser.Cond_statContext ctx) { }

    @Override public void exitCond_stat(MlangParser.Cond_statContext ctx) { }

    @Override public void enterCirc_stat(MlangParser.Circ_statContext ctx) { }

    @Override public void exitCirc_stat(MlangParser.Circ_statContext ctx) { }

    @Override public void enterJump_stat(MlangParser.Jump_statContext ctx) { }

    @Override public void exitJump_stat(MlangParser.Jump_statContext ctx) { }

    @Override public void enterExpr_stat(MlangParser.Expr_statContext ctx) { }

    @Override public void exitExpr_stat(MlangParser.Expr_statContext ctx) { }

    @Override public void enterDecl_stat(MlangParser.Decl_statContext ctx) { }

    @Override public void exitDecl_stat(MlangParser.Decl_statContext ctx) { }

    @Override public void enterExpr(MlangParser.ExprContext ctx) { }

    @Override public void exitExpr(MlangParser.ExprContext ctx) { }

    @Override public void enterActual_parameters(MlangParser.Actual_parametersContext ctx) { }

    @Override public void exitActual_parameters(MlangParser.Actual_parametersContext ctx) { }

    @Override public void enterFormal_parameters(MlangParser.Formal_parametersContext ctx) { }

    @Override public void exitFormal_parameters(MlangParser.Formal_parametersContext ctx) { }

    @Override public void enterAssign_expr(MlangParser.Assign_exprContext ctx) { }

    @Override public void exitAssign_expr(MlangParser.Assign_exprContext ctx) { }

    @Override public void enterId(MlangParser.IdContext ctx) { }

    @Override public void exitId(MlangParser.IdContext ctx) { }

    @Override public void enterClass_id(MlangParser.Class_idContext ctx) { }

    @Override public void exitClass_id(MlangParser.Class_idContext ctx) { }

    @Override public void enterClass_type(MlangParser.Class_typeContext ctx) { }

    @Override public void exitClass_type(MlangParser.Class_typeContext ctx) { }


    @Override public void enterEveryRule(ParserRuleContext ctx) { }

    @Override public void exitEveryRule(ParserRuleContext ctx) { }

    @Override public void visitTerminal(TerminalNode node) { }

    @Override public void visitErrorNode(ErrorNode node) { }
}
