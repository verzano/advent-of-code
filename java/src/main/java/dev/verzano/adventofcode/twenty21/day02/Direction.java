package dev.verzano.adventofcode.twenty21.day02;

public enum Direction {
    FORWARD,
    DOWN,
    UP;

    static Direction fromString(String name) {
        return Direction.valueOf(name.toUpperCase());
    }
}
