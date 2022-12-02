package dev.verzano.adventofcode.twenty22.day02;

import static dev.verzano.adventofcode.twenty22.day02.Move.*;

public enum Outcome {
    WIN(6), DRAW(3), LOSS(0);

    public final int score;

    Outcome(int score) {
        this.score = score;
    }

    public static Outcome calculateOutcome(Move theirs, Move yours) {
        if (theirs == yours) {
            return DRAW;
        } else if (theirs == ROCK) {
            return yours == PAPER ? WIN : LOSS;
        } else if (theirs == PAPER) {
            return yours == SCISSORS ? WIN : LOSS;
        } else {
            return yours == ROCK ? WIN : LOSS;
        }
    }

    public static Outcome fromStrategyGuide(char input) {
        return switch (input) {
            case 'X' -> LOSS;
            case 'Y' -> DRAW;
            case 'Z' -> WIN;
            default -> throw new RuntimeException("This shouldn't have happened, unknown input: " + input);
        };
    }
}
