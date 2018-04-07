package Parser;
// Generated from F:/programing/Compiler/M_Language_Compiler/Mlang_Compiler/src\Mlang.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MlangParser}.
 */
public interface MlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MlangParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(MlangParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(MlangParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#class_def}.
	 * @param ctx the parse tree
	 */
	void enterClass_def(MlangParser.Class_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#class_def}.
	 * @param ctx the parse tree
	 */
	void exitClass_def(MlangParser.Class_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#func_def}.
	 * @param ctx the parse tree
	 */
	void enterFunc_def(MlangParser.Func_defContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#func_def}.
	 * @param ctx the parse tree
	 */
	void exitFunc_def(MlangParser.Func_defContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#var_dec}.
	 * @param ctx the parse tree
	 */
	void enterVar_dec(MlangParser.Var_decContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#var_dec}.
	 * @param ctx the parse tree
	 */
	void exitVar_dec(MlangParser.Var_decContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterStat(MlangParser.StatContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitStat(MlangParser.StatContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#cond_stat}.
	 * @param ctx the parse tree
	 */
	void enterCond_stat(MlangParser.Cond_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#cond_stat}.
	 * @param ctx the parse tree
	 */
	void exitCond_stat(MlangParser.Cond_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#circ_stat}.
	 * @param ctx the parse tree
	 */
	void enterCirc_stat(MlangParser.Circ_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#circ_stat}.
	 * @param ctx the parse tree
	 */
	void exitCirc_stat(MlangParser.Circ_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#jump_stat}.
	 * @param ctx the parse tree
	 */
	void enterJump_stat(MlangParser.Jump_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#jump_stat}.
	 * @param ctx the parse tree
	 */
	void exitJump_stat(MlangParser.Jump_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#expr_stat}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stat(MlangParser.Expr_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#expr_stat}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stat(MlangParser.Expr_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#decl_stat}.
	 * @param ctx the parse tree
	 */
	void enterDecl_stat(MlangParser.Decl_statContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#decl_stat}.
	 * @param ctx the parse tree
	 */
	void exitDecl_stat(MlangParser.Decl_statContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MlangParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MlangParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#actual_parameters}.
	 * @param ctx the parse tree
	 */
	void enterActual_parameters(MlangParser.Actual_parametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#actual_parameters}.
	 * @param ctx the parse tree
	 */
	void exitActual_parameters(MlangParser.Actual_parametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#formal_parameters}.
	 * @param ctx the parse tree
	 */
	void enterFormal_parameters(MlangParser.Formal_parametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#formal_parameters}.
	 * @param ctx the parse tree
	 */
	void exitFormal_parameters(MlangParser.Formal_parametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssign_expr(MlangParser.Assign_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#assign_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssign_expr(MlangParser.Assign_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(MlangParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(MlangParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#class_id}.
	 * @param ctx the parse tree
	 */
	void enterClass_id(MlangParser.Class_idContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#class_id}.
	 * @param ctx the parse tree
	 */
	void exitClass_id(MlangParser.Class_idContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#class_type}.
	 * @param ctx the parse tree
	 */
	void enterClass_type(MlangParser.Class_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#class_type}.
	 * @param ctx the parse tree
	 */
	void exitClass_type(MlangParser.Class_typeContext ctx);
}