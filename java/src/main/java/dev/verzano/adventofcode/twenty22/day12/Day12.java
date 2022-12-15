package dev.verzano.adventofcode.twenty22.day12;

import java.util.LinkedList;
import java.util.List;

class Day12 {
    public static int part1(char[][] heights) {
        var starts = generateGraphAndGetStarts(heights, false);
        return Elevation.navigate(starts.get(0));
    }

    public static int part2(char[][] heights) {
        var starts = generateGraphAndGetStarts(heights, true);
        return starts.stream()
                .mapToInt(Elevation::navigate)
                .min()
                .orElseThrow(() -> new RuntimeException("Unable to determine minimum step count"));
    }

    private static List<Elevation> generateGraphAndGetStarts(char[][] heights, boolean includeAllAs) {
        var starts = new LinkedList<Elevation>();
        var elevations = new Elevation[heights.length][heights[0].length];
        for (var r = 0; r < heights.length; r++) {
            for (var c = 0; c < heights[r].length; c++) {
                var heightChar = heights[r][c];
                var elevation = switch (heightChar) {
                    case 'S' -> {
                        var sStart = new Elevation(r, c, 0);
                        starts.add(sStart);
                        yield sStart;
                    }
                    case 'E' -> new Elevation(r, c, 25, true);
                    case 'a' -> {
                        var aStart = new Elevation(r, c, 0);
                        if (includeAllAs) {
                            starts.add(aStart);
                        }
                        yield aStart;
                    }
                    default -> new Elevation(r, c, heightChar - 'a');
                };

                elevations[r][c] = elevation;

                if (r > 0) {
                    var above = elevations[r - 1][c];
                    above.maybeAddNavigableNeighbor(elevation);
                    elevation.maybeAddNavigableNeighbor(above);
                }

                if (c > 0) {
                    var left = elevations[r][c - 1];
                    left.maybeAddNavigableNeighbor(elevation);
                    elevation.maybeAddNavigableNeighbor(left);
                }
            }
        }

        if (starts.isEmpty()) {
            throw new RuntimeException("Unable to locate any start positions");
        }
        return starts;
    }
}
