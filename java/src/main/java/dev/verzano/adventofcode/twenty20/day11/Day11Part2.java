package dev.verzano.adventofcode.twenty20.day11;

import dev.verzano.adventofcode.Helper;

import java.util.Arrays;

public class Day11Part2 {
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
        var nOccupied = 0;

        nOccupied += aboveOccupied(seatMap, r, c) ? 1 : 0;
        nOccupied += belowOccupied(seatMap, r, c) ? 1 : 0;
        nOccupied += leftOccupied(seatMap, r, c) ? 1 : 0;
        nOccupied += rightOccupied(seatMap, r, c) ? 1 : 0;
        nOccupied += aboveLeftOccupied(seatMap, r, c) ? 1 : 0;
        nOccupied += belowRightOccupied(seatMap, r, c) ? 1 : 0;
        nOccupied += belowLeftOccupied(seatMap, r, c) ? 1 : 0;
        nOccupied += aboveRightOccupied(seatMap, r, c) ? 1 : 0;

        return nOccupied < 5;
    }

    private static boolean checkUnoccupied(Boolean[][] seatMap, int r, int c) {
        return !(verticalOccupied(seatMap, r, c)
                || horizontalOccupied(seatMap, r, c)
                || aboveLeftBelowRightOccupied(seatMap, r, c)
                || belowLeftAboveRightOccupied(seatMap, r, c));
    }

    private static boolean aboveOccupied(Boolean[][] seatMap, int r, int c) {
        for (var r1 = r - 1; r1 >= 0; r1--) {
            if (seatMap[r1][c] != null) {
                return seatMap[r1][c];
            }
        }

        return false;
    }

    private static boolean belowOccupied(Boolean[][] seatMap, int r, int c) {
        for (var r1 = r + 1; r1 < seatMap.length; r1++) {
            if (seatMap[r1][c] != null) {
                return seatMap[r1][c];
            }
        }

        return false;
    }

    private static boolean verticalOccupied(Boolean[][] seatMap, int r, int c) {
        return aboveOccupied(seatMap, r, c) || belowOccupied(seatMap, r, c);
    }

    private static boolean leftOccupied(Boolean[][] seatMap, int r, int c) {
        for (var c1 = c - 1; c1 >= 0; c1--) {
            if (seatMap[r][c1] != null) {
                return seatMap[r][c1];
            }
        }

        return false;
    }

    private static boolean rightOccupied(Boolean[][] seatMap, int r, int c) {
        for (var c1 = c + 1; c1 < seatMap[r].length; c1++) {
            if (seatMap[r][c1] != null) {
                return seatMap[r][c1];
            }
        }

        return false;
    }

    private static boolean horizontalOccupied(Boolean[][] seatMap, int r, int c) {
        return leftOccupied(seatMap, r, c) || rightOccupied(seatMap, r, c);
    }

    private static boolean aboveLeftBelowRightOccupied(Boolean[][] seatMap, int r, int c) {
        return aboveLeftOccupied(seatMap, r, c) || belowRightOccupied(seatMap, r, c);
    }

    private static boolean aboveLeftOccupied(Boolean[][] seatMap, int r, int c) {
        var r1 = r - 1;
        var c1 = c - 1;
        while (r1 >= 0 && c1 >= 0) {
            if (seatMap[r1][c1] != null) {
                return seatMap[r1][c1];
            }

            r1--;
            c1--;
        }
        return false;
    }

    private static boolean belowRightOccupied(Boolean[][] seatMap, int r, int c) {
        var r1 = r + 1;
        var c1 = c + 1;
        while (r1 < seatMap.length && c1 < seatMap[r1].length) {
            if (seatMap[r1][c1] != null) {
                return seatMap[r1][c1];
            }

            r1++;
            c1++;
        }

        return false;
    }

    private static boolean belowLeftAboveRightOccupied(Boolean[][] seatMap, int r, int c) {
        return belowLeftOccupied(seatMap, r, c) || aboveRightOccupied(seatMap, r, c);
    }

    private static boolean belowLeftOccupied(Boolean[][] seatMap, int r, int c) {
        var r1 = r + 1;
        var c1 = c - 1;
        while (r1 < seatMap.length && c1 >= 0) {
            if (seatMap[r1][c1] != null) {
                return seatMap[r1][c1];
            }

            r1++;
            c1--;
        }

        return false;
    }

    private static boolean aboveRightOccupied(Boolean[][] seatMap, int r, int c) {
        var r1 = r - 1;
        var c1 = c + 1;
        while (r1 >= 0 && c1 < seatMap[r1].length) {
            if (seatMap[r1][c1] != null) {
                return seatMap[r1][c1];
            }

            r1--;
            c1++;
        }
        return false;
    }
}
