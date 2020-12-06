package dev.verzano.aoc2020.day5;

import static dev.verzano.aoc2020.Helper.getResourceAsStringList;

public class Day5Part1 {
    public static void main(String[] args) {
        var lines = getResourceAsStringList("day5/input.txt");

        var highestSeatId = 0;

        for (var line : lines) {
            var seatId = getSeatId(line);
            highestSeatId = Math.max(seatId, highestSeatId);
        }

//        highestSeatId = getSeatId("FBFBBFFRLR"); // Should be e357
        System.out.println("Highest seat id: " + highestSeatId);
    }

    private static int getSeatId(String line) {
        var row = getRow(line);
        var col = getColumn(line);

        return row * 8 + col;
    }

    private static int getRow(String line) {
        var rowCode = line.substring(0, 7);
        return decode(rowCode, 'F', 127);
    }

    private static int getColumn(String line) {
        var colCode = line.substring(7, 10);
        return decode(colCode, 'L', 7);
    }

    private static int decode(String code, char lowChar, int maxVal) {
        var l = 0;
        var r = maxVal;
        var val = 0;
        for (int i = 0; i < code.length(); i++) {
            if (i == code.length() - 1) {
                if (code.charAt(i) == lowChar) {
                    val = l;
                } else {
                    val = r;
                }
            } else {
                if (code.charAt(i) == lowChar) {
                    r = ((int) Math.floor((r + l) / 2.0));
                } else {
                    l = ((int) Math.ceil((r + l) / 2.0));
                }
            }
        }

        return val;
    }
}
