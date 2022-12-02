package dev.verzano.adventofcode.twenty21.day05;

import java.util.Arrays;

import static java.lang.Math.max;
import static java.lang.Math.min;
import static java.util.Arrays.copyOf;

public class SeaFloor {
    private int[][] map = new int[][]{{0}};

    public void addHorizontalVentLine(VentLine vl) {
        final var ax = vl.a().x();
        final var ay = vl.a().y();
        final var bx = vl.b().x();
        final var by = vl.b().y();

        if (ax == bx) {
            expandIfNeeded(vl);
            for (var y = min(ay, by); y <= max(ay, by); y++) {
                map[y][ax] += 1;
            }
        } else if (ay == by) {
            expandIfNeeded(vl);
            for (var x = min(ax, bx); x <= max(ax, bx); x++) {
                map[ay][x] += 1;
            }
        }
    }

    public void addDiagonalVentLine(VentLine vl) {
        final var ax = vl.a().x();
        final var ay = vl.a().y();
        final var bx = vl.b().x();
        final var by = vl.b().y();

        final var dx = ax - bx;
        final var dy = ay - by;
        if (dx == dy) {
            expandIfNeeded(vl);
            var xMax = max(ax, bx);
            var yMax = max(ay, by);

            var y = min(ay, by);
            var x = min(ax, bx);
            for (; y <= yMax; y++, x++) {
                map[y][x] += 1;
            }
        } else if (dx == -dy) {
            expandIfNeeded(vl);
            if (dy < 0) {
                var yMin = min(ay, by);

                var y = max(ay, by);
                var x = min(ax, bx);
                for (; y >= yMin; y--, x++) {
                    map[y][x] += 1;
                }
            } else {
                var yMax = max(ay, by);

                var y = min(ay, by);
                var x = max(ax, bx);
                for (; y <= yMax; y++, x--) {
                    map[y][x] += 1;
                }
            }
        }
    }

    public int countOverlaps() {
        return Arrays.stream(map)
                .map(xs -> Arrays.stream(xs).filter(x -> x >= 2).count())
                .mapToInt(Long::intValue)
                .sum();
    }

    public void expandIfNeeded(VentLine vl) {
        final var a = vl.a();
        final var b = vl.b();

        final var oldX = map[0].length;
        final var newX = max(max(oldX, a.x()), b.x()) + 1;
        if (oldX != newX) {
            for (var y = 0; y < map.length; y++) {
                map[y] = copyOf(map[y], newX);
            }
        }

        final var oldY = map.length;
        final var newY = max(max(oldY, a.y()), b.y()) + 1;
        if (oldY != newY) {
            map = copyOf(map, newY);
            for (var y = oldY; y < map.length; y++) {
                map[y] = new int[newX];
            }
        }
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var xs : map) {
            for (var v : xs) {
                sb.append(v);
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
