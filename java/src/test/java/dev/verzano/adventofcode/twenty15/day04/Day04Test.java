package dev.verzano.adventofcode.twenty15.day04;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class Day04Test {
    private static Object[][] part1TestDataSource() {
        return new Object[][]{
                {"abcdef", 609043},
                {"pqrstuv", 1048970}
        };
    }

    @ParameterizedTest
    @MethodSource("part1TestDataSource")
    void part1TestData(String prefix, int expectedSuffix) {
        var suffix = Day04.part1(prefix);
        System.out.println("Suffix for prefix '" + prefix + "' is: " + suffix);
        assertEquals(expectedSuffix, suffix);
    }

    @Test
    void part1RealData() {
        String prefix = "ckczppom";
        var suffix = Day04.part1(prefix);
        System.out.println("Suffix for prefix '" + prefix + "' is: " + suffix);
    }

    @Test
    void part2RealData() {
        String prefix = "ckczppom";
        var suffix = Day04.part2(prefix);
        System.out.println("Suffix for prefix '" + prefix + "' is: " + suffix);
    }
}
