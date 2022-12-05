package dev.verzano.adventofcode.twenty22.day03;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day03Test {
    private static final List<String> testInput = List.of(
            "vJrwpWtwJgWrhcsFMMfFFhFp",
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
            "PmmdzqPrVvPwwTWBwg",
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
            "ttgJtRGJQctTZtZT",
            "CrZsJsPPZsGzwwsLwLmpwMDw"
    );

    @Test
    public void part1TestData() {
        var priority = Day03.part1(testInput);
        System.out.println("Priority sum: " + priority);
        assertEquals(157, priority);
    }

    @Test
    public void part1RealData() {
        var priority = Day03.part1(getResourceAsStringList("twenty22/day03/input.csv"));
        System.out.println("Priority sum: " + priority);
    }

    @Test
    public void part2TestData() {
        var priority = Day03.part2(testInput);
        System.out.println("Priority sum: " + priority);
        assertEquals(70, priority);
    }

    @Test
    public void part2RealData() {
        var priority = Day03.part2(getResourceAsStringList("twenty22/day03/input.csv"));
        System.out.println("Priority sum: " + priority);
    }
}
