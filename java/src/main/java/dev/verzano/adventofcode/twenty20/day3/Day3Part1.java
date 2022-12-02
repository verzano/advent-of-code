package dev.verzano.adventofcode.twenty20.day3;

import dev.verzano.adventofcode.Helper;

public class Day3Part1 {
    public static void main(String[] args) {
        var map = Helper.getResourceAsStringList("twenty20/day3/intput.txt")
                .stream()
                .map(s -> s.chars()
                        .mapToObj(c -> c == '#')
                        .toArray(Boolean[]::new))
                .toArray(Boolean[][]::new);

        var treeCount = 0;
        var x = 0;
        for (Boolean[] row : map) {
            treeCount += row[x] ? 1 : 0;
            x = (x + 3) % row.length;
        }

        System.out.println("Number of trees hit: " + treeCount);
    }
}
