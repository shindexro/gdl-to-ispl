import org.ggp.base.util.gdl.grammar.*;

import java.util.*;

public class IsplDescriptionFactory {

    private static final String TRUE = "Environment.dummyvar=Environment.dummyvar";
    private static final String FALSE = "!(Environment.dummyvar=Environment.dummyvar)";

    private final List<GdlRule> flatGdlDescription;
    private final StringBuilder isplDescription;
    private String terminalCondition;

    private final Set<String> roles = new HashSet<>();
    private final Map<String, Set<GdlRule>> relations = new HashMap<>();
    private final Set<GdlRule> legals = new HashSet<>();
    private final Set<GdlRule> goals = new HashSet<>();
    private final Set<GdlRule> nexts = new HashSet<>();
    private final Set<GdlRule> inits = new HashSet<>();
    private final Set<GdlRule> terminals = new HashSet<>();
    private final Set<String> basePropositions = new HashSet<>();
    private final Set<String> initPropositions = new HashSet<>();

    private final Map<String, List<String>> propToNextRuleConditions = new HashMap<>();
    private final Map<String, Set<String>> agentActions = new HashMap<>();
    private final Map<String, List<String>> agentProtocols = new HashMap<>();

    public IsplDescriptionFactory(List<GdlRule> flatGdlDescription) {
        this.flatGdlDescription = flatGdlDescription;
        this.isplDescription = new StringBuilder();
    }

    public String build() {
        if (isplDescription.length() > 0)
            return isplDescription.toString();
        groupRules();

        setBasePropositions();
        setInitPropositions();
        setTerminalCondition();
        setAgentInfo();
        setEvolutions();

        format();
        return this.isplDescription.toString();
    }

    private void format() {
        append("Semantics = SingleAssignment;\n");
        formatEnvironmentAgent();
        for (String role : roles) {
            formatStandardAgent(role);
        }
        formatEvaluation();
        formatInitStates();
        formatFormulae();
    }

    private void formatInitStates() {
        append("InitStates\n");
        for (String prop : basePropositions) {
            if (initPropositions.contains(prop)) {
                append("  Environment.").append(prop).append("=true and\n");
            } else {
                append("  Environment.").append(prop).append("=false and\n");
            }
        }
        for (String role : roles) {
            append(String.format("  %s.dummyvar=true and\n", role));
        }
        append("  Environment.dummyvar=true ;\n");
        append("end InitStates\n\n");
    }

    private void formatFormulae() {
        append("Formulae\n");
        append("  -- Environment.RedStates refers to terminal game states.\n");
        append("  EF Environment.RedStates;\n");
        append("end Formulae\n\n");
    }

    private void formatEvaluation() {
        append("Evaluation\n");
        for (GdlRule r : goals) {
            GdlSentence head = r.getHead();
            List<GdlLiteral> body = r.getBody();
            append(String.format("  %s if %s; \n", translateSentence(head), expandLiterals(body, relations)));
        }
        append("end Evaluation\n\n");
    }

    private void formatStandardAgent(String role) {
        append("Agent ").append(role).append("\n");
        append("  Vars:\n    dummyvar : boolean;\n  end Vars\n");
        append("  Actions = ").append(agentActions.get(role).toString().replace('[', '{').replace(']', '}')).append(";\n");
        append("  Protocol:\n");
        for (String proto : agentProtocols.get(role)) {
            append("    ").append(proto).append(";\n");
        }
        append("  end Protocol\n");
        append("  Evolution:\n    dummyvar=true if dummyvar=dummyvar;\n  end Evolution\n");
        append("end Agent\n\n");
    }

    private void formatEnvironmentAgent() {
        append("Agent Environment\n");
        append("  Obsvars:\n");
        for (String prop : basePropositions) {
            append("    ").append(prop).append(" : boolean;\n");
        }
        append("    dummyvar : boolean;\n");
        append("  end Obsvars\n");
        append("  Vars:\n  end Vars\n");
        append("  RedStates:\n    ").append(terminalCondition.replace("Environment.", "")).append(";\n  end RedStates\n");
        append("  Actions={noop};\n  Protocol:\n  end Protocol\n");

        append("  Evolution:\n");
        for (Map.Entry<String, List<String>> entry : propToNextRuleConditions.entrySet()) {
            String prop = entry.getKey();
            String condition = String.join(" or ", entry.getValue()).replace("Environment.", "");
            append(String.format("    %s=true if %s ;\n", prop, condition));
            append(String.format("    %s=false if !( %s ) ;\n", prop, condition));
        }
        append("    dummyvar=true if dummyvar=dummyvar ;\n");
        append("  end Evolution\n");

        append("end Agent\n\n");
    }

    private void setTerminalCondition() {
        StringBuilder sb = new StringBuilder();
        for (GdlRule r : terminals) {
            if (sb.length() > 0)
                sb.append(" or ");
            sb.append("( ").append(expandLiterals(r.getBody(), relations)).append(" )");
        }
        terminalCondition = sb.toString();
    }

    private void groupRules() {
        for (GdlRule rule : flatGdlDescription) {
            GdlSentence head = rule.getHead();
            String headName = head.getName().toString();

            switch (headName) {
                case "role":
                    roles.add(head.get(0).toString());
                    break;
                case "init":
                    inits.add(rule);
                    break;
                case "next":
                    nexts.add(rule);
                    break;
                case "legal":
                    legals.add(rule);
                    break;
                case "goal":
                    goals.add(rule);
                    break;
                case "terminal":
                    terminals.add(rule);
                    break;
            }

            String relName = translateSentence(head);
            relations.putIfAbsent(relName, new HashSet<>());
            relations.get(relName).add(rule);
        }
    }

    private void setBasePropositions() {
        for (GdlRule r : nexts) {
            GdlSentence head = r.getHead();
            GdlTerm prop = head.get(0);
            basePropositions.add(translateTerm(prop));
        }

        for (GdlRule r : inits) {
            GdlSentence head = r.getHead();
            GdlTerm prop = head.get(0);
            basePropositions.add(translateTerm(prop));
        }
    }

    private void setInitPropositions() {
        for (GdlRule r : inits) {
            GdlSentence head = r.getHead();
            GdlTerm prop = head.get(0);
            initPropositions.add(translateTerm(prop));
        }
    }


    private void setAgentInfo() {
        for (GdlRule r : legals) {
            GdlSentence head = r.getHead();
            List<GdlLiteral> body = r.getBody();
            String role = head.get(0).toString();
            String action = translateTerm(head.get(1));

            agentProtocols.putIfAbsent(role, new ArrayList<>());
            agentProtocols.get(role).add(String.format("( !( %s ) and ( %s ) ) : { %s }",
                    terminalCondition, expandLiterals(body, relations), action));

            agentActions.putIfAbsent(role, new HashSet<>());
            agentActions.get(role).add(action);
        }
    }

    private void setEvolutions() {
        for (GdlRule r : nexts) {
            GdlSentence head = r.getHead();
            List<GdlLiteral> body = r.getBody();
            String prop = translateTerm(head.get(0));
            propToNextRuleConditions.putIfAbsent(prop, new ArrayList<>());
            propToNextRuleConditions.get(prop).add(expandLiterals(body, relations));
        }
    }

    private StringBuilder append(String str) {
        return isplDescription.append(str);
    }

    private static String translateTerm(GdlTerm term) {
        return translateSentence(term.toSentence());
    }

    private static String translateSentence(GdlSentence sentence) {
        StringBuilder sb = new StringBuilder();
        sb.append(sentence.getName());
        for (GdlTerm term : sentence.getBody()) {
            sb.append('_');
            sb.append(term.toString());
        }
        return sb.toString();
    }

    private static String expandLiteral(GdlLiteral literal, Map<String, Set<GdlRule>> relations) {
        if (literal instanceof GdlNot) {
            GdlNot not = (GdlNot) literal;
            return "!(" + expandLiteral(not.getBody(), relations) + ")";

        } else if (literal instanceof GdlDistinct) {
            GdlDistinct distinct = (GdlDistinct) literal;
            String arg1 = distinct.getArg1().toString();
            String arg2 = distinct.getArg2().toString();
            return arg1.equals(arg2) ? FALSE : TRUE;

        } else if (literal instanceof GdlOr) {
            throw new IllegalArgumentException("Description should not contain Or rules, considering using the DeOrer");

        } else if (literal instanceof GdlSentence) {
            GdlSentence sentence = (GdlSentence) literal;
            String head = sentence.getName().getValue();
            if (head.equals("true")) {
                return String.format("Environment.%s=true", translateTerm(sentence.get(0)));

            } else if (head.equals("does")) {
                String role = sentence.get(0).toString();
                String action = translateTerm(sentence.get(1));
                return String.format("%s.Action=%s", role, action);

            } else {
                return expandCustomSentence(sentence, relations);
            }
        }
        throw new IllegalArgumentException("Unknown literal: " + literal);
    }

    private static String expandCustomSentence(GdlSentence sentence, Map<String, Set<GdlRule>> relations) {
        String relName = translateSentence(sentence);
        Set<GdlRule> outRules = relations.get(relName);
        StringBuilder sb = new StringBuilder();
        for (GdlRule rule : outRules) {
            if (sb.length() > 0)
                sb.append(" or ");
            sb.append(expandLiterals(rule.getBody(), relations));
        }
        return sb.toString();
    }

    private static String expandLiterals(List<GdlLiteral> literals, Map<String, Set<GdlRule>> relations) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (GdlLiteral lit : literals) {
            if (sb.length() > 1)
                sb.append(" and ");
            sb.append(expandLiteral(lit, relations));
        }
        sb.append(')');
        return sb.toString();
    }
}
