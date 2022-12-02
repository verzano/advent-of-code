package dev.verzano.adventofcode.twenty22.day01;

import java.util.List;

public record Elf(
        int id,
        List<Integer> carriedCalories,
        int totalCarried
) {
    public Elf(int id, List<Integer> carriedCalories) {
        this(id, carriedCalories, carriedCalories.stream().mapToInt(c -> c).sum());
    }
}
