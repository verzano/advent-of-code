package dev.verzano.adventofcode.twenty22.day09;

import java.util.List;

record Vectors(List<Vector> list) {
    public static Vectors fromStrings(List<String> ss) {
        var steps = ss.stream().map(Vector::fromString).toList();
        return new Vectors(steps);
    }
}
