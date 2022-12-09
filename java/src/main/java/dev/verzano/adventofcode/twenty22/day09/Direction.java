package dev.verzano.adventofcode.twenty22.day09;

enum Direction {
    UP_LEFT, UP, UP_RIGHT, RIGHT, DOWN_RIGHT, DOWN, DOWN_LEFT, LEFT;

    public static Direction fromString(String s) {
        return switch (s) {
            case "U" -> UP;
            case "D" -> DOWN;
            case "L" -> LEFT;
            case "R" -> RIGHT;
            default -> throw new RuntimeException("cannot get Direction for unknown String: " + s);
        };
    }
}
