// Generated from GDL.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GDLParser}.
 */
public interface GDLListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GDLParser#description}.
	 * @param ctx the parse tree
	 */
	void enterDescription(GDLParser.DescriptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#description}.
	 * @param ctx the parse tree
	 */
	void exitDescription(GDLParser.DescriptionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#gdlRule}.
	 * @param ctx the parse tree
	 */
	void enterGdlRule(GDLParser.GdlRuleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#gdlRule}.
	 * @param ctx the parse tree
	 */
	void exitGdlRule(GDLParser.GdlRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#comment}.
	 * @param ctx the parse tree
	 */
	void enterComment(GDLParser.CommentContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#comment}.
	 * @param ctx the parse tree
	 */
	void exitComment(GDLParser.CommentContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void enterLiteral(GDLParser.LiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#literal}.
	 * @param ctx the parse tree
	 */
	void exitLiteral(GDLParser.LiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#notLiteral}.
	 * @param ctx the parse tree
	 */
	void enterNotLiteral(GDLParser.NotLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#notLiteral}.
	 * @param ctx the parse tree
	 */
	void exitNotLiteral(GDLParser.NotLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#orLiteral}.
	 * @param ctx the parse tree
	 */
	void enterOrLiteral(GDLParser.OrLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#orLiteral}.
	 * @param ctx the parse tree
	 */
	void exitOrLiteral(GDLParser.OrLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#distinctLiteral}.
	 * @param ctx the parse tree
	 */
	void enterDistinctLiteral(GDLParser.DistinctLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#distinctLiteral}.
	 * @param ctx the parse tree
	 */
	void exitDistinctLiteral(GDLParser.DistinctLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#propositionLiteral}.
	 * @param ctx the parse tree
	 */
	void enterPropositionLiteral(GDLParser.PropositionLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#propositionLiteral}.
	 * @param ctx the parse tree
	 */
	void exitPropositionLiteral(GDLParser.PropositionLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#relationLiteral}.
	 * @param ctx the parse tree
	 */
	void enterRelationLiteral(GDLParser.RelationLiteralContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#relationLiteral}.
	 * @param ctx the parse tree
	 */
	void exitRelationLiteral(GDLParser.RelationLiteralContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(GDLParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(GDLParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#var}.
	 * @param ctx the parse tree
	 */
	void enterVar(GDLParser.VarContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#var}.
	 * @param ctx the parse tree
	 */
	void exitVar(GDLParser.VarContext ctx);
}