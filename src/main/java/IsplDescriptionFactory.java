import org.ggp.base.util.gdl.grammar.*;

import java.util.*;

public class IsplDescriptionFactory {

    private final List<GdlRule> flatGdlDescription;
    private final StringBuilder isplDescription;
    private String terminalCondition;

    private final List<String> roles = new ArrayList<>();
    private final Map<String, Set<GdlRule>> relations = new HashMap<>();
    private final Set<GdlRule> legals = new HashSet<>();
    private final Set<GdlRule> goals = new HashSet<>();
    private final Set<GdlRule> nexts = new HashSet<>();
    private final Set<GdlRule> inits = new HashSet<>();
    private final Set<GdlRule> terminals = new HashSet<>();
    private final Set<String> basePropositions = new HashSet<>();
    private final Set<String> initPropositions = new HashSet<>();

    private final Map<String, List<String>> propToNextRuleConditions = new HashMap<>();
    private final Map<String, List<String>> goalToConditions = new HashMap<>();
    private final Map<String, TreeSet<Integer>> roleToGoalRewards = new HashMap<>();
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
        setGoals();

        format();
        return this.isplDescription.toString().replace("TRUE", "dummyvar=dummyvar").replace("FALSE", "!(dummyvar=dummyvar)");
    }

    private void format() {
        append("Semantics = SingleAssignment;\n");
        formatEnvironmentAgent();
        for (String role : roles) {
            formatStandardAgent(role);
        }
        formatEvaluation();
        formatInitStates();
        formatGroups();
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

    private void formatGroups() {
        append("Groups\n");
        for (String role : roles) {
            append(String.format("  %s = { %s } ;\n", role, role));
        }
        append(String.format("  allAgents = { %s } ;\n", String.join(", ", roles)));
        append("end Groups\n\n");
    }

    private void formatFormulae() {
        append("Formulae\n");

        append("  -- Environment.RedStates refers to terminal game states.\n");
        append("  AF Environment.RedStates;\n\n");
        append("  -- Fairness\n");
        append(fairnessFormula());
        append(" ;\n\n");
        append("  -- Weak winnability\n");
        append(weakWinnabilityFormula());
        append(" ;\n\n");
        append("  -- Strong winnability\n");
        append(strongWinnabilityFormula());
        append(" ;\n\n");
        append("  -- Unique goal\n");
        append(uniqueGoalFormula());
        append(" ;\n\n");
        append("end Formulae\n\n");
    }

    private String uniqueGoalFormula() {
        StringBuilder sb = new StringBuilder();
        sb.append("AG (Environment.RedStates -> (");
        for (String role : roles) {
            sb.append(roleUniqueGoal(role));
        }
        sb.append(") )");
        return sb.toString();
    }

    private String roleUniqueGoal(String role) {
        TreeSet<Integer> rewards = roleToGoalRewards.get(role);
        List<String> clauses = new ArrayList<>();
        for (int i = 0; i < rewards.size(); i++) {
            clauses.add(roleNthUniqueGoal(role, i));
        }
        return "(" + String.join(" \nor ", clauses) + ")";
    }

    private String roleNthUniqueGoal(String role, int n) {
        TreeSet<Integer> rewards = roleToGoalRewards.get(role);
        Iterator<Integer> it = rewards.iterator();
        List<String> clauses = new ArrayList<>();
        for (int i = 0; i < rewards.size(); i++) {
            int reward = it.next();
            if (i == n) {
                clauses.add(String.format("goal_%s_%d", role, reward));
            } else {
                clauses.add(String.format("!goal_%s_%d", role, reward));
            }
        }
        return "(" + String.join(" and ", clauses) + ")";
    }

    private String strongWinnabilityFormula() {
        List<String> clauses = new ArrayList<>();
        for (String role : roles) {
            clauses.add(String.format("<%s> F (Environment.RedStates and goal_%s_%d)", role, role, roleToGoalRewards.get(role).last()));
        }
        return String.join("\nor ", clauses);
    }

    private String weakWinnabilityFormula() {
        List<String> clauses = new ArrayList<>();
        for (String role : roles) {
            clauses.add(String.format("<allAgents> F (Environment.RedStates and goal_%s_%d)", role, roleToGoalRewards.get(role).last()));
        }
        return String.join("\nand ", clauses);
    }

    private String fairnessFormula() {
        List<String> clauses = new ArrayList<>();
        for (String role : roles) {
            clauses.add(String.format("<%s> F (Environment.RedStates and (!goal_%s_%d))", role, role, roleToGoalRewards.get(role).first()));
        }
        return String.join("\nand ", clauses);
    }

    private void formatEvaluation() {
        append("Evaluation\n");
        for (Map.Entry<String, List<String>> entry : goalToConditions.entrySet()) {
            String prop = entry.getKey();
            String condition = "(" + String.join(") or (", entry.getValue()) + ")";
            append(String.format("    %s if %s ;\n", prop, condition));
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
        for (String prop : basePropositions) {
            List<String> conditions = propToNextRuleConditions.get(prop);
            String condition = (conditions == null) ? "!dummyvar=dummyvar" : "(" + String.join(") or (", conditions).replace("Environment.", "") + ")";
            append(String.format("    %s=true if %s ;\n", prop, condition));
            append(String.format("    %s=false if !( %s ) ;\n", prop, condition));
        }
        append("    dummyvar=true if dummyvar=dummyvar ;\n");
        append("  end Evolution\n");

        append("end Agent\n\n");
    }

    private void setTerminalCondition() {
        List<String> clauses = new ArrayList<>();
        for (GdlRule r : terminals) {
            String exlit = expandLiterals(r.getBody());
            if (exlit.equals("TRUE")) {
                terminalCondition = "(Environment.dummyvar = Environment.dummyvar)";
                return;
            }
            if (!exlit.equals("FALSE"))
                clauses.add(exlit);
        }
        terminalCondition = "(" + String.join(") or (", clauses) + ")";
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
                    terminalCondition, expandLiterals(body), action).replace("TRUE", "dummyvar=dummyvar"));

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
            String exlit = expandLiterals(body);
            if (!exlit.equals("FALSE"))
                propToNextRuleConditions.get(prop).add(expandLiterals(body));
        }
    }

    private void setGoals() {
        for (GdlRule r : goals) {
            GdlSentence head = r.getHead();
            List<GdlLiteral> body = r.getBody();
            String goal = translateSentence(head);
            String role = head.get(0).toString();
            int reward = Integer.parseInt(head.get(1).toString());

            goalToConditions.putIfAbsent(goal, new ArrayList<>());
            String exlit = expandLiterals(body);
            if (!exlit.equals("FALSE"))
                goalToConditions.get(goal).add(expandLiterals(body));

            roleToGoalRewards.putIfAbsent(role, new TreeSet<>());
            roleToGoalRewards.get(role).add(reward);
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

    private String expandLiteral(GdlLiteral literal) {
        if (literal instanceof GdlNot) {
            GdlNot not = (GdlNot) literal;
            return "!(" + expandLiteral(not.getBody()) + ")";

        } else if (literal instanceof GdlDistinct) {
            GdlDistinct distinct = (GdlDistinct) literal;
            String arg1 = distinct.getArg1().toString();
            String arg2 = distinct.getArg2().toString();
            return arg1.equals(arg2) ? "FALSE" : "TRUE";

        } else if (literal instanceof GdlOr) {
            throw new IllegalArgumentException("Description should not contain Or rules, considering using the DeORer");

        } else if (literal instanceof GdlSentence) {
            GdlSentence sentence = (GdlSentence) literal;
            String head = sentence.getName().getValue();
            if (head.equals("true")) {
                String prop = translateTerm(sentence.get(0));
                return basePropositions.contains(prop) ? String.format("Environment.%s=true", prop) : "FALSE";

            } else if (head.equals("does")) {
                String role = sentence.get(0).toString();
                String action = translateTerm(sentence.get(1));
                return String.format("%s.Action=%s", role, action);

            } else {
                return expandCustomSentence(sentence);
            }
        }
        throw new IllegalArgumentException("Unknown literal: " + literal);
    }

    private String expandCustomSentence(GdlSentence sentence) {
        String relName = translateSentence(sentence);
        if (!relations.containsKey(relName))
            return "FALSE";

        Set<GdlRule> outRules = relations.get(relName);
        List<String> clauses = new ArrayList<>();
        for (GdlRule rule : outRules) {
            String exlit = expandLiterals(rule.getBody());
            if (exlit.equals("TRUE"))
                return "TRUE";
            if (!exlit.equals("FALSE"))
                clauses.add(exlit);
        }

        if (clauses.isEmpty())
            return "FALSE";
        else
            return "(" + String.join(") or (", clauses) + ")";
    }

    private String expandLiterals(List<GdlLiteral> literals) {
        List<String> clauses = new ArrayList<>();
        for (GdlLiteral lit : literals) {
            String exlit = expandLiteral(lit);
            if (exlit.equals("FALSE"))
                return "FALSE";
            if (!exlit.equals("TRUE"))
                clauses.add(exlit);
        }
        if (clauses.isEmpty())
            return "TRUE";
        else
            return "(" + String.join(") and (", clauses) + ")";
    }
}
