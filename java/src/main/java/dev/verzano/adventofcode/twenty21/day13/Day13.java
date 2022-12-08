package dev.verzano.adventofcode.twenty21.day13;

class Day13 {
    protected static Matrix part1(Instructions instructions) {
        return instructions.foldOnce();
    }

    protected static Matrix part2(Instructions instructions) {
        return instructions.foldAll();
    }
}
