package dev.verzano.adventofcode.twenty21.day01;

import java.util.LinkedList;
import java.util.List;

public class Day01 {
    public static int part1(List<Integer> depths) {
        return calculateIncreases(depths);
    }

    public static int part2(List<Integer> depths) {
        var groupedDepths = new LinkedList<Integer>();

        for (var i = 0; i < depths.size() - 2; i++) {
            groupedDepths.add(depths.get(i) + depths.get(i + 1) + depths.get(i + 2));
        }

        return calculateIncreases(groupedDepths);
    }

    private static int calculateIncreases(List<Integer> depths) {
        var increases = 0;
        var prev = depths.get(0);
        for (var current : depths.subList(1, depths.size())) {
            if (current > prev) {
                increases++;
            }

            prev = current;
        }

        return increases;
    }
}
