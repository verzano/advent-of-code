package dev.verzano.adventofcode.twenty21.day11;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsIntMatrix;
import static dev.verzano.adventofcode.twenty21.day11.Day11.part1;
import static dev.verzano.adventofcode.twenty21.day11.Day11.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {
    @Test
    void part1SmallData2Steps() {
        var octopi = part1(getResourceAsIntMatrix("twenty21/day11/small.txt"), 2);
        System.out.println("Number of flashes: " + octopi.countFlashes());
        assertEquals(9, octopi.countFlashes());
    }

    @Test
    void part1TestData10Steps() {
        var octopi = part1(getResourceAsIntMatrix("twenty21/day11/test.txt"), 10);
        System.out.println("Number of flashes: " + octopi.countFlashes());
        assertEquals(204, octopi.countFlashes());
    }

    @Test
    void part1TestData100Steps() {
        var octopi = part1(getResourceAsIntMatrix("twenty21/day11/test.txt"), 100);
        System.out.println("Number of flashes: " + octopi.countFlashes());
        assertEquals(1656, octopi.countFlashes());
    }

    @Test
    void part1RealData100Steps() {
        var octopi = part1(getResourceAsIntMatrix("twenty21/day11/real.txt"), 100);
        System.out.println("Number of flashes: " + octopi.countFlashes());
    }

    @Test
    void part2TestData() {
        var step = part2(getResourceAsIntMatrix("twenty21/day11/test.txt"));
        System.out.println("Synchronized on step: " + step);
        assertEquals(195, step);
    }

    @Test
    void part2RealData() {
        var step = part2(getResourceAsIntMatrix("twenty21/day11/real.txt"));
        System.out.println("Synchronized on step: " + step);
    }
}