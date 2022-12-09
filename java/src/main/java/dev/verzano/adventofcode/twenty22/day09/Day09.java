package dev.verzano.adventofcode.twenty22.day09;

import java.util.List;

class Day09 {
    protected static int part1(List<String> vectorStrings) {
        var vectors = Vectors.fromStrings(vectorStrings);
        var headTailState = new HeadTailsState(1);
        headTailState.processSteps(vectors);
        headTailState.prettyPrintTailPositionHistory();
        return headTailState.totalTailPositions();
    }

    protected static int part2(List<String> vectorStrings) {
        var vectors = Vectors.fromStrings(vectorStrings);
        var headTailState = new HeadTailsState(9);
        headTailState.processSteps(vectors);
        headTailState.prettyPrintTailPositionHistory();
        return headTailState.totalTailPositions();
    }
}
