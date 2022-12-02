package dev.verzano.adventofcode.twenty22.day02;

public enum Move {
    ROCK(1), PAPER(2), SCISSORS(3);

    public final int score;

    Move(int score) {
        this.score = score;
    }

    public static Move fromStrategyGuide(char input) {
        return switch (input) {
            case 'A', 'X' -> ROCK;
            case 'B', 'Y' -> PAPER;
            case 'C', 'Z' -> SCISSORS;
            default -> throw new RuntimeException("This shouldn't have happened, unknown input: " + input);
        };
    }

    public static Move forDesiredOutcome(Move theirs, Outcome desiredOutcome) {
        return switch (desiredOutcome) {
            case DRAW -> theirs;
            case WIN -> switch (theirs) {
                case ROCK -> PAPER;
                case PAPER -> SCISSORS;
                case SCISSORS -> ROCK;
            };
            case LOSS -> switch (theirs) {
                case ROCK -> SCISSORS;
                case PAPER -> ROCK;
                case SCISSORS -> PAPER;
            };
        };
    }
}
