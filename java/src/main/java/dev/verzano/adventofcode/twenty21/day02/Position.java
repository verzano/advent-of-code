package dev.verzano.adventofcode.twenty21.day02;

public record Position(int horizontalPosition, int depth, int aim) {
    protected static Position defaultPosition() {
        return new Position(0, 0, 0);
    }

    public Position move(Move move) {
        return switch (move.direction()) {
            case FORWARD -> new Position(horizontalPosition + move.distance(), depth, 0);
            case DOWN -> new Position(horizontalPosition, depth + move.distance(), 0);
            case UP -> new Position(horizontalPosition, depth - move.distance(), 0);
        };
    }

    public Position moveWithAim(Move move) {
        return switch (move.direction()) {
            case FORWARD -> new Position(horizontalPosition + move.distance(), depth + (aim * move.distance()), aim);
            case DOWN -> new Position(horizontalPosition, depth, aim + move.distance());
            case UP -> new Position(horizontalPosition, depth, aim - move.distance());
        };
    }
}
