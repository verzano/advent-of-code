package dev.verzano.adventofcode.twenty21.day05;

import org.junit.jupiter.api.Test;

import java.util.List;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;
import static dev.verzano.adventofcode.twenty21.day05.Day05.part1;
import static dev.verzano.adventofcode.twenty21.day05.Day05.part2;
import static org.junit.jupiter.api.Assertions.assertEquals;

class Day05Test {
    private static final List<VentLine> testData = List.of(
            new VentLine(new Vent(0, 9), new Vent(5, 9)),
            new VentLine(new Vent(8, 0), new Vent(0, 8)),
            new VentLine(new Vent(9, 4), new Vent(3, 4)),
            new VentLine(new Vent(2, 2), new Vent(2, 1)),
            new VentLine(new Vent(7, 0), new Vent(7, 4)),
            new VentLine(new Vent(6, 4), new Vent(2, 0)),
            new VentLine(new Vent(0, 9), new Vent(2, 9)),
            new VentLine(new Vent(3, 4), new Vent(1, 4)),
            new VentLine(new Vent(0, 0), new Vent(8, 8)),
            new VentLine(new Vent(5, 5), new Vent(8, 2)));

    @Test
    void part1TestData() {
        var sf = part1(testData);
        System.out.println(sf);
        assertEquals(5, sf.countOverlaps());
    }

    @Test
    void part1RealData() {
        var sf = part1(fromStringList(getResourceAsStringList("twenty21/day05/input.csv")));
//        System.out.println(sf);
        System.out.println("Number of overlaps: " + sf.countOverlaps());
    }

    @Test
    void part2TestData() {
        var sf = part2(testData);
        System.out.println(sf);
        assertEquals(12, sf.countOverlaps());
    }

    @Test
    void part2RealData() {
        var sf = part2(fromStringList(getResourceAsStringList("twenty21/day05/input.csv")));
//        System.out.println(sf);
        System.out.println("Number of overlaps: " + sf.countOverlaps());
    }

    private static List<VentLine> fromStringList(List<String> vlStrings) {
        return vlStrings.stream()
                .map(VentLine::fromString)
                .toList();
    }
}