// Generated from F:/programing/Compiler/M_Language_Compiler/Mlang_Compiler/src/Code/Parser\Mlang.g4 by ANTLR 4.7
package Code.Parser;
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
	 * Visit a parse tree produced by {@link MlangParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MlangParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#classDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDecl(MlangParser.ClassDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#functionDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDecl(MlangParser.FunctionDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#variableDecl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDecl(MlangParser.VariableDeclContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(MlangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#builtInType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBuiltInType(MlangParser.BuiltInTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#userType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserType(MlangParser.UserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MlangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(MlangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(MlangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#actual_parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitActual_parameter(MlangParser.Actual_parameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(MlangParser.ExpressionContext ctx);
}