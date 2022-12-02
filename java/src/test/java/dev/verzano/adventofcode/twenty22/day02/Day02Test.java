package dev.verzano.adventofcode.twenty22.day02;

import dev.verzano.adventofcode.Helper;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
    private static final char[][] testInput = {
            {'A', 'Y'},
            {'B', 'X'},
            {'C', 'Z'},
    };

    @Test
    void part1TestData() {
        var score = Day02.part1(testInput);
        System.out.println("Final score: " + score);
        assertEquals(15, score);
    }

    @Test
    void part1RealData() {
        char[][] lines = Helper.getResourceAsCharMatrix("twenty22/day02/input.csv");
        var strategyGuide = new char[lines.length][2];
        for (var i = 0; i < lines.length; i++) {
            strategyGuide[i][0] = lines[i][0];
            strategyGuide[i][1] = lines[i][2];
        }
        var score = Day02.part1(strategyGuide);
        System.out.println("Final score: " + score);
    }

    @Test
    void part2TestData() {
        var score = Day02.part2(testInput);
        System.out.println("Final score: " + score);
        assertEquals(12, score);
    }

    @Test
    void part2RealData() {
        char[][] lines = Helper.getResourceAsCharMatrix("twenty22/day02/input.csv");
        var strategyGuide = new char[lines.length][2];
        for (var i = 0; i < lines.length; i++) {
            strategyGuide[i][0] = lines[i][0];
            strategyGuide[i][1] = lines[i][2];
        }
        var score = Day02.part2(strategyGuide);
        System.out.println("Final score: " + score);
    }
}
