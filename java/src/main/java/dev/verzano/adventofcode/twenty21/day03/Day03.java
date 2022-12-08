package dev.verzano.adventofcode.twenty21.day03;

import java.util.Arrays;

import static java.lang.Integer.parseInt;
import static java.lang.String.copyValueOf;
import static java.util.Arrays.stream;
import static java.util.stream.Collectors.joining;

class Day03 {
    protected static DiagnosticReport part1(char[][] data) {
        var bits = new int[data[0].length];
        Arrays.fill(bits, 0);

        for (var row : data) {
            for (var i = 0; i < row.length; i++) {
                bits[i] += row[i] == '0' ? -1 : 1;
            }
        }

        var gamma = parseInt(stream(bits)
                .mapToObj(bit -> bit > 0 ? "1" : "0")
                .collect(joining()), 2);

        var epsilon = parseInt(stream(bits)
                .mapToObj(bit -> bit < 0 ? "1" : "0")
                .collect(joining()), 2);

        return new DiagnosticReport(gamma, epsilon, 0, 0);
    }

    protected static DiagnosticReport part2(char[][] data) {
        var oxyData = Arrays.copyOf(data, data.length);
        var col = 0;
        while (oxyData.length > 1) {
            var acc = 0;
            for (var row : oxyData) {
                acc += row[col] == '0' ? -1 : 1;
            }

            final var keep = acc >= 0 ? '1' : '0';
            final var _col = col;
            oxyData = Arrays.stream(oxyData)
                    .filter(r -> r[_col] == keep)
                    .toList()
                    .toArray(new char[][]{});
            col++;
        }

        var co2Data = Arrays.copyOf(data, data.length);
        col = 0;
        while (co2Data.length > 1) {
            var acc = 0;
            for (var row : co2Data) {
                acc += row[col] == '0' ? -1 : 1;
            }

            final var keep = acc < 0 ? '1' : '0';
            final var _col = col;
            co2Data = Arrays.stream(co2Data)
                    .filter(r -> r[_col] == keep)
                    .toList()
                    .toArray(new char[][]{});
            col++;
        }

        return new DiagnosticReport(0, 0, parseInt(copyValueOf(co2Data[0]), 2), parseInt(copyValueOf(oxyData[0]), 2));
    }
}
