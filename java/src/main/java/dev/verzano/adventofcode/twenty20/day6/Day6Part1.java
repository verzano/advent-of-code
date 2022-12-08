package dev.verzano.adventofcode.twenty20.day6;

import dev.verzano.adventofcode.Helper;

import java.util.Arrays;
import java.util.stream.Collectors;

class Day6Part1 {
    public static void main(String[] args) {
        var unique = Arrays.stream(Helper.getResourceAsString("twenty20/day6/input.txt")
                        .replace("\n\n", "\t")
                        .replace("\n", "")
                        .split("\t"))
                .map(l -> l.chars()
                        .distinct()
                        .mapToObj(i -> String.valueOf((char) i))
                        .collect(Collectors.joining()))
                .collect(Collectors.joining())
                .length();

        System.out.println("Number of unique: " + unique);
    }
}
