package dev.verzano.adventofcode.twenty15.day02;

import java.util.List;

public class Day02 {
    protected static long part1(List<String> dimensions) {
        var totalSurfaceArea = 0;
        for (var dimensionString : dimensions) {
            var dimensionArray = dimensionString.split("x");
            var l = Integer.parseInt(dimensionArray[0]);
            var w = Integer.parseInt(dimensionArray[1]);
            var h = Integer.parseInt(dimensionArray[2]);
            var a = l * w;
            var b = l * h;
            var c = w * h;
            totalSurfaceArea += 2 * (a + b + c) + Math.min(a, Math.min(b, c));
        }

        return totalSurfaceArea;
    }

    protected static long part2(List<String> dimensions) {
        var totalLength = 0;
        for (var dimensionString : dimensions) {
            var dimensionArray = dimensionString.split("x");
            var l = Integer.parseInt(dimensionArray[0]);
            var w = Integer.parseInt(dimensionArray[1]);
            var h = Integer.parseInt(dimensionArray[2]);
            var x = 2 * (l + w + h) - 2 * (Math.max(l, Math.max(w, h)));

            totalLength += l * w * h + x;
        }

        return totalLength;
    }
}
