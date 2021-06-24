// Generated from GDL.g4 by ANTLR 4.9.2
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
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, CONST=8, COMMENT=9, 
		WS=10;
	public static final int
		RULE_description = 0, RULE_gdlRule = 1, RULE_literal = 2, RULE_notLiteral = 3, 
		RULE_orLiteral = 4, RULE_distinctLiteral = 5, RULE_propositionLiteral = 6, 
		RULE_relationLiteral = 7, RULE_term = 8, RULE_var = 9;
	private static String[] makeRuleNames() {
		return new String[] {
			"description", "gdlRule", "literal", "notLiteral", "orLiteral", "distinctLiteral", 
			"propositionLiteral", "relationLiteral", "term", "var"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'(<='", "')'", "'('", "'not'", "'or'", "'distinct'", "'?'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, null, null, null, null, "CONST", "COMMENT", "WS"
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
		public List<GdlRuleContext> gdlRule() {
			return getRuleContexts(GdlRuleContext.class);
		}
		public GdlRuleContext gdlRule(int i) {
			return getRuleContext(GdlRuleContext.class,i);
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
	}

	public final DescriptionContext description() throws RecognitionException {
		DescriptionContext _localctx = new DescriptionContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_description);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << CONST))) != 0)) {
				{
				{
				setState(20);
				gdlRule();
				}
				}
				setState(25);
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

	public static class GdlRuleContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public GdlRuleContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_gdlRule; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterGdlRule(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitGdlRule(this);
		}
	}

	public final GdlRuleContext gdlRule() throws RecognitionException {
		GdlRuleContext _localctx = new GdlRuleContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_gdlRule);
		int _la;
		try {
			setState(35);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(26);
				match(T__0);
				setState(28); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(27);
					literal();
					}
					}
					setState(30); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__2) | (1L << T__3) | (1L << T__4) | (1L << T__5) | (1L << CONST))) != 0) );
				setState(32);
				match(T__1);
				}
				break;
			case T__2:
			case T__3:
			case T__4:
			case T__5:
			case CONST:
				enterOuterAlt(_localctx, 2);
				{
				setState(34);
				literal();
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

	public static class LiteralContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public NotLiteralContext notLiteral() {
			return getRuleContext(NotLiteralContext.class,0);
		}
		public OrLiteralContext orLiteral() {
			return getRuleContext(OrLiteralContext.class,0);
		}
		public DistinctLiteralContext distinctLiteral() {
			return getRuleContext(DistinctLiteralContext.class,0);
		}
		public PropositionLiteralContext propositionLiteral() {
			return getRuleContext(PropositionLiteralContext.class,0);
		}
		public RelationLiteralContext relationLiteral() {
			return getRuleContext(RelationLiteralContext.class,0);
		}
		public LiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitLiteral(this);
		}
	}

	public final LiteralContext literal() throws RecognitionException {
		LiteralContext _localctx = new LiteralContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_literal);
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				match(T__2);
				setState(38);
				literal();
				setState(39);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				notLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(42);
				orLiteral();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(43);
				distinctLiteral();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(44);
				propositionLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(45);
				relationLiteral();
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

	public static class NotLiteralContext extends ParserRuleContext {
		public LiteralContext literal() {
			return getRuleContext(LiteralContext.class,0);
		}
		public NotLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_notLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterNotLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitNotLiteral(this);
		}
	}

	public final NotLiteralContext notLiteral() throws RecognitionException {
		NotLiteralContext _localctx = new NotLiteralContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_notLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(48);
			match(T__3);
			setState(49);
			literal();
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

	public static class OrLiteralContext extends ParserRuleContext {
		public List<LiteralContext> literal() {
			return getRuleContexts(LiteralContext.class);
		}
		public LiteralContext literal(int i) {
			return getRuleContext(LiteralContext.class,i);
		}
		public OrLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_orLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterOrLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitOrLiteral(this);
		}
	}

	public final OrLiteralContext orLiteral() throws RecognitionException {
		OrLiteralContext _localctx = new OrLiteralContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_orLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(51);
			match(T__4);
			setState(52);
			literal();
			setState(54); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(53);
					literal();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(56); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
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

	public static class DistinctLiteralContext extends ParserRuleContext {
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public DistinctLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_distinctLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterDistinctLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitDistinctLiteral(this);
		}
	}

	public final DistinctLiteralContext distinctLiteral() throws RecognitionException {
		DistinctLiteralContext _localctx = new DistinctLiteralContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_distinctLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(58);
			match(T__5);
			setState(59);
			term();
			setState(60);
			term();
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

	public static class PropositionLiteralContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GDLParser.CONST, 0); }
		public PropositionLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propositionLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterPropositionLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitPropositionLiteral(this);
		}
	}

	public final PropositionLiteralContext propositionLiteral() throws RecognitionException {
		PropositionLiteralContext _localctx = new PropositionLiteralContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_propositionLiteral);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(62);
			match(CONST);
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

	public static class RelationLiteralContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GDLParser.CONST, 0); }
		public List<TermContext> term() {
			return getRuleContexts(TermContext.class);
		}
		public TermContext term(int i) {
			return getRuleContext(TermContext.class,i);
		}
		public RelationLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relationLiteral; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterRelationLiteral(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitRelationLiteral(this);
		}
	}

	public final RelationLiteralContext relationLiteral() throws RecognitionException {
		RelationLiteralContext _localctx = new RelationLiteralContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_relationLiteral);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			match(CONST);
			setState(66); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(65);
					term();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(68); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
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

	public static class TermContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public VarContext var() {
			return getRuleContext(VarContext.class,0);
		}
		public TerminalNode CONST() { return getToken(GDLParser.CONST, 0); }
		public RelationLiteralContext relationLiteral() {
			return getRuleContext(RelationLiteralContext.class,0);
		}
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitTerm(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		TermContext _localctx = new TermContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_term);
		try {
			setState(77);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				match(T__2);
				setState(71);
				term();
				setState(72);
				match(T__1);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(74);
				var();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(75);
				match(CONST);
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(76);
				relationLiteral();
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

	public static class VarContext extends ParserRuleContext {
		public TerminalNode CONST() { return getToken(GDLParser.CONST, 0); }
		public VarContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).enterVar(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GDLListener ) ((GDLListener)listener).exitVar(this);
		}
	}

	public final VarContext var() throws RecognitionException {
		VarContext _localctx = new VarContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(79);
			match(T__6);
			setState(80);
			match(CONST);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\fU\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\3"+
		"\2\7\2\30\n\2\f\2\16\2\33\13\2\3\3\3\3\6\3\37\n\3\r\3\16\3 \3\3\3\3\3"+
		"\3\5\3&\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\5\4\61\n\4\3\5\3\5\3\5"+
		"\3\6\3\6\3\6\6\69\n\6\r\6\16\6:\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\6\tE\n"+
		"\t\r\t\16\tF\3\n\3\n\3\n\3\n\3\n\3\n\3\n\5\nP\n\n\3\13\3\13\3\13\3\13"+
		"\2\2\f\2\4\6\b\n\f\16\20\22\24\2\2\2W\2\31\3\2\2\2\4%\3\2\2\2\6\60\3\2"+
		"\2\2\b\62\3\2\2\2\n\65\3\2\2\2\f<\3\2\2\2\16@\3\2\2\2\20B\3\2\2\2\22O"+
		"\3\2\2\2\24Q\3\2\2\2\26\30\5\4\3\2\27\26\3\2\2\2\30\33\3\2\2\2\31\27\3"+
		"\2\2\2\31\32\3\2\2\2\32\3\3\2\2\2\33\31\3\2\2\2\34\36\7\3\2\2\35\37\5"+
		"\6\4\2\36\35\3\2\2\2\37 \3\2\2\2 \36\3\2\2\2 !\3\2\2\2!\"\3\2\2\2\"#\7"+
		"\4\2\2#&\3\2\2\2$&\5\6\4\2%\34\3\2\2\2%$\3\2\2\2&\5\3\2\2\2\'(\7\5\2\2"+
		"()\5\6\4\2)*\7\4\2\2*\61\3\2\2\2+\61\5\b\5\2,\61\5\n\6\2-\61\5\f\7\2."+
		"\61\5\16\b\2/\61\5\20\t\2\60\'\3\2\2\2\60+\3\2\2\2\60,\3\2\2\2\60-\3\2"+
		"\2\2\60.\3\2\2\2\60/\3\2\2\2\61\7\3\2\2\2\62\63\7\6\2\2\63\64\5\6\4\2"+
		"\64\t\3\2\2\2\65\66\7\7\2\2\668\5\6\4\2\679\5\6\4\28\67\3\2\2\29:\3\2"+
		"\2\2:8\3\2\2\2:;\3\2\2\2;\13\3\2\2\2<=\7\b\2\2=>\5\22\n\2>?\5\22\n\2?"+
		"\r\3\2\2\2@A\7\n\2\2A\17\3\2\2\2BD\7\n\2\2CE\5\22\n\2DC\3\2\2\2EF\3\2"+
		"\2\2FD\3\2\2\2FG\3\2\2\2G\21\3\2\2\2HI\7\5\2\2IJ\5\22\n\2JK\7\4\2\2KP"+
		"\3\2\2\2LP\5\24\13\2MP\7\n\2\2NP\5\20\t\2OH\3\2\2\2OL\3\2\2\2OM\3\2\2"+
		"\2ON\3\2\2\2P\23\3\2\2\2QR\7\t\2\2RS\7\n\2\2S\25\3\2\2\2\t\31 %\60:FO";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}