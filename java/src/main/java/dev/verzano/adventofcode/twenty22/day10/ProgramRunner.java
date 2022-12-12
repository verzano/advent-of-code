package dev.verzano.adventofcode.twenty22.day10;

import java.util.Set;
import java.util.function.Consumer;

import static dev.verzano.adventofcode.twenty22.day10.Operation.ADD_X;

class ProgramRunner {
    private int x;
    private int cycle;
    private int signalStrength;

    public ProgramRunner() {
        reset();
    }

    public int getSignalStrength() {
        return signalStrength;
    }

    private void execute(Program program, Consumer<Void> fun) {
        reset();
        for (var instruction : program.instructions()) {
            var operation = instruction.operation();
            for (int i = 0; i < operation.cycles; i++) {
                fun.accept(null);
                cycle++;
            }
            if (operation == ADD_X) {
                x += instruction.value();
            }
        }
    }

    public void executeForSignalStrength(Program program, Set<Integer> probeCycles) {
        execute(program, (_ignored) -> maybeProbeForSignalStrength(probeCycles));
    }

    public void executeForCRTImage(Program program, int crtWidth) {
        execute(program, (_ignored) -> printForCRTImage(crtWidth));
    }

    private void maybeProbeForSignalStrength(Set<Integer> probeCycles) {
        if (probeCycles.contains(cycle)) {
            signalStrength += x * cycle;
            System.out.println("During the " + cycle + "th cycle, register X has the value " + x + ", so the signal " +
                    "strength is " + cycle + " * " + x + " = " + (x * cycle) + ".");
        }
    }

    private void printForCRTImage(int crtWidth) {
        var position = (cycle % crtWidth);
        if (position == x || position == x + 1 || position == x + 2) {
            System.out.print("#");
        } else {
            System.out.print(".");
        }

        if (position == 0) {
            System.out.println();
        }
    }

    private void reset() {
        x = 1;
        cycle = 1;
        signalStrength = 0;
    }
}
