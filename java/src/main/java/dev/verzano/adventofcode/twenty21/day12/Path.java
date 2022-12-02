package dev.verzano.adventofcode.twenty21.day12;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class Path {
    private final List<Cave> caves = new LinkedList<>();
    private boolean visitedSmallCaveTwice = false;

    public Path(Cave start) {
        caves.add(start);
    }

    public Path(List<Cave> caves, boolean visitedSmallCaveTwice) {
        this.caves.addAll(caves);
        this.visitedSmallCaveTwice = visitedSmallCaveTwice;
    }

    public Cave tail() {
        return caves.get(caves.size() - 1);
    }

    public boolean incomplete() {
        return !tail().isEnd();
    }

    public void addCave(Cave c) {
        if (!c.isBig() && caves.contains(c)) {
            visitedSmallCaveTwice = true;
        }
        caves.add(c);
    }

    public boolean hasVisitedSmallCaveTwice() {
        return visitedSmallCaveTwice;
    }

    public Set<Path> branch() {
        var paths = new HashSet<Path>();
        var tail = tail();
        for (var c : tail.getAdjacentCaves()) {
            if (c.isBig() || !caves.contains(c)) {
                var p = new Path(caves, visitedSmallCaveTwice);
                p.addCave(c);
                paths.add(p);
            }
        }
        return paths;
    }

    public Set<Path> branchDoubleVisit() {
        var paths = new HashSet<Path>();
        var tail = tail();
        for (var c : tail.getAdjacentCaves()) {
            if (!c.isStart()) {
                if (c.isBig() || !caves.contains(c) || !hasVisitedSmallCaveTwice()) {
                    var p = new Path(caves, visitedSmallCaveTwice);
                    p.addCave(c);
                    paths.add(p);
                }
            }
        }
        return paths;
    }

    @Override
    public String toString() {
        return caves.stream()
                .map(Cave::getName)
                .collect(Collectors.joining(","));
    }
}
