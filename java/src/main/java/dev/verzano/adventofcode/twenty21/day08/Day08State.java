package dev.verzano.adventofcode.twenty21.day08;

import java.util.LinkedList;
import java.util.List;

public class Day08State {
    private final List<SignalPair> signalPairs = new LinkedList<>();

    public void addState(SignalLine sl, SignalMapping sm) {
        signalPairs.add(new SignalPair(sl, sm));
    }

    public String prettyPrint() {
        var sb = new StringBuilder();
        for (var sp : signalPairs) {
            sb.append(sp.prettyPrint()).append("\n");
        }
        return sb.toString();
    }

    public int sum() {
        return signalPairs.stream()
                .mapToInt(SignalPair::convertOutput)
                .sum();
    }

    private record SignalPair(SignalLine sl, SignalMapping sm) {
        public Integer convertOutput() {
            return sl.convertOutputs(sm);
        }

        public String prettyPrint() {
            return sl.prettyPrint(sm);
        }
    }
}
