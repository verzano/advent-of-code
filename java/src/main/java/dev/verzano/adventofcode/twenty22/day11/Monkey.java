package dev.verzano.adventofcode.twenty22.day11;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicLong;

record Monkey(LinkedList<Long> itemWorryLevels, Operation operation, Test test, AtomicLong inspectedItemCount) {
    public long numInspectedItems() {
        return inspectedItemCount.get();
    }

    public boolean hasItems() {
        return itemWorryLevels.size() != 0;
    }

    public ItemInspectionResult inspectFirst(boolean reduceWorry, long leastCommonMultiple) {
        inspectedItemCount.incrementAndGet();

        var itemWorryLevel = itemWorryLevels.removeFirst();
        var newItemWorryLevel = operation.apply(itemWorryLevel, reduceWorry, leastCommonMultiple);
        return new ItemInspectionResult(newItemWorryLevel, test.getMonkeyToThrowTo(newItemWorryLevel));
    }

    public void throwItem(long itemWorryLevel) {
        itemWorryLevels.addLast(itemWorryLevel);
    }

    /*
      Starting itemWorryLevels: 79, 98
      Operation: new = old * 19
      Test: divisible by 23
        If true: throw to monkey 2
        If false: throw to monkey 3
     */
    public static Monkey fromStrings(
            String itemWorryLevelsS,
            String operationS,
            String divisorS,
            String trueMonkeyS,
            String falseMonkeyS) {
        var itemWorryLevelParts = itemWorryLevelsS
                .split(": ")[1]
                .split(", ");
        var itemWorryLevels = new LinkedList<>(Arrays.stream(itemWorryLevelParts).map(Long::parseLong).toList());
        var operation = Operation.fromString(operationS);
        var test = Test.fromStrings(divisorS, trueMonkeyS, falseMonkeyS);
        return new Monkey(itemWorryLevels, operation, test, new AtomicLong(0));
    }
}
