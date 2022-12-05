package dev.verzano.adventofcode.twenty21.day05;

import static java.lang.Integer.parseInt;
import static java.util.Arrays.stream;

public record VentLine(Vent a, Vent b) {
    protected static VentLine fromString(String s) {
        var vents = stream(s.split(" -> "))
                .map(coordsS -> {
                    var coords = coordsS.split(",");
                    return new Vent(parseInt(coords[0]), parseInt(coords[1]));
                }).toList();
        return new VentLine(vents.get(0), vents.get(1));
    }
}
