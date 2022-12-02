package dev.verzano.adventofcode.twenty20.day11;

import dev.verzano.adventofcode.Helper;

import java.util.Arrays;

public class Day11Part1 {
    public static void main(String[] args) {
        var seatMap = Helper.getResourceAsStringList("twenty20/day11/input.txt")
                .stream()
                .map(l -> {
                    Boolean[] r = new Boolean[l.length()];
                    for (var i = 0; i < l.length(); i++) {
                        r[i] = l.charAt(i) == 'L' ? false : null;
                    }
                    return r;
                })
                .toList()
                .toArray(new Boolean[0][0]);

        var iteration = 0;
        printSeatMap(seatMap, iteration);
        boolean changed;
        do {
            var newSeatMap = new Boolean[seatMap.length][seatMap[0].length];
            changed = false;
            for (var r = 0; r < seatMap.length; r++) {
                for (var c = 0; c < seatMap[r].length; c++) {
                    Boolean occupied = seatMap[r][c];
                    if (occupied == null) {
                        continue;
                    }


                    if (occupied) {
                        newSeatMap[r][c] = checkOccupied(seatMap, r, c);
                    } else {
                        newSeatMap[r][c] = checkUnoccupied(seatMap, r, c);
                    }

                    changed |= occupied != newSeatMap[r][c];
                }
            }

            printSeatMap(newSeatMap, ++iteration);
            seatMap = newSeatMap;
        } while (changed);

        var nOccupied = Arrays.stream(seatMap)
                .mapToInt(r -> Arrays.stream(r).mapToInt(b -> b != null && b ? 1 : 0).sum())
                .sum();
        System.out.println("Number of occupied seats: " + nOccupied);
    }

    private static void printSeatMap(Boolean[][] newSeatMap, int iteration) {
        System.out.println("-- Iteration " + iteration + " --");
        for (Boolean[] r : newSeatMap) {
            for (Boolean c : r) {
                System.out.print(c == null ? '.' : c ? '#' : 'L');
            }
            System.out.println();
        }
        System.out.println("\n\n");
    }

    private static boolean checkOccupied(Boolean[][] seatMap, int r, int c) {
        var notFirstRow = r > 0;
        var notLastRow = r < seatMap.length - 1;
        var notFirstCol = c > 0;
        var notLastCol = c < seatMap[r].length - 1;

        var nOccupied = 0;
        for (var r1 = r - (notFirstRow ? 1 : 0); r1 <= r + (notLastRow ? 1 : 0); r1++) {
            for (var c1 = c - (notFirstCol ? 1 : 0); c1 <= c + (notLastCol ? 1 : 0); c1++) {
                if (r1 == r && c1 == c || seatMap[r1][c1] == null) {
                    continue;
                }

                nOccupied += seatMap[r1][c1] ? 1 : 0;

                if (nOccupied >= 4) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean checkUnoccupied(Boolean[][] seatMap, int r, int c) {
        var notFirstRow = r > 0;
        var notLastRow = r < seatMap.length - 1;
        var notFirstCol = c > 0;
        var notLastCol = c < seatMap[r].length - 1;

        for (var r1 = r - (notFirstRow ? 1 : 0); r1 <= r + (notLastRow ? 1 : 0); r1++) {
            for (var c1 = c - (notFirstCol ? 1 : 0); c1 <= c + (notLastCol ? 1 : 0); c1++) {
                if (r1 == r && c1 == c || seatMap[r1][c1] == null) {
                    continue;
                }

                if (seatMap[r1][c1]) {
                    return false;
                }
            }
        }

        return true;
    }
}
