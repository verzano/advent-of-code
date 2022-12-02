package dev.verzano.adventofcode.twenty21.day13;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day13.Day13.part1;
import static dev.verzano.adventofcode.twenty21.day13.Day13.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day13Test {
    @Test
    void part1TestData() {
        var matrix = part1(convertToInstructions(getResourceAsStringList("twenty21/day13/test.txt")));
        System.out.println("Visible points: " + matrix.visiblePoints());
        assertEquals(17, matrix.visiblePoints());
    }

    @Test
    void part1RealData() {
        var matrix = part1(convertToInstructions(getResourceAsStringList("twenty21/day13/real.txt")));
        System.out.println("Visible points: " + matrix.visiblePoints());
    }

    @Test
    void part2TestData() {
        var matrix = part2(convertToInstructions(getResourceAsStringList("twenty21/day13/test.txt")));
        System.out.println(matrix.prettyPrint());
    }

    @Test
    void part2RealData() {
        var matrix = part2(convertToInstructions(getResourceAsStringList("twenty21/day13/real.txt")));
        System.out.println(matrix.prettyPrint());
    }

    private static Instructions convertToInstructions(List<String> lines) {
        var instructions = new Instructions();

        for (var line : lines) {
            if (!line.isBlank()) {
                if (line.startsWith("fold along")) {
                    instructions.addFold(line);
                } else {
                    instructions.addPointString(line);
                }
            }
        }

        return instructions;
    }
}