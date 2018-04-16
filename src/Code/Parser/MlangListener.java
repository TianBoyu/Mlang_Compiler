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
	 * Enter a parse tree produced by {@link MlangParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void enterArrayType(MlangParser.ArrayTypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MlangParser#arrayType}.
	 * @param ctx the parse tree
	 */
	void exitArrayType(MlangParser.ArrayTypeContext ctx);
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
	 * Enter a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBlockStat(MlangParser.BlockStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blockStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBlockStat(MlangParser.BlockStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterVarDeclStat(MlangParser.VarDeclStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code varDeclStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitVarDeclStat(MlangParser.VarDeclStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterIfStat(MlangParser.IfStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitIfStat(MlangParser.IfStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterForStat(MlangParser.ForStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code forStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitForStat(MlangParser.ForStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterWhileStat(MlangParser.WhileStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code whileStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitWhileStat(MlangParser.WhileStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterReturnStat(MlangParser.ReturnStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitReturnStat(MlangParser.ReturnStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterBreakStat(MlangParser.BreakStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code breakStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitBreakStat(MlangParser.BreakStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterContinueStat(MlangParser.ContinueStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code continueStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitContinueStat(MlangParser.ContinueStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterExprStat(MlangParser.ExprStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exprStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitExprStat(MlangParser.ExprStatContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void enterEmptyStat(MlangParser.EmptyStatContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptyStat}
	 * labeled alternative in {@link MlangParser#statement}.
	 * @param ctx the parse tree
	 */
	void exitEmptyStat(MlangParser.EmptyStatContext ctx);
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
	 * Enter a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNewExpr(MlangParser.NewExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code newExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNewExpr(MlangParser.NewExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code boolConstExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBoolConstExpr(MlangParser.BoolConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code boolConstExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBoolConstExpr(MlangParser.BoolConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterThisExpr(MlangParser.ThisExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code thisExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitThisExpr(MlangParser.ThisExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNullExpr(MlangParser.NullExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code nullExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNullExpr(MlangParser.NullExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(MlangParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code arrayExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(MlangParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMemberExpr(MlangParser.MemberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code memberExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMemberExpr(MlangParser.MemberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSuffixExpr(MlangParser.SuffixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code suffixExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSuffixExpr(MlangParser.SuffixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBinaryExpr(MlangParser.BinaryExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code binaryExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBinaryExpr(MlangParser.BinaryExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrExpr(MlangParser.OrExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrExpr(MlangParser.OrExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code intConstExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIntConstExpr(MlangParser.IntConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code intConstExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIntConstExpr(MlangParser.IntConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterSubExpr(MlangParser.SubExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code subExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitSubExpr(MlangParser.SubExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterPrefixExpr(MlangParser.PrefixExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code prefixExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitPrefixExpr(MlangParser.PrefixExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code stringConstExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterStringConstExpr(MlangParser.StringConstExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code stringConstExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitStringConstExpr(MlangParser.StringConstExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterCallExpr(MlangParser.CallExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code callExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitCallExpr(MlangParser.CallExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAssignExpr(MlangParser.AssignExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code assignExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAssignExpr(MlangParser.AssignExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIdExpr(MlangParser.IdExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code idExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIdExpr(MlangParser.IdExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndExpr(MlangParser.AndExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andExpr}
	 * labeled alternative in {@link MlangParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndExpr(MlangParser.AndExprContext ctx);
}