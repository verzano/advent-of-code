package dev.verzano.adventofcode.twenty22.day06;

import org.junit.jupiter.api.Test;

import static dev.verzano.adventofcode.Helper.getResourceAsString;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day06Test {
    private static final String testData1 = "mjqjpqmgbljsphdztnvjfqwrcgsmlb";
    private static final String testData2 = "bvwbjplbgvbhsrlpgdmjqwftvncz";
    private static final String testData3 = "nppdvjthqldpwncqszvftbrmjlhg";
    private static final String testData4 = "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg";
    private static final String testData5 = "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw";

    @Test
    void part1TestData1() {
        var markerLocation = Day06.part1(testData1);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(7, markerLocation);
    }

    @Test
    void part1TestData2() {
        var markerLocation = Day06.part1(testData2);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(5, markerLocation);
    }

    @Test
    void part1TestData3() {
        var markerLocation = Day06.part1(testData3);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(6, markerLocation);
    }

    @Test
    void part1TestData4() {
        var markerLocation = Day06.part1(testData4);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(10, markerLocation);
    }

    @Test
    void part1TestData5() {
        var markerLocation = Day06.part1(testData5);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(11, markerLocation);
    }

    @Test
    void part1RealData() {
        var markerLocation = Day06.part1(getResourceAsString("twenty22/day06/input.csv"));
        System.out.println("First marker after character " + markerLocation);
    }

    @Test
    void part2TestData1() {
        var markerLocation = Day06.part2(testData1);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(19, markerLocation);
    }

    @Test
    void part2TestData2() {
        var markerLocation = Day06.part2(testData2);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(23, markerLocation);
    }

    @Test
    void part2TestData3() {
        var markerLocation = Day06.part2(testData3);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(23, markerLocation);
    }

    @Test
    void part2TestData4() {
        var markerLocation = Day06.part2(testData4);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(29, markerLocation);
    }

    @Test
    void part2TestData5() {
        var markerLocation = Day06.part2(testData5);
        System.out.println("First marker after character " + markerLocation);
        assertEquals(26, markerLocation);
    }

    @Test
    void part2RealData() {
        var markerLocation = Day06.part2(getResourceAsString("twenty22/day06/input.csv"));
        System.out.println("First marker after character " + markerLocation);
    }
}
