package dev.verzano.adventofcode.twenty21.day14;

import java.util.HashMap;
import java.util.Map;

public class InsertionRules {
    private final Map<Pair, Single> rulesMap = new HashMap<>();

    public void addRule(Pair pair, Single single) {
        rulesMap.put(pair, single);
    }

    public Single getSingle(Pair pair) {
        return rulesMap.get(pair);
    }
}
