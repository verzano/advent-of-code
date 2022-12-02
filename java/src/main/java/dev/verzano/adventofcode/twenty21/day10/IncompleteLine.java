package dev.verzano.adventofcode.twenty21.day10;

import java.util.LinkedList;

public record IncompleteLine(String line, LinkedList<Character> requiredSuffix) {
    public long points() {
        var points = 0L;
        for (var c : requiredSuffix) {
            points *= 5L;
            switch (c) {
                case ')' -> points += 1L;
                case ']' -> points += 2L;
                case '}' -> points += 3L;
                case '>' -> points += 4L;
            }
        }

        return points;
    }
}
