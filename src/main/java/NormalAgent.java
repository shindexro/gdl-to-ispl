import java.util.HashSet;
import java.util.Set;

public class NormalAgent {
    private String name;
    private Set<String> actions;

    public NormalAgent(String name) {
        this.name = name;
        this.actions = new HashSet<>();
    }
}
