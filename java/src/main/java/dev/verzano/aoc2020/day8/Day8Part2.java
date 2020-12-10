package dev.verzano.aoc2020.day8;

import dev.verzano.aoc2020.Helper;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Day8Part2 {
    enum Operation { nop, acc, jmp }

    record ProgramState(int idx, int acc) { }

    static class Instruction {
        private final Operation operation;
        private final int value;
        private final int idx;
        private int timesPerformed = 0;

        public Instruction(Operation operation, int value, int idx) {
            this.operation = operation;
            this.value = value;
            this.idx = idx;
        }

        public ProgramState execute(ProgramState programState) {
            timesPerformed++;
            return switch (operation) {
                case nop: yield new ProgramState(programState.idx + 1, programState.acc);
                case acc: yield new ProgramState(programState.idx + 1, programState.acc + value);
                case jmp: yield new ProgramState(programState.idx + value, programState.acc);
            };
        }
    }

    public static void main(String[] args) {
        var idx = new AtomicInteger(0);
        var instructions = Helper.getResourceAsStringList("day8/input.txt")
                .stream()
                .map(l -> {
                    var pair = l.split(" ");
                    return new Instruction(Operation.valueOf(pair[0]), Integer.parseInt(pair[1]), idx.getAndIncrement());
                })
                .collect(Collectors.toList());

        var programState = new ProgramState(0, 0);
        while (instructions.get(programState.idx).timesPerformed < 2) {
            programState = instructions.get(programState.idx).execute(programState);
        }

        var loop = instructions.stream()
                .filter(i -> i.timesPerformed > 1)
                .filter(i -> i.operation != Operation.acc)
                .collect(Collectors.toList());

        System.out.println("Final Program State: " + programState);
    }
}
