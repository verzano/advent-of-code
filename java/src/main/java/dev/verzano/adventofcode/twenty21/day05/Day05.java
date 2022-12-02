package dev.verzano.adventofcode.twenty21.day05;

import java.util.List;

public class Day05 {
    public static SeaFloor part1(List<VentLine> vls) {
        final var sf = new SeaFloor();
        vls.forEach(sf::addHorizontalVentLine);
        return sf;
    }

    public static SeaFloor part2(List<VentLine> vls) {
        final var sf = new SeaFloor();
        vls.forEach(vl -> {
            sf.addHorizontalVentLine(vl);
            sf.addDiagonalVentLine(vl);
        });
        return sf;
    }
}
