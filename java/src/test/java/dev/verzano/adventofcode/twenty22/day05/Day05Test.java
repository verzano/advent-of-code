package dev.verzano.adventofcode.twenty22.day05;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
    @Test
    void part1TestData() {
        var message = Day05.part1(getResourceAsStringList("twenty22/day05/testInput.csv"));
        System.out.println("Crate message: " + message);
        assertEquals("CMZ", message);
    }

    @Test
    void part1RealData() {
        var message = Day05.part1(getResourceAsStringList("twenty22/day05/input.csv"));
        System.out.println("Crate message: " + message);
    }

    @Test
    void part2TestData() {
        var message = Day05.part2(getResourceAsStringList("twenty22/day05/testInput.csv"));
        System.out.println("Crate message: " + message);
        assertEquals("MCD", message);
    }

    @Test
    void part2RealData() {
        var message = Day05.part2(getResourceAsStringList("twenty22/day05/input.csv"));
        System.out.println("Crate message: " + message);
    }
}
