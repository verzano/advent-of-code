package dev.verzano.adventofcode.twenty21.day13;

import java.util.LinkedList;
import java.util.List;

import static dev.verzano.adventofcode.twenty21.day13.Axis.fromChar;
import static java.lang.Integer.parseInt;

public class Instructions {
    private final Matrix matrix = new Matrix();
    private final List<Fold> folds = new LinkedList<>();

    public void addPointString(String xyString) {
        var xy = xyString.split(",");
        matrix.addPoint(new Point(parseInt(xy[0]), parseInt(xy[1])));
    }

    public void addFold(String foldString) {
        var fold = foldString.split(" ")[2].split("=");
        folds.add(new Fold(fromChar(fold[0].charAt(0)), parseInt(fold[1])));
    }

    public Matrix foldOnce() {
        return matrix.fold(folds.get(0));
    }

    public Matrix foldAll() {
        var m = matrix;
        for (var f : folds) {
            m = m.fold(f);
        }

        return m;
    }
}
