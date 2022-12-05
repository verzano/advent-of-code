package dev.verzano.adventofcode.twenty21.day06;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Day06 {
    protected static List<Integer> part1(List<Integer> fish, int nDays) {
        for (var i = 0; i < nDays; i++) {
            var _fish = new LinkedList<Integer>();
            for (var f : fish) {
                if (f == 0) {
                    _fish.add(6);
                    _fish.add(8);
                } else {
                    _fish.add(f - 1);
                }
            }
            fish = _fish;
        }

        return fish;
    }

    protected static Map<Integer, Long> part2(List<Integer> fish, int nDays) {
        var fishMap = new HashMap<Integer, Long>();
        for (Integer integer : fish) {
            fishMap.compute(integer, (k, v) -> v == null ? 1L : v + 1L);
        }

        for (var i = 0; i <= 8; i++) {
            fishMap.putIfAbsent(i, 0L);
        }

        for (var i = 0; i < nDays; i++) {
            var _fishMap = new HashMap<Integer, Long>();
            for (var f = 1; f <= 8; f++) {
                _fishMap.put(f - 1, fishMap.get(f));
            }
            _fishMap.put(6, _fishMap.get(6) + fishMap.get(0));
            _fishMap.put(8, fishMap.get(0));
            fishMap = _fishMap;
        }

        return fishMap;
    }
}
