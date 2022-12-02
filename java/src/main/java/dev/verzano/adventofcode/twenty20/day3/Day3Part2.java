package dev.verzano.adventofcode.twenty20.day3;

import dev.verzano.adventofcode.Helper;

public class Day3Part2 {
    public static void main(String[] args) {
        var map = Helper.getResourceAsStringList("twenty20/day3/intput.txt")
                .stream()
                .map(s -> s.chars()
                        .mapToObj(c -> c == '#')
                        .toArray(Boolean[]::new))
                .toArray(Boolean[][]::new);

        var count11 = 0L;
        var count31 = 0L;
        var count51 = 0L;
        var count71 = 0L;
        var count12 = 0L;

        var horiz11 = 0;
        var horiz31 = 0;
        var horiz51 = 0;
        var horiz71 = 0;
        var horiz12 = 0;

        var even = true;

        for (Boolean[] row : map) {
            count11 += row[horiz11] ? 1 : 0;
            horiz11 = (horiz11 + 1) % row.length;

            count31 += row[horiz31] ? 1 : 0;
            horiz31 = (horiz31 + 3) % row.length;

            count51 += row[horiz51] ? 1 : 0;
            horiz51 = (horiz51 + 5) % row.length;

            count71 += row[horiz71] ? 1 : 0;
            horiz71 = (horiz71 + 7) % row.length;

            if (even) {
                count12 += row[horiz12] ? 1 : 0;
                horiz12 = (horiz12 + 1) % row.length;
            }
            even = !even;
        }

        System.out.println("Number of trees hit for count11: " + count11);
        System.out.println("Number of trees hit for count31: " + count31);
        System.out.println("Number of trees hit for count51: " + count51);
        System.out.println("Number of trees hit for count71: " + count71);
        System.out.println("Number of trees hit for count12: " + count12);
        System.out.println("Solution: " + (count11 * count31 * count51 * count71 * count12));
    }
}
