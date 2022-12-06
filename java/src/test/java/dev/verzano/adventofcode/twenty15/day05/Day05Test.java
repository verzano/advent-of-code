package dev.verzano.adventofcode.twenty15.day05;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
    private static Object[][] part1TestDataSource() {
        return new Object[][]{
                {"ugknbfddgicrmopn", 1},
                {"aaa", 1},
                {"jchzalrnumimnmhp", 0},
                {"haegwjzuvuyypxyu", 0},
                {"dvszwmarrgswjxmb", 0},
        };
    }

    private static Object[][] part2TestDataSource() {
        return new Object[][]{
                {"qjhvhtzxzqqjkmpb", 1},
                {"xxyxx", 1},
                {"uurcxstgmygtbstg", 0},
                {"ieodomkazucvgmuy", 0},
        };
    }

    @ParameterizedTest
    @MethodSource("part1TestDataSource")
    void part1TestData(String input, int expectedNiceCount) {
        var niceCount = Day05.part1(List.of(input));
        System.out.println(input + " is " + (niceCount == 0 ? "naughty" : "nice"));
        assertEquals(expectedNiceCount, niceCount);
    }

    @Test
    void part1RealData() {
        var niceCount = Day05.part1(getResourceAsStringList("twenty15/day05/input.csv"));
        System.out.println("Nice count: " + niceCount);
    }

    @ParameterizedTest
    @MethodSource("part2TestDataSource")
    void part2TestData(String input, int expectedNiceCount) {
        var niceCount = Day05.part2(List.of(input));
        System.out.println(input + " is " + (niceCount == 0 ? "naughty" : "nice"));
        assertEquals(expectedNiceCount, niceCount);
    }

    @Test
    void part2RealData() {
        var niceCount = Day05.part2(getResourceAsStringList("twenty15/day05/input.csv"));
        System.out.println("Nice count: " + niceCount);
    }
}
