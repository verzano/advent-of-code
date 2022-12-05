package dev.verzano.adventofcode.twenty21.day13;

public enum Axis {
    X, Y;

    protected static Axis fromChar(Character c) {
        return switch (c) {
            case 'x' -> X;
            case 'y' -> Y;
            default -> throw new RuntimeException();
        };
    }
}
