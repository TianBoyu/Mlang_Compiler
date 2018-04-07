package Parser;
// Generated from F:/programing/Compiler/M_Language_Compiler/Mlang_Compiler/src\Mlang.g4 by ANTLR 4.7
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
		BREAK=41, CONTI=42, RETURN=43, NEW=44, CLASS=45, THIS=46, NUM=47, ESC=48, 
		STR=49, COMMENT=50, MUL=51, DIV=52, ADD=53, SUB=54, ID=55, WS=56;
	public static final int
		RULE_prog = 0, RULE_class_def = 1, RULE_func_def = 2, RULE_var_dec = 3, 
		RULE_stat = 4, RULE_cond_stat = 5, RULE_circ_stat = 6, RULE_jump_stat = 7, 
		RULE_expr_stat = 8, RULE_decl_stat = 9, RULE_expr = 10, RULE_actual_parameters = 11, 
		RULE_formal_parameters = 12, RULE_assign_expr = 13, RULE_id = 14, RULE_class_id = 15, 
		RULE_class_type = 16;
	public static final String[] ruleNames = {
		"prog", "class_def", "func_def", "var_dec", "stat", "cond_stat", "circ_stat", 
		"jump_stat", "expr_stat", "decl_stat", "expr", "actual_parameters", "formal_parameters", 
		"assign_expr", "id", "class_id", "class_type"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'('", "')'", "';'", "'++'", "'--'", "'!'", "'~'", 
		"'['", "']'", "'[]'", "'%'", "'<<'", "'>>'", "'<'", "'<='", "'>'", "'>='", 
		"'=='", "'!='", "'&'", "'^'", "'|'", "'&&'", "'||'", "','", "'='", "'.'", 
		"'bool'", "'int'", "'string'", "'null'", "'void'", "'true'", "'false'", 
		"'if'", "'else'", "'for'", "'while'", "'break'", "'continue'", "'return'", 
		"'new'", "'class'", "'this'", null, null, null, "'//'", "'*'", "'/'", 
		"'+'", "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, "BOOL", "INT", "STRING", "NULL", "VOID", 
		"TRUE", "FALSE", "IF", "ELSE", "FOR", "WHILE", "BREAK", "CONTI", "RETURN", 
		"NEW", "CLASS", "THIS", "NUM", "ESC", "STR", "COMMENT", "MUL", "DIV", 
		"ADD", "SUB", "ID", "WS"
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
	public String getGrammarFileName() { return "Parser/Mlang.g4"; }

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
	public static class ProgContext extends ParserRuleContext {
		public List<Func_defContext> func_def() {
			return getRuleContexts(Func_defContext.class);
		}
		public Func_defContext func_def(int i) {
			return getRuleContext(Func_defContext.class,i);
		}
		public List<Class_defContext> class_def() {
			return getRuleContexts(Class_defContext.class);
		}
		public Class_defContext class_def(int i) {
			return getRuleContext(Class_defContext.class,i);
		}
		public List<Var_decContext> var_dec() {
			return getRuleContexts(Var_decContext.class);
		}
		public Var_decContext var_dec(int i) {
			return getRuleContext(Var_decContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(37); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(37);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(34);
					func_def();
					}
					break;
				case 2:
					{
					setState(35);
					class_def();
					}
					break;
				case 3:
					{
					setState(36);
					var_dec();
					}
					break;
				}
				}
				setState(39); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << CLASS) | (1L << ID))) != 0) );
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

	public static class Class_defContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MlangParser.CLASS, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ProgContext prog() {
			return getRuleContext(ProgContext.class,0);
		}
		public Class_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterClass_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitClass_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitClass_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_defContext class_def() throws RecognitionException {
		Class_defContext _localctx = new Class_defContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_class_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(CLASS);
			setState(42);
			id(0);
			setState(43);
			match(T__0);
			setState(44);
			prog();
			setState(45);
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

	public static class Func_defContext extends ParserRuleContext {
		public Class_typeContext class_type() {
			return getRuleContext(Class_typeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Formal_parametersContext formal_parameters() {
			return getRuleContext(Formal_parametersContext.class,0);
		}
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public Func_defContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_def; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterFunc_def(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitFunc_def(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitFunc_def(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_defContext func_def() throws RecognitionException {
		Func_defContext _localctx = new Func_defContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_func_def);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(47);
			class_type();
			setState(48);
			id(0);
			setState(49);
			match(T__2);
			setState(50);
			formal_parameters(0);
			setState(51);
			match(T__3);
			setState(52);
			match(T__0);
			setState(53);
			stat();
			setState(54);
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

	public static class Var_decContext extends ParserRuleContext {
		public Class_typeContext class_type() {
			return getRuleContext(Class_typeContext.class,0);
		}
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public Var_decContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_dec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterVar_dec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitVar_dec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitVar_dec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_decContext var_dec() throws RecognitionException {
		Var_decContext _localctx = new Var_decContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_var_dec);
		try {
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(56);
				class_type();
				setState(57);
				assign_expr();
				setState(58);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				class_type();
				setState(61);
				match(ID);
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

	public static class StatContext extends ParserRuleContext {
		public Cond_statContext cond_stat() {
			return getRuleContext(Cond_statContext.class,0);
		}
		public Circ_statContext circ_stat() {
			return getRuleContext(Circ_statContext.class,0);
		}
		public Jump_statContext jump_stat() {
			return getRuleContext(Jump_statContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public Expr_statContext expr_stat() {
			return getRuleContext(Expr_statContext.class,0);
		}
		public Decl_statContext decl_stat() {
			return getRuleContext(Decl_statContext.class,0);
		}
		public StatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterStat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitStat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitStat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatContext stat() throws RecognitionException {
		StatContext _localctx = new StatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_stat);
		int _la;
		try {
			setState(78);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(65);
				cond_stat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(66);
				circ_stat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(67);
				jump_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(68);
				match(T__0);
				setState(70); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(69);
					stat();
					}
					}
					setState(72); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << NULL) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONTI) | (1L << RETURN) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0) );
				setState(74);
				match(T__1);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(76);
				expr_stat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				decl_stat();
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

	public static class Cond_statContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MlangParser.IF, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(MlangParser.ELSE, 0); }
		public Cond_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cond_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterCond_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitCond_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitCond_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Cond_statContext cond_stat() throws RecognitionException {
		Cond_statContext _localctx = new Cond_statContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_cond_stat);
		try {
			setState(94);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(80);
				match(IF);
				setState(81);
				match(T__2);
				setState(82);
				expr(0);
				setState(83);
				match(T__3);
				setState(84);
				stat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(IF);
				setState(87);
				match(T__2);
				setState(88);
				expr(0);
				setState(89);
				match(T__3);
				setState(90);
				stat();
				setState(91);
				match(ELSE);
				setState(92);
				stat();
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

	public static class Circ_statContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(MlangParser.FOR, 0); }
		public StatContext stat() {
			return getRuleContext(StatContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode WHILE() { return getToken(MlangParser.WHILE, 0); }
		public Circ_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_circ_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterCirc_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitCirc_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitCirc_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Circ_statContext circ_stat() throws RecognitionException {
		Circ_statContext _localctx = new Circ_statContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_circ_stat);
		int _la;
		try {
			setState(117);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(96);
				match(FOR);
				setState(97);
				match(T__2);
				setState(99);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(98);
					expr(0);
					}
				}

				setState(101);
				match(T__4);
				setState(103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(102);
					expr(0);
					}
				}

				setState(105);
				match(T__4);
				setState(107);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(106);
					expr(0);
					}
				}

				setState(109);
				match(T__3);
				setState(110);
				stat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(111);
				match(WHILE);
				setState(112);
				match(T__2);
				setState(113);
				expr(0);
				setState(114);
				match(T__3);
				setState(115);
				stat();
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Jump_statContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MlangParser.RETURN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(MlangParser.BREAK, 0); }
		public TerminalNode CONTI() { return getToken(MlangParser.CONTI, 0); }
		public Jump_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterJump_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitJump_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitJump_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jump_statContext jump_stat() throws RecognitionException {
		Jump_statContext _localctx = new Jump_statContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_jump_stat);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				setState(119);
				match(RETURN);
				setState(121);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(120);
					expr(0);
					}
				}

				setState(123);
				match(T__4);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(BREAK);
				setState(125);
				match(T__4);
				}
				break;
			case CONTI:
				enterOuterAlt(_localctx, 3);
				{
				setState(126);
				match(CONTI);
				setState(127);
				match(T__4);
				}
				break;
			default:
				throw new NoViableAltException(this);
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

	public static class Expr_statContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterExpr_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitExpr_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitExpr_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_statContext expr_stat() throws RecognitionException {
		Expr_statContext _localctx = new Expr_statContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_expr_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			expr(0);
			setState(131);
			match(T__4);
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

	public static class Decl_statContext extends ParserRuleContext {
		public Var_decContext var_dec() {
			return getRuleContext(Var_decContext.class,0);
		}
		public Decl_statContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_decl_stat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterDecl_stat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitDecl_stat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitDecl_stat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Decl_statContext decl_stat() throws RecognitionException {
		Decl_statContext _localctx = new Decl_statContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_decl_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(133);
			var_dec();
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

	public static class ExprContext extends ParserRuleContext {
		public Token op;
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Actual_parametersContext actual_parameters() {
			return getRuleContext(Actual_parametersContext.class,0);
		}
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode NEW() { return getToken(MlangParser.NEW, 0); }
		public Class_idContext class_id() {
			return getRuleContext(Class_idContext.class,0);
		}
		public TerminalNode NUM() { return getToken(MlangParser.NUM, 0); }
		public TerminalNode TRUE() { return getToken(MlangParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MlangParser.FALSE, 0); }
		public TerminalNode NULL() { return getToken(MlangParser.NULL, 0); }
		public TerminalNode STR() { return getToken(MlangParser.STR, 0); }
		public Assign_exprContext assign_expr() {
			return getRuleContext(Assign_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(176);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				{
				setState(136);
				id(0);
				setState(137);
				match(T__2);
				setState(138);
				actual_parameters(0);
				setState(139);
				match(T__3);
				}
				break;
			case 2:
				{
				setState(141);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__5 || _la==T__6) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(142);
				expr(22);
				}
				break;
			case 3:
				{
				setState(143);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==ADD || _la==SUB) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(144);
				expr(21);
				}
				break;
			case 4:
				{
				setState(145);
				((ExprContext)_localctx).op = _input.LT(1);
				_la = _input.LA(1);
				if ( !(_la==T__7 || _la==T__8) ) {
					((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(146);
				expr(20);
				}
				break;
			case 5:
				{
				setState(147);
				match(NEW);
				setState(148);
				class_id();
				setState(163);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(153); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(149);
							match(T__9);
							setState(150);
							expr(0);
							setState(151);
							match(T__10);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(155); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(160);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(157);
							match(T__11);
							}
							} 
						}
						setState(162);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(165);
				match(NUM);
				}
				break;
			case 7:
				{
				setState(166);
				match(TRUE);
				}
				break;
			case 8:
				{
				setState(167);
				match(FALSE);
				}
				break;
			case 9:
				{
				setState(168);
				match(NULL);
				}
				break;
			case 10:
				{
				setState(169);
				match(STR);
				}
				break;
			case 11:
				{
				setState(170);
				id(0);
				}
				break;
			case 12:
				{
				setState(171);
				match(T__2);
				setState(172);
				expr(0);
				setState(173);
				match(T__3);
				}
				break;
			case 13:
				{
				setState(175);
				assign_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(212);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(210);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(178);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(179);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__12) | (1L << MUL) | (1L << DIV))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(180);
						expr(19);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(181);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(182);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==ADD || _la==SUB) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(183);
						expr(18);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(184);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(185);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__13 || _la==T__14) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(186);
						expr(17);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(187);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(188);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__15) | (1L << T__16) | (1L << T__17) | (1L << T__18))) != 0)) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(189);
						expr(16);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(190);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(191);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__19 || _la==T__20) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(192);
						expr(15);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(193);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(194);
						match(T__21);
						setState(195);
						expr(14);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(196);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(197);
						match(T__22);
						setState(198);
						expr(13);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(199);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(200);
						match(T__23);
						setState(201);
						expr(12);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(202);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(203);
						match(T__24);
						setState(204);
						expr(11);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(206);
						match(T__25);
						setState(207);
						expr(10);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(209);
						((ExprContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==T__5 || _la==T__6) ) {
							((ExprContext)_localctx).op = (Token)_errHandler.recoverInline(this);
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
				setState(214);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
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

	public static class Actual_parametersContext extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Actual_parametersContext actual_parameters() {
			return getRuleContext(Actual_parametersContext.class,0);
		}
		public Actual_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_actual_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterActual_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitActual_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitActual_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Actual_parametersContext actual_parameters() throws RecognitionException {
		return actual_parameters(0);
	}

	private Actual_parametersContext actual_parameters(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Actual_parametersContext _localctx = new Actual_parametersContext(_ctx, _parentState);
		Actual_parametersContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_actual_parameters, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(216);
				expr(0);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(224);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Actual_parametersContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_actual_parameters);
					setState(219);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(220);
					match(T__26);
					setState(221);
					expr(0);
					}
					} 
				}
				setState(226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
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

	public static class Formal_parametersContext extends ParserRuleContext {
		public Class_idContext class_id() {
			return getRuleContext(Class_idContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public Formal_parametersContext formal_parameters() {
			return getRuleContext(Formal_parametersContext.class,0);
		}
		public Formal_parametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formal_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterFormal_parameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitFormal_parameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitFormal_parameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Formal_parametersContext formal_parameters() throws RecognitionException {
		return formal_parameters(0);
	}

	private Formal_parametersContext formal_parameters(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Formal_parametersContext _localctx = new Formal_parametersContext(_ctx, _parentState);
		Formal_parametersContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_formal_parameters, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(231);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(228);
				class_id();
				setState(229);
				id(0);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Formal_parametersContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_formal_parameters);
					setState(233);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(234);
					match(T__26);
					setState(235);
					class_id();
					setState(236);
					id(0);
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class Assign_exprContext extends ParserRuleContext {
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Assign_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assign_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterAssign_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitAssign_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitAssign_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assign_exprContext assign_expr() throws RecognitionException {
		Assign_exprContext _localctx = new Assign_exprContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(243);
			id(0);
			setState(244);
			match(T__27);
			setState(245);
			expr(0);
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

	public static class IdContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public List<IdContext> id() {
			return getRuleContexts(IdContext.class);
		}
		public IdContext id(int i) {
			return getRuleContext(IdContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		return id(0);
	}

	private IdContext id(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		IdContext _localctx = new IdContext(_ctx, _parentState);
		IdContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_id, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(248);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(260);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(258);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new IdContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_id);
						setState(250);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(251);
						match(T__28);
						setState(252);
						id(2);
						}
						break;
					case 2:
						{
						_localctx = new IdContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_id);
						setState(253);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(254);
						match(T__9);
						setState(255);
						expr(0);
						setState(256);
						match(T__10);
						}
						break;
					}
					} 
				}
				setState(262);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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

	public static class Class_idContext extends ParserRuleContext {
		public TerminalNode BOOL() { return getToken(MlangParser.BOOL, 0); }
		public TerminalNode INT() { return getToken(MlangParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MlangParser.STRING, 0); }
		public TerminalNode VOID() { return getToken(MlangParser.VOID, 0); }
		public TerminalNode ID() { return getToken(MlangParser.ID, 0); }
		public Class_idContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterClass_id(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitClass_id(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitClass_id(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_idContext class_id() throws RecognitionException {
		Class_idContext _localctx = new Class_idContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_class_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(263);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << VOID) | (1L << ID))) != 0)) ) {
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

	public static class Class_typeContext extends ParserRuleContext {
		public Class_idContext class_id() {
			return getRuleContext(Class_idContext.class,0);
		}
		public Class_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).enterClass_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MlangListener ) ((MlangListener)listener).exitClass_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MlangVisitor ) return ((MlangVisitor<? extends T>)visitor).visitClass_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_typeContext class_type() throws RecognitionException {
		Class_typeContext _localctx = new Class_typeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_class_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(265);
			class_id();
			setState(269);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(266);
				match(T__11);
				}
				}
				setState(271);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 11:
			return actual_parameters_sempred((Actual_parametersContext)_localctx, predIndex);
		case 12:
			return formal_parameters_sempred((Formal_parametersContext)_localctx, predIndex);
		case 14:
			return id_sempred((IdContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 18);
		case 1:
			return precpred(_ctx, 17);
		case 2:
			return precpred(_ctx, 16);
		case 3:
			return precpred(_ctx, 15);
		case 4:
			return precpred(_ctx, 14);
		case 5:
			return precpred(_ctx, 13);
		case 6:
			return precpred(_ctx, 12);
		case 7:
			return precpred(_ctx, 11);
		case 8:
			return precpred(_ctx, 10);
		case 9:
			return precpred(_ctx, 9);
		case 10:
			return precpred(_ctx, 24);
		}
		return true;
	}
	private boolean actual_parameters_sempred(Actual_parametersContext _localctx, int predIndex) {
		switch (predIndex) {
		case 11:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean formal_parameters_sempred(Formal_parametersContext _localctx, int predIndex) {
		switch (predIndex) {
		case 12:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean id_sempred(IdContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 1);
		case 14:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u0113\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\3\2\6\2(\n\2\r\2\16\2)\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3"+
		"\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5B\n\5\3\6\3\6\3"+
		"\6\3\6\3\6\6\6I\n\6\r\6\16\6J\3\6\3\6\3\6\3\6\5\6Q\n\6\3\7\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\5\7a\n\7\3\b\3\b\3\b\5\bf\n\b"+
		"\3\b\3\b\5\bj\n\b\3\b\3\b\5\bn\n\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\5\b"+
		"x\n\b\3\t\3\t\5\t|\n\t\3\t\3\t\3\t\3\t\3\t\5\t\u0083\n\t\3\n\3\n\3\n\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\6\f\u009c\n\f\r\f\16\f\u009d\3\f\7\f\u00a1\n\f\f\f\16\f\u00a4"+
		"\13\f\5\f\u00a6\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\5\f\u00b3"+
		"\n\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3"+
		"\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00d5"+
		"\n\f\f\f\16\f\u00d8\13\f\3\r\3\r\5\r\u00dc\n\r\3\r\3\r\3\r\7\r\u00e1\n"+
		"\r\f\r\16\r\u00e4\13\r\3\16\3\16\3\16\3\16\5\16\u00ea\n\16\3\16\3\16\3"+
		"\16\3\16\3\16\7\16\u00f1\n\16\f\16\16\16\u00f4\13\16\3\17\3\17\3\17\3"+
		"\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u0105"+
		"\n\20\f\20\16\20\u0108\13\20\3\21\3\21\3\22\3\22\7\22\u010e\n\22\f\22"+
		"\16\22\u0111\13\22\3\22\2\6\26\30\32\36\23\2\4\6\b\n\f\16\20\22\24\26"+
		"\30\32\34\36 \"\2\n\3\2\b\t\3\2\678\3\2\n\13\4\2\17\17\65\66\3\2\20\21"+
		"\3\2\22\25\3\2\26\27\5\2 \"$$99\2\u0134\2\'\3\2\2\2\4+\3\2\2\2\6\61\3"+
		"\2\2\2\bA\3\2\2\2\nP\3\2\2\2\f`\3\2\2\2\16w\3\2\2\2\20\u0082\3\2\2\2\22"+
		"\u0084\3\2\2\2\24\u0087\3\2\2\2\26\u00b2\3\2\2\2\30\u00d9\3\2\2\2\32\u00e5"+
		"\3\2\2\2\34\u00f5\3\2\2\2\36\u00f9\3\2\2\2 \u0109\3\2\2\2\"\u010b\3\2"+
		"\2\2$(\5\6\4\2%(\5\4\3\2&(\5\b\5\2\'$\3\2\2\2\'%\3\2\2\2\'&\3\2\2\2()"+
		"\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*\3\3\2\2\2+,\7/\2\2,-\5\36\20\2-.\7\3\2"+
		"\2./\5\2\2\2/\60\7\4\2\2\60\5\3\2\2\2\61\62\5\"\22\2\62\63\5\36\20\2\63"+
		"\64\7\5\2\2\64\65\5\32\16\2\65\66\7\6\2\2\66\67\7\3\2\2\678\5\n\6\289"+
		"\7\4\2\29\7\3\2\2\2:;\5\"\22\2;<\5\34\17\2<=\7\7\2\2=B\3\2\2\2>?\5\"\22"+
		"\2?@\79\2\2@B\3\2\2\2A:\3\2\2\2A>\3\2\2\2B\t\3\2\2\2CQ\5\f\7\2DQ\5\16"+
		"\b\2EQ\5\20\t\2FH\7\3\2\2GI\5\n\6\2HG\3\2\2\2IJ\3\2\2\2JH\3\2\2\2JK\3"+
		"\2\2\2KL\3\2\2\2LM\7\4\2\2MQ\3\2\2\2NQ\5\22\n\2OQ\5\24\13\2PC\3\2\2\2"+
		"PD\3\2\2\2PE\3\2\2\2PF\3\2\2\2PN\3\2\2\2PO\3\2\2\2Q\13\3\2\2\2RS\7\'\2"+
		"\2ST\7\5\2\2TU\5\26\f\2UV\7\6\2\2VW\5\n\6\2Wa\3\2\2\2XY\7\'\2\2YZ\7\5"+
		"\2\2Z[\5\26\f\2[\\\7\6\2\2\\]\5\n\6\2]^\7(\2\2^_\5\n\6\2_a\3\2\2\2`R\3"+
		"\2\2\2`X\3\2\2\2a\r\3\2\2\2bc\7)\2\2ce\7\5\2\2df\5\26\f\2ed\3\2\2\2ef"+
		"\3\2\2\2fg\3\2\2\2gi\7\7\2\2hj\5\26\f\2ih\3\2\2\2ij\3\2\2\2jk\3\2\2\2"+
		"km\7\7\2\2ln\5\26\f\2ml\3\2\2\2mn\3\2\2\2no\3\2\2\2op\7\6\2\2px\5\n\6"+
		"\2qr\7*\2\2rs\7\5\2\2st\5\26\f\2tu\7\6\2\2uv\5\n\6\2vx\3\2\2\2wb\3\2\2"+
		"\2wq\3\2\2\2x\17\3\2\2\2y{\7-\2\2z|\5\26\f\2{z\3\2\2\2{|\3\2\2\2|}\3\2"+
		"\2\2}\u0083\7\7\2\2~\177\7+\2\2\177\u0083\7\7\2\2\u0080\u0081\7,\2\2\u0081"+
		"\u0083\7\7\2\2\u0082y\3\2\2\2\u0082~\3\2\2\2\u0082\u0080\3\2\2\2\u0083"+
		"\21\3\2\2\2\u0084\u0085\5\26\f\2\u0085\u0086\7\7\2\2\u0086\23\3\2\2\2"+
		"\u0087\u0088\5\b\5\2\u0088\25\3\2\2\2\u0089\u008a\b\f\1\2\u008a\u008b"+
		"\5\36\20\2\u008b\u008c\7\5\2\2\u008c\u008d\5\30\r\2\u008d\u008e\7\6\2"+
		"\2\u008e\u00b3\3\2\2\2\u008f\u0090\t\2\2\2\u0090\u00b3\5\26\f\30\u0091"+
		"\u0092\t\3\2\2\u0092\u00b3\5\26\f\27\u0093\u0094\t\4\2\2\u0094\u00b3\5"+
		"\26\f\26\u0095\u0096\7.\2\2\u0096\u00a5\5 \21\2\u0097\u0098\7\f\2\2\u0098"+
		"\u0099\5\26\f\2\u0099\u009a\7\r\2\2\u009a\u009c\3\2\2\2\u009b\u0097\3"+
		"\2\2\2\u009c\u009d\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e"+
		"\u00a2\3\2\2\2\u009f\u00a1\7\16\2\2\u00a0\u009f\3\2\2\2\u00a1\u00a4\3"+
		"\2\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a6\3\2\2\2\u00a4"+
		"\u00a2\3\2\2\2\u00a5\u009b\3\2\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00b3\3\2"+
		"\2\2\u00a7\u00b3\7\61\2\2\u00a8\u00b3\7%\2\2\u00a9\u00b3\7&\2\2\u00aa"+
		"\u00b3\7#\2\2\u00ab\u00b3\7\63\2\2\u00ac\u00b3\5\36\20\2\u00ad\u00ae\7"+
		"\5\2\2\u00ae\u00af\5\26\f\2\u00af\u00b0\7\6\2\2\u00b0\u00b3\3\2\2\2\u00b1"+
		"\u00b3\5\34\17\2\u00b2\u0089\3\2\2\2\u00b2\u008f\3\2\2\2\u00b2\u0091\3"+
		"\2\2\2\u00b2\u0093\3\2\2\2\u00b2\u0095\3\2\2\2\u00b2\u00a7\3\2\2\2\u00b2"+
		"\u00a8\3\2\2\2\u00b2\u00a9\3\2\2\2\u00b2\u00aa\3\2\2\2\u00b2\u00ab\3\2"+
		"\2\2\u00b2\u00ac\3\2\2\2\u00b2\u00ad\3\2\2\2\u00b2\u00b1\3\2\2\2\u00b3"+
		"\u00d6\3\2\2\2\u00b4\u00b5\f\24\2\2\u00b5\u00b6\t\5\2\2\u00b6\u00d5\5"+
		"\26\f\25\u00b7\u00b8\f\23\2\2\u00b8\u00b9\t\3\2\2\u00b9\u00d5\5\26\f\24"+
		"\u00ba\u00bb\f\22\2\2\u00bb\u00bc\t\6\2\2\u00bc\u00d5\5\26\f\23\u00bd"+
		"\u00be\f\21\2\2\u00be\u00bf\t\7\2\2\u00bf\u00d5\5\26\f\22\u00c0\u00c1"+
		"\f\20\2\2\u00c1\u00c2\t\b\2\2\u00c2\u00d5\5\26\f\21\u00c3\u00c4\f\17\2"+
		"\2\u00c4\u00c5\7\30\2\2\u00c5\u00d5\5\26\f\20\u00c6\u00c7\f\16\2\2\u00c7"+
		"\u00c8\7\31\2\2\u00c8\u00d5\5\26\f\17\u00c9\u00ca\f\r\2\2\u00ca\u00cb"+
		"\7\32\2\2\u00cb\u00d5\5\26\f\16\u00cc\u00cd\f\f\2\2\u00cd\u00ce\7\33\2"+
		"\2\u00ce\u00d5\5\26\f\r\u00cf\u00d0\f\13\2\2\u00d0\u00d1\7\34\2\2\u00d1"+
		"\u00d5\5\26\f\f\u00d2\u00d3\f\32\2\2\u00d3\u00d5\t\2\2\2\u00d4\u00b4\3"+
		"\2\2\2\u00d4\u00b7\3\2\2\2\u00d4\u00ba\3\2\2\2\u00d4\u00bd\3\2\2\2\u00d4"+
		"\u00c0\3\2\2\2\u00d4\u00c3\3\2\2\2\u00d4\u00c6\3\2\2\2\u00d4\u00c9\3\2"+
		"\2\2\u00d4\u00cc\3\2\2\2\u00d4\u00cf\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d5"+
		"\u00d8\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d6\u00d7\3\2\2\2\u00d7\27\3\2\2"+
		"\2\u00d8\u00d6\3\2\2\2\u00d9\u00db\b\r\1\2\u00da\u00dc\5\26\f\2\u00db"+
		"\u00da\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00e2\3\2\2\2\u00dd\u00de\f\4"+
		"\2\2\u00de\u00df\7\35\2\2\u00df\u00e1\5\26\f\2\u00e0\u00dd\3\2\2\2\u00e1"+
		"\u00e4\3\2\2\2\u00e2\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\31\3\2\2"+
		"\2\u00e4\u00e2\3\2\2\2\u00e5\u00e9\b\16\1\2\u00e6\u00e7\5 \21\2\u00e7"+
		"\u00e8\5\36\20\2\u00e8\u00ea\3\2\2\2\u00e9\u00e6\3\2\2\2\u00e9\u00ea\3"+
		"\2\2\2\u00ea\u00f2\3\2\2\2\u00eb\u00ec\f\4\2\2\u00ec\u00ed\7\35\2\2\u00ed"+
		"\u00ee\5 \21\2\u00ee\u00ef\5\36\20\2\u00ef\u00f1\3\2\2\2\u00f0\u00eb\3"+
		"\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2\2\2\u00f3"+
		"\33\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\5\36\20\2\u00f6\u00f7\7\36"+
		"\2\2\u00f7\u00f8\5\26\f\2\u00f8\35\3\2\2\2\u00f9\u00fa\b\20\1\2\u00fa"+
		"\u00fb\79\2\2\u00fb\u0106\3\2\2\2\u00fc\u00fd\f\3\2\2\u00fd\u00fe\7\37"+
		"\2\2\u00fe\u0105\5\36\20\4\u00ff\u0100\f\4\2\2\u0100\u0101\7\f\2\2\u0101"+
		"\u0102\5\26\f\2\u0102\u0103\7\r\2\2\u0103\u0105\3\2\2\2\u0104\u00fc\3"+
		"\2\2\2\u0104\u00ff\3\2\2\2\u0105\u0108\3\2\2\2\u0106\u0104\3\2\2\2\u0106"+
		"\u0107\3\2\2\2\u0107\37\3\2\2\2\u0108\u0106\3\2\2\2\u0109\u010a\t\t\2"+
		"\2\u010a!\3\2\2\2\u010b\u010f\5 \21\2\u010c\u010e\7\16\2\2\u010d\u010c"+
		"\3\2\2\2\u010e\u0111\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110"+
		"#\3\2\2\2\u0111\u010f\3\2\2\2\33\')AJP`eimw{\u0082\u009d\u00a2\u00a5\u00b2"+
		"\u00d4\u00d6\u00db\u00e2\u00e9\u00f2\u0104\u0106\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}