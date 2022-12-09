package dev.verzano.adventofcode.twenty22.day09;

import java.util.HashSet;
import java.util.Set;

public class PositionHistory {
    private Position current;
    private final Set<Position> positionHistory = new HashSet<>();

    public PositionHistory() {
        current = Position.defaultPosition();
        positionHistory.add(current);
    }

    public Set<Position> getPositionHistory() {
        return positionHistory;
    }

    public void prettyPrintPositionHistory() {
        var minX = Integer.MAX_VALUE;
        var maxX = Integer.MIN_VALUE;

        var minY = Integer.MAX_VALUE;
        var maxY = Integer.MIN_VALUE;

        for (var p : positionHistory) {
            minX = Math.min(minX, p.x());
            maxX = Math.max(maxX, p.x());

            minY = Math.min(minY, p.y());
            maxY = Math.max(maxY, p.y());
        }

        var points = new boolean[Math.abs(minY - maxY) + 1][maxX - minX + 1];
        for (var p : positionHistory) {
            points[Math.abs(p.y() - maxY)][p.x() - minX] = true;
        }


        for (var row = points.length - 1; row >= 0; row--) {
            for (var col = 0; col < points[row].length; col++) {
                System.out.print(points[row][col] ? '#' : '.');
            }
            System.out.println();
        }
    }

    public void move(Direction d) {
        current = current.move(d);
        positionHistory.add(current);
    }

    public void correctPosition(PositionHistory previousSegment) {
        var xDiff = previousSegment.current.x() - current.x();
        var yDiff = previousSegment.current.y() - current.y();

        if (Math.abs(xDiff) < 2 && Math.abs(yDiff) < 2) {
            return;
        }

        if (xDiff == 0) {
            if (yDiff < 0) {
                current = current.move(Direction.UP);
                positionHistory.add(current);
            } else if (yDiff > 0) {
                current = current.move(Direction.DOWN);
                positionHistory.add(current);
            }
        } else if (yDiff == 0) {
            if (xDiff > 0) {
                current = current.move(Direction.RIGHT);
                positionHistory.add(current);
            } else {
                current = current.move(Direction.LEFT);
                positionHistory.add(current);
            }
        } else if (yDiff < 0) {
            if (xDiff > 0) {
                current = current.move(Direction.UP_RIGHT);
                positionHistory.add(current);
            } else {
                current = current.move(Direction.UP_LEFT);
                positionHistory.add(current);
            }
        } else {
            if (xDiff > 0) {
                current = current.move(Direction.DOWN_RIGHT);
                positionHistory.add(current);
            } else {
                current = current.move(Direction.DOWN_LEFT);
                positionHistory.add(current);
            }
        }
    }
}
