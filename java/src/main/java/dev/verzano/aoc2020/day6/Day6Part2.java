package dev.verzano.aoc2020.day6;

import dev.verzano.aoc2020.Helper;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class Day6Part2 {
    public static void main(String[] args) {
        var nValid = 0;
        for (String chunk : Arrays.stream(Helper.getResourceAsString("day6/input.txt")
                .split("\n\n"))
                .collect(Collectors.toList())) {
            Set<String> valid = null;
            for (String line : chunk.split("\n")) {
                if (valid == null) {
                    valid = line.codePoints()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.toSet());
                } else {
                    valid.retainAll(line.codePoints()
                            .mapToObj(c -> String.valueOf((char) c))
                            .collect(Collectors.toSet()));
                }
            }
            nValid += valid == null ? 0 : valid.size();
        }

        System.out.println(nValid);
    }
}
