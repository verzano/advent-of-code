package dev.verzano.adventofcode.twenty22.day08;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsIntMatrix;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day08Test {
    private static final int[][] testInput = {
            {3, 0, 3, 7, 3},
            {2, 5, 5, 1, 2},
            {6, 5, 3, 3, 2},
            {3, 3, 5, 4, 9},
            {3, 5, 3, 9, 0},
    };

    @Test
    void part1TestData() {
        var treeGrid = Day08.part1(testInput);
        treeGrid.prettyPrintVisibility();
        System.out.println("Number of visible trees: " + treeGrid.getVisible());
        assertEquals(21, treeGrid.getVisible());
    }

    @Test
    void part1RealData() {
        var treeGrid = Day08.part1(getResourceAsIntMatrix("twenty22/day08/input.csv"));
//        treeGrid.prettyPrintVisibility();
        System.out.println("Number of visible trees: " + treeGrid.getVisible());
    }

    @Test
    void part2TestData() {
        var treeGrid = Day08.part2(testInput);
        treeGrid.prettyPrintScenicScore();
        System.out.println("Highest scenic score: " + treeGrid.getHighestScenicScore());
        assertEquals(8, treeGrid.getHighestScenicScore());
    }

    @Test
    void part2RealData() {
        var treeGrid = Day08.part2(getResourceAsIntMatrix("twenty22/day08/input.csv"));
//        treeGrid.prettyPrintScenicScore();
        System.out.println("Highest scenic score: " + treeGrid.getHighestScenicScore());
    }
}
