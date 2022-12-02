package dev.verzano.adventofcode.twenty21.day11;

public class Day11 {
    public static Octopi part1(int[][] input, int steps) {
        var octopi = new Octopi(input);

        System.out.println("Before any steps:\n" + octopi.prettyPrint());
        for (var i = 0; i < steps; i++) {
            octopi.increaseEnergyLevelsAndResetFlashed();
            octopi.tryFlash();
            System.out.println("After step " + (i + 1) + ":\n" + octopi.prettyPrint());
        }

        return octopi;
    }

    public static int part2(int[][] input) {
        var octopi = new Octopi(input);

        var step = 0;
        while (!octopi.allFlashed()) {
            octopi.increaseEnergyLevelsAndResetFlashed();
            octopi.tryFlash();
            step++;
        }

        return step;
    }
}
