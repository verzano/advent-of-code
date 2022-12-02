package dev.verzano.adventofcode.twenty21.day09;

import java.util.LinkedList;
import java.util.List;

public class Basin {
    private final List<Point> points = new LinkedList<>();

    public void addPoint(int r, int c) {
        points.add(new Point(r, c));
    }

    public boolean notContainsPoint(int r, int c) {
        return !points.contains(new Point(r, c));
    }

    public int basinSize() {
        return points.size();
    }

    @Override
    public String toString() {
        return "Basin{" +
                "points=" + points +
                '}';
    }

    private record Point(int r, int c) {}
}
