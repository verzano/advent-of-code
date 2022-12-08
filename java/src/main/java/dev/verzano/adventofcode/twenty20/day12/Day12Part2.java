package dev.verzano.adventofcode.twenty20.day12;

import dev.verzano.adventofcode.Helper;

class Day12Part2 {
    enum Action {
        N, S, E, W,
        L, R,
        F
    }

    record Instruction(Action action, int value) {
    }

    record Waypoint(int x, int y) {
        public Waypoint turn(int value) {
            return switch (modTurnValue(value)) {
                case -3, 1 -> new Waypoint(y, -x);
                case -2, 2 -> new Waypoint(-x, -y);
                case -1, 3 -> new Waypoint(-y, x);
                case 0 -> this;
                default -> throw new IllegalArgumentException();
            };
        }

        private static int modTurnValue(int value) {
            return (value % 360) / 90;
        }
    }

    record Ship(int x, int y) {
        public Ship moveToWaypoint(Waypoint waypoint, int value) {
            return new Ship(x + waypoint.x * value, y + waypoint.y * value);
        }
    }

    record State(Waypoint waypoint, Ship ship) {
    }

    public static void main(String[] args) {
        var instructions = Helper.getResourceAsStringList("twenty20/day12/input.txt")
                .stream()
                .map(l -> {
                    var action = Action.valueOf(l.substring(0, 1));
                    var value = Integer.parseInt(l.substring(1));
                    return new Instruction(action, value);
                })
                .toList();

        var state = new State(new Waypoint(10, 1), new Ship(0, 0));

        for (var instruction : instructions) {
            final var ship = state.ship;
            final var waypoint = state.waypoint;
            final var value = instruction.value;
            state = switch (instruction.action) {
                case N -> new State(new Waypoint(waypoint.x, waypoint.y + value), ship);
                case S -> new State(new Waypoint(waypoint.x, waypoint.y - value), ship);
                case E -> new State(new Waypoint(waypoint.x + value, waypoint.y), ship);
                case W -> new State(new Waypoint(waypoint.x - value, waypoint.y), ship);
                case L -> new State(waypoint.turn(-value), ship);
                case R -> new State(waypoint.turn(value), ship);
                case F -> new State(waypoint, ship.moveToWaypoint(waypoint, value));
            };
        }

        System.out.println("Manhattan distance from start: " + (Math.abs(state.ship.x) + Math.abs(state.ship.y)));
    }
}
