package dev.verzano.adventofcode.twenty21.day08;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day08.Day08.part1;
import static dev.verzano.adventofcode.twenty21.day08.Day08.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Test {
    @Test
    void part1TestData() {
        var signalsStrings = getResourceAsStringList("twenty21/day08/test.csv");
        var signals = signalsStrings.stream().map(SignalLine::fromString).toList();
        var _1s4s7sand8s = part1(signals);
        System.out.println("Number of 1s 4s 7s and 8s: " + _1s4s7sand8s);
        assertEquals(26, _1s4s7sand8s);
    }

    @Test
    void part1RealData() {
        var signalsStrings = getResourceAsStringList("twenty21/day08/input.csv");
        var signals = signalsStrings.stream().map(SignalLine::fromString).toList();
        var _1s4s7sand8s = part1(signals);
        System.out.println("Number of 1s 4s 7s and 8s: " + _1s4s7sand8s);
    }

    @Test
    void part2HTroubleSpot() {
        var signalsStrings = getResourceAsStringList("twenty21/day08/trouble.csv");
        var signals = signalsStrings.stream().map(SignalLine::fromString).toList();
        var state = part2(signals);
        System.out.println(state.prettyPrint());
        var sum = state.sum();
        System.out.println("Sum of outputs: " + sum);
        assertEquals(9361, sum);
    }

    @Test
    void part2TestData() {
        var signalsStrings = getResourceAsStringList("twenty21/day08/test.csv");
        var signals = signalsStrings.stream().map(SignalLine::fromString).toList();
        var state = part2(signals);
        System.out.println(state.prettyPrint());
         var sum = state.sum();
        System.out.println("Sum of outputs: " + sum);
        assertEquals(61229, sum);
    }

    @Test
    void part2RealData() {
        var signalsStrings = getResourceAsStringList("twenty21/day08/input.csv");
        var signals = signalsStrings.stream().map(SignalLine::fromString).toList();
        var state = part2(signals);
        System.out.println("Sum of outputs: " + state.sum());
    }
}