package dev.verzano.adventofcode.twenty22.day09;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.LinkedList;
import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day09Test {
    private static final List<String> testInput = new LinkedList<>();

    static {
        {
            testInput.add("R 4");
            testInput.add("U 4");
            testInput.add("L 3");
            testInput.add("D 1");
            testInput.add("R 4");
            testInput.add("D 1");
            testInput.add("L 5");
            testInput.add("R 2");
        }
    }

    private static final List<String> testInput2 = new LinkedList<>();

    static {
        {
            testInput2.add("R 5");
            testInput2.add("U 8");
            testInput2.add("L 8");
            testInput2.add("D 3");
            testInput2.add("R 17");
            testInput2.add("D 10");
            testInput2.add("L 25");
            testInput2.add("U 20");

        }
    }

    private static Object[][] part2TestDataSource() {
        return new Object[][]{
                {testInput, 1},
                {testInput2, 36}
        };
    }

    @Test
    void part1TestData() {
        var totalTailPositions = Day09.part1(testInput);
        System.out.println("Total number of tail positions: " + totalTailPositions);
        assertEquals(13, totalTailPositions);
    }

    @Test
    void part1RealData() {
        var totalTailPositions = Day09.part1(getResourceAsStringList("twenty22/day09/input.csv"));
        System.out.println("Total number of tail positions: " + totalTailPositions);
    }

    @ParameterizedTest
    @MethodSource("part2TestDataSource")
    void part2TestData(List<String> vectors, int expectedTotalPositions) {
        var totalTailPositions = Day09.part2(vectors);
        System.out.println("Total number of tail positions: " + totalTailPositions);
        assertEquals(expectedTotalPositions, totalTailPositions);
    }

    @Test
    void part2RealData() {
        var totalTailPositions = Day09.part2(getResourceAsStringList("twenty22/day09/input.csv"));
        System.out.println("Total number of tail positions: " + totalTailPositions);
    }
}
