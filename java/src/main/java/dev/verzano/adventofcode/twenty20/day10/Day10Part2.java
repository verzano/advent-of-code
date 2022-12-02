package dev.verzano.adventofcode.twenty20.day10;

import dev.verzano.adventofcode.Helper;

import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Day10Part2 {
    public static void main(String[] args) {
        var adapters = Helper.getResourceAsIntegerList("twenty20/day10/input.txt")
                .stream()
                .sorted()
                .collect(Collectors.toList());
        adapters.add(0, 0);
        adapters.add(adapters.get(adapters.size() - 1) + 3);

        var cache = new HashMap<Integer, Long>();
        var combinations = calculateCombinations(adapters, cache, 0);
        System.out.println("Number of combinations: " + combinations);
    }

    private static long calculateCombinations(List<Integer> adapters, HashMap<Integer, Long> cache, int index) {
        if (index == adapters.size() - 1) {
            return 1;
        } else if (cache.containsKey(index)) {
            return cache.get(index);
        }

        var combinations = 0L;
        for (var i = index + 1; i < adapters.size(); i++) {
            if (adapters.get(i) - adapters.get(index) <= 3) {
                combinations += calculateCombinations(adapters, cache, i);
            }
        }
        cache.put(index, combinations);
        return combinations;
    }
}
