package dev.verzano.adventofcode.twenty22.day10;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day10Test {
    @Test
    void part1TestData() {
        var signalStrength = Day10.part1(getResourceAsStringList("twenty22/day10/testData.csv"));
        System.out.println("Total signal strength: " + signalStrength);
        assertEquals(13140, signalStrength);
    }

    @Test
    void part1RealData() {
        var signalStrength = Day10.part1(getResourceAsStringList("twenty22/day10/input.csv"));
        System.out.println("Total signal strength: " + signalStrength);
    }

    @Test
    void part2TestData() {
        var signalStrength = Day10.part2(getResourceAsStringList("twenty22/day10/testData.csv"));
    }

    @Test
    void part2RealData() {
        var signalStrength = Day10.part2(getResourceAsStringList("twenty22/day10/input.csv"));
    }
}
