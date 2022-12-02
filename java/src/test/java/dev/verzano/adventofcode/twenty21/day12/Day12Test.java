package dev.verzano.adventofcode.twenty21.day12;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day12.Day12.part1;
import static dev.verzano.adventofcode.twenty21.day12.Day12.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day12Test {
    @Test
    void part1SmallData() {
        var paths = part1(getResourceAsStringList("twenty21/day12/small.txt"));
        System.out.println(paths.prettyPrint());
        System.out.println("Number of paths: " + paths.size());
        assertEquals(10, paths.size());
    }

    @Test
    void part1TestData() {
        var paths = part1(getResourceAsStringList("twenty21/day12/test.txt"));
        System.out.println(paths.prettyPrint());
        System.out.println("Number of paths: " + paths.size());
        assertEquals(19, paths.size());
    }

    @Test
    void part1LargeData() {
        var paths = part1(getResourceAsStringList("twenty21/day12/large.txt"));
        System.out.println(paths.prettyPrint());
        System.out.println("Number of paths: " + paths.size());
        assertEquals(226, paths.size());
    }

    @Test
    void part1RealData() {
        var paths = part1(getResourceAsStringList("twenty21/day12/real.txt"));
        System.out.println("Number of paths: " + paths.size());
    }

    @Test
    void part2SmallData() {
        var paths = part2(getResourceAsStringList("twenty21/day12/small.txt"));
        System.out.println(paths.prettyPrint());
        System.out.println("Number of paths: " + paths.size());
        assertEquals(36, paths.size());
    }

    @Test
    void part2TestData() {
        var paths = part2(getResourceAsStringList("twenty21/day12/test.txt"));
        System.out.println(paths.prettyPrint());
        System.out.println("Number of paths: " + paths.size());
        assertEquals(103, paths.size());
    }

    @Test
    void part2LargeData() {
        var paths = part2(getResourceAsStringList("twenty21/day12/large.txt"));
        System.out.println(paths.prettyPrint());
        System.out.println("Number of paths: " + paths.size());
        assertEquals(3509, paths.size());
    }

    @Test
    void part2RealData() {
        var paths = part2(getResourceAsStringList("twenty21/day12/real.txt"));
        System.out.println("Number of paths: " + paths.size());
    }
}