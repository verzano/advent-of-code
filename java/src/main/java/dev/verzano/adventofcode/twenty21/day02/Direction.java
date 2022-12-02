package dev.verzano.adventofcode.twenty21.day02;

public enum Direction {
    FORWARD,
    DOWN,
    UP;

    public static Direction forString(String name) {
        return Direction.valueOf(name.toUpperCase());
    }
}
