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
		BREAK=41, CONTI=42, RETURN=43, NEW=44, CLASS=45, THIS=46, NUM=47, ESC=48, 
		STR=49, COMMENT=50, MUL=51, DIV=52, ADD=53, SUB=54, ID=55, WS=56;
	public static final int
		RULE_prog = 0, RULE_class_def = 1, RULE_func_def = 2, RULE_var_dec = 3, 
		RULE_block = 4, RULE_stat = 5, RULE_cond_stat = 6, RULE_circ_stat = 7, 
		RULE_jump_stat = 8, RULE_expr_stat = 9, RULE_decl_stat = 10, RULE_expr = 11, 
		RULE_actual_parameters = 12, RULE_formal_parameters = 13, RULE_assign_expr = 14, 
		RULE_id = 15, RULE_class_id = 16, RULE_class_type = 17;
	public static final String[] ruleNames = {
		"prog", "class_def", "func_def", "var_dec", "block", "stat", "cond_stat", 
		"circ_stat", "jump_stat", "expr_stat", "decl_stat", "expr", "actual_parameters", 
		"formal_parameters", "assign_expr", "id", "class_id", "class_type"
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
			setState(39); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				setState(39);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
				case 1:
					{
					setState(36);
					func_def();
					}
					break;
				case 2:
					{
					setState(37);
					class_def();
					}
					break;
				case 3:
					{
					setState(38);
					var_dec();
					}
					break;
				}
				}
				setState(41); 
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
			setState(43);
			match(CLASS);
			setState(44);
			id(0);
			setState(45);
			match(T__0);
			setState(46);
			prog();
			setState(47);
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
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public Formal_parametersContext formal_parameters() {
			return getRuleContext(Formal_parametersContext.class,0);
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
			setState(49);
			class_type();
			setState(50);
			id(0);
			setState(51);
			match(T__2);
			setState(53);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,2,_ctx) ) {
			case 1:
				{
				setState(52);
				formal_parameters(0);
				}
				break;
			}
			setState(55);
			match(T__3);
			setState(56);
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
			setState(65);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(58);
				class_type();
				setState(59);
				assign_expr();
				setState(60);
				match(T__4);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(62);
				class_type();
				setState(63);
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

	public static class BlockContext extends ParserRuleContext {
		public List<StatContext> stat() {
			return getRuleContexts(StatContext.class);
		}
		public StatContext stat(int i) {
			return getRuleContext(StatContext.class,i);
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
		enterRule(_localctx, 8, RULE_block);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(T__0);
			setState(71);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << NULL) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONTI) | (1L << RETURN) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
				{
				{
				setState(68);
				stat();
				}
				}
				setState(73);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(74);
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
		enterRule(_localctx, 10, RULE_stat);
		int _la;
		try {
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				cond_stat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(77);
				circ_stat();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(78);
				jump_stat();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(79);
				match(T__0);
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(80);
					stat();
					}
					}
					setState(83); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << BOOL) | (1L << INT) | (1L << STRING) | (1L << NULL) | (1L << VOID) | (1L << TRUE) | (1L << FALSE) | (1L << IF) | (1L << FOR) | (1L << WHILE) | (1L << BREAK) | (1L << CONTI) | (1L << RETURN) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0) );
				setState(85);
				match(T__1);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(87);
				expr_stat();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(88);
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
		enterRule(_localctx, 12, RULE_cond_stat);
		try {
			setState(105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				match(IF);
				setState(92);
				match(T__2);
				setState(93);
				expr(0);
				setState(94);
				match(T__3);
				setState(95);
				stat();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(97);
				match(IF);
				setState(98);
				match(T__2);
				setState(99);
				expr(0);
				setState(100);
				match(T__3);
				setState(101);
				stat();
				setState(102);
				match(ELSE);
				setState(103);
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
		enterRule(_localctx, 14, RULE_circ_stat);
		int _la;
		try {
			setState(128);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(107);
				match(FOR);
				setState(108);
				match(T__2);
				setState(110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(109);
					expr(0);
					}
				}

				setState(112);
				match(T__4);
				setState(114);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(113);
					expr(0);
					}
				}

				setState(116);
				match(T__4);
				setState(118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(117);
					expr(0);
					}
				}

				setState(120);
				match(T__3);
				setState(121);
				stat();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(WHILE);
				setState(123);
				match(T__2);
				setState(124);
				expr(0);
				setState(125);
				match(T__3);
				setState(126);
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
		enterRule(_localctx, 16, RULE_jump_stat);
		int _la;
		try {
			setState(139);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				match(RETURN);
				setState(132);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__5) | (1L << T__6) | (1L << T__7) | (1L << T__8) | (1L << NULL) | (1L << TRUE) | (1L << FALSE) | (1L << NEW) | (1L << NUM) | (1L << STR) | (1L << ADD) | (1L << SUB) | (1L << ID))) != 0)) {
					{
					setState(131);
					expr(0);
					}
				}

				setState(134);
				match(T__4);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(135);
				match(BREAK);
				setState(136);
				match(T__4);
				}
				break;
			case CONTI:
				enterOuterAlt(_localctx, 3);
				{
				setState(137);
				match(CONTI);
				setState(138);
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
		enterRule(_localctx, 18, RULE_expr_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			expr(0);
			setState(142);
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
		enterRule(_localctx, 20, RULE_decl_stat);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
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
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(147);
				id(0);
				setState(148);
				match(T__2);
				setState(149);
				actual_parameters(0);
				setState(150);
				match(T__3);
				}
				break;
			case 2:
				{
				setState(152);
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
				setState(153);
				expr(22);
				}
				break;
			case 3:
				{
				setState(154);
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
				setState(155);
				expr(21);
				}
				break;
			case 4:
				{
				setState(156);
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
				setState(157);
				expr(20);
				}
				break;
			case 5:
				{
				setState(158);
				match(NEW);
				setState(159);
				class_id();
				setState(174);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(164); 
					_errHandler.sync(this);
					_alt = 1;
					do {
						switch (_alt) {
						case 1:
							{
							{
							setState(160);
							match(T__9);
							setState(161);
							expr(0);
							setState(162);
							match(T__10);
							}
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						setState(166); 
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
					} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
					setState(171);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(168);
							match(T__11);
							}
							} 
						}
						setState(173);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
					}
					}
					break;
				}
				}
				break;
			case 6:
				{
				setState(176);
				match(NUM);
				}
				break;
			case 7:
				{
				setState(177);
				match(TRUE);
				}
				break;
			case 8:
				{
				setState(178);
				match(FALSE);
				}
				break;
			case 9:
				{
				setState(179);
				match(NULL);
				}
				break;
			case 10:
				{
				setState(180);
				match(STR);
				}
				break;
			case 11:
				{
				setState(181);
				id(0);
				}
				break;
			case 12:
				{
				setState(182);
				match(T__2);
				setState(183);
				expr(0);
				setState(184);
				match(T__3);
				}
				break;
			case 13:
				{
				setState(186);
				assign_expr();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(223);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(221);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(189);
						if (!(precpred(_ctx, 18))) throw new FailedPredicateException(this, "precpred(_ctx, 18)");
						setState(190);
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
						setState(191);
						expr(19);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(192);
						if (!(precpred(_ctx, 17))) throw new FailedPredicateException(this, "precpred(_ctx, 17)");
						setState(193);
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
						setState(194);
						expr(18);
						}
						break;
					case 3:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(195);
						if (!(precpred(_ctx, 16))) throw new FailedPredicateException(this, "precpred(_ctx, 16)");
						setState(196);
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
						setState(197);
						expr(17);
						}
						break;
					case 4:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(198);
						if (!(precpred(_ctx, 15))) throw new FailedPredicateException(this, "precpred(_ctx, 15)");
						setState(199);
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
						setState(200);
						expr(16);
						}
						break;
					case 5:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(201);
						if (!(precpred(_ctx, 14))) throw new FailedPredicateException(this, "precpred(_ctx, 14)");
						setState(202);
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
						setState(203);
						expr(15);
						}
						break;
					case 6:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(204);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(205);
						match(T__21);
						setState(206);
						expr(14);
						}
						break;
					case 7:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(207);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(208);
						match(T__22);
						setState(209);
						expr(13);
						}
						break;
					case 8:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(210);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(211);
						match(T__23);
						setState(212);
						expr(12);
						}
						break;
					case 9:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(213);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(214);
						match(T__24);
						setState(215);
						expr(11);
						}
						break;
					case 10:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(216);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(217);
						match(T__25);
						setState(218);
						expr(10);
						}
						break;
					case 11:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(219);
						if (!(precpred(_ctx, 24))) throw new FailedPredicateException(this, "precpred(_ctx, 24)");
						setState(220);
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
				setState(225);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_actual_parameters, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(228);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				{
				setState(227);
				expr(0);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(235);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Actual_parametersContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_actual_parameters);
					setState(230);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(231);
					match(T__26);
					setState(232);
					expr(0);
					}
					} 
				}
				setState(237);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_formal_parameters, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(242);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				{
				setState(239);
				class_id();
				setState(240);
				id(0);
				}
				break;
			}
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Formal_parametersContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_formal_parameters);
					setState(244);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(245);
					match(T__26);
					setState(246);
					class_id();
					setState(247);
					id(0);
					}
					} 
				}
				setState(253);
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
		enterRule(_localctx, 28, RULE_assign_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(254);
			id(0);
			setState(255);
			match(T__27);
			setState(256);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_id, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(259);
			match(ID);
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new IdContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_id);
						setState(261);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(262);
						match(T__28);
						setState(263);
						id(2);
						}
						break;
					case 2:
						{
						_localctx = new IdContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_id);
						setState(264);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(265);
						match(T__9);
						setState(266);
						expr(0);
						setState(267);
						match(T__10);
						}
						break;
					}
					} 
				}
				setState(273);
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
		enterRule(_localctx, 32, RULE_class_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(274);
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
		enterRule(_localctx, 34, RULE_class_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(276);
			class_id();
			setState(280);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==T__11) {
				{
				{
				setState(277);
				match(T__11);
				}
				}
				setState(282);
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
		case 11:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 12:
			return actual_parameters_sempred((Actual_parametersContext)_localctx, predIndex);
		case 13:
			return formal_parameters_sempred((Formal_parametersContext)_localctx, predIndex);
		case 15:
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3:\u011e\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\6\2*\n\2\r\2\16\2+\3\3\3\3\3\3\3\3\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\5\48\n\4\3\4\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5D\n\5"+
		"\3\6\3\6\7\6H\n\6\f\6\16\6K\13\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\6\7T\n\7"+
		"\r\7\16\7U\3\7\3\7\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3"+
		"\b\3\b\3\b\3\b\3\b\3\b\5\bl\n\b\3\t\3\t\3\t\5\tq\n\t\3\t\3\t\5\tu\n\t"+
		"\3\t\3\t\5\ty\n\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0083\n\t\3\n\3"+
		"\n\5\n\u0087\n\n\3\n\3\n\3\n\3\n\3\n\5\n\u008e\n\n\3\13\3\13\3\13\3\f"+
		"\3\f\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\6\r\u00a7\n\r\r\r\16\r\u00a8\3\r\7\r\u00ac\n\r\f\r\16\r\u00af\13"+
		"\r\5\r\u00b1\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\5\r\u00be"+
		"\n\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3"+
		"\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00e0"+
		"\n\r\f\r\16\r\u00e3\13\r\3\16\3\16\5\16\u00e7\n\16\3\16\3\16\3\16\7\16"+
		"\u00ec\n\16\f\16\16\16\u00ef\13\16\3\17\3\17\3\17\3\17\5\17\u00f5\n\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00fc\n\17\f\17\16\17\u00ff\13\17\3\20"+
		"\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\7\21\u0110\n\21\f\21\16\21\u0113\13\21\3\22\3\22\3\23\3\23\7\23\u0119"+
		"\n\23\f\23\16\23\u011c\13\23\3\23\2\6\30\32\34 \24\2\4\6\b\n\f\16\20\22"+
		"\24\26\30\32\34\36 \"$\2\n\3\2\b\t\3\2\678\3\2\n\13\4\2\17\17\65\66\3"+
		"\2\20\21\3\2\22\25\3\2\26\27\5\2 \"$$99\2\u0140\2)\3\2\2\2\4-\3\2\2\2"+
		"\6\63\3\2\2\2\bC\3\2\2\2\nE\3\2\2\2\f[\3\2\2\2\16k\3\2\2\2\20\u0082\3"+
		"\2\2\2\22\u008d\3\2\2\2\24\u008f\3\2\2\2\26\u0092\3\2\2\2\30\u00bd\3\2"+
		"\2\2\32\u00e4\3\2\2\2\34\u00f0\3\2\2\2\36\u0100\3\2\2\2 \u0104\3\2\2\2"+
		"\"\u0114\3\2\2\2$\u0116\3\2\2\2&*\5\6\4\2\'*\5\4\3\2(*\5\b\5\2)&\3\2\2"+
		"\2)\'\3\2\2\2)(\3\2\2\2*+\3\2\2\2+)\3\2\2\2+,\3\2\2\2,\3\3\2\2\2-.\7/"+
		"\2\2./\5 \21\2/\60\7\3\2\2\60\61\5\2\2\2\61\62\7\4\2\2\62\5\3\2\2\2\63"+
		"\64\5$\23\2\64\65\5 \21\2\65\67\7\5\2\2\668\5\34\17\2\67\66\3\2\2\2\67"+
		"8\3\2\2\289\3\2\2\29:\7\6\2\2:;\5\n\6\2;\7\3\2\2\2<=\5$\23\2=>\5\36\20"+
		"\2>?\7\7\2\2?D\3\2\2\2@A\5$\23\2AB\79\2\2BD\3\2\2\2C<\3\2\2\2C@\3\2\2"+
		"\2D\t\3\2\2\2EI\7\3\2\2FH\5\f\7\2GF\3\2\2\2HK\3\2\2\2IG\3\2\2\2IJ\3\2"+
		"\2\2JL\3\2\2\2KI\3\2\2\2LM\7\4\2\2M\13\3\2\2\2N\\\5\16\b\2O\\\5\20\t\2"+
		"P\\\5\22\n\2QS\7\3\2\2RT\5\f\7\2SR\3\2\2\2TU\3\2\2\2US\3\2\2\2UV\3\2\2"+
		"\2VW\3\2\2\2WX\7\4\2\2X\\\3\2\2\2Y\\\5\24\13\2Z\\\5\26\f\2[N\3\2\2\2["+
		"O\3\2\2\2[P\3\2\2\2[Q\3\2\2\2[Y\3\2\2\2[Z\3\2\2\2\\\r\3\2\2\2]^\7\'\2"+
		"\2^_\7\5\2\2_`\5\30\r\2`a\7\6\2\2ab\5\f\7\2bl\3\2\2\2cd\7\'\2\2de\7\5"+
		"\2\2ef\5\30\r\2fg\7\6\2\2gh\5\f\7\2hi\7(\2\2ij\5\f\7\2jl\3\2\2\2k]\3\2"+
		"\2\2kc\3\2\2\2l\17\3\2\2\2mn\7)\2\2np\7\5\2\2oq\5\30\r\2po\3\2\2\2pq\3"+
		"\2\2\2qr\3\2\2\2rt\7\7\2\2su\5\30\r\2ts\3\2\2\2tu\3\2\2\2uv\3\2\2\2vx"+
		"\7\7\2\2wy\5\30\r\2xw\3\2\2\2xy\3\2\2\2yz\3\2\2\2z{\7\6\2\2{\u0083\5\f"+
		"\7\2|}\7*\2\2}~\7\5\2\2~\177\5\30\r\2\177\u0080\7\6\2\2\u0080\u0081\5"+
		"\f\7\2\u0081\u0083\3\2\2\2\u0082m\3\2\2\2\u0082|\3\2\2\2\u0083\21\3\2"+
		"\2\2\u0084\u0086\7-\2\2\u0085\u0087\5\30\r\2\u0086\u0085\3\2\2\2\u0086"+
		"\u0087\3\2\2\2\u0087\u0088\3\2\2\2\u0088\u008e\7\7\2\2\u0089\u008a\7+"+
		"\2\2\u008a\u008e\7\7\2\2\u008b\u008c\7,\2\2\u008c\u008e\7\7\2\2\u008d"+
		"\u0084\3\2\2\2\u008d\u0089\3\2\2\2\u008d\u008b\3\2\2\2\u008e\23\3\2\2"+
		"\2\u008f\u0090\5\30\r\2\u0090\u0091\7\7\2\2\u0091\25\3\2\2\2\u0092\u0093"+
		"\5\b\5\2\u0093\27\3\2\2\2\u0094\u0095\b\r\1\2\u0095\u0096\5 \21\2\u0096"+
		"\u0097\7\5\2\2\u0097\u0098\5\32\16\2\u0098\u0099\7\6\2\2\u0099\u00be\3"+
		"\2\2\2\u009a\u009b\t\2\2\2\u009b\u00be\5\30\r\30\u009c\u009d\t\3\2\2\u009d"+
		"\u00be\5\30\r\27\u009e\u009f\t\4\2\2\u009f\u00be\5\30\r\26\u00a0\u00a1"+
		"\7.\2\2\u00a1\u00b0\5\"\22\2\u00a2\u00a3\7\f\2\2\u00a3\u00a4\5\30\r\2"+
		"\u00a4\u00a5\7\r\2\2\u00a5\u00a7\3\2\2\2\u00a6\u00a2\3\2\2\2\u00a7\u00a8"+
		"\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2\2\2\u00a9\u00ad\3\2\2\2\u00aa"+
		"\u00ac\7\16\2\2\u00ab\u00aa\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3"+
		"\2\2\2\u00ad\u00ae\3\2\2\2\u00ae\u00b1\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0"+
		"\u00a6\3\2\2\2\u00b0\u00b1\3\2\2\2\u00b1\u00be\3\2\2\2\u00b2\u00be\7\61"+
		"\2\2\u00b3\u00be\7%\2\2\u00b4\u00be\7&\2\2\u00b5\u00be\7#\2\2\u00b6\u00be"+
		"\7\63\2\2\u00b7\u00be\5 \21\2\u00b8\u00b9\7\5\2\2\u00b9\u00ba\5\30\r\2"+
		"\u00ba\u00bb\7\6\2\2\u00bb\u00be\3\2\2\2\u00bc\u00be\5\36\20\2\u00bd\u0094"+
		"\3\2\2\2\u00bd\u009a\3\2\2\2\u00bd\u009c\3\2\2\2\u00bd\u009e\3\2\2\2\u00bd"+
		"\u00a0\3\2\2\2\u00bd\u00b2\3\2\2\2\u00bd\u00b3\3\2\2\2\u00bd\u00b4\3\2"+
		"\2\2\u00bd\u00b5\3\2\2\2\u00bd\u00b6\3\2\2\2\u00bd\u00b7\3\2\2\2\u00bd"+
		"\u00b8\3\2\2\2\u00bd\u00bc\3\2\2\2\u00be\u00e1\3\2\2\2\u00bf\u00c0\f\24"+
		"\2\2\u00c0\u00c1\t\5\2\2\u00c1\u00e0\5\30\r\25\u00c2\u00c3\f\23\2\2\u00c3"+
		"\u00c4\t\3\2\2\u00c4\u00e0\5\30\r\24\u00c5\u00c6\f\22\2\2\u00c6\u00c7"+
		"\t\6\2\2\u00c7\u00e0\5\30\r\23\u00c8\u00c9\f\21\2\2\u00c9\u00ca\t\7\2"+
		"\2\u00ca\u00e0\5\30\r\22\u00cb\u00cc\f\20\2\2\u00cc\u00cd\t\b\2\2\u00cd"+
		"\u00e0\5\30\r\21\u00ce\u00cf\f\17\2\2\u00cf\u00d0\7\30\2\2\u00d0\u00e0"+
		"\5\30\r\20\u00d1\u00d2\f\16\2\2\u00d2\u00d3\7\31\2\2\u00d3\u00e0\5\30"+
		"\r\17\u00d4\u00d5\f\r\2\2\u00d5\u00d6\7\32\2\2\u00d6\u00e0\5\30\r\16\u00d7"+
		"\u00d8\f\f\2\2\u00d8\u00d9\7\33\2\2\u00d9\u00e0\5\30\r\r\u00da\u00db\f"+
		"\13\2\2\u00db\u00dc\7\34\2\2\u00dc\u00e0\5\30\r\f\u00dd\u00de\f\32\2\2"+
		"\u00de\u00e0\t\2\2\2\u00df\u00bf\3\2\2\2\u00df\u00c2\3\2\2\2\u00df\u00c5"+
		"\3\2\2\2\u00df\u00c8\3\2\2\2\u00df\u00cb\3\2\2\2\u00df\u00ce\3\2\2\2\u00df"+
		"\u00d1\3\2\2\2\u00df\u00d4\3\2\2\2\u00df\u00d7\3\2\2\2\u00df\u00da\3\2"+
		"\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e3\3\2\2\2\u00e1\u00df\3\2\2\2\u00e1"+
		"\u00e2\3\2\2\2\u00e2\31\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e4\u00e6\b\16\1"+
		"\2\u00e5\u00e7\5\30\r\2\u00e6\u00e5\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7"+
		"\u00ed\3\2\2\2\u00e8\u00e9\f\4\2\2\u00e9\u00ea\7\35\2\2\u00ea\u00ec\5"+
		"\30\r\2\u00eb\u00e8\3\2\2\2\u00ec\u00ef\3\2\2\2\u00ed\u00eb\3\2\2\2\u00ed"+
		"\u00ee\3\2\2\2\u00ee\33\3\2\2\2\u00ef\u00ed\3\2\2\2\u00f0\u00f4\b\17\1"+
		"\2\u00f1\u00f2\5\"\22\2\u00f2\u00f3\5 \21\2\u00f3\u00f5\3\2\2\2\u00f4"+
		"\u00f1\3\2\2\2\u00f4\u00f5\3\2\2\2\u00f5\u00fd\3\2\2\2\u00f6\u00f7\f\4"+
		"\2\2\u00f7\u00f8\7\35\2\2\u00f8\u00f9\5\"\22\2\u00f9\u00fa\5 \21\2\u00fa"+
		"\u00fc\3\2\2\2\u00fb\u00f6\3\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2"+
		"\2\2\u00fd\u00fe\3\2\2\2\u00fe\35\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101"+
		"\5 \21\2\u0101\u0102\7\36\2\2\u0102\u0103\5\30\r\2\u0103\37\3\2\2\2\u0104"+
		"\u0105\b\21\1\2\u0105\u0106\79\2\2\u0106\u0111\3\2\2\2\u0107\u0108\f\3"+
		"\2\2\u0108\u0109\7\37\2\2\u0109\u0110\5 \21\4\u010a\u010b\f\4\2\2\u010b"+
		"\u010c\7\f\2\2\u010c\u010d\5\30\r\2\u010d\u010e\7\r\2\2\u010e\u0110\3"+
		"\2\2\2\u010f\u0107\3\2\2\2\u010f\u010a\3\2\2\2\u0110\u0113\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0111\u0112\3\2\2\2\u0112!\3\2\2\2\u0113\u0111\3\2\2\2"+
		"\u0114\u0115\t\t\2\2\u0115#\3\2\2\2\u0116\u011a\5\"\22\2\u0117\u0119\7"+
		"\16\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b%\3\2\2\2\u011c\u011a\3\2\2\2\35)+\67CIU[kptx\u0082"+
		"\u0086\u008d\u00a8\u00ad\u00b0\u00bd\u00df\u00e1\u00e6\u00ed\u00f4\u00fd"+
		"\u010f\u0111\u011a";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}