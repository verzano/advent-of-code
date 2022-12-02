package dev.verzano.adventofcode.twenty21.day10;

public record ErrorLine(String line, char expected, char found) {
    public long points() {
        return switch (found) {
            case ')' -> 3L;
            case ']' -> 57L;
            case '}' -> 1197L;
            case '>' -> 25137L;
            default -> throw new RuntimeException();
        };
    }
}
