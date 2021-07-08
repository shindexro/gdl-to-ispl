import antlr.GDLBaseListener;
import antlr.GDLParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.*;

public class TranslationListener extends GDLBaseListener {
    private final GDLParser parser;
    private final Set<String> roles;
    private final Set<GDLParser.InitContext> inits;
    private final Set<GDLParser.NextContext> nexts;
    private final Set<GDLParser.GoalContext> goals;
    private final Set<GDLParser.LegalContext> legals;
    private final Set<GDLParser.TerminalContext> terminals;
    private final Map<String, Relation> relations;

    private static final String TRUE = "(Environment.terminal = Environment.terminal)";
    private static final String FALSE = "(Environment.terminal != Environment.terminal)";

    public TranslationListener(GDLParser parser) {
        this.parser = parser;
        this.roles = new HashSet<>();
        this.inits = new HashSet<>();
        this.nexts = new HashSet<>();
        this.goals = new HashSet<>();
        this.legals = new HashSet<>();
        this.terminals = new HashSet<>();
        this.relations = new HashMap<>();
    }

    @Override
    public void enterInit(GDLParser.InitContext ctx) {
        inits.add(ctx);
        addRelation(ctx.predicate());
    }

    @Override
    public void enterRole(GDLParser.RoleContext ctx) {
        roles.add(ctx.CONST().getText());
    }

    @Override
    public void enterNext(GDLParser.NextContext ctx) {
        nexts.add(ctx);
        addRelation(ctx.predicate());
    }

    @Override
    public void enterGoal(GDLParser.GoalContext ctx) {
        goals.add(ctx);
    }

    @Override
    public void enterLegal(GDLParser.LegalContext ctx) {
        legals.add(ctx);
    }

    @Override
    public void enterTerminal(GDLParser.TerminalContext ctx) {
        terminals.add(ctx);
    }

    private void addRelation(GDLParser.PredicateContext ctx) {
        String name = ctx.CONST().getText();
        List<GDLParser.AtomContext> atoms = ctx.atom();

        relations.putIfAbsent(name, new Relation(name, atoms.size()));
        for (int i = 0; i < atoms.size(); i++)
            if (isGround(atoms.get(i)))
                relations.get(name).addArg(i, atoms.get(i).getText());
    }

    @Override
    public void exitDescription(GDLParser.DescriptionContext ctx) {
        printEnvironmentAgent();
        for (String role : roles)
            printAgent(role);
        printInitStates();
    }

    private void printInitStates() {
        output("InitStates:");
        for (String role : roles) {
            output(String.format("Environment.points_%s=0", role), 1);
        }
        for (GDLParser.InitContext ctx : inits) {
            output(String.format("Environment.%s=true", ctx.predicate().getText()), 1);
        }
        output("end InitStates");
    }

    private void printAgent(String role) {
        output(String.format("Agent %s:", role));
        output("end Agent");
        output();
    }

    private void printEnvironmentAgent() {
        output("Agent Environment:");

        // Observable variables
        output("Obsvars:", 1);
        output("terminal: boolean", 2);

        for (String role : roles)
            output(String.format("points_%s: 0..100", role), 2);

        for (Relation rel : relations.values())
            for (List<String> pred : rel.all())
                output(String.format("%s: boolean", String.join("_", pred)), 2);

        output("end Obsvars", 1);

        // Evolution function
        output("Evolution:", 1);

        for (GDLParser.GoalContext ctx : goals) {
            String role = ctx.atom(0).getText();
            int score = Integer.parseInt(ctx.atom(1).getText());
            GDLParser.GruleContext rule = (GDLParser.GruleContext) ctx.parent;
            output(String.format("points_%s=%d if ", role, score), 2);
            output(expandRuleConditions(rule, new HashMap<>()), 3);
        }

        for (GDLParser.NextContext ctx : nexts) {
            GDLParser.PredicateContext pred = ctx.predicate();
            String predName = pred.CONST().getText();
            Relation rel = relations.get(predName);
            GDLParser.GruleContext rule = (GDLParser.GruleContext) ctx.parent;

            for (List<String> args : rel.all()) {
                Map<String, String> varMap = generateVarMap(pred, args);
                if (varMap == null) continue;
                output(String.format("%s=true if ", String.join("_", args)), 2);
                output(expandRuleConditions(rule, varMap), 3);
            }
        }

        for (GDLParser.TerminalContext ctx : terminals) {
            GDLParser.GruleContext rule = (GDLParser.GruleContext) ctx.parent;
            output("terminal=true if ", 2);
            output(expandRuleConditions(rule, new HashMap<>()), 3);
        }

        output("end Evolution", 1);


        output("end Agent");
        output();
    }

    private Map<String, String> generateVarMap(GDLParser.PredicateContext pred, List<String> groundArgs) {
        List<GDLParser.AtomContext> atoms = pred.atom();
        Map<String, String> varMap = new HashMap<>();
        for (int i = 0; i < atoms.size(); i++) {
            GDLParser.AtomContext atom = atoms.get(i);
            if (atom.VAR() != null) {
                varMap.put(atom.VAR().getText().substring(1), groundArgs.get(i + 1));
            } else if (!atom.CONST().getText().equals(groundArgs.get(i + 1))) {
                return null;
            }
        }
        return varMap;
    }

    private String expandRuleConditions(GDLParser.GruleContext ctx, Map<String, String> varMap) {
        List<GDLParser.ConditionContext> conditions = ctx.condition();
        if (conditions == null || conditions.isEmpty())
            return null;

        StringBuilder sb = new StringBuilder();
        sb.append(expandCondition(conditions.get(0), varMap));
        for (int i = 1; i < conditions.size(); i++) {
            sb.append(" and ");
            sb.append(expandCondition(conditions.get(i), varMap));
        }
        return sb.toString();
    }

    private String expandCondition(GDLParser.ConditionContext ctx, Map<String, String> varMap) {
        if (ctx.ROLE() != null) {
            return roles.contains(sub(ctx.atom(0), varMap)) ? TRUE : FALSE;

        } else if (ctx.TRUE() != null) {
            return expandPredicate(ctx.predicate(), varMap);

        } else if (ctx.NOT() != null) {
            return "!(" + expandCondition(ctx.condition(0), varMap) + ")";

        } else if (ctx.OR() != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("(");
            sb.append(expandCondition(ctx.condition(0), varMap));
            for (int i = 1; i < ctx.condition().size(); i++) {
                sb.append(" or ");
                sb.append(expandCondition(ctx.condition(i), varMap));
            }
            sb.append(")");
            return sb.toString();

        } else if (ctx.DISTINCT() != null) {
            String left = sub(ctx.atom(0), varMap);
            String right = sub(ctx.atom(1), varMap);
            return left.equals(right) ? FALSE : TRUE;

        } else if (ctx.DOES() != null) {
            return String.format("%s.Action=%s",
                    sub(ctx.atom(0), varMap),
                    sub(ctx.arg(), varMap));

        } else {
            return expandPredicate(ctx.predicate(), varMap);
        }
    }

    private String expandPredicate(GDLParser.PredicateContext ctx, Map<String, String> varMap) {
        StringBuilder sb = new StringBuilder();
        sb.append(ctx.CONST().getText());
        for (GDLParser.AtomContext atom : ctx.atom()) {
            sb.append("_");
            sb.append(sub(atom, varMap));
        }
        return sb.toString();
    }

    private String sub(GDLParser.ArgContext arg, Map<String, String> varMap) {
        if (arg.atom() != null) {
            return sub(arg.atom(), varMap);
        } else {
            GDLParser.PredicateContext pred = arg.predicate();
            StringBuilder sb = new StringBuilder();
            sb.append(pred.CONST());
            for (GDLParser.AtomContext atom : pred.atom()) {
                sb.append("_");
                sb.append(sub(atom, varMap));
            }
            return sb.toString();
        }
    }

    private String sub(GDLParser.AtomContext atom, Map<String, String> varMap) {
        if (atom.CONST() != null)
            return atom.CONST().getText();
        String var = atom.VAR().getText().substring(1);
        return varMap.getOrDefault(var, atom.getText());
    }

    private void output() {
        System.out.println();
    }

    private void output(String str) {
        output(str, 0);
    }

    private void output(String str, int indentation) {
        for (int i = 0; i < indentation; i++)
            System.out.print("    ");
        System.out.println(str);
    }

    private void printContexts(Set<? extends ParserRuleContext> set) {
        for (ParserRuleContext ctx : set) {
            System.out.print(ctx.getText() + ", ");
        }
        System.out.println();
    }

    private boolean isGround(GDLParser.AtomContext ctx) {
        return ctx.CONST() != null;
    }
}
