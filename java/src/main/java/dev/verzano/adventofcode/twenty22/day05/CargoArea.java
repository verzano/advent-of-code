package dev.verzano.adventofcode.twenty22.day05;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public record CargoArea(List<CrateStack> crateStacks) {
    public void move(int n, int from, int to) {
        IntStream.range(0, n).forEach(i -> crateStacks.get(to).putOnTop(crateStacks.get(from).takeFromTop()));
    }

    public void moveMultiple(int n, int from, int to) {
        crateStacks.get(to).putOnTop(crateStacks.get(from).takeFromTop(n));
    }

    public String getMessage() {
        var builder = new StringBuilder();
        crateStacks.forEach(cs -> builder.append(cs.peekTopCrate()));
        return builder.toString();
    }

    public static CargoArea fromStringList(List<String> cargoAreaStrings) {
        List<CrateStack> crateStacks = new LinkedList<>();
        var lastLine = cargoAreaStrings.remove(cargoAreaStrings.size() - 1);
        IntStream.range(0, (lastLine.length() + 2)/4)
                .forEach(i -> crateStacks.add(new CrateStack()));

        for (var s : cargoAreaStrings) {
            for (var i = 1; i < s.length(); i += 4) {
                char crate = s.charAt(i);
                if (crate != ' ') {
                    crateStacks.get((i - 1)/4).putOnBottom(crate);
                }
            }
        }

        return new CargoArea(crateStacks);
    }
}
