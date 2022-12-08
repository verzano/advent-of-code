package dev.verzano.adventofcode.twenty22.day02;

import java.util.LinkedList;
import java.util.List;

class Day02 {
    protected static int part1(char[][] strategyGuide) {
        return convertToRounds(strategyGuide, Mode.FOR_MOVE)
                .stream()
                .mapToInt(Round::calculateScore)
                .sum();
    }

    protected static int part2(char[][] strategyGuide) {
        return convertToRounds(strategyGuide, Mode.FOR_OUTCOME)
                .stream()
                .mapToInt(Round::calculateScore)
                .sum();
    }

    private static List<Round> convertToRounds(char[][] strategyGuide, Mode mode) {
        var rounds = new LinkedList<Round>();
        for (var sg : strategyGuide) {
            rounds.add(Round.fromStrategyGuide(sg, mode));
        }
        return rounds;
    }

    protected enum Mode {
        FOR_OUTCOME, FOR_MOVE
    }
}
