package dev.verzano.adventofcode.twenty22.day12;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

record Elevation(String id, Set<Elevation> navigableNeighbors, int height, boolean isDestination) {
    Elevation(int r, int c, int height, boolean isDestination) {
        this(r + ":" + c, new HashSet<>(), height, isDestination);
    }

    Elevation(int r, int c, int height) {
        this(r, c, height, false);
    }

    public static int navigate(Elevation start) {
        var visited = new HashSet<ElevationDepthPair>();
        var queue = new ArrayDeque<ElevationDepthPair>();
        queue.add(new ElevationDepthPair(start, 0));
        while (!queue.isEmpty()) {
            var pair = queue.remove();
            if (pair.elevation.isDestination) {
                return pair.depth;
            }
            visited.add(pair);
            pair.elevation.navigableNeighbors
                    .stream()
                    .map(e -> new ElevationDepthPair(e, pair.depth + 1))
                    .forEach(queue::add);
            queue.removeAll(visited);
        }

        System.out.println("Unable to navigate to destination from: " + start.id);
        return Integer.MAX_VALUE;
    }

    public void maybeAddNavigableNeighbor(Elevation neighbor) {
        if (neighbor.height() - height <= 1) {
            navigableNeighbors.add(neighbor);
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) return true;
        if (obj == null || obj.getClass() != this.getClass()) return false;
        var that = (Elevation) obj;
        return this.id.equals(that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Elevation[" +
                "id=" + id +
                "navigableNeighbors=" + navigableNeighbors.stream().map(e -> e.id + "=" + e.height).toList() + ", " +
                "height=" + height + ", " +
                "isDestination=" + isDestination + ']';
    }

    private record ElevationDepthPair(Elevation elevation, int depth) {
        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj == null || obj.getClass() != this.getClass()) return false;
            var that = (ElevationDepthPair) obj;
            return Objects.equals(this.elevation, that.elevation);
        }

        @Override
        public int hashCode() {
            return Objects.hash(elevation);
        }
    }
}
