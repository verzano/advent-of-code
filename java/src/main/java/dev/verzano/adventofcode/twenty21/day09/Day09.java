package dev.verzano.adventofcode.twenty21.day09;

import static dev.verzano.adventofcode.twenty21.day09.Basins.buildBasin;
import static dev.verzano.adventofcode.twenty21.day09.LowPoints.isLowPoint;

class Day09 {
    protected static LowPoints part1(int[][] input) {
        var lps = new LowPoints();

        for (var r = 0; r < input.length; r++) {
            for (var c = 0; c < input[r].length; c++) {
                if (isLowPoint(input, r, c)) {
                    lps.addLowPoint(input[r][c]);
                }
            }
        }

        return lps;
    }

    protected static Basins part2(int[][] input) {
        var basins = new Basins();
        for (var r = 0; r < input.length; r++) {
            for (var c = 0; c < input[r].length; c++) {
                if (isLowPoint(input, r, c)) {
                    var basin = buildBasin(input, r, c);
                    basins.addBasin(basin);
                }
            }
        }

        return basins;
    }
}
