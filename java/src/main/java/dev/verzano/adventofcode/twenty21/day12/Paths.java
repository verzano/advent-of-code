package dev.verzano.adventofcode.twenty21.day12;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Paths {
    private final Set<Path> paths = new HashSet<>();

    public Paths(Cave start) {
        paths.add(new Path(start));
    }

    public Set<Path> getCopy() {
        return new HashSet<>(paths);
    }

    public boolean incomplete() {
        return paths.stream().anyMatch(Path::incomplete);
    }

    public int size() {
        return paths.size();
    }

    public String prettyPrint() {
        return paths.stream()
                .map(Path::toString)
                .collect(Collectors.joining("\n"));
    }

    public static Paths findPaths(Cave start, boolean doubleVisit) {
        var paths = new Paths(start);
        while (paths.incomplete()) {
            for (var p : paths.getCopy()) {
                if (p.incomplete()) {
                    paths.paths.remove(p);
                    if (doubleVisit) {
                        paths.paths.addAll(p.branchDoubleVisit());
                    } else {
                        paths.paths.addAll(p.branch());
                    }
                }
            }
        }

        return paths;
    }
}
