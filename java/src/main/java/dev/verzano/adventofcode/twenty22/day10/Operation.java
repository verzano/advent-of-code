package dev.verzano.adventofcode.twenty22.day10;

enum Operation {
    NO_OP(1), ADD_X(2);

    public final int cycles;

    Operation(int cycles) {
        this.cycles = cycles;
    }

    public static Operation forString(String s) {
        return switch (s) {
            case "noop" -> NO_OP;
            case "addx" -> ADD_X;
            default -> throw new RuntimeException("Unknown operation string: " + s);
        };
    }
}
