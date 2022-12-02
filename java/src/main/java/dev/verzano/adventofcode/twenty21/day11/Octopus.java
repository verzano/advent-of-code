package dev.verzano.adventofcode.twenty21.day11;

import java.util.HashSet;
import java.util.Set;

public class Octopus {
    private final Set<Octopus> adjacentOs = new HashSet<>();
    private long flashes = 0;
    private boolean flashed = false;
    private int energyLevel;

    public Octopus(int energyLevel) {
        this.energyLevel = energyLevel;
    }

    public long getFlashes() {
        return flashes;
    }

    public int getEnergyLevel() {
        return energyLevel;
    }

    public void addAdjacentOctopus(Octopus o) {
        adjacentOs.add(o);
    }

    public void resetFlashed() {
        flashed = false;
    }

    public void increaseEnergyLevel() {
        energyLevel++;
    }

    public void tryFlash() {
        if (!flashed && energyLevel > 9) {
            flashes++;
            flashed = true;
            for (var o : adjacentOs) {
                o.increaseEnergyLevel();
            }

            for (var o : adjacentOs) {
                o.tryFlash();
            }
        }

        if (flashed) {
            energyLevel = 0;
        }
    }
}
