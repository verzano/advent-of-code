package dev.verzano.adventofcode.twenty21.day05;

import java.util.List;

class Day05 {
    protected static SeaFloor part1(List<VentLine> vls) {
        final var sf = new SeaFloor();
        vls.forEach(sf::addHorizontalVentLine);
        return sf;
    }

    protected static SeaFloor part2(List<VentLine> vls) {
        final var sf = new SeaFloor();
        vls.forEach(vl -> {
            sf.addHorizontalVentLine(vl);
            sf.addDiagonalVentLine(vl);
        });
        return sf;
    }
}
