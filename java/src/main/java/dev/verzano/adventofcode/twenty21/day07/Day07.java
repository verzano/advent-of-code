package dev.verzano.adventofcode.twenty21.day07;

import java.util.List;

public class Day07 {
    protected static int part1(List<Integer> crabs) {
        crabs = crabs.stream().sorted().toList();
        var fuelToUse = 0;
        for (var i = 0; i < crabs.size() / 2; i++) {
            fuelToUse += crabs.get(crabs.size() - i - 1) - crabs.get(i);
        }

        return fuelToUse;
    }

    protected static int part2(List<Integer> crabs) {
        var rightBound = Integer.MIN_VALUE;
        for (var c : crabs) {
            rightBound = Math.max(rightBound, c);
        }

        var fuel = calculateFuelPart2(crabs, 0);
        for (var i = 1; i < rightBound; i++) {
            var _fuel = calculateFuelPart2(crabs, i);

            if (_fuel > fuel) {
                return fuel;
            }
            fuel = _fuel;
        }
        return -1;
    }

    private static int calculateFuelPart2(List<Integer> crabs, int endPosition) {
        var fuel = 0;
        for (var c : crabs) {
            var d = Math.abs(c - endPosition);
            fuel += (d * (d + 1))/2;
        }

        return fuel;
    }
}
