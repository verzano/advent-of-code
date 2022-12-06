package dev.verzano.adventofcode.twenty15.day01;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static dev.verzano.adventofcode.Helper.getResourceAsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    private static Object[][] part1TestDataSource() {
        return new Object[][]{
                {"(())", 0},
                {"()()", 0},
                {"(((", 3},
                {"(()(()(", 3},
                {"))(((((", 3},
                {"())", -1},
                {"))(", -1},
                {")))", -3},
                {")())())", -3}
        };
    }
    private static Object[][] part2TestDataSource() {
        return new Object[][]{
                {")", 1},
                {"()())", 5},
        };
    }

    @ParameterizedTest
    @MethodSource("part1TestDataSource")
    void part1TestData(String directions, int expectedFloor) {
        var floor = Day01.part1(directions);
        System.out.println("Floor for directions: '" + directions + "' is: " + floor);
        assertEquals(expectedFloor, floor);
    }

    @Test
    void part1RealData() {
        var floor = Day01.part1(getResourceAsString("twenty15/day01/input.csv"));
        System.out.println("Floor is: " + floor);
    }

    @ParameterizedTest
    @MethodSource("part2TestDataSource")
    void part2TestData(String directions, int expectedStepNumber) {
        var stepNumber = Day01.part2(directions);
        System.out.println("Entered basement on step number" + stepNumber + " for directions: '" + directions + "'");
        assertEquals(expectedStepNumber, stepNumber);
    }

    @Test
    void part2RealData() {
        var stepNumber = Day01.part2(getResourceAsString("twenty15/day01/input.csv"));
        System.out.println("Floor is: " + stepNumber);
    }
}
