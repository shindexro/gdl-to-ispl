// Generated from D:/Study/Year 4/Individual Project/gdl2ispl/src/main/java/antlr\GDL.g4 by ANTLR 4.9.1
package antlr;
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
	 * Enter a parse tree produced by {@link GDLParser#clause}.
	 * @param ctx the parse tree
	 */
	void enterClause(GDLParser.ClauseContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#clause}.
	 * @param ctx the parse tree
	 */
	void exitClause(GDLParser.ClauseContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#grule}.
	 * @param ctx the parse tree
	 */
	void enterGrule(GDLParser.GruleContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#grule}.
	 * @param ctx the parse tree
	 */
	void exitGrule(GDLParser.GruleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code init}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterInit(GDLParser.InitContext ctx);
	/**
	 * Exit a parse tree produced by the {@code init}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitInit(GDLParser.InitContext ctx);
	/**
	 * Enter a parse tree produced by the {@code role}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterRole(GDLParser.RoleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code role}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitRole(GDLParser.RoleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code customFact}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 */
	void enterCustomFact(GDLParser.CustomFactContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customFact}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 */
	void exitCustomFact(GDLParser.CustomFactContext ctx);
	/**
	 * Enter a parse tree produced by the {@code next}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void enterNext(GDLParser.NextContext ctx);
	/**
	 * Exit a parse tree produced by the {@code next}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void exitNext(GDLParser.NextContext ctx);
	/**
	 * Enter a parse tree produced by the {@code legal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void enterLegal(GDLParser.LegalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code legal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void exitLegal(GDLParser.LegalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code goal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void enterGoal(GDLParser.GoalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code goal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void exitGoal(GDLParser.GoalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code base}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void enterBase(GDLParser.BaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code base}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void exitBase(GDLParser.BaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code input}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void enterInput(GDLParser.InputContext ctx);
	/**
	 * Exit a parse tree produced by the {@code input}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void exitInput(GDLParser.InputContext ctx);
	/**
	 * Enter a parse tree produced by the {@code terminal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void enterTerminal(GDLParser.TerminalContext ctx);
	/**
	 * Exit a parse tree produced by the {@code terminal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void exitTerminal(GDLParser.TerminalContext ctx);
	/**
	 * Enter a parse tree produced by the {@code customRule}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void enterCustomRule(GDLParser.CustomRuleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code customRule}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 */
	void exitCustomRule(GDLParser.CustomRuleContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#condition}.
	 * @param ctx the parse tree
	 */
	void enterCondition(GDLParser.ConditionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#condition}.
	 * @param ctx the parse tree
	 */
	void exitCondition(GDLParser.ConditionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void enterPredicate(GDLParser.PredicateContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#predicate}.
	 * @param ctx the parse tree
	 */
	void exitPredicate(GDLParser.PredicateContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#arg}.
	 * @param ctx the parse tree
	 */
	void enterArg(GDLParser.ArgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#arg}.
	 * @param ctx the parse tree
	 */
	void exitArg(GDLParser.ArgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GDLParser#atom}.
	 * @param ctx the parse tree
	 */
	void enterAtom(GDLParser.AtomContext ctx);
	/**
	 * Exit a parse tree produced by {@link GDLParser#atom}.
	 * @param ctx the parse tree
	 */
	void exitAtom(GDLParser.AtomContext ctx);
}