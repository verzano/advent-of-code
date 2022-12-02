package dev.verzano.adventofcode.twenty21.day09;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public final class LowPoints {
    private final List<Integer> lps = new LinkedList<>();

    public LowPoints() {
    }

    public List<Integer> lps() {
        return lps;
    }

    public void addLowPoint(int lp) {
        lps.add(lp);
    }

    public int riskLevel() {
        return lps.stream().mapToInt(lp -> lp + 1).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this)
            return true;
        if (obj == null || obj.getClass() != this.getClass())
            return false;
        var that = (LowPoints) obj;
        return Objects.equals(this.lps, that.lps);
    }

    @Override
    public int hashCode() {
        return Objects.hash(lps);
    }

    @Override
    public String toString() {
        return "LowPoints[" +
                "lps=" + lps + ']';
    }

    public static boolean isLowPoint(int[][] map, int r, int c) {
        var p = map[r][c];
        if (r > 0 && p >= map[r - 1][c]) {
            return false;
        }

        if (r < map.length - 1 && p >= map[r + 1][c]) {
            return false;
        }

        if (c > 0 && p >= map[r][c - 1]) {
            return false;
        }

        if (c < map[r].length - 1 && p >= map[r][c + 1]) {
            return false;
        }

        return true;
    }
}
