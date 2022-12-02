package dev.verzano.adventofcode.twenty21.day02;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day02.Day02.part1;
import static dev.verzano.adventofcode.twenty21.day02.Day02.part2;
import static dev.verzano.adventofcode.twenty21.day02.Direction.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day02Test {
    private static final List<Move> testMoves = List.of(
            new Move(FORWARD, 5),
            new Move(DOWN, 5),
            new Move(FORWARD, 8),
            new Move(UP, 3),
            new Move(DOWN, 8),
            new Move(FORWARD, 2));

    @Test
    void part1TestData() {
        var position = part1(testMoves);
        System.out.println("Final horizontal position and depth: " + position.horizontalPosition() + " " + position.depth());
        System.out.println("Solution value is: " + position.horizontalPosition() * position.depth());

        assertEquals(150, position.horizontalPosition() * position.depth());
    }

    @Test
    void part1RealData() {
        var position = part1(convertToMoves(getResourceAsStringList("twenty21/day02/input.csv")));
        System.out.println("Final horizontal position and depth: " + position.horizontalPosition() + " " + position.depth());
        System.out.println("Solution value is: " + position.horizontalPosition() * position.depth());
    }

    @Test
    void part2TestData() {
        var position = part2(testMoves);
        System.out.println("Final horizontal position and depth: " + position.horizontalPosition() + " " + position.depth());
        System.out.println("Solution value is: " + position.horizontalPosition() * position.depth());

        assertEquals(900, position.horizontalPosition() * position.depth());
    }

    @Test
    void part2RealData() {
        var position = part2(convertToMoves(getResourceAsStringList("twenty21/day02/input.csv")));
        System.out.println("Final horizontal position and depth: " + position.horizontalPosition() + " " + position.depth());
        System.out.println("Solution value is: " + position.horizontalPosition() * position.depth());
    }

    private static List<Move> convertToMoves(List<String> stringMoves) {
        return stringMoves.stream()
                .map(s -> s.split(" "))
                .map(s -> new Move(Direction.forString(s[0]), Integer.parseInt(s[1])))
                .toList();
    }
}