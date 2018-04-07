package Parser;
// Generated from F:/programing/Compiler/M_Language_Compiler/Mlang_Compiler/src\Mlang.g4 by ANTLR 4.7
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MlangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MlangVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MlangParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(MlangParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#class_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_def(MlangParser.Class_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#func_def}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_def(MlangParser.Func_defContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#var_dec}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_dec(MlangParser.Var_decContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStat(MlangParser.StatContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#cond_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCond_stat(MlangParser.Cond_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#circ_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCirc_stat(MlangParser.Circ_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#jump_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_stat(MlangParser.Jump_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#expr_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stat(MlangParser.Expr_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#decl_stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDecl_stat(MlangParser.Decl_statContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MlangParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#actual_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActual_parameters(MlangParser.Actual_parametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#formal_parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormal_parameters(MlangParser.Formal_parametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#assign_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssign_expr(MlangParser.Assign_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MlangParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#class_id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_id(MlangParser.Class_idContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#class_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_type(MlangParser.Class_typeContext ctx);
}