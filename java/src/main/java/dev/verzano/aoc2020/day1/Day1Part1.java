package dev.verzano.aoc2020.day1;

import java.util.stream.Collectors;

import static dev.verzano.aoc2020.Helper.getResourceAsStringList;

public class Day1Part1 {
    public static void main(String[] args) {
        var lines = getResourceAsStringList("day1/input.txt")
                .stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());

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
