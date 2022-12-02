package dev.verzano.adventofcode.twenty20.day1;

import static dev.verzano.adventofcode.Helper.getResourceAsIntegerList;

public class Day1Part1 {
    public static void main(String[] args) {
        var lines = getResourceAsIntegerList("twenty20/day1/input.txt");

        for (var i = 0; i < lines.size() - 1; i++) {
            for (var j = i + 1; j < lines.size(); j++) {
                var l = lines.get(i);
                var r = lines.get(j);
                if (l + r == 2020) {
                    System.out.println("Found it! l = " + l + " and r = " + r + " and l * r = " + (l * r));
                    return;
                }
            }
        }
    }
}
