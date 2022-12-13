package dev.verzano.adventofcode.twenty22.day10;

record Instruction(Operation operation, Integer value) {
    public static Instruction fromString(String s) {
        var parts = s.split(" ");
        var operation = Operation.fromString(parts[0]);
        var value = switch (operation) {
            case ADD_X -> Integer.parseInt(parts[1]);
            case NO_OP -> null;
        };

        return new Instruction(operation, value);
    }
}
