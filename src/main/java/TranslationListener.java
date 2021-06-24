import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TranslationListener extends GDLBaseListener {
    private GDLParser parser;
    private Set<String> roles;

    public TranslationListener(GDLParser parser) {
        this.parser = parser;
        this.roles = new HashSet<>();
    }

    @Override
    public void enterRelationLiteral(GDLParser.RelationLiteralContext ctx) {
        super.enterRelationLiteral(ctx);
        String predicate = ctx.CONST().getText();

        if (predicate.equals("role")) {
            GDLParser.TermContext term = ctx.term(0);
            while (term.term() != null)
                term = term.term();
            String role = term.CONST().getText();
            roles.add(role);
        }
    }
}
