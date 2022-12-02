package dev.verzano.adventofcode.twenty21.day11;

public class Octopi {
    private final Octopus[][] octopi;

    public Octopi(int[][] input) {
        this.octopi = new Octopus[input.length][input[0].length];
        for (var r = 0; r < input.length; r++) {
            for (var c = 0; c < input[r].length; c++) {
                addOctopus(new Octopus(input[r][c]), r, c);
            }
        }
    }

    public void addOctopus(Octopus o, int r, int c) {
        octopi[r][c] = o;

        if (r > 0) {
            var top = octopi[r - 1][c];
            if (top != null) {
                o.addAdjacentOctopus(top);
                top.addAdjacentOctopus(o);
            }

            if (c > 0) {
                var topLeft = octopi[r - 1][c - 1];
                if (topLeft != null) {
                    o.addAdjacentOctopus(topLeft);
                    topLeft.addAdjacentOctopus(o);
                }
            }

            if (c < octopi[r].length - 1) {
                var topRight = octopi[r - 1][c + 1];
                if (topRight != null) {
                    o.addAdjacentOctopus(topRight);
                    topRight.addAdjacentOctopus(o);
                }
            }
        }

        if (r < octopi.length - 1) {
            var bottom = octopi[r + 1][c];
            if (bottom != null) {
                o.addAdjacentOctopus(bottom);
                bottom.addAdjacentOctopus(o);
            }

            if (c < octopi[r].length - 1) {
                var bottomRight = octopi[r + 1][c + 1];
                if (bottomRight != null) {
                    o.addAdjacentOctopus(bottomRight);
                }
            }

            if (c > 0) {
                var bottomLeft = octopi[r + 1][c - 1];
                if (bottomLeft != null) {
                    o.addAdjacentOctopus(bottomLeft);
                    bottomLeft.addAdjacentOctopus(o);
                }
            }
        }

        if (c > 0) {
            var left = octopi[r][c - 1];
            if (left != null) {
                o.addAdjacentOctopus(left);
                left.addAdjacentOctopus(o);
            }
        }

        if (c < octopi[r].length - 1) {
            var right = octopi[r][c + 1];
            if (right != null) {
                o.addAdjacentOctopus(right);
                right.addAdjacentOctopus(o);
            }
        }
    }

    public void increaseEnergyLevelsAndResetFlashed() {
        for (var r : octopi) {
            for (var o : r) {
                o.increaseEnergyLevel();
                o.resetFlashed();
            }
        }
    }

    public void tryFlash() {
        for (var r : octopi) {
            for (var o : r) {
                o.tryFlash();
            }
        }
    }

    public int countFlashes() {
        var sum = 0;
        for (var r : octopi) {
            for (var o : r) {
                sum += o.getFlashes();
            }
        }
        return sum;
    }

    public String prettyPrint() {
        var sb = new StringBuilder();
        for (var r : octopi) {
            for (var o : r) {
                sb.append(o.getEnergyLevel());
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public boolean allFlashed() {
        for (var r : octopi) {
            for (var o : r) {
                if (o.getEnergyLevel() != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
