package dev.verzano.adventofcode.twenty22.day11;

import java.util.LinkedList;
import java.util.List;

record Monkeys(List<Monkey> monkeys, long leastCommonMultiple) {
    public void executeRounds(int nRounds, boolean reduceWorry) {
        for (var i = 0; i < nRounds; i++) {
            for (var monkey : monkeys) {
                while (monkey.hasItems()) {
                    var result = monkey.inspectFirst(reduceWorry, leastCommonMultiple);
                    monkeys.get(result.destinationMonkey())
                            .throwItem(result.itemWorryLevel());
                }
            }
        }
    }

    public long getMonkeyBusinessLevel() {
        var inspectedItemCounts = monkeys.stream()
                .mapToLong(Monkey::numInspectedItems)
                .sorted()
                .toArray();
        return inspectedItemCounts[inspectedItemCounts.length - 1]
                * inspectedItemCounts[inspectedItemCounts.length - 2];
    }

    /*
    Monkey 0:
      Starting items: 79, 98
      Operation: new = old * 19
      Test: divisible by 23
        If true: throw to monkey 2
        If false: throw to monkey 3

    Monkey 1:
      Starting items: 54, 65, 75, 74
      Operation: new = old + 6
      Test: divisible by 19
        If true: throw to monkey 2
        If false: throw to monkey 0

     */
    public static Monkeys fromStrings(List<String> monkeyStrings) {
        var monkeys = new LinkedList<Monkey>();
        var leastCommonMultiple = 1L;
        for (var i = 0; i < monkeyStrings.size(); i += 7) {
            var monkey = Monkey.fromStrings(
                    monkeyStrings.get(i + 1).trim(),
                    monkeyStrings.get(i + 2).trim(),
                    monkeyStrings.get(i + 3).trim(),
                    monkeyStrings.get(i + 4).trim(),
                    monkeyStrings.get(i + 5).trim());
            monkeys.add(monkey);
            leastCommonMultiple *= monkey.test().divisor();
        }
        return new Monkeys(monkeys, leastCommonMultiple);
    }
}
