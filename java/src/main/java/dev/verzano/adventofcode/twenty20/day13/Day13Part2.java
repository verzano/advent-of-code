package dev.verzano.adventofcode.twenty20.day13;

import dev.verzano.adventofcode.Helper;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.stream.Collectors;

class Day13Part2 {
    record BusId(long id, long offset) {
    }

    public static void main(String[] args) {
        var input = Helper.getResourceAsStringList("twenty20/day13/input.txt");
        var busIds = Arrays.stream(input.get(1).split(","))
                .map(bid -> bid.equals("x") ? null : Long.valueOf(bid))
                .collect(Collectors.toList());

        var busIdsList = new LinkedList<BusId>();
        for (int i = 0; i < busIds.size(); i++) {
            var busId = busIds.get(i);
            if (busId != null) {
                busIdsList.add(new BusId(busId, i));
            }
        }

        var idx = 1;
        var step = busIdsList.get(0).id;
        var t = step;
        for (; t < Long.MAX_VALUE; t += step) {
            var success = true;
            for (var i = 0; i <= idx; i++) {
                var busId = busIdsList.get(i);
                if ((t + busId.offset) % busId.id != 0) {
                    success = false;
                    break;
                }
            }

            if (success && idx == busIdsList.size() - 1) {
                break;
            }
            if (success) {
                step *= busIdsList.get(idx).id;
                idx++;
            }
        }

        System.out.println("Earliest Timestamp: " + t);
    }
}
