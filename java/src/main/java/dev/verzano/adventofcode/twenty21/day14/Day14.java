package dev.verzano.adventofcode.twenty21.day14;

class Day14 {
    protected static Day14State part1(Day14State state) {
        var pt = state.polymerTemplate();
        for (var i = 0; i < 10; i++) {
            pt = pt.insert(state.insertionRules(), state.counter());
        }
        return new Day14State(pt, state.insertionRules(), state.counter());
    }

    protected static Day14State part2(Day14State state) {
        var pt = state.polymerTemplate();
        for (var i = 0; i < 40; i++) {
            pt = pt.insert(state.insertionRules(), state.counter());
        }
        return new Day14State(pt, state.insertionRules(), state.counter());
    }
}
