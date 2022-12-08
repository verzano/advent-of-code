package dev.verzano.adventofcode.twenty20.day5;

import java.util.stream.Collectors;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;

class Day5Part2 {
    public static void main(String[] args) {
        var seatIds = getResourceAsStringList("twenty20/day5/input.txt")
                .stream()
                .map(Day5Part2::getSeatId)
                .collect(Collectors.toSet());

        var seatId = 8;
        for (; ; seatId++) {
            if (!seatIds.contains(seatId)
                    && seatIds.contains(seatId - 1)
                    && seatIds.contains(seatId + 1)) {
                break;
            }
        }

        System.out.println("My seat id: " + seatId);
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
