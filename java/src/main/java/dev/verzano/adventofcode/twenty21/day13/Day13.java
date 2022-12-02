package dev.verzano.adventofcode.twenty21.day13;

public class Day13 {
    public static Matrix part1(Instructions instructions) {
        return instructions.foldOnce();
    }

    public static Matrix part2(Instructions instructions) {
        return instructions.foldAll();
    }
}
