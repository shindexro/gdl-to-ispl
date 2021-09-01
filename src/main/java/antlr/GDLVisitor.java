// Generated from D:/Study/Year 4/Individual Project/gdl2ispl/src/main/java/antlr\GDL.g4 by ANTLR 4.9.1
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GDLParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GDLVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GDLParser#description}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDescription(GDLParser.DescriptionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GDLParser#clause}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClause(GDLParser.ClauseContext ctx);
	/**
	 * Visit a parse tree produced by {@link GDLParser#grule}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrule(GDLParser.GruleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code init}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInit(GDLParser.InitContext ctx);
	/**
	 * Visit a parse tree produced by the {@code role}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRole(GDLParser.RoleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code customFact}
	 * labeled alternative in {@link GDLParser#fact}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomFact(GDLParser.CustomFactContext ctx);
	/**
	 * Visit a parse tree produced by the {@code next}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNext(GDLParser.NextContext ctx);
	/**
	 * Visit a parse tree produced by the {@code legal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLegal(GDLParser.LegalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code goal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGoal(GDLParser.GoalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code base}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBase(GDLParser.BaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code input}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInput(GDLParser.InputContext ctx);
	/**
	 * Visit a parse tree produced by the {@code terminal}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerminal(GDLParser.TerminalContext ctx);
	/**
	 * Visit a parse tree produced by the {@code customRule}
	 * labeled alternative in {@link GDLParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCustomRule(GDLParser.CustomRuleContext ctx);
	/**
	 * Visit a parse tree produced by {@link GDLParser#condition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCondition(GDLParser.ConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GDLParser#predicate}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPredicate(GDLParser.PredicateContext ctx);
	/**
	 * Visit a parse tree produced by {@link GDLParser#arg}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArg(GDLParser.ArgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GDLParser#atom}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtom(GDLParser.AtomContext ctx);
}