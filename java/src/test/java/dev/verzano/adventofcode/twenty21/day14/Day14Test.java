package dev.verzano.adventofcode.twenty21.day14;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day14.Day14.part1;
import static dev.verzano.adventofcode.twenty21.day14.Day14.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day14Test {
    @Test
    void part1TestData() {
        var state = part1(convertToState(getResourceAsStringList("twenty21/day14/test.txt")));
        var score = state.score();
        System.out.println("Score: " + score);
        assertEquals(1588, score);
    }

    @Test
    void part1RealData() {
        var state = part1(convertToState(getResourceAsStringList("twenty21/day14/real.txt")));
        var score = state.score();
        System.out.println("Score: " + score);
    }

    @Test
    void part2TestData() {
        var state = part2(convertToState(getResourceAsStringList("twenty21/day14/test.txt")));
        var score = state.score();
        System.out.println("Score: " + score);
        assertEquals(2188189693529L, score);
    }

    @Test
    void part2RealData() {
        var state = part2(convertToState(getResourceAsStringList("twenty21/day14/real.txt")));
        var score = state.score();
        System.out.println("Score: " + score);
    }

    private static Day14State convertToState(List<String> lines) {
        var counter = new SingleCounter();
        var pairMap = new HashMap<Pair, Long>();
        var startCode = lines.remove(0);
        for (var i = 0; i < startCode.length(); i++) {
            counter.increment(new Single(startCode.substring(i, i + 1)), 1L);
        }

        for (var i = 0; i < startCode.length() - 1; i++) {
            var a = new Single(startCode.substring(i, i + 1));
            var c = new Single(startCode.substring(i + 1, i + 2));
            pairMap.compute(new Pair(a, c), (k, v) -> v == null ? 1 : v + 1);
        }

        var polymerTemplate = new PolymerTemplate(pairMap);
        lines.remove(0);

        var insertionRules = new InsertionRules();
        for (var line : lines) {
            var rule = line.split(" -> ");
            var a = new Single(rule[0].substring(0, 1));
            var c = new Single(rule[0].substring(1, 2));
            insertionRules.addRule(new Pair(a, c), new Single(rule[1]));
        }

        return new Day14State(polymerTemplate, insertionRules, counter);
    }
}