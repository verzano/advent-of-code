package dev.verzano.adventofcode.twenty22.day09;

record Vector(Direction direction, int distance) {
    public static Vector fromString(String s) {
        var parts = s.split(" ");
        return new Vector(Direction.fromString(parts[0]), Integer.parseInt(parts[1]));
    }
}
