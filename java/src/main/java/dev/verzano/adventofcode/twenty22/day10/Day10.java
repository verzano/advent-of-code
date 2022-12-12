package dev.verzano.adventofcode.twenty22.day10;

import java.util.List;
import java.util.Set;

class Day10 {
    protected static int part1(List<String> instructionStrings) {
        var program = Program.forStrings(instructionStrings);
        var runner = new ProgramRunner();
        runner.executeForSignalStrength(program, Set.of(20, 60, 100, 140, 180, 220));
        return runner.getSignalStrength();
    }

    protected static int part2(List<String> instructionStrings) {
        var program = Program.forStrings(instructionStrings);
        var runner = new ProgramRunner();
        runner.executeForCRTImage(program, 40);
        return runner.getSignalStrength();
    }
}
