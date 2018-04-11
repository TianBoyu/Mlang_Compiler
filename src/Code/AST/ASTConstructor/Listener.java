package Code.AST.ASTConstructor;

import Code.AST.Node.DeclNode.DeclNode;
import Code.AST.Node.ProgNode;
import Code.AST.Tools.Position;
import Code.Parser.*;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class Listener extends MlangBaseListener
{
    private ProgNode AST_tree;
    public ProgNode getASTTree() {
        return AST_tree;
    }
    @Override
    public void enterProg(MlangParser.ProgContext ctx)
    {
        List<DeclNode> decls = new ArrayList<>();
        Position pos = new Position(0);
        AST_tree = new ProgNode(pos, decls);
    }
    @Override public void exitProg(MlangParser.ProgContext ctx) { }
    @Override
    public void enterClass_def(MlangParser.Class_defContext ctx)
    {
//        ClassDecNode class_dec = new ClassDecNode()
    }
    @Override public void exitClass_def(MlangParser.Class_defContext ctx) { }
      
    @Override public void enterFunc_def(MlangParser.Func_defContext ctx) { }
     
    @Override public void exitFunc_def(MlangParser.Func_defContext ctx) { }
     
    @Override public void enterVar_dec(MlangParser.Var_decContext ctx) { }
     
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
