package dev.verzano.adventofcode.twenty15.day06;

class LightMatrix {
    private final boolean[][] lightBools;  // will all default to false so all "off"
    private final int[][] lightInts;  // will all default to 0
    private int litCount = 0;
    private long totalBrightness = 0;

    public LightMatrix(int nRows, int nCols) {
        lightBools = new boolean[nRows][nCols];
        lightInts = new int[nRows][nCols];
    }

    public int getLitCount() {
        return litCount;
    }

    public long getTotalBrightness() {
        return totalBrightness;
    }

    public void performInstruction(Instruction instruction) {
        for (var x = instruction.start().x(); x <= instruction.end().x(); x++) {
            for (var y = instruction.start().y(); y <= instruction.end().y(); y++) {
                var oldVal = lightBools[y][x];
                switch (instruction.operation()) {
                    case TURN_ON -> {
                        lightBools[y][x] = true;
                        if (!oldVal) {
                            litCount++;
                        }

                        lightInts[y][x]++;
                        totalBrightness++;
                    }
                    case TURN_OFF -> {
                        lightBools[y][x] = false;
                        if (oldVal) {
                            litCount--;
                        }


                        if (lightInts[y][x] > 0) {
                            lightInts[y][x]--;
                            totalBrightness--;
                        }
                    }
                    case TOGGLE -> {
                        lightBools[y][x] = !lightBools[y][x];
                        if (oldVal) {
                            litCount--;
                        } else {
                            litCount++;
                        }

                        lightInts[y][x] += 2;
                        totalBrightness += 2;
                    }
                }
            }
        }
    }
}
