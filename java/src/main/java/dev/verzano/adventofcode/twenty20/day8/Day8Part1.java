package dev.verzano.adventofcode.twenty20.day8;

import dev.verzano.adventofcode.Helper;

class Day8Part1 {
    enum Operation {nop, acc, jmp}

    record ProgramState(int idx, int acc) {
    }

    static class Instruction {
        private final Operation operation;
        private final int value;
        private boolean performed = false;

        public Instruction(Operation operation, int value) {
            this.operation = operation;
            this.value = value;
        }

        public ProgramState execute(ProgramState programState) {
            performed = true;
            return switch (operation) {
                case nop: yield new ProgramState(programState.idx + 1, programState.acc);
                case acc: yield new ProgramState(programState.idx + 1, programState.acc + value);
                case jmp: yield new ProgramState(programState.idx + value, programState.acc);
            };
        }
    }

    public static void main(String[] args) {
        var instructions = Helper.getResourceAsStringList("twenty20/day8/input.txt")
                .stream()
                .map(l -> {
                    var pair = l.split(" ");
                    return new Instruction(Operation.valueOf(pair[0]), Integer.parseInt(pair[1]));
                })
                .toList();

        var programState = new ProgramState(0, 0);
        while (!instructions.get(programState.idx).performed) {
            programState = instructions.get(programState.idx).execute(programState);
        }

        System.out.println("Final Program State: " + programState);
    }
}
