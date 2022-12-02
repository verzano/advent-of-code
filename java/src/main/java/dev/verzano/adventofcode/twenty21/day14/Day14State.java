package dev.verzano.adventofcode.twenty21.day14;

public record Day14State(PolymerTemplate polymerTemplate, InsertionRules insertionRules, SingleCounter counter) {
    public long score() {
        return counter.score();
    }
}
