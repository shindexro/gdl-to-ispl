import com.google.common.collect.Sets;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Relation {
    String name;
    private List<Set<String>> args;

    public Relation(String name, int arity) {
        this.name = name;
        args = new ArrayList<>(arity + 1);
        for (int i = 0; i <= arity; i++)
            args.add(new HashSet<>());
        args.get(0).add(name);
    }

    public void addArg(int pos, String arg) {
        args.get(pos + 1).add(arg);
    }

    public Set<List<String>> all() {
        return Sets.cartesianProduct(args);
    }

    public String name() {
        return name;
    }

    public int arity() {
        return args.size() - 1;
    }
}
