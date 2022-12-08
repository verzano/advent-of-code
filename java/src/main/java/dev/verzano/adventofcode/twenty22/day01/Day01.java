package dev.verzano.adventofcode.twenty22.day01;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

class Day01 {
    protected static Elf part1(List<String> calorieStrings) {
        var elves = convertToElves(calorieStrings);
        elves.sort(Comparator.comparingInt(Elf::totalCarried).reversed());

        return elves.get(0);
    }

    protected static List<Elf> part2(List<String> calorieStrings) {
        var elves = convertToElves(calorieStrings);
        elves.sort(Comparator.comparingInt(Elf::totalCarried).reversed());

        return List.of(elves.get(0), elves.get(1), elves.get(2));
    }

    private static List<Elf> convertToElves(List<String> calorieStrings) {
        var id = 1;
        var elfCalories = new LinkedList<Integer>();
        var elves = new LinkedList<Elf>();
        for (var calorieString : calorieStrings) {
            if (calorieString.isBlank()) {
                elves.add(new Elf(id, elfCalories));
                id++;
                elfCalories = new LinkedList<>();
            } else {
                elfCalories.add(Integer.parseInt(calorieString));
            }
        }
        elves.add(new Elf(id, elfCalories));
        return elves;
    }
}
