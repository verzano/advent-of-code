package dev.verzano.adventofcode.twenty21.day10;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day10.Day10.part1;
import static dev.verzano.adventofcode.twenty21.day10.Day10.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
    @Test
    void part1TestData() {
        var lines = part1(getResourceAsStringList("twenty21/day10/test.txt"));
        var errorPoints = lines.errorPoints();
        System.out.println(lines.printErrors());
        System.out.println("Error points: " + errorPoints);
        assertEquals(26397, errorPoints);
    }

    @Test
    void part1RealData() {
        var lines = part1(getResourceAsStringList("twenty21/day10/real.txt"));
        var errorPoints = lines.errorPoints();
        System.out.println("Error points: " + errorPoints);
    }

    @Test
    void part2TestData() {
        var lines = part2(getResourceAsStringList("twenty21/day10/test.txt"));
        var incompletePoints = lines.incompletePoints();
        System.out.println(lines.printIncompletes());
        System.out.println("Incomplete points: " + incompletePoints);
        assertEquals(288957, incompletePoints);
    }

    @Test
    void part2RealData() {
        var lines = part2(getResourceAsStringList("twenty21/day10/real.txt"));
        var incompletePoints = lines.incompletePoints();
        System.out.println("Incomplete points: " + incompletePoints);
    }
}