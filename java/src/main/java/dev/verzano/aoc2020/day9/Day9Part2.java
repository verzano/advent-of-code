package dev.verzano.aoc2020.day9;

import dev.verzano.aoc2020.Helper;

import java.util.List;
import java.util.stream.Collectors;

public class Day9Part2 {
    private static final int BAD_ENTRY = 29221323;

    public static void main(String[] args) {
        var nums = Helper.getResourceAsStringList("day9/input.txt")
                .stream()
                .map(Long::valueOf)
                .collect(Collectors.toList());

        for (var i = 0; i < nums.size() - 1; i++) {
            for (var j = i + 1; j < nums.size(); j++) {
                List<Long> numsSubset = nums.subList(i, j);
                long sum = numsSubset.stream().mapToLong(l -> l).sum();
                if (sum == BAD_ENTRY) {
                    var min = numsSubset.stream().mapToLong(l -> l).min().getAsLong();
                    var max = numsSubset.stream().mapToLong(l -> l).max().getAsLong();
                    System.out.println("Sum of min and max: " + (min + max));
                    return;
                } else if (sum > BAD_ENTRY) {
                    break;
                }
            }
        }
    }
}
