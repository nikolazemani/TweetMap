package filters;

import twitter4j.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AndFilter implements Filter {
    private final Filter child1;
    private final Filter child2;

    public AndFilter(Filter child1,Filter child2) {
        this.child1 = child1;
        this.child2 = child2;
    }

    @Override
    public boolean matches(Status s) {
        return child1.matches(s) && child2.matches(s);
    }



    @Override
    public List<String> terms() {
        return joinLists(child1,child2);
    }


    @Override
    public String toString() {
        return "(" + child1 + " and " + child2 + ")";
    }

    private List<String> joinLists(Filter child1, Filter child2) {
        List<String> list = Stream.concat(child1.terms().stream(), child2.terms().stream())
                .collect(Collectors.toList());

        return list;
    }
}
