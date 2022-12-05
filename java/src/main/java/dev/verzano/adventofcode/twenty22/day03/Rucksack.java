package dev.verzano.adventofcode.twenty22.day03;

import java.util.HashSet;
import java.util.Set;

public record Rucksack(Set<Character> allItems, Set<Character> pocket1, Set<Character> pocket2) {
    public char findDuplicateItem() {
        for (var item : pocket1) {
            if (pocket2.contains(item)) {
                return item;
            }
        }

        throw new RuntimeException("Failed to find duplicate item for " + this);
    }

    public static char findGroupBadgeItem(Rucksack rucksack1, Rucksack rucksack2, Rucksack rucksack3) {
        for (var item : rucksack1.allItems) {
            if (rucksack2.allItems.contains(item) && rucksack3.allItems.contains(item)) {
                return item;
            }
        }

        throw new RuntimeException("Failed to find duplicate item for "
                + rucksack1 + " "
                + rucksack2 + " "
                + rucksack3);
    }

    public static int calculatePriority(char item) {
        return item > 96 ? item - 96 : item - 38;
    }

    static Rucksack fromItemString(String items) {
        var allItems = toPocket(items);

        var midIndex = items.length() / 2;
        var pocket1 = toPocket(items.substring(0, midIndex));
        var pocket2 = toPocket(items.substring(midIndex));

        return new Rucksack(allItems, pocket1, pocket2);
    }

    private static Set<Character> toPocket(String items) {
        var pocket = new HashSet<Character>();
        for (var item : items.toCharArray()) {
            pocket.add(item);
        }
        return pocket;
    }
}
