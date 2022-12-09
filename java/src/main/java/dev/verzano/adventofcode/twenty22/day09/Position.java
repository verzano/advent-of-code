package dev.verzano.adventofcode.twenty22.day09;

record Position(int x, int y) {
    public static Position defaultPosition() {
        return new Position(0, 0);
    }

    public Position move(Direction d) {
        return switch (d) {
            case UP_LEFT -> new Position(x - 1, y - 1);
            case UP -> new Position(x, y - 1);
            case UP_RIGHT -> new Position(x + 1, y - 1);
            case RIGHT -> new Position(x + 1, y);
            case DOWN_RIGHT -> new Position(x + 1, y + 1);
            case DOWN -> new Position(x, y + 1);
            case DOWN_LEFT -> new Position(x - 1, y + 1);
            case LEFT -> new Position(x - 1, y);
        };
    }
}
