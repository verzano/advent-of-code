package dev.verzano.adventofcode.twenty21.day04;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day04.Day04.part1;
import static dev.verzano.adventofcode.twenty21.day04.Day04.part2;
import static dev.verzano.adventofcode.twenty21.day04.GameInput.fromStringList;
import static java.util.List.of;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {
    private static final GameInput testData = new GameInput(
            of(7, 4, 9, 5, 11, 17, 23, 2, 0, 14, 21, 24, 10, 16, 13, 6, 15, 25, 12, 22, 18, 20, 8, 19, 3, 26, 1),
            of(new GameBoard(of(
                            of(22, 13, 17, 11, 0),
                            of(8, 2, 23, 4, 24),
                            of(21, 9, 14, 16, 7),
                            of(6, 10, 3, 18, 5),
                            of(1, 12, 20, 15, 19)
                    )),
                    new GameBoard(of(
                            of(3, 15, 0, 2, 22),
                            of(9, 18, 13, 17, 5),
                            of(19, 8, 7, 25, 23),
                            of(20, 11, 10, 24, 4),
                            of(14, 21, 16, 12, 6)
                    )),
                    new GameBoard(of(
                            of(14, 21, 17, 24, 4),
                            of(10, 16, 15, 9, 19),
                            of(18, 8, 23, 26, 20),
                            of(22, 11, 13, 6, 5),
                            of(2, 0, 12, 3, 7)
                    ))));

//    @Test
//    void part01TestData() {
//        var winningState = part1(testData);
//        System.out.println("Winning state: " + winningState);
//        var finalScore = winningState.finalScore();
//        System.out.println("Final score: " + finalScore);
//        assertEquals(4512, finalScore);
//    }

    @Test
    void part01RealData() {
        var winningState = part1(fromStringList(getResourceAsStringList("twenty21/day04/input.csv")));
        System.out.println("Winning state: " + winningState);
        System.out.println("Final score: " + winningState.finalScore());
    }

    @Test
    void part02TestData() {
        var winningState = part2(testData);
        System.out.println("Winning state: " + winningState);
        var finalScore = winningState.finalScore();
        System.out.println("Final score: " + finalScore);
        assertEquals(1924, finalScore);
    }

    @Test
    void part02RealData() {
        var winningState = part2(fromStringList(getResourceAsStringList("twenty21/day04/input.csv")));
        System.out.println("Winning state: " + winningState);
        System.out.println("Final score: " + winningState.finalScore());
    }
}