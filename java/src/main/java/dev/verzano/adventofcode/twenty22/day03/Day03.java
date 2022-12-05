package dev.verzano.adventofcode.twenty22.day03;

import java.util.List;

public class Day03 {
    public static int part1(List<String> rucksackList) {
        return rucksackList.stream()
                .map(Rucksack::fromItemString)
                .map(Rucksack::findDuplicateItem)
                .mapToInt(Rucksack::calculatePriority)
                .sum();
    }

    public static int part2(List<String> rucksackList) {
        var rucksacks = rucksackList.stream()
                .map(Rucksack::fromItemString)
                .toList();
        var prioritySum = 0;
        for (var i = 0; i < rucksacks.size() - 2; i += 3) {
            var groupBadgeItem = Rucksack.findGroupBadgeItem(
                    rucksacks.get(i),
                    rucksacks.get(i + 1),
                    rucksacks.get(i + 2));
            prioritySum += Rucksack.calculatePriority(groupBadgeItem);
        }
        return prioritySum;
    }
}
