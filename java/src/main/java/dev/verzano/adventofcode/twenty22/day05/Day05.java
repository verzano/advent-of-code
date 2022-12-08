package dev.verzano.adventofcode.twenty22.day05;

import java.util.LinkedList;
import java.util.List;

class Day05 {
    protected static String part1(List<String> input) {
        var cargoAreaStrings = new LinkedList<String>();
        while (!input.get(0).isBlank()) {
            cargoAreaStrings.add(input.remove(0));
        }
        input.remove(0);

        var cargoArea = CargoArea.fromStringList(cargoAreaStrings);
        input.forEach(line -> {
            var chunks = line.split(" ");
            cargoArea.move(
                    Integer.parseInt(chunks[1]),
                    Integer.parseInt(chunks[3]) - 1,
                    Integer.parseInt(chunks[5]) - 1);
        });

        return cargoArea.getMessage();
    }

    protected static String part2(List<String> input) {
        var cargoAreaStrings = new LinkedList<String>();
        while (!input.get(0).isBlank()) {
            cargoAreaStrings.add(input.remove(0));
        }
        input.remove(0);

        var cargoArea = CargoArea.fromStringList(cargoAreaStrings);
        input.forEach(line -> {
            var chunks = line.split(" ");
            cargoArea.moveMultiple(
                    Integer.parseInt(chunks[1]),
                    Integer.parseInt(chunks[3]) - 1,
                    Integer.parseInt(chunks[5]) - 1);
        });

        return cargoArea.getMessage();
    }
}
