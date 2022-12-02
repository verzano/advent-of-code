package dev.verzano.adventofcode.twenty21.day03;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsCharMatrix;
import static dev.verzano.adventofcode.twenty21.day03.Day03.part1;
import static dev.verzano.adventofcode.twenty21.day03.Day03.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {
    private static final char[][] testData = new char[][]{
            {'0', '0', '1', '0', '0'},
            {'1', '1', '1', '1', '0'},
            {'1', '0', '1', '1', '0'},
            {'1', '0', '1', '1', '1'},
            {'1', '0', '1', '0', '1'},
            {'0', '1', '1', '1', '1'},
            {'0', '0', '1', '1', '1'},
            {'1', '1', '1', '0', '0'},
            {'1', '0', '0', '0', '0'},
            {'1', '1', '0', '0', '1'},
            {'0', '0', '0', '1', '0'},
            {'0', '1', '0', '1', '0'},
    };

    @Test
    void part1TestData() {
        var report = part1(testData);
        System.out.println(report);
        System.out.println("Power consumption is: " + report.powerConsumption());
        assertEquals(198, report.powerConsumption());
    }

    @Test
    void part1RealData() {
        var report = part1(getResourceAsCharMatrix("twenty21/day03/input.csv"));
        System.out.println(report);
        System.out.println("Power consumption is: " + report.powerConsumption());
    }

    @Test
    void part2TestData() {
        var report = part2(testData);
        System.out.println(report);
        System.out.println("Life support rating is: " + report.lifeSupportRating());
        assertEquals(230, report.lifeSupportRating());
    }

    @Test
    void part2RealData() {
        var report = part2(getResourceAsCharMatrix("twenty21/day03/input.csv"));
        System.out.println(report);
        System.out.println("Life support rating is: " + report.lifeSupportRating());
    }
}
