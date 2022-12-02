package dev.verzano.adventofcode.twenty21.day01;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsIntegerList;
import static dev.verzano.adventofcode.twenty21.day01.Day01.part1;
import static dev.verzano.adventofcode.twenty21.day01.Day01.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    private static final List<Integer> testDepths = List.of(199, 200, 208, 210, 200, 207, 240, 269, 260, 263);

    @Test
    void part1TestData() {
        var increases = part1(testDepths);
        System.out.println("Number of increases = " + increases);

        assertEquals(7, increases);
    }

    @Test
    void part1RealData() {
        var increases = part1(getResourceAsIntegerList("twenty21/day01/input.csv"));
        System.out.println("Number of increases = " + increases);
    }

    @Test
    void part2TestData() {
        var increases = part2(testDepths);
        System.out.println("Number of increases = " + increases);

        assertEquals(5, increases);
    }

    @Test
    void part2RealData() {
        var increases = part2(getResourceAsIntegerList("twenty21/day01/input.csv"));
        System.out.println("Number of increases = " + increases);
    }
}