package dev.verzano.adventofcode.twenty22.day04;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {
    private static final List<String> testInput = List.of(
            "2-4,6-8",
            "2-3,4-5",
            "5-7,7-9",
            "2-8,3-7",
            "6-6,4-6",
            "2-6,4-8");

    @Test
    void part1TestData() {
        var fullyContainedPairs = Day04.part1(testInput);
        System.out.println("Number of full overlaps: " + fullyContainedPairs);
        assertEquals(2, fullyContainedPairs);
    }

    @Test
    void part1RealData() {
        var fullyContainedPairs = Day04.part1(getResourceAsStringList("twenty22/day04/input.csv"));
        System.out.println("Number of full overlaps: " + fullyContainedPairs);
    }

    @Test
    void part2TestData() {
        var fullyContainedPairs = Day04.part2(testInput);
        System.out.println("Number of full overlaps: " + fullyContainedPairs);
        assertEquals(4, fullyContainedPairs);
    }

    @Test
    void part2RealData() {
        var fullyContainedPairs = Day04.part2(getResourceAsStringList("twenty22/day04/input.csv"));
        System.out.println("Number of full overlaps: " + fullyContainedPairs);
    }
}
