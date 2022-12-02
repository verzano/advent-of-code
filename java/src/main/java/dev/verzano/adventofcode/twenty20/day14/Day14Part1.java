package dev.verzano.adventofcode.twenty20.day14;

import dev.verzano.adventofcode.Helper;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Day14Part1 {
    record Bitmask(long value, boolean doOr) {
        public long apply(long input) {
            if (doOr) {
                return input | value;
            } else {
                return input & value;
            }
        }
    }

    public static void main(String[] args) {
        var program = Helper.getResourceAsStringList("twenty20/day14/input.txt");

        var mem = new HashMap<Long, Long>();
        var masks = new LinkedList<Bitmask>();

        for (var line : program) {
            var parts = line.split(" = ");
            if (parts[0].equals("mask")) {
                masks.clear();
                var cs = parts[1].toCharArray();
                for (var i = 0; i < cs.length; i++) {
                    var c = cs[i];
                    if (c == '1') {
                        masks.add(new Bitmask((long) Math.pow(2, 35 - i), true));
                    } else if (c == '0') {
                        masks.add(new Bitmask(Long.MAX_VALUE ^ (long) Math.pow(2, 35 - i), false));
                    }
                }
            } else {
                var pattern = Pattern.compile("mem\\[(\\d*)]");
                var m = pattern.matcher(parts[0]);
                if (m.find()) {
                    var address = Long.parseLong(m.group(1));
                    var value = Long.parseLong(parts[1]);
                    for (var mask : masks) {
                        value = mask.apply(value);
                    }
                    mem.put(address, value);
                }
            }
        }

        var sum = mem.values()
                .stream()
                .mapToLong(l -> l)
                .sum();

        System.out.println("Total sum: " + sum);
    }
}
