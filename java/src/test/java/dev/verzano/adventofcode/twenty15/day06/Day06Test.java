package dev.verzano.adventofcode.twenty15.day06;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {
    @Test
    void day06Part1TestData() {
        var litLights = Day06.part1(getResourceAsStringList("twenty15/day06/testData.csv"));
        System.out.println("Number of lit lights: " + litLights);
        assertEquals(998_996, litLights);
    }

    @Test
    void day06Part1RealData() {
        var litLights = Day06.part1(getResourceAsStringList("twenty15/day06/realData.csv"));
        System.out.println("Number of lit lights: " + litLights);
    }

    @Test
    void day06Part2RealData() {
        var litLights = Day06.part2(getResourceAsStringList("twenty15/day06/realData.csv"));
        System.out.println("Total brightness of lights: " + litLights);
    }
}
