package dev.verzano.adventofcode.twenty22.day12;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsCharMatrix;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {
    @Test
    void part1TestData() {
        var stepCount = Day12.part1(getResourceAsCharMatrix("twenty22/day12/testData.csv"));
        System.out.println("Number of steps: " + stepCount);
        assertEquals(31, stepCount);
    }

    @Test
    void part1RealData() {
        var stepCount = Day12.part1(getResourceAsCharMatrix("twenty22/day12/realData.csv"));
        System.out.println("Number of steps: " + stepCount);
    }

    @Test
    void part2TestData() {
        var stepCount = Day12.part2(getResourceAsCharMatrix("twenty22/day12/testData.csv"));
        System.out.println("Number of steps: " + stepCount);
        assertEquals(29, stepCount);
    }

    @Test
    void part2RealData() {
        var stepCount = Day12.part2(getResourceAsCharMatrix("twenty22/day12/realData.csv"));
        System.out.println("Number of steps: " + stepCount);
    }
}
