package dev.verzano.adventofcode.twenty21.day09;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsIntMatrix;
import static dev.verzano.adventofcode.twenty21.day09.Day09.part1;
import static dev.verzano.adventofcode.twenty21.day09.Day09.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {
    @Test
    void part1TestData() {
        var lowPoints = part1(getResourceAsIntMatrix("twenty21/day09/test.txt"));
        System.out.println("Low points: " + lowPoints.lps());
        var riskLevel = lowPoints.riskLevel();
        System.out.println("Risk Level: " + riskLevel);
        assertEquals(15, riskLevel);
    }

    @Test
    void part1RealData() {
        var lowPoints = part1(getResourceAsIntMatrix("twenty21/day09/real.txt"));
        System.out.println("Risk Level: " + lowPoints.riskLevel());
    }
    @Test
    void part2TestData() {
        var basins = part2(getResourceAsIntMatrix("twenty21/day09/test.txt"));
        System.out.println("Basins: " + basins.getBasins());
        var solution = basins.solutionValue();
        System.out.println("Solution: " + solution);
        assertEquals(1134, solution);
    }

    @Test
    void part2RealData() {
        var basins = part2(getResourceAsIntMatrix("twenty21/day09/real.txt"));
        System.out.println("Solution: " + basins.solutionValue());
    }
}