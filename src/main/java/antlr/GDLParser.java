// Generated from D:/Study/Year 4/Individual Project/gdl2ispl/src/main/java/antlr\GDL.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GDLParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, INIT=4, BASE=5, INPUT=6, ROLE=7, GOAL=8, NEXT=9, 
		TERMINAL=10, LEGAL=11, NOT=12, TRUE=13, OR=14, DISTINCT=15, DOES=16, CONST=17, 
		VAR=18, COMMENT=19, WS=20;
	public static final int
		RULE_description = 0, RULE_clause = 1, RULE_grule = 2, RULE_fact = 3, 
		RULE_head = 4, RULE_condition = 5, RULE_predicate = 6, RULE_arg = 7, RULE_atom = 8;
	private static String[] makeRuleNames() {
		return new String[] {
			"description", "clause", "grule", "fact", "head", "condition", "predicate", 
			"arg", "atom"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'(<='", "')'", "'('", "'init'", "'base'", "'input'", "'role'", 
			"'goal'", "'next'", "'terminal'", "'legal'", "'not'", "'true'", "'or'", 
			"'distinct'", "'does'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "INIT", "BASE", "INPUT", "ROLE", "GOAL", "NEXT", 
			"TERMINAL", "LEGAL", "NOT", "TRUE", "OR", "DISTINCT", "DOES", "CONST", 
			"VAR", "COMMENT", "WS"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
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
	public String getGrammarFileName() { return "GDL.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GDLParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class DescriptionContext extends ParserRuleContext {
		public List<ClauseContext> clause() {
			return getRuleContexts(ClauseContext.class);
		}
		public ClauseContext clause(int i) {
			return getRuleContext(ClauseContext.class,i);
		}
		public DescriptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_description; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterDescription(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitDescription(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitDescription(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(21);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << TERMINAL) | (1L << CONST))) != 0)) {
				{
				{
				setState(18);
				clause();
				}
				}
				setState(23);
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

	public static class ClauseContext extends ParserRuleContext {
		public GruleContext grule() {
			return getRuleContext(GruleContext.class,0);
		}
		public FactContext fact() {
			return getRuleContext(FactContext.class,0);
		}
		public ClauseContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_clause; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterClause(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitClause(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitClause(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClauseContext clause() throws RecognitionException {
		ClauseContext _localctx = new ClauseContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_clause);
		try {
			setState(26);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				grule();
				}
				break;
			case T__2:
			case TERMINAL:
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				fact();
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

	public static class GruleContext extends ParserRuleContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public GruleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterGrule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitGrule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitGrule(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GruleContext grule() throws RecognitionException {
		GruleContext _localctx = new GruleContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_grule);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(28);
			match(T__0);
			setState(29);
			head();
			setState(31); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(30);
				condition();
				}
				}
				setState(33); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==T__2 || _la==CONST );
			setState(35);
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

	public static class FactContext extends ParserRuleContext {
		public FactContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fact; }
	 
		public FactContext() { }
		public void copyFrom(FactContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class InitContext extends FactContext {
		public TerminalNode INIT() { return getToken(GDLParser.INIT, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public InitContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterInit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitInit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitInit(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RoleContext extends FactContext {
		public TerminalNode ROLE() { return getToken(GDLParser.ROLE, 0); }
		public TerminalNode CONST() { return getToken(GDLParser.CONST, 0); }
		public RoleContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterRole(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitRole(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitRole(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CustomFactContext extends FactContext {
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public CustomFactContext(FactContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterCustomFact(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitCustomFact(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitCustomFact(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactContext fact() throws RecognitionException {
		FactContext _localctx = new FactContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_fact);
		try {
			setState(47);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				_localctx = new InitContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(T__2);
				setState(38);
				match(INIT);
				setState(39);
				predicate();
				setState(40);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new RoleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(42);
				match(T__2);
				setState(43);
				match(ROLE);
				setState(44);
				match(CONST);
				setState(45);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new CustomFactContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				head();
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

	public static class HeadContext extends ParserRuleContext {
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
	 
		public HeadContext() { }
		public void copyFrom(HeadContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class NextContext extends HeadContext {
		public TerminalNode NEXT() { return getToken(GDLParser.NEXT, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public NextContext(HeadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterNext(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitNext(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitNext(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InputContext extends HeadContext {
		public TerminalNode INPUT() { return getToken(GDLParser.INPUT, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public InputContext(HeadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterInput(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitInput(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitInput(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GoalContext extends HeadContext {
		public TerminalNode GOAL() { return getToken(GDLParser.GOAL, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public GoalContext(HeadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterGoal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitGoal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitGoal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CustomRuleContext extends HeadContext {
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public CustomRuleContext(HeadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterCustomRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitCustomRule(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitCustomRule(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LegalContext extends HeadContext {
		public TerminalNode LEGAL() { return getToken(GDLParser.LEGAL, 0); }
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public LegalContext(HeadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterLegal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitLegal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitLegal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TerminalContext extends HeadContext {
		public TerminalNode TERMINAL() { return getToken(GDLParser.TERMINAL, 0); }
		public TerminalContext(HeadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterTerminal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitTerminal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitTerminal(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BaseContext extends HeadContext {
		public TerminalNode BASE() { return getToken(GDLParser.BASE, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public BaseContext(HeadContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterBase(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitBase(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_head);
		try {
			setState(79);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				_localctx = new NextContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(49);
				match(T__2);
				setState(50);
				match(NEXT);
				setState(51);
				predicate();
				setState(52);
				match(T__1);
				}
				break;
			case 2:
				_localctx = new LegalContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(54);
				match(T__2);
				setState(55);
				match(LEGAL);
				setState(56);
				atom();
				setState(57);
				arg();
				setState(58);
				match(T__1);
				}
				break;
			case 3:
				_localctx = new GoalContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(60);
				match(T__2);
				setState(61);
				match(GOAL);
				setState(62);
				atom();
				setState(63);
				atom();
				setState(64);
				match(T__1);
				}
				break;
			case 4:
				_localctx = new BaseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(66);
				match(T__2);
				setState(67);
				match(BASE);
				setState(68);
				predicate();
				setState(69);
				match(T__1);
				}
				break;
			case 5:
				_localctx = new InputContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(71);
				match(T__2);
				setState(72);
				match(INPUT);
				setState(73);
				atom();
				setState(74);
				predicate();
				setState(75);
				match(T__1);
				}
				break;
			case 6:
				_localctx = new TerminalContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(77);
				match(TERMINAL);
				}
				break;
			case 7:
				_localctx = new CustomRuleContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(78);
				predicate();
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

	public static class ConditionContext extends ParserRuleContext {
		public TerminalNode ROLE() { return getToken(GDLParser.ROLE, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public TerminalNode TRUE() { return getToken(GDLParser.TRUE, 0); }
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public TerminalNode NOT() { return getToken(GDLParser.NOT, 0); }
		public List<ConditionContext> condition() {
			return getRuleContexts(ConditionContext.class);
		}
		public ConditionContext condition(int i) {
			return getRuleContext(ConditionContext.class,i);
		}
		public TerminalNode OR() { return getToken(GDLParser.OR, 0); }
		public TerminalNode DISTINCT() { return getToken(GDLParser.DISTINCT, 0); }
		public TerminalNode DOES() { return getToken(GDLParser.DOES, 0); }
		public ArgContext arg() {
			return getRuleContext(ArgContext.class,0);
		}
		public ConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_condition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterCondition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitCondition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConditionContext condition() throws RecognitionException {
		ConditionContext _localctx = new ConditionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_condition);
		int _la;
		try {
			setState(119);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(81);
				match(T__2);
				setState(82);
				match(ROLE);
				setState(83);
				atom();
				setState(84);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				match(T__2);
				setState(87);
				match(TRUE);
				setState(88);
				predicate();
				setState(89);
				match(T__1);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(91);
				match(T__2);
				setState(92);
				match(NOT);
				setState(93);
				condition();
				setState(94);
				match(T__1);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(96);
				match(T__2);
				setState(97);
				match(OR);
				setState(98);
				condition();
				setState(100); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(99);
					condition();
					}
					}
					setState(102); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==T__2 || _la==CONST );
				setState(104);
				match(T__1);
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(106);
				match(T__2);
				setState(107);
				match(DISTINCT);
				setState(108);
				atom();
				setState(109);
				atom();
				setState(110);
				match(T__1);
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(112);
				match(T__2);
				setState(113);
				match(DOES);
				setState(114);
				atom();
				setState(115);
				arg();
				setState(116);
				match(T__1);
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(118);
				predicate();
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

	public static class PredicateContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GDLParser.CONST, 0); }
		public List<AtomContext> atom() {
			return getRuleContexts(AtomContext.class);
		}
		public AtomContext atom(int i) {
			return getRuleContext(AtomContext.class,i);
		}
		public PredicateContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_predicate; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterPredicate(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitPredicate(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitPredicate(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PredicateContext predicate() throws RecognitionException {
		PredicateContext _localctx = new PredicateContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_predicate);
		int _la;
		try {
			setState(131);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONST:
				enterOuterAlt(_localctx, 1);
				{
				setState(121);
				match(CONST);
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(122);
				match(T__2);
				setState(123);
				match(CONST);
				setState(125); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(124);
					atom();
					}
					}
					setState(127); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CONST || _la==VAR );
				setState(129);
				match(T__1);
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

	public static class ArgContext extends ParserRuleContext {
		public AtomContext atom() {
			return getRuleContext(AtomContext.class,0);
		}
		public PredicateContext predicate() {
			return getRuleContext(PredicateContext.class,0);
		}
		public ArgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arg; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterArg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitArg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitArg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgContext arg() throws RecognitionException {
		ArgContext _localctx = new ArgContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_arg);
		try {
			setState(135);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(133);
				atom();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(134);
				predicate();
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

	public static class AtomContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GDLParser.CONST, 0); }
		public TerminalNode VAR() { return getToken(GDLParser.VAR, 0); }
		public AtomContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atom; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterAtom(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitAtom(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GDLVisitor ) return ((GDLVisitor<? extends T>)visitor).visitAtom(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomContext atom() throws RecognitionException {
		AtomContext _localctx = new AtomContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_atom);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(137);
			_la = _input.LA(1);
			if ( !(_la==CONST || _la==VAR) ) {
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\26\u008e\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\3\2\7"+
		"\2\26\n\2\f\2\16\2\31\13\2\3\3\3\3\5\3\35\n\3\3\4\3\4\3\4\6\4\"\n\4\r"+
		"\4\16\4#\3\4\3\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\5\5\62\n\5\3"+
		"\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\5\6R\n\6\3\7\3\7\3\7"+
		"\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\6\7g"+
		"\n\7\r\7\16\7h\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\3\7\5\7z\n\7\3\b\3\b\3\b\3\b\6\b\u0080\n\b\r\b\16\b\u0081\3\b\3\b\5\b"+
		"\u0086\n\b\3\t\3\t\5\t\u008a\n\t\3\n\3\n\3\n\2\2\13\2\4\6\b\n\f\16\20"+
		"\22\2\3\3\2\23\24\2\u0099\2\27\3\2\2\2\4\34\3\2\2\2\6\36\3\2\2\2\b\61"+
		"\3\2\2\2\nQ\3\2\2\2\fy\3\2\2\2\16\u0085\3\2\2\2\20\u0089\3\2\2\2\22\u008b"+
		"\3\2\2\2\24\26\5\4\3\2\25\24\3\2\2\2\26\31\3\2\2\2\27\25\3\2\2\2\27\30"+
		"\3\2\2\2\30\3\3\2\2\2\31\27\3\2\2\2\32\35\5\6\4\2\33\35\5\b\5\2\34\32"+
		"\3\2\2\2\34\33\3\2\2\2\35\5\3\2\2\2\36\37\7\3\2\2\37!\5\n\6\2 \"\5\f\7"+
		"\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7\4\2\2&\7\3\2"+
		"\2\2\'(\7\5\2\2()\7\6\2\2)*\5\16\b\2*+\7\4\2\2+\62\3\2\2\2,-\7\5\2\2-"+
		".\7\t\2\2./\7\23\2\2/\62\7\4\2\2\60\62\5\n\6\2\61\'\3\2\2\2\61,\3\2\2"+
		"\2\61\60\3\2\2\2\62\t\3\2\2\2\63\64\7\5\2\2\64\65\7\13\2\2\65\66\5\16"+
		"\b\2\66\67\7\4\2\2\67R\3\2\2\289\7\5\2\29:\7\r\2\2:;\5\22\n\2;<\5\20\t"+
		"\2<=\7\4\2\2=R\3\2\2\2>?\7\5\2\2?@\7\n\2\2@A\5\22\n\2AB\5\22\n\2BC\7\4"+
		"\2\2CR\3\2\2\2DE\7\5\2\2EF\7\7\2\2FG\5\16\b\2GH\7\4\2\2HR\3\2\2\2IJ\7"+
		"\5\2\2JK\7\b\2\2KL\5\22\n\2LM\5\16\b\2MN\7\4\2\2NR\3\2\2\2OR\7\f\2\2P"+
		"R\5\16\b\2Q\63\3\2\2\2Q8\3\2\2\2Q>\3\2\2\2QD\3\2\2\2QI\3\2\2\2QO\3\2\2"+
		"\2QP\3\2\2\2R\13\3\2\2\2ST\7\5\2\2TU\7\t\2\2UV\5\22\n\2VW\7\4\2\2Wz\3"+
		"\2\2\2XY\7\5\2\2YZ\7\17\2\2Z[\5\16\b\2[\\\7\4\2\2\\z\3\2\2\2]^\7\5\2\2"+
		"^_\7\16\2\2_`\5\f\7\2`a\7\4\2\2az\3\2\2\2bc\7\5\2\2cd\7\20\2\2df\5\f\7"+
		"\2eg\5\f\7\2fe\3\2\2\2gh\3\2\2\2hf\3\2\2\2hi\3\2\2\2ij\3\2\2\2jk\7\4\2"+
		"\2kz\3\2\2\2lm\7\5\2\2mn\7\21\2\2no\5\22\n\2op\5\22\n\2pq\7\4\2\2qz\3"+
		"\2\2\2rs\7\5\2\2st\7\22\2\2tu\5\22\n\2uv\5\20\t\2vw\7\4\2\2wz\3\2\2\2"+
		"xz\5\16\b\2yS\3\2\2\2yX\3\2\2\2y]\3\2\2\2yb\3\2\2\2yl\3\2\2\2yr\3\2\2"+
		"\2yx\3\2\2\2z\r\3\2\2\2{\u0086\7\23\2\2|}\7\5\2\2}\177\7\23\2\2~\u0080"+
		"\5\22\n\2\177~\3\2\2\2\u0080\u0081\3\2\2\2\u0081\177\3\2\2\2\u0081\u0082"+
		"\3\2\2\2\u0082\u0083\3\2\2\2\u0083\u0084\7\4\2\2\u0084\u0086\3\2\2\2\u0085"+
		"{\3\2\2\2\u0085|\3\2\2\2\u0086\17\3\2\2\2\u0087\u008a\5\22\n\2\u0088\u008a"+
		"\5\16\b\2\u0089\u0087\3\2\2\2\u0089\u0088\3\2\2\2\u008a\21\3\2\2\2\u008b"+
		"\u008c\t\2\2\2\u008c\23\3\2\2\2\f\27\34#\61Qhy\u0081\u0085\u0089";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}