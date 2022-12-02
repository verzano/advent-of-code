package dev.verzano.adventofcode.twenty21.day14;

import java.util.HashMap;
import java.util.Map;

public class SingleCounter {
    private final Map<String, Long> counts = new HashMap<>();

    public void increment(Single single, Long count) {
        counts.compute(single.b(), (k, v) -> v == null ? count : v + count);
    }

    public long score() {
        var max = counts.values().stream().mapToLong(i -> i).max().orElseThrow();
        var min = counts.values().stream().mapToLong(i -> i).min().orElseThrow();
        return max - min;
    }
}
