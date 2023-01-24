package dev.verzano.adventofcode.twenty15.day06;

import java.util.List;

class Day06 {
    protected static int part1(List<String> instructionStrings) {
        var matrix = new LightMatrix(1000, 1000);

        var instructions = mapToInstructions(instructionStrings);
        for (var instruction : instructions) {
            matrix.performInstruction(instruction);
        }

        return matrix.getLitCount();
    }

    protected static long part2(List<String> instructionStrings) {
        var matrix = new LightMatrix(1000, 1000);

        var instructions = mapToInstructions(instructionStrings);
        for (var instruction : instructions) {
            matrix.performInstruction(instruction);
        }

        return matrix.getTotalBrightness();
    }

    private static List<Instruction> mapToInstructions(List<String> strings) {
        return strings.stream().map(s -> {
            var parts = s.split(" ");
            if (parts[0].equals("toggle")) {
                return Instruction.toggle(parts[1], parts[3]);
            } else if (parts[1].equals("on")) {
                return Instruction.turnOn(parts[2], parts[4]);
            } else if (parts[1].equals("off")) {
                return Instruction.turnOff(parts[2], parts[4]);
            } else {
                throw new RuntimeException("Unable to process instruction string: " + s);
            }
        }).toList();
    }
}
