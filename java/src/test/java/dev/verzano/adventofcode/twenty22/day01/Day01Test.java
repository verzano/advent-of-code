package dev.verzano.adventofcode.twenty22.day01;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day01Test {
    private static final List<String> testInput = new LinkedList<>();

    static {
        {
            testInput.add("1000");
            testInput.add("2000");
            testInput.add("3000");
            testInput.add("");
            testInput.add("4000");
            testInput.add("");
            testInput.add("5000");
            testInput.add("6000");
            testInput.add("");
            testInput.add("7000");
            testInput.add("8000");
            testInput.add("9000");
            testInput.add("");
            testInput.add("10000");
        }
    }

    @Test
    void part1TestData() {
        var elf = Day01.part1(testInput);
        System.out.println("Elf with most carried calories: " + elf);

        assertEquals(24000, elf.totalCarried());
    }

    @Test
    void part1RealData() {
        var realData = getResourceAsStringList("twenty22/day01/input.csv");
        var elf = Day01.part1(realData);
        System.out.println("Elf with most carried calories: " + elf);
    }

    @Test
    void part2TestData() {
        var elves = Day01.part2(testInput);
        System.out.println("Top 3 elves with most carried calories: " + elves);

        assertEquals(45000, elves.stream().mapToInt(Elf::totalCarried).sum());
    }

    @Test
    void part2RealData() {
        var realData = getResourceAsStringList("twenty22/day01/input.csv");
        var elves = Day01.part2(realData);
        System.out.println("Top 3 elves with most carried calories: " + elves);
        System.out.println("Total calories: " + elves.stream().mapToInt(Elf::totalCarried).sum());
    }
}
