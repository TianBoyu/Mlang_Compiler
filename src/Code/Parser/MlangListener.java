// Generated from F:/programing/Compiler/M_Language_Compiler/Mlang_Compiler/src/Code/Parser\Mlang.g4 by ANTLR 4.7
package Code.Parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MlangParser}.
 */
public interface MlangListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MlangParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MlangParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MlangParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void enterClassDecl(MlangParser.ClassDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#classDecl}.
	 * @param ctx the parse tree
	 */
	void exitClassDecl(MlangParser.ClassDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDecl(MlangParser.FunctionDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#functionDecl}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDecl(MlangParser.FunctionDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void enterVariableDecl(MlangParser.VariableDeclContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#variableDecl}.
	 * @param ctx the parse tree
	 */
	void exitVariableDecl(MlangParser.VariableDeclContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void enterParameter(MlangParser.ParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#parameter}.
	 * @param ctx the parse tree
	 */
	void exitParameter(MlangParser.ParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void enterBuiltInType(MlangParser.BuiltInTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#builtInType}.
	 * @param ctx the parse tree
	 */
	void exitBuiltInType(MlangParser.BuiltInTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#userType}.
	 * @param ctx the parse tree
	 */
	void enterUserType(MlangParser.UserTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#userType}.
	 * @param ctx the parse tree
	 */
	void exitUserType(MlangParser.UserTypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MlangParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MlangParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#block}.
	 * @param ctx the parse tree
	 */
	void enterBlock(MlangParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#block}.
	 * @param ctx the parse tree
	 */
	void exitBlock(MlangParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterStatement(MlangParser.StatementContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitStatement(MlangParser.StatementContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#actual_parameter}.
	 * @param ctx the parse tree
	 */
	void enterActual_parameter(MlangParser.Actual_parameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#actual_parameter}.
	 * @param ctx the parse tree
	 */
	void exitActual_parameter(MlangParser.Actual_parameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(MlangParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(MlangParser.ExpressionContext ctx);
}