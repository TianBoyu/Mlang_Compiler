// Generated from F:/programing/Compiler/M_Language_Compiler/Mlang_Compiler/src/Code/Parser\Mlang.g4 by ANTLR 4.7
package Code.Parser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MlangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, BOOL=30, INT=31, STRING=32, 
		NULL=33, VOID=34, TRUE=35, FALSE=36, IF=37, ELSE=38, FOR=39, WHILE=40, 
		BREAK=41, CONTINUE=42, RETURN=43, NEW=44, CLASS=45, THIS=46, NUM=47, ESC=48, 
		STR=49, COMMENT=50, BLOCK_COMMENT=51, MUL=52, DIV=53, ADD=54, SUB=55, 
		ID=56, WS=57;
	public static final int
		RULE_program = 0, RULE_classDecl = 1, RULE_functionDecl = 2, RULE_statement = 3, 
		RULE_variableDecl = 4, RULE_parameter = 5, RULE_formal_parameter = 6, 
		RULE_arrayType = 7, RULE_builtInType = 8, RULE_userType = 9, RULE_type = 10, 
		RULE_block = 11, RULE_actual_parameter = 12, RULE_expression = 13, RULE_functionCall = 14;
	public static final String[] ruleNames = {
		"program", "classDecl", "functionDecl", "statement", "variableDecl", "parameter", 
		"formal_parameter", "arrayType", "builtInType", "userType", "type", "block", 
		"actual_parameter", "expression", "functionCall"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "';'", "'='", "','", "'[]'", "'.'", 
		"'['", "']'", "'++'", "'--'", "'!'", "'~'", "'%'", "'<<'", "'>>'", "'<'", 
		"'<='", "'>'", "'>='", "'=='", "'!='", "'&'", "'^'", "'|'", "'&&'", "'||'", 
		"'bool'", "'int'", "'string'", "'null'", "'void'", "'true'", "'false'", 
		"'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", 
		"'new'", "'class'", "'this'", null, null, null, null, null, "'*'", "'/'", 
		"'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "BOOL", "INT", "STRING", "NULL", "VOID", 
		"TRUE", "FALSE", "IF", "ELSE", "FOR", "WHILE", "BREAK", "CONTINUE", "RETURN", 
		"NEW", "CLASS", "THIS", "NUM", "ESC", "STR", "COMMENT", "BLOCK_COMMENT", 
		"MUL", "DIV", "ADD", "SUB", "ID", "WS"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mlang.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MlangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class ProgramContext extends ParserRuleContext {
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<ClassDeclContext> classDecl() {
			return getRuleContexts(ClassDeclContext.class);
		}
		public ClassDeclContext classDecl(int i) {
			return getRuleContext(ClassDeclContext.class,i);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_program);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(35);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << ID))) != 0)) {
				{
				setState(33);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(30);
					variableDecl();
					}
					break;
				case 2:
					{
					setState(31);
					functionDecl();
					}
					break;
				case 3:
					{
					setState(32);
					classDecl();
					}
					break;
				}
				}
				setState(37);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ClassDeclContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MlangParser.CLASS, 0); }
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public List<FunctionDeclContext> functionDecl() {
			return getRuleContexts(FunctionDeclContext.class);
		}
		public FunctionDeclContext functionDecl(int i) {
			return getRuleContext(FunctionDeclContext.class,i);
		}
		public List<VariableDeclContext> variableDecl() {
			return getRuleContexts(VariableDeclContext.class);
		}
		public VariableDeclContext variableDecl(int i) {
			return getRuleContext(VariableDeclContext.class,i);
		}
		public ClassDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterClassDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitClassDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitClassDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclContext classDecl() throws RecognitionException {
		ClassDeclContext _localctx = new ClassDeclContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_classDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			match(CLASS);
			setState(39);
			match(ID);
			setState(40);
			match(T__0);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(43);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
				case 1:
					{
					setState(41);
					functionDecl();
					}
					break;
				case 2:
					{
					setState(42);
					variableDecl();
					}
					break;
				}
				}
				setState(47);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(48);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FunctionDeclContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public Formal_parameterContext formal_parameter() {
			return getRuleContext(Formal_parameterContext.class,0);
		}
		public FunctionDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterFunctionDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitFunctionDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitFunctionDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclContext functionDecl() throws RecognitionException {
		FunctionDeclContext _localctx = new FunctionDeclContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_functionDecl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(50);
				type();
				}
				break;
			}
			setState(53);
			match(ID);
			setState(54);
			match(T__2);
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << ID))) != 0)) {
				{
				setState(55);
				formal_parameter();
				}
			}

			setState(58);
			match(T__3);
			setState(59);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StatementContext extends ParserRuleContext {
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
	 
		public StatementContext() { }
		public void copyFrom(StatementContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class IfStatContext extends StatementContext {
		public TerminalNode IF() { return getToken(MlangParser.IF, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MlangParser.ELSE, 0); }
		public IfStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterIfStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitIfStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitIfStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockStatContext extends StatementContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public BlockStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterBlockStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitBlockStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitBlockStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VarDeclStatContext extends StatementContext {
		public VariableDeclContext variableDecl() {
			return getRuleContext(VariableDeclContext.class,0);
		}
		public VarDeclStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterVarDeclStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitVarDeclStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitVarDeclStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprStatContext extends StatementContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExprStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterExprStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitExprStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitExprStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ReturnStatContext extends StatementContext {
		public TerminalNode RETURN() { return getToken(MlangParser.RETURN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ReturnStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterReturnStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitReturnStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitReturnStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ContinueStatContext extends StatementContext {
		public TerminalNode CONTINUE() { return getToken(MlangParser.CONTINUE, 0); }
		public ContinueStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterContinueStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitContinueStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitContinueStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BreakStatContext extends StatementContext {
		public TerminalNode BREAK() { return getToken(MlangParser.BREAK, 0); }
		public BreakStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterBreakStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitBreakStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitBreakStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EmptyStatContext extends StatementContext {
		public EmptyStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterEmptyStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitEmptyStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitEmptyStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ForStatContext extends StatementContext {
		public ExpressionContext init;
		public ExpressionContext cond;
		public ExpressionContext update;
		public TerminalNode FOR() { return getToken(MlangParser.FOR, 0); }
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ForStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterForStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitForStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitForStat(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileStatContext extends StatementContext {
		public TerminalNode WHILE() { return getToken(MlangParser.WHILE, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public WhileStatContext(StatementContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterWhileStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitWhileStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitWhileStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_statement);
		int _la;
		try {
			setState(106);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new BlockStatContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(61);
				block();
				}
				break;
			case 2:
				_localctx = new VarDeclStatContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				variableDecl();
				}
				break;
			case 3:
				_localctx = new IfStatContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(63);
				match(IF);
				setState(64);
				match(T__2);
				setState(65);
				expression(0);
				setState(66);
				match(T__3);
				setState(67);
				statement();
				setState(70);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
				case 1:
					{
					setState(68);
					match(ELSE);
					setState(69);
					statement();
					}
					break;
				}
				}
				break;
			case 4:
				_localctx = new ForStatContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(72);
				match(FOR);
				setState(73);
				match(T__2);
				setState(75);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(74);
					((ForStatContext)_localctx).init = expression(0);
					}
				}

				setState(77);
				match(T__4);
				setState(79);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(78);
					((ForStatContext)_localctx).cond = expression(0);
					}
				}

				setState(81);
				match(T__4);
				setState(83);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(82);
					((ForStatContext)_localctx).update = expression(0);
					}
				}

				setState(85);
				match(T__3);
				setState(86);
				statement();
				}
				break;
			case 5:
				_localctx = new WhileStatContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				match(WHILE);
				setState(88);
				match(T__2);
				setState(89);
				expression(0);
				setState(90);
				match(T__3);
				setState(91);
				statement();
				}
				break;
			case 6:
				_localctx = new ReturnStatContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(93);
				match(RETURN);
				setState(95);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(94);
					expression(0);
					}
				}

				setState(97);
				match(T__4);
				}
				break;
			case 7:
				_localctx = new BreakStatContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(98);
				match(BREAK);
				setState(99);
				match(T__4);
				}
				break;
			case 8:
				_localctx = new ContinueStatContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(100);
				match(CONTINUE);
				setState(101);
				match(T__4);
				}
				break;
			case 9:
				_localctx = new ExprStatContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(102);
				expression(0);
				setState(103);
				match(T__4);
				}
				break;
			case 10:
				_localctx = new EmptyStatContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(105);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class VariableDeclContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VariableDeclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDecl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterVariableDecl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitVariableDecl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitVariableDecl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclContext variableDecl() throws RecognitionException {
		VariableDeclContext _localctx = new VariableDeclContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_variableDecl);
		try {
			setState(118);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(108);
				type();
				setState(109);
				match(ID);
				setState(110);
				match(T__5);
				setState(111);
				expression(0);
				setState(112);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(114);
				type();
				setState(115);
				match(ID);
				setState(116);
				match(T__4);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ParameterContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_parameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(120);
			type();
			setState(121);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Formal_parameterContext extends ParserRuleContext {
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public Formal_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterFormal_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitFormal_parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitFormal_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_parameterContext formal_parameter() throws RecognitionException {
		Formal_parameterContext _localctx = new Formal_parameterContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_formal_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(123);
			parameter();
			setState(128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(124);
				match(T__6);
				setState(125);
				parameter();
				}
				}
				setState(130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayTypeContext extends ParserRuleContext {
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public ArrayTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterArrayType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitArrayType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitArrayType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayTypeContext arrayType() throws RecognitionException {
		ArrayTypeContext _localctx = new ArrayTypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arrayType);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case BOOL:
			case INT:
			case STRING:
			case VOID:
				{
				setState(131);
				builtInType();
				}
				break;
			case ID:
				{
				setState(132);
				userType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(136); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(135);
					match(T__7);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(138); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BuiltInTypeContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(MlangParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(MlangParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MlangParser.STRING, 0); }
		public TerminalNode VOID() { return getToken(MlangParser.VOID, 0); }
		public BuiltInTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_builtInType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterBuiltInType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitBuiltInType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitBuiltInType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BuiltInTypeContext builtInType() throws RecognitionException {
		BuiltInTypeContext _localctx = new BuiltInTypeContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_builtInType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UserTypeContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public UserTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterUserType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitUserType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitUserType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserTypeContext userType() throws RecognitionException {
		UserTypeContext _localctx = new UserTypeContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_userType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(ID);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public ArrayTypeContext arrayType() {
			return getRuleContext(ArrayTypeContext.class,0);
		}
		public BuiltInTypeContext builtInType() {
			return getRuleContext(BuiltInTypeContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_type);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(144);
				arrayType();
				}
				break;
			case 2:
				{
				setState(145);
				builtInType();
				}
				break;
			case 3:
				{
				setState(146);
				userType();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BlockContext extends ParserRuleContext {
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(149);
			match(T__0);
			setState(153);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__4) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << NULL) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONTINUE) | (1L << RETURN) | (1L << NEW) | (1L << THIS) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				{
				setState(150);
				statement();
				}
				}
				setState(155);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(156);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Actual_parameterContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public Actual_parameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actual_parameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterActual_parameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitActual_parameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitActual_parameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Actual_parameterContext actual_parameter() throws RecognitionException {
		Actual_parameterContext _localctx = new Actual_parameterContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_actual_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			expression(0);
			setState(163);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__6) {
				{
				{
				setState(159);
				match(T__6);
				setState(160);
				expression(0);
				}
				}
				setState(165);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NewExprContext extends ExpressionContext {
		public TerminalNode NEW() { return getToken(MlangParser.NEW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public NewExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterNewExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitNewExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitNewExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BoolConstExprContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(MlangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MlangParser.FALSE, 0); }
		public BoolConstExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterBoolConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitBoolConstExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitBoolConstExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ThisExprContext extends ExpressionContext {
		public TerminalNode THIS() { return getToken(MlangParser.THIS, 0); }
		public ThisExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterThisExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitThisExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitThisExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NullExprContext extends ExpressionContext {
		public TerminalNode NULL() { return getToken(MlangParser.NULL, 0); }
		public NullExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterNullExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitNullExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitNullExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ArrayExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ArrayExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterArrayExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitArrayExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitArrayExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MemberExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public MemberExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterMemberExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitMemberExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitMemberExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SuffixExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SuffixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterSuffixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitSuffixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitSuffixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BinaryExprContext extends ExpressionContext {
		public Token op;
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public BinaryExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterBinaryExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitBinaryExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitBinaryExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterOrExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitOrExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitOrExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IntConstExprContext extends ExpressionContext {
		public TerminalNode NUM() { return getToken(MlangParser.NUM, 0); }
		public IntConstExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterIntConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitIntConstExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitIntConstExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SubExprContext extends ExpressionContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SubExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterSubExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitSubExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitSubExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PrefixExprContext extends ExpressionContext {
		public Token op;
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public PrefixExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterPrefixExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitPrefixExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitPrefixExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class StringConstExprContext extends ExpressionContext {
		public TerminalNode STR() { return getToken(MlangParser.STR, 0); }
		public StringConstExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterStringConstExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitStringConstExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitStringConstExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallExprContext extends ExpressionContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public CallExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterCallExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitCallExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitCallExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AssignExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AssignExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterAssignExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitAssignExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitAssignExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IdExprContext extends ExpressionContext {
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public IdExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterIdExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitIdExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitIdExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndExprContext extends ExpressionContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndExprContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterAndExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitAndExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitAndExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_expression, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				_localctx = new CallExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(167);
				functionCall();
				}
				break;
			case 2:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(168);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__11 || _la==T__12) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(169);
				expression(23);
				}
				break;
			case 3:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(170);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(171);
				expression(22);
				}
				break;
			case 4:
				{
				_localctx = new PrefixExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(172);
				((PrefixExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__13 || _la==T__14) ) {
					((PrefixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(173);
				expression(21);
				}
				break;
			case 5:
				{
				_localctx = new NewExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(174);
				match(NEW);
				setState(175);
				type();
				setState(190);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
				case 1:
					{
					setState(180); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(176);
							match(T__9);
							setState(177);
							expression(0);
							setState(178);
							match(T__10);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(182); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(187);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(184);
							match(T__7);
							}
							} 
						}
						setState(189);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 6:
				{
				_localctx = new IntConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(192);
				match(NUM);
				}
				break;
			case 7:
				{
				_localctx = new BoolConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(193);
				match(TRUE);
				}
				break;
			case 8:
				{
				_localctx = new BoolConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(194);
				match(FALSE);
				}
				break;
			case 9:
				{
				_localctx = new NullExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(195);
				match(NULL);
				}
				break;
			case 10:
				{
				_localctx = new StringConstExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(196);
				match(STR);
				}
				break;
			case 11:
				{
				_localctx = new IdExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(197);
				match(ID);
				}
				break;
			case 12:
				{
				_localctx = new SubExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(198);
				match(T__2);
				setState(199);
				expression(0);
				setState(200);
				match(T__3);
				}
				break;
			case 13:
				{
				_localctx = new ThisExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(202);
				match(THIS);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(251);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(205);
						if (!(precpred(_ctx, 19))) throw new FailedPredicateException(this, "precpred(_ctx, 19)");
						setState(206);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << MUL) | (1L << DIV))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(207);
						expression(20);
						}
						break;
					case 2:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(208);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(209);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(210);
						expression(19);
						}
						break;
					case 3:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(211);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(212);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__16 || _la==T__17) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(213);
						expression(18);
						}
						break;
					case 4:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(214);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(215);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__18) | (1L << T__19) | (1L << T__20) | (1L << T__21))) != 0)) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(216);
						expression(17);
						}
						break;
					case 5:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(217);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(218);
						((BinaryExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__22 || _la==T__23) ) {
							((BinaryExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(219);
						expression(16);
						}
						break;
					case 6:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(220);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(221);
						match(T__24);
						setState(222);
						expression(15);
						}
						break;
					case 7:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(223);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(224);
						match(T__25);
						setState(225);
						expression(14);
						}
						break;
					case 8:
						{
						_localctx = new BinaryExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(226);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(227);
						match(T__26);
						setState(228);
						expression(13);
						}
						break;
					case 9:
						{
						_localctx = new AndExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(229);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(230);
						match(T__27);
						setState(231);
						expression(12);
						}
						break;
					case 10:
						{
						_localctx = new OrExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(232);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(233);
						match(T__28);
						setState(234);
						expression(11);
						}
						break;
					case 11:
						{
						_localctx = new AssignExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(235);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(236);
						match(T__5);
						setState(237);
						expression(2);
						}
						break;
					case 12:
						{
						_localctx = new MemberExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(238);
						if (!(precpred(_ctx, 27))) throw new FailedPredicateException(this, "precpred(_ctx, 27)");
						setState(239);
						match(T__8);
						setState(242);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
						case 1:
							{
							setState(240);
							match(ID);
							}
							break;
						case 2:
							{
							setState(241);
							functionCall();
							}
							break;
						}
						}
						break;
					case 13:
						{
						_localctx = new ArrayExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(244);
						if (!(precpred(_ctx, 26))) throw new FailedPredicateException(this, "precpred(_ctx, 26)");
						setState(245);
						match(T__9);
						setState(246);
						expression(0);
						setState(247);
						match(T__10);
						}
						break;
					case 14:
						{
						_localctx = new SuffixExprContext(new ExpressionContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(249);
						if (!(precpred(_ctx, 25))) throw new FailedPredicateException(this, "precpred(_ctx, 25)");
						setState(250);
						((SuffixExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__11 || _la==T__12) ) {
							((SuffixExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						}
						break;
					}
					} 
				}
				setState(255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public Actual_parameterContext actual_parameter() {
			return getRuleContext(Actual_parameterContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterFunctionCall(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitFunctionCall(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(256);
			match(ID);
			setState(257);
			match(T__2);
			setState(259);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__11) | (1L << T__12) | (1L << T__13) | (1L << T__14) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << THIS) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				setState(258);
				actual_parameter();
				}
			}

			setState(261);
			match(T__3);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 19);
		case 1:
			return precpred(_ctx, 18);
		case 2:
			return precpred(_ctx, 17);
		case 3:
			return precpred(_ctx, 16);
		case 4:
			return precpred(_ctx, 15);
		case 5:
			return precpred(_ctx, 14);
		case 6:
			return precpred(_ctx, 13);
		case 7:
			return precpred(_ctx, 12);
		case 8:
			return precpred(_ctx, 11);
		case 9:
			return precpred(_ctx, 10);
		case 10:
			return precpred(_ctx, 1);
		case 11:
			return precpred(_ctx, 27);
		case 12:
			return precpred(_ctx, 26);
		case 13:
			return precpred(_ctx, 25);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3;\u010a\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\3\2\3\2\3\2\7\2$\n\2"+
		"\f\2\16\2\'\13\2\3\3\3\3\3\3\3\3\3\3\7\3.\n\3\f\3\16\3\61\13\3\3\3\3\3"+
		"\3\4\5\4\66\n\4\3\4\3\4\3\4\5\4;\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3"+
		"\5\3\5\3\5\3\5\5\5I\n\5\3\5\3\5\3\5\5\5N\n\5\3\5\3\5\5\5R\n\5\3\5\3\5"+
		"\5\5V\n\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5b\n\5\3\5\3\5\3\5"+
		"\3\5\3\5\3\5\3\5\3\5\3\5\5\5m\n\5\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\5\6y\n\6\3\7\3\7\3\7\3\b\3\b\3\b\7\b\u0081\n\b\f\b\16\b\u0084\13"+
		"\b\3\t\3\t\5\t\u0088\n\t\3\t\6\t\u008b\n\t\r\t\16\t\u008c\3\n\3\n\3\13"+
		"\3\13\3\f\3\f\3\f\5\f\u0096\n\f\3\r\3\r\7\r\u009a\n\r\f\r\16\r\u009d\13"+
		"\r\3\r\3\r\3\16\3\16\3\16\7\16\u00a4\n\16\f\16\16\16\u00a7\13\16\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\6\17"+
		"\u00b7\n\17\r\17\16\17\u00b8\3\17\7\17\u00bc\n\17\f\17\16\17\u00bf\13"+
		"\17\5\17\u00c1\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\5\17\u00ce\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17"+
		"\u00f5\n\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00fe\n\17\f\17\16"+
		"\17\u0101\13\17\3\20\3\20\3\20\5\20\u0106\n\20\3\20\3\20\3\20\2\3\34\21"+
		"\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36\2\n\4\2 \"$$\3\2\16\17\3\289\3"+
		"\2\20\21\4\2\22\22\66\67\3\2\23\24\3\2\25\30\3\2\31\32\2\u0136\2%\3\2"+
		"\2\2\4(\3\2\2\2\6\65\3\2\2\2\bl\3\2\2\2\nx\3\2\2\2\fz\3\2\2\2\16}\3\2"+
		"\2\2\20\u0087\3\2\2\2\22\u008e\3\2\2\2\24\u0090\3\2\2\2\26\u0095\3\2\2"+
		"\2\30\u0097\3\2\2\2\32\u00a0\3\2\2\2\34\u00cd\3\2\2\2\36\u0102\3\2\2\2"+
		" $\5\n\6\2!$\5\6\4\2\"$\5\4\3\2# \3\2\2\2#!\3\2\2\2#\"\3\2\2\2$\'\3\2"+
		"\2\2%#\3\2\2\2%&\3\2\2\2&\3\3\2\2\2\'%\3\2\2\2()\7/\2\2)*\7:\2\2*/\7\3"+
		"\2\2+.\5\6\4\2,.\5\n\6\2-+\3\2\2\2-,\3\2\2\2.\61\3\2\2\2/-\3\2\2\2/\60"+
		"\3\2\2\2\60\62\3\2\2\2\61/\3\2\2\2\62\63\7\4\2\2\63\5\3\2\2\2\64\66\5"+
		"\26\f\2\65\64\3\2\2\2\65\66\3\2\2\2\66\67\3\2\2\2\678\7:\2\28:\7\5\2\2"+
		"9;\5\16\b\2:9\3\2\2\2:;\3\2\2\2;<\3\2\2\2<=\7\6\2\2=>\5\30\r\2>\7\3\2"+
		"\2\2?m\5\30\r\2@m\5\n\6\2AB\7\'\2\2BC\7\5\2\2CD\5\34\17\2DE\7\6\2\2EH"+
		"\5\b\5\2FG\7(\2\2GI\5\b\5\2HF\3\2\2\2HI\3\2\2\2Im\3\2\2\2JK\7)\2\2KM\7"+
		"\5\2\2LN\5\34\17\2ML\3\2\2\2MN\3\2\2\2NO\3\2\2\2OQ\7\7\2\2PR\5\34\17\2"+
		"QP\3\2\2\2QR\3\2\2\2RS\3\2\2\2SU\7\7\2\2TV\5\34\17\2UT\3\2\2\2UV\3\2\2"+
		"\2VW\3\2\2\2WX\7\6\2\2Xm\5\b\5\2YZ\7*\2\2Z[\7\5\2\2[\\\5\34\17\2\\]\7"+
		"\6\2\2]^\5\b\5\2^m\3\2\2\2_a\7-\2\2`b\5\34\17\2a`\3\2\2\2ab\3\2\2\2bc"+
		"\3\2\2\2cm\7\7\2\2de\7+\2\2em\7\7\2\2fg\7,\2\2gm\7\7\2\2hi\5\34\17\2i"+
		"j\7\7\2\2jm\3\2\2\2km\7\7\2\2l?\3\2\2\2l@\3\2\2\2lA\3\2\2\2lJ\3\2\2\2"+
		"lY\3\2\2\2l_\3\2\2\2ld\3\2\2\2lf\3\2\2\2lh\3\2\2\2lk\3\2\2\2m\t\3\2\2"+
		"\2no\5\26\f\2op\7:\2\2pq\7\b\2\2qr\5\34\17\2rs\7\7\2\2sy\3\2\2\2tu\5\26"+
		"\f\2uv\7:\2\2vw\7\7\2\2wy\3\2\2\2xn\3\2\2\2xt\3\2\2\2y\13\3\2\2\2z{\5"+
		"\26\f\2{|\7:\2\2|\r\3\2\2\2}\u0082\5\f\7\2~\177\7\t\2\2\177\u0081\5\f"+
		"\7\2\u0080~\3\2\2\2\u0081\u0084\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083"+
		"\3\2\2\2\u0083\17\3\2\2\2\u0084\u0082\3\2\2\2\u0085\u0088\5\22\n\2\u0086"+
		"\u0088\5\24\13\2\u0087\u0085\3\2\2\2\u0087\u0086\3\2\2\2\u0088\u008a\3"+
		"\2\2\2\u0089\u008b\7\n\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\21\3\2\2\2\u008e\u008f\t\2\2"+
		"\2\u008f\23\3\2\2\2\u0090\u0091\7:\2\2\u0091\25\3\2\2\2\u0092\u0096\5"+
		"\20\t\2\u0093\u0096\5\22\n\2\u0094\u0096\5\24\13\2\u0095\u0092\3\2\2\2"+
		"\u0095\u0093\3\2\2\2\u0095\u0094\3\2\2\2\u0096\27\3\2\2\2\u0097\u009b"+
		"\7\3\2\2\u0098\u009a\5\b\5\2\u0099\u0098\3\2\2\2\u009a\u009d\3\2\2\2\u009b"+
		"\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c\u009e\3\2\2\2\u009d\u009b\3\2"+
		"\2\2\u009e\u009f\7\4\2\2\u009f\31\3\2\2\2\u00a0\u00a5\5\34\17\2\u00a1"+
		"\u00a2\7\t\2\2\u00a2\u00a4\5\34\17\2\u00a3\u00a1\3\2\2\2\u00a4\u00a7\3"+
		"\2\2\2\u00a5\u00a3\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\33\3\2\2\2\u00a7"+
		"\u00a5\3\2\2\2\u00a8\u00a9\b\17\1\2\u00a9\u00ce\5\36\20\2\u00aa\u00ab"+
		"\t\3\2\2\u00ab\u00ce\5\34\17\31\u00ac\u00ad\t\4\2\2\u00ad\u00ce\5\34\17"+
		"\30\u00ae\u00af\t\5\2\2\u00af\u00ce\5\34\17\27\u00b0\u00b1\7.\2\2\u00b1"+
		"\u00c0\5\26\f\2\u00b2\u00b3\7\f\2\2\u00b3\u00b4\5\34\17\2\u00b4\u00b5"+
		"\7\r\2\2\u00b5\u00b7\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b7\u00b8\3\2\2\2\u00b8"+
		"\u00b6\3\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\u00bd\3\2\2\2\u00ba\u00bc\7\n"+
		"\2\2\u00bb\u00ba\3\2\2\2\u00bc\u00bf\3\2\2\2\u00bd\u00bb\3\2\2\2\u00bd"+
		"\u00be\3\2\2\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00c0\u00b6\3\2"+
		"\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00ce\3\2\2\2\u00c2\u00ce\7\61\2\2\u00c3"+
		"\u00ce\7%\2\2\u00c4\u00ce\7&\2\2\u00c5\u00ce\7#\2\2\u00c6\u00ce\7\63\2"+
		"\2\u00c7\u00ce\7:\2\2\u00c8\u00c9\7\5\2\2\u00c9\u00ca\5\34\17\2\u00ca"+
		"\u00cb\7\6\2\2\u00cb\u00ce\3\2\2\2\u00cc\u00ce\7\60\2\2\u00cd\u00a8\3"+
		"\2\2\2\u00cd\u00aa\3\2\2\2\u00cd\u00ac\3\2\2\2\u00cd\u00ae\3\2\2\2\u00cd"+
		"\u00b0\3\2\2\2\u00cd\u00c2\3\2\2\2\u00cd\u00c3\3\2\2\2\u00cd\u00c4\3\2"+
		"\2\2\u00cd\u00c5\3\2\2\2\u00cd\u00c6\3\2\2\2\u00cd\u00c7\3\2\2\2\u00cd"+
		"\u00c8\3\2\2\2\u00cd\u00cc\3\2\2\2\u00ce\u00ff\3\2\2\2\u00cf\u00d0\f\25"+
		"\2\2\u00d0\u00d1\t\6\2\2\u00d1\u00fe\5\34\17\26\u00d2\u00d3\f\24\2\2\u00d3"+
		"\u00d4\t\4\2\2\u00d4\u00fe\5\34\17\25\u00d5\u00d6\f\23\2\2\u00d6\u00d7"+
		"\t\7\2\2\u00d7\u00fe\5\34\17\24\u00d8\u00d9\f\22\2\2\u00d9\u00da\t\b\2"+
		"\2\u00da\u00fe\5\34\17\23\u00db\u00dc\f\21\2\2\u00dc\u00dd\t\t\2\2\u00dd"+
		"\u00fe\5\34\17\22\u00de\u00df\f\20\2\2\u00df\u00e0\7\33\2\2\u00e0\u00fe"+
		"\5\34\17\21\u00e1\u00e2\f\17\2\2\u00e2\u00e3\7\34\2\2\u00e3\u00fe\5\34"+
		"\17\20\u00e4\u00e5\f\16\2\2\u00e5\u00e6\7\35\2\2\u00e6\u00fe\5\34\17\17"+
		"\u00e7\u00e8\f\r\2\2\u00e8\u00e9\7\36\2\2\u00e9\u00fe\5\34\17\16\u00ea"+
		"\u00eb\f\f\2\2\u00eb\u00ec\7\37\2\2\u00ec\u00fe\5\34\17\r\u00ed\u00ee"+
		"\f\3\2\2\u00ee\u00ef\7\b\2\2\u00ef\u00fe\5\34\17\4\u00f0\u00f1\f\35\2"+
		"\2\u00f1\u00f4\7\13\2\2\u00f2\u00f5\7:\2\2\u00f3\u00f5\5\36\20\2\u00f4"+
		"\u00f2\3\2\2\2\u00f4\u00f3\3\2\2\2\u00f5\u00fe\3\2\2\2\u00f6\u00f7\f\34"+
		"\2\2\u00f7\u00f8\7\f\2\2\u00f8\u00f9\5\34\17\2\u00f9\u00fa\7\r\2\2\u00fa"+
		"\u00fe\3\2\2\2\u00fb\u00fc\f\33\2\2\u00fc\u00fe\t\3\2\2\u00fd\u00cf\3"+
		"\2\2\2\u00fd\u00d2\3\2\2\2\u00fd\u00d5\3\2\2\2\u00fd\u00d8\3\2\2\2\u00fd"+
		"\u00db\3\2\2\2\u00fd\u00de\3\2\2\2\u00fd\u00e1\3\2\2\2\u00fd\u00e4\3\2"+
		"\2\2\u00fd\u00e7\3\2\2\2\u00fd\u00ea\3\2\2\2\u00fd\u00ed\3\2\2\2\u00fd"+
		"\u00f0\3\2\2\2\u00fd\u00f6\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fe\u0101\3\2"+
		"\2\2\u00ff\u00fd\3\2\2\2\u00ff\u0100\3\2\2\2\u0100\35\3\2\2\2\u0101\u00ff"+
		"\3\2\2\2\u0102\u0103\7:\2\2\u0103\u0105\7\5\2\2\u0104\u0106\5\32\16\2"+
		"\u0105\u0104\3\2\2\2\u0105\u0106\3\2\2\2\u0106\u0107\3\2\2\2\u0107\u0108"+
		"\7\6\2\2\u0108\37\3\2\2\2\35#%-/\65:HMQUalx\u0082\u0087\u008c\u0095\u009b"+
		"\u00a5\u00b8\u00bd\u00c0\u00cd\u00f4\u00fd\u00ff\u0105";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}