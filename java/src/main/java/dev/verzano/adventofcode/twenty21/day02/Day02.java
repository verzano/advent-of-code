package dev.verzano.adventofcode.twenty21.day02;

import java.util.List;

public class Day02 {
    protected static Position part1(List<Move> moves) {
        var position = Position.defaultPosition();

        for (var move : moves) {
            position = position.move(move);
        }

        return position;
    }

    protected static Position part2(List<Move> moves) {
        var position = Position.defaultPosition();

        for (var move : moves) {
            position = position.moveWithAim(move);
        }

        return position;
    }
}
