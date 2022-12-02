package dev.verzano.adventofcode.twenty21.day13;

public enum Axis {
    X, Y;

    public static Axis fromChar(Character c) {
        return switch (c) {
            case 'x' -> X;
            case 'y' -> Y;
            default -> throw new RuntimeException();
        };
    }
}
