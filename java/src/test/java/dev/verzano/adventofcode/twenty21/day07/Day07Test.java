package dev.verzano.adventofcode.twenty21.day07;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsIntegerList;
import static dev.verzano.adventofcode.twenty21.day07.Day07.part1;
import static dev.verzano.adventofcode.twenty21.day07.Day07.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {
    private static final List<Integer> testData = List.of(16, 1, 2, 0, 4, 2, 7, 1, 2, 14);

    @Test
    void part1TestData() {
        var fuel = part1(testData);
        System.out.println("Fuel to use: " + fuel);
        assertEquals(37, fuel);
    }

    @Test
    void part1RealData() {
        var fuel = part1(getResourceAsIntegerList("twenty21/day07/input.csv"));
        System.out.println("Fuel to use: " + fuel);
    }

    @Test
    void part2TestData() {
        var fuel = part2(testData);
        System.out.println("Fuel to use: " + fuel);
        assertEquals(168, fuel);
    }

    @Test
    void part2RealData() {
        var fuel = part2(getResourceAsIntegerList("twenty21/day07/input.csv"));
        System.out.println("Fuel to use: " + fuel);
    }
}