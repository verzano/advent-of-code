package dev.verzano.adventofcode.twenty22.day11;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day11Test {
    @Test
    void part1TestData() {
        var monkeyBusiness = Day11.part1(getResourceAsStringList("twenty22/day11/testData.csv"));
        System.out.println("Level of monkey business: " + monkeyBusiness);
        assertEquals(10605L, monkeyBusiness);
    }

    @Test
    void part1RealData() {
        var monkeyBusiness = Day11.part1(getResourceAsStringList("twenty22/day11/input.csv"));
        System.out.println("Level of monkey business: " + monkeyBusiness);
    }

    @Test
    void part2TestData() {
        var monkeyBusiness = Day11.part2(getResourceAsStringList("twenty22/day11/testData.csv"));
        System.out.println("Level of monkey business: " + monkeyBusiness);
        assertEquals(2713310158L, monkeyBusiness);
    }

    @Test
    void part2RealData() {
        var monkeyBusiness = Day11.part2(getResourceAsStringList("twenty22/day11/input.csv"));
        System.out.println("Level of monkey business: " + monkeyBusiness);
    }
}
