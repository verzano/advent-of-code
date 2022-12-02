package dev.verzano.adventofcode.twenty21.day13;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

public class Matrix {
    public final Set<Point> points = new HashSet<>();

    public Matrix() {

    }

    public Matrix(Set<Point> points) {
        this.points.addAll(points);
    }

    public void addPoint(Point p) {
        points.add(p);
    }

    public Matrix fold(Fold f) {
        return new Matrix(points.stream().map(p -> p.fold(f)).collect(Collectors.toSet()));
    }

    public int visiblePoints() {
        return points.size();
    }

    public String prettyPrint() {
        var maxX = points.stream().max(comparingInt(Point::x)).orElseThrow().x();
        var maxY = points.stream().max(comparingInt(Point::y)).orElseThrow().y();
        var bMat = new boolean[maxY + 1][maxX + 1];

        points.forEach(p -> bMat[p.y()][p.x()] = true);

        var sb = new StringBuilder();
        for (var r : bMat) {
            for (var c : r) {
                sb.append(c ? "X" : " ");
            }
            sb.append('\n');
        }
        return sb.toString();
    }
}
