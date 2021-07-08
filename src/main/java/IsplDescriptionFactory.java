import org.ggp.base.util.gdl.grammar.*;

import java.util.*;

public class IsplDescriptionFactory {

    private static final String TRUE = "Environment.terminal=Environment.terminal";
    private static final String FALSE = "!(Environment.terminal=Environment.terminal)";

    private IsplDescriptionFactory() {
    }

    public static String create(List<GdlRule> flatGdlDescription) {
        Set<String> roles = new HashSet<>();
        Set<String> basePropositions = new HashSet<>();
        Set<String> initPropositions = new HashSet<>();
        Map<String, Set<String>> roleActions = new HashMap<>();
        Map<String, Set<GdlRule>> functions = new HashMap<>();

        Map<String, List<String>> nextRules = new HashMap<>();
        List<String> evolutions = new ArrayList<>();
        Map<String, List<String>> agentProtocols = new HashMap<>();


        for (GdlRule rule : flatGdlDescription) {
            GdlSentence head = rule.getHead();
            String headName = head.getName().toString();

            if (headName.equals("base")
                    || headName.equals("input")
                    || headName.equals("goal")) {
                // skip these keywords

            } else if (headName.equals("role")) {
                roles.add(head.get(0).toString());

            } else if (headName.equals("init") || headName.equals("next")) {
                GdlTerm prop = head.get(0);
                basePropositions.add(translateTerm(prop));
                if (headName.equals("init"))
                    initPropositions.add(translateTerm(prop));

            } else if (headName.equals("legal")) {
                String role = head.get(0).toString();
                String action = translateTerm(head.get(1));
                roleActions.putIfAbsent(role, new HashSet<>());
                roleActions.get(role).add(action);

            } else {
                String funcName = translateSentence(head);
                functions.putIfAbsent(funcName, new HashSet<>());
                functions.get(funcName).add(rule);
            }
        }

        for (GdlRule rule : flatGdlDescription) {
            GdlSentence head = rule.getHead();
            List<GdlLiteral> body = rule.getBody();
            String headName = head.getName().toString();

            if (headName.equals("goal")) {
                String role = head.get(0).toString();
                String points = head.get(1).toString();
                evolutions.add(String.format("points_%s=%s if %s", role, points, expandLiterals(body, functions)));

            } else if (headName.equals("next")) {
                String prop = translateTerm(head.get(0));
                nextRules.putIfAbsent(prop, new ArrayList<>());
                nextRules.get(prop).add(expandLiterals(body, functions));

            } else if (headName.equals("terminal")) {
                evolutions.add(String.format("terminal=true if %s", expandLiterals(body, functions)));

            } else if (headName.equals("legal")) {
                String role = head.get(0).toString();
                String action = translateTerm(head.get(1));
                agentProtocols.putIfAbsent(role, new ArrayList<>());
                agentProtocols.get(role).add(
                        String.format("%s : {%s}", expandLiterals(body, functions), action)
                );
            }

        }

        for (Map.Entry<String, List<String>> entry : nextRules.entrySet()) {
            String prop = entry.getKey();
            String cond = String.join(" or ", entry.getValue());
            evolutions.add(String.format("%s=true if %s", prop, cond));
            evolutions.add(String.format("%s=false if !(%s)", prop, cond));
        }

        StringBuilder sb = new StringBuilder();

        sb.append("Semantics = SingleAssignment;\n");
        sb.append("Agent Environment\n");
        sb.append("  Obsvars:\n");
        for (String prop : basePropositions) {
            sb.append("    ").append(prop).append(" : boolean;\n");
        }
        sb.append("    terminal : boolean;\n");
        for (String role : roles) {
            sb.append("    points_").append(role).append(" : 0..100;\n");
        }

        sb.append("  end Obsvars\n");
        sb.append("  Vars:\n  end Vars\n  RedStates:\n  end RedStates\n  Actions={noop};\n  Protocol:\n  end Protocol\n");

        sb.append("  Evolution:\n");
        for (String evo : evolutions) {
            sb.append("    ").append(evo.replace("Environment.", "")).append(";\n");
        }
        sb.append("  end Evolution\n");
        sb.append("end Agent\n");

        for (String role : roles) {
            sb.append("Agent ").append(role).append("\n");
            sb.append("  Vars:\n    dummy : boolean;\n  end Vars\n");
            sb.append("  Actions = ").append(roleActions.get(role).toString().replace('[', '{').replace(']', '}')).append(";\n");
            sb.append("  Protocol:\n");
            for (String proto : agentProtocols.get(role)) {
                sb.append("    ").append(proto).append(";\n");
            }
            sb.append("  end Protocol\n");
            sb.append("  Evolution:\n    dummy=true if dummy=dummy;\n  end Evolution\n");
            sb.append("end Agent\n");
        }

        sb.append("Evaluation\n");
        sb.append("  terminated if Environment.terminal=true;\n");
        sb.append("end Evaluation\n");

        sb.append("InitStates\n");
        for (String prop : basePropositions) {
            if (initPropositions.contains(prop)) {
                sb.append("  Environment.").append(prop).append("=true and\n");
            } else {
                sb.append("  Environment.").append(prop).append("=false and\n");
            }
        }
        for (String role : roles) {
            sb.append("  Environment.points_").append(role).append("=0 and\n");
            sb.append("  ").append(role).append(".dummy=true and\n");
        }
        sb.append("  Environment.terminal=false;\n");
        sb.append("end InitStates\n");

        sb.append("Formulae\n");
        sb.append("  EF terminated;\n");
        sb.append("end Formulae\n");

        return sb.toString();
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

    private static String expandLiteral(GdlLiteral literal, Map<String, Set<GdlRule>> functions) {
        if (literal instanceof GdlNot) {
            GdlNot not = (GdlNot) literal;
            return "!(" + expandLiteral(not.getBody(), functions) + ")";

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
                return expandCustomSentence(sentence, functions);
            }
        }
        throw new IllegalArgumentException("Unknown literal: " + literal);
    }

    private static String expandCustomSentence(GdlSentence sentence, Map<String, Set<GdlRule>> functions) {
        String funcName = translateSentence(sentence);
        Set<GdlRule> outRules = functions.get(funcName);
        StringBuilder sb = new StringBuilder();
        for (GdlRule rule : outRules) {
            if (sb.length() > 0)
                sb.append(" or ");
            sb.append(expandLiterals(rule.getBody(), functions));
        }
        return sb.toString();
    }

    private static String expandLiterals(List<GdlLiteral> literals, Map<String, Set<GdlRule>> functions) {
        StringBuilder sb = new StringBuilder();
        sb.append('(');
        for (GdlLiteral lit : literals) {
            if (sb.length() > 1)
                sb.append(" and ");
            sb.append(expandLiteral(lit, functions));
        }
        sb.append(')');
        return sb.toString();
    }
}
