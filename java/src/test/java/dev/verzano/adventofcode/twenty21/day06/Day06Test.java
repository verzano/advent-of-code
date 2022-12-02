package dev.verzano.adventofcode.twenty21.day06;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsIntegerList;
import static dev.verzano.adventofcode.twenty21.day06.Day06.part1;
import static dev.verzano.adventofcode.twenty21.day06.Day06.part2;

class Day06Test {
    private static final List<Integer> testData = List.of(3, 4, 3, 1, 2);

    @Test
    void part1TestData18() {
        var fish = part1(testData, 18);
        System.out.println("Fish state: " + fish);
        System.out.println("Fish after 18 days: " + fish.size());
        assertEquals(26, fish.size());
    }

    @Test
    void part1TestData80() {
        var fish = part1(testData, 80);
        System.out.println("Fish after 80 days: " + fish.size());
        assertEquals(5934, fish.size());
    }

    @Test
    void part1RealData() {
        var fish = part1(getResourceAsIntegerList("twenty21/day06/input.csv"), 80);
        System.out.println("Fish after 80 days: " + fish.size());
    }

    @Test
    void part2TestData() {
        var fishMap = part2(testData, 256);
        var nFishes = fishMap.values()
                .stream()
                .mapToLong(l -> l).sum();
        System.out.println("Fish after 256 days: " + nFishes);
        assertEquals(26984457539L, nFishes);
    }

    @Test
    void part2RealData() {
        var fishMap = part2(getResourceAsIntegerList("twenty21/day06/input.csv"), 256);
        var nFishes = fishMap.values()
                .stream()
                .mapToLong(l -> l).sum();
        System.out.println("Fish after 256 days: " + nFishes);
    }
}
