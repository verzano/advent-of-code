package dev.verzano.adventofcode.twenty15.day02;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
    private static Object[][] part1TestDataSource() {
        return new Object[][]{
                {"2x3x4", 58},
                {"1x1x10", 43}
        };
    }

    private static Object[][] part2TestDataSource() {
        return new Object[][]{
                {"2x3x4", 34},
                {"1x1x10", 14}
        };
    }

    @ParameterizedTest
    @MethodSource("part1TestDataSource")
    void part1TestData(String dimension, int expectedSurfaceArea) {
        var surfaceArea = Day02.part1(List.of(dimension));
        System.out.println("Surface area for dimension '" + dimension + "' is: " + surfaceArea);
        assertEquals(expectedSurfaceArea, surfaceArea);
    }

    @Test
    void part1RealData() {
        var surfaceArea = Day02.part1(getResourceAsStringList("twenty15/day02/input.csv"));
        System.out.println("Total surface area: " + surfaceArea);
    }

    @ParameterizedTest
    @MethodSource("part2TestDataSource")
    void part2TestData(String dimension, int expectedLength) {
        var length = Day02.part2(List.of(dimension));
        System.out.println("Length for dimension '" + dimension + "' is: " + length);
        assertEquals(expectedLength, length);
    }

    @Test
    void part2RealData() {
        var length = Day02.part2(getResourceAsStringList("twenty15/day02/input.csv"));
        System.out.println("Total length of ribbon: " + length);
    }
}
