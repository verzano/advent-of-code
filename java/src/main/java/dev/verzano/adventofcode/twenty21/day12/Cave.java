package dev.verzano.adventofcode.twenty21.day12;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Cave {
    private final Set<Cave> adjacentCaves = new HashSet<>();
    private final boolean big;
    private final String name;

    public Cave(String name) {
        this.big = Character.isUpperCase(name.charAt(0));
        this.name = name;
    }

    public Set<Cave> getAdjacentCaves() {
        return adjacentCaves;
    }

    public boolean isBig() {
        return big;
    }

    public String getName() {
        return name;
    }

    public boolean isStart() {
        return name.equals("start");
    }

    public boolean isEnd() {
        return name.equals("end");
    }

    public void addAdjacentCave(Cave cave) {
        adjacentCaves.add(cave);
    }

    protected static void makeAdjacent(Cave a, Cave b) {
        a.addAdjacentCave(b);
        b.addAdjacentCave(a);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Cave cave = (Cave) o;
        return name.equals(cave.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
