package dev.verzano.adventofcode.twenty20.day7;

import java.util.*;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;

public class Day7Part1 {
    record Bag(String color, Collection<Bag> heldBy) {
        public void addHolder(Bag bag) {
            heldBy.add(bag);
        }
    }

    public static void main(String[] args) {

        var lines = getResourceAsStringList("twenty20/day7/input.txt");

        var bagForest = new HashMap<String, Bag>();
        lines.forEach(l -> {
            // obviously better with some actual regular expressions, but this will work for now
            var parts = l.split("bags contain");
            var color = parts[0].trim();
            var holder = bagForest.getOrDefault(color, new Bag(color, new ArrayList<>()));
            bagForest.put(color, holder);

            if (!parts[1].trim().equals("no other bags.")) {
                Arrays.stream(parts[1].split(","))
                        .map(b -> b.split("bag")[0])
                        .map(b -> b.split("\\d")[1])
                        .map(String::trim)
                        .forEach(c -> {
                            var holdee = bagForest.getOrDefault(c, new Bag(c, new ArrayList<>()));
                            holdee.addHolder(holder);
                            bagForest.put(c, holdee);
                        });
            }
        });

        var shinyGoldBag = bagForest.get("shiny gold");
        var nShinyGoldBagHolders = countHolders(shinyGoldBag, new HashSet<>(), 0);
        System.out.println("Shiny Gold bags can be held by " + nShinyGoldBagHolders + " bag colors");
    }

    private static int countHolders(Bag bag, Set<String> alreadyCounted, int acc) {
        for (Bag holder : bag.heldBy) {
            if (!alreadyCounted.contains(holder.color)) {
                alreadyCounted.add(holder.color);
                acc += countHolders(holder, alreadyCounted, 1);
            }
        }

        return acc;
    }
}
