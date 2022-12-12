package dev.verzano.adventofcode.twenty22.day10;

import java.util.List;

record Program(List<Instruction> instructions) {
    public static Program forStrings(List<String> ss) {
        var instructions = ss.stream()
                .map(Instruction::forString)
                .toList();
        return new Program(instructions);
    }
}
