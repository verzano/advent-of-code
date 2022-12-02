package dev.verzano.adventofcode.twenty21.day12;

import java.util.List;

public class Day12 {
    public static Paths part1(List<String> input) {
        var g = new Graph();
        for (var s : input) {
            var ss = s.split("-");
            g.addConnectedCaves(ss[0], ss[1]);
        }

        return g.findPaths(false);
    }

    public static Paths part2(List<String> input) {
        var g = new Graph();
        for (var s : input) {
            var ss = s.split("-");
            g.addConnectedCaves(ss[0], ss[1]);
        }

        return g.findPaths(true);
    }
}
