package dev.verzano.adventofcode.twenty21.day13;

public record Point(int x, int y) {
    public Point fold(Fold fold) {
        return switch (fold.a()) {
            case X -> x < fold.v() ? this : new Point(2 * fold.v() - x, y);
            case Y -> y <= fold.v() ? this : new Point(x, 2 * fold.v() - y);
        };
    }
}
