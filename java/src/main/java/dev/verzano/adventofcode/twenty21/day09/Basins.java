package dev.verzano.adventofcode.twenty21.day09;

import java.util.LinkedList;
import java.util.List;

import static java.util.Comparator.comparingInt;

public class Basins {
    private final List<Basin> basins = new LinkedList<>();

    public List<Basin> getBasins() {
        return basins;
    }

    public void addBasin(Basin basin) {
        basins.add(basin);
    }

    public int solutionValue() {
        return basins.stream()
                .sorted(comparingInt(Basin::basinSize).reversed())
                .toList()
                .subList(0, 3)
                .stream()
                .mapToInt(Basin::basinSize)
                .reduce(1, (a, b) -> a * b);
    }

    protected static Basin buildBasin(int[][] map, int r, int c) {
        var basin = new Basin();
        basin.addPoint(r, c);
        return buildBasinInternal(basin, map, r, c);
    }

    private static Basin buildBasinInternal(Basin basin, int[][] map, int r, int c) {
        var p = map[r][c];

        if (r > 0) {
            var above = map[r - 1][c];
            if (above != 9 && p < above && basin.notContainsPoint(r - 1, c)) {
                basin.addPoint(r - 1, c);
                buildBasinInternal(basin, map, r - 1, c);
            }
        }

        if (r < map.length - 1) {
            var below = map[r + 1][c];
            if (below != 9 && p < below && basin.notContainsPoint(r + 1, c)) {
                basin.addPoint(r + 1, c);
                buildBasinInternal(basin, map, r + 1, c);
            }
        }

        if (c > 0) {
            var left = map[r][c - 1];
            if (left != 9 && p < left && basin.notContainsPoint(r, c - 1)) {
                basin.addPoint(r, c - 1);
                buildBasinInternal(basin, map, r, c - 1);
            }
        }

        if (c < map[r].length - 1) {
            var right = map[r][c + 1];
            if (right != 9 && p < right && basin.notContainsPoint(r, c + 1)) {
                basin.addPoint(r, c + 1);
                buildBasinInternal(basin, map, r, c + 1);
            }
        }

        return basin;
    }
}
