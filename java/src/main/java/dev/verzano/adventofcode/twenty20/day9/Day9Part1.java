package dev.verzano.adventofcode.twenty20.day9;

import dev.verzano.adventofcode.Helper;

import java.util.List;

class Day9Part1 {
    private static final int PREAMBLE_LENGTH = 25;

    public static void main(String[] args) {
        var nums = Helper.getResourceAsStringList("twenty20/day9/input.txt")
                .stream()
                .map(Long::valueOf)
                .toList();

        for (var idx = PREAMBLE_LENGTH; idx < nums.size(); idx++) {
            if (!canSumTo(nums.subList(idx - PREAMBLE_LENGTH, idx), nums.get(idx))) {
                System.out.println("Bad entry: " + nums.get(idx));
            }
        }
    }

    private static boolean canSumTo(List<Long> nums, Long sum) {
        for (var i = 0; i < nums.size() - 1; i++) {
            for (var j = i + 1; j < nums.size(); j++) {
                if (nums.get(i) + nums.get(j) == sum) {
                    return true;
                }
            }
        }

        return false;
    }
}
