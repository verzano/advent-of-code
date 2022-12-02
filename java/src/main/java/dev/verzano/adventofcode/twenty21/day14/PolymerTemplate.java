package dev.verzano.adventofcode.twenty21.day14;

import java.util.HashMap;
import java.util.List;

import static java.util.List.of;

public record PolymerTemplate(HashMap<Pair, Long> pairs) {
    public PolymerTemplate insert(InsertionRules rules, SingleCounter counter) {
        var newPairs = new HashMap<Pair, Long>();
        for (var e : pairs.entrySet()) {
            var pairs = insert(e.getKey(), rules, e.getValue(), counter);
            for (var pair : pairs) {
                newPairs.compute(pair, (k, v) -> v == null ? e.getValue() : v + e.getValue());
            }
        }
        return new PolymerTemplate(newPairs);
    }


    private List<Pair> insert(Pair pair, InsertionRules rules, Long count, SingleCounter counter) {
        Single single = rules.getSingle(pair);
        counter.increment(single, count);
        var ab = new Pair(pair.a(), single);
        var bc = new Pair(single, pair.c());
        return of(ab, bc);
    }
}
