package dev.verzano.adventofcode.twenty21.day12;

import java.util.HashMap;

import static dev.verzano.adventofcode.twenty21.day12.Cave.makeAdjacent;

public class Graph {
    private final HashMap<String, Cave> caves = new HashMap<>();

    public Graph() {
        caves.put("start", new Cave("start"));
        caves.put("end", new Cave("end"));
    }

    public void addConnectedCaves(String a, String b) {
        var caveA = caves.getOrDefault(a, new Cave(a));
        caves.put(a, caveA);

        var caveB = caves.getOrDefault(b, new Cave(b));
        caves.put(b, caveB);

        makeAdjacent(caveA, caveB);
    }

    public Paths findPaths(boolean doubleVisit) {
        var start = caves.get("start");
        return Paths.findPaths(start, doubleVisit);
    }
}
