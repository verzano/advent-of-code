package dev.verzano.adventofcode.twenty22.day09;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class HeadTailsState {
    private final PositionHistory head = new PositionHistory();
    private final LinkedList<PositionHistory> tailSegments = new LinkedList<>();

    public HeadTailsState(int tailsSections) {
        IntStream.range(0, tailsSections).forEach(i -> tailSegments.add(new PositionHistory()));
    }

    public void processSteps(Vectors vectors) {
        for (var v : vectors.list()) {
            for (var i = 0; i < v.distance(); i++) {
                head.move(v.direction());
                var previousSegment = head;
                for (var tail : tailSegments) {
                    tail.correctPosition(previousSegment);
                    previousSegment = tail;
                }
            }
        }
    }

    public int totalTailPositions() {
        return tailSegments.getLast().getPositionHistory().size();
    }

    public void prettyPrintTailPositionHistory() {
        tailSegments.getLast().prettyPrintPositionHistory();
    }
}
