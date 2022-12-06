package dev.verzano.adventofcode.twenty22.day06;

import java.util.HashSet;

public class Day06 {
    protected static int part1(String dataStream) {
        final int markerLength = 4;

        return findMarker(dataStream, markerLength);
    }

    protected static int part2(String dataStream) {
        final int markerLength = 14;

        return findMarker(dataStream, markerLength);
    }

    private static int findMarker(String dataStream, int markerLength) {
        for (var i = 0; i < dataStream.length() - markerLength; i++) {
            var set = new HashSet<Character>();
            for (var j = markerLength - 1; j >= 0; j--) {
                if (!set.add(dataStream.charAt(i + j))) {
                    i += j;
                    break;
                }

                if (set.size() == markerLength) {
                    return i + set.size();
                }
            }
        }

        throw new RuntimeException("Unable to find a marker :(");
    }
}
