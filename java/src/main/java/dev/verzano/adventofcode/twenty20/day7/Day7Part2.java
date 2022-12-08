package dev.verzano.adventofcode.twenty20.day7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;

class Day7Part2 {
    record Bag(String color, Collection<HoldeePair> holdees) {
        public void addHoldeePair(HoldeePair holdeePair) {
            holdees.add(holdeePair);
        }
    }

    record HoldeePair(int count, Bag bag) {
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
                        .map(b -> b.split("bag")[0].trim())
                        .forEach(b -> {
                            var n = Integer.parseInt(b.substring(0, b.indexOf(" ")));
                            var c = b.substring(b.indexOf(" ") + 1);
                            var holdee = bagForest.getOrDefault(c, new Bag(c, new ArrayList<>()));
                            holder.addHoldeePair(new HoldeePair(n, holdee));
                            bagForest.put(c, holdee);
                        });
            }
        });

        var shinyGoldBag = bagForest.get("shiny gold");
        var containedBags = countHoldees(shinyGoldBag, 1) - 1;
        System.out.println("Shiny Gold bags must contain " + containedBags + " bags");
    }

    private static long countHoldees(Bag bag, int count) {
        var acc = count;
        for (HoldeePair holdee : bag.holdees) {
            acc += countHoldees(holdee.bag, count * holdee.count);
        }

        return acc;
    }
}
