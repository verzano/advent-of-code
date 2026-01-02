package dev.verzano.adventofcode.twenty22.day13;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {
    @Test
    void part1TestData() {
        var indexSum = Day13.part1(getResourceAsStringList("twenty22/day13/testData.txt"));
        System.out.println("Sum of indices: " + indexSum);
        assertEquals(13, indexSum);
    }

    @Test
    void part1RealData() {
        var indexSum = Day13.part1(getResourceAsStringList("twenty22/day13/realData.txt"));
        System.out.println("Sum of indices: " + indexSum);
    }
}
