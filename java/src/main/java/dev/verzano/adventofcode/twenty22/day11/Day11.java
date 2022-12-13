package dev.verzano.adventofcode.twenty22.day11;

import java.util.List;

class Day11 {
    protected static long part1(List<String> monkeyStrings) {
        var monkeys = Monkeys.fromStrings(monkeyStrings);
        monkeys.executeRounds(20, true);
        return monkeys.getMonkeyBusinessLevel();
    }

    protected static long part2(List<String> monkeyStrings) {
        var monkeys = Monkeys.fromStrings(monkeyStrings);
        monkeys.executeRounds(10_000, false);
        return monkeys.getMonkeyBusinessLevel();
    }
}
