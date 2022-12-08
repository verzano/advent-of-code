package dev.verzano.adventofcode.twenty22.day07;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day07Test {
    private static final List<String> testInput = new LinkedList<>();

    static {
        {
            testInput.add("$ cd /");
            testInput.add("$ ls");
            testInput.add("dir a");
            testInput.add("14848514 b.txt");
            testInput.add("8504156 c.dat");
            testInput.add("dir d");
            testInput.add("$ cd a");
            testInput.add("$ ls");
            testInput.add("dir e");
            testInput.add("29116 f");
            testInput.add("2557 g");
            testInput.add("62596 h.lst");
            testInput.add("$ cd e");
            testInput.add("$ ls");
            testInput.add("584 i");
            testInput.add("$ cd ..");
            testInput.add("$ cd ..");
            testInput.add("$ cd d");
            testInput.add("$ ls");
            testInput.add("4060174 j");
            testInput.add("8033020 d.log");
            testInput.add("5626152 d.ext");
            testInput.add("7214296 k");
        }
    }

    @Test
    void part1TestData() {
        var sizeOfSmallDirs = Day07.part1(testInput);
        System.out.println("Size of small dirs: " + sizeOfSmallDirs);
        assertEquals(95437, sizeOfSmallDirs);
    }

    @Test
    void part1RealData() {
        var sizeOfSmallDirs = Day07.part1(getResourceAsStringList("twenty22/day07/input.csv"));
        System.out.println("Size of small dirs: " + sizeOfSmallDirs);
    }

    @Test
    void part2TestData() {
        var sizeOfSmallestDirToDelete = Day07.part2(testInput);
        System.out.println("Size of smallest directory to delete: " + sizeOfSmallestDirToDelete);
        assertEquals(24933642, sizeOfSmallestDirToDelete);
    }

    @Test
    void part2RealData() {
        var sizeOfSmallestDirToDelete = Day07.part2(getResourceAsStringList("twenty22/day07/input.csv"));
        System.out.println("Size of smallest directory to delete: " + sizeOfSmallestDirToDelete);
    }
}
