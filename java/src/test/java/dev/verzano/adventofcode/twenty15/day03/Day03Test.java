package dev.verzano.adventofcode.twenty15.day03;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static dev.verzano.adventofcode.Helper.getResourceAsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {
    private static Object[][] part1TestDataSource() {
        return new Object[][]{
                {">", 2},
                {"^>v<", 4},
                {"^v^v^v^v^v", 2},
        };
    }

    private static Object[][] part2TestDataSource() {
        return new Object[][]{
                {"^v", 3},
                {"^>v<", 3},
                {"^v^v^v^v^v", 11},
        };
    }

    @ParameterizedTest
    @MethodSource("part1TestDataSource")
    void part1TestData(String directions, int expectedHouses) {
        var houses = Day03.part1(directions);
        System.out.println("Number of houses for directions '" + directions + "' is: " + houses);
        assertEquals(expectedHouses, houses);
    }

    @Test
    void part1RealData() {
        var houses = Day03.part1(getResourceAsString("twenty15/day03/input.csv"));
        System.out.println("Number of houses: " + houses);
    }

    @ParameterizedTest
    @MethodSource("part2TestDataSource")
    void part2TestData(String directions, int expectedHouses) {
        var houses = Day03.part2(directions);
        System.out.println("Number of houses for directions '" + directions + "' is: " + houses);
        assertEquals(expectedHouses, houses);
    }

    @Test
    void part2RealData() {
        var houses = Day03.part2(getResourceAsString("twenty15/day03/input.csv"));
        System.out.println("Number of houses: " + houses);
    }
}
