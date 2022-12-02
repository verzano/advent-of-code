package dev.verzano.adventofcode.twenty22.day02;

public record Round(Move theirs, Move yours, Outcome outcome) {
    public Round(Move theirs, Move yours) {
        this(theirs, yours, Outcome.calculateOutcome(theirs, yours));
    }

    public int calculateScore() {
        return yours.score + outcome.score;
    }

    public static Round fromStrategyGuide(char[] sg, Day02.Mode mode) {
        var theirs = Move.fromStrategyGuide(sg[0]);
        return switch (mode) {
            case FOR_MOVE -> new Round(theirs, Move.fromStrategyGuide(sg[1]));
            case FOR_OUTCOME -> new Round(theirs, Move.forDesiredOutcome(theirs, Outcome.fromStrategyGuide(sg[1])));
        };
    }
}
