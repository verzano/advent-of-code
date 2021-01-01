package dev.verzano.aoc2020.day12;

import dev.verzano.aoc2020.Helper;

import java.util.stream.Collectors;

public class Day12Part1 {
    enum Action {
        N, S, E, W,
        L, R,
        F
    }

    enum Direction {
        N {
            @Override
            public Direction turn(int value) {
                return switch (Direction.modTurnValue(value)) {
                    case -3, 1 -> E;
                    case -2, 2 -> S;
                    case -1, 3 -> W;
                    case 0 -> N;
                    default -> throw new IllegalArgumentException();
                };
            }
        },
        S {
            @Override
            public Direction turn(int value) {
                return switch (Direction.modTurnValue(value)) {
                    case -3, 1 -> W;
                    case -2, 2 -> N;
                    case -1, 3 -> E;
                    case 0 -> S;
                    default -> throw new IllegalArgumentException();
                };
            }
        },
        E {
            @Override
            public Direction turn(int value) {
                return switch (Direction.modTurnValue(value)) {
                    case -3, 1 -> S;
                    case -2, 2 -> W;
                    case -1, 3 -> N;
                    case 0 -> E;
                    default -> throw new IllegalArgumentException();
                };
            }
        },
        W {
            @Override
            public Direction turn(int value) {
                return switch (Direction.modTurnValue(value)) {
                    case -3, 1 -> N;
                    case -2, 2 -> E;
                    case -1, 3 -> S;
                    case 0 -> W;
                    default -> throw new IllegalArgumentException();
                };
            }
        };

        public abstract Direction turn(int value);

        private static int modTurnValue(int value) {
            return (value % 360)/90;
        }
    }

    record Instruction(Action action, int value) {}

    record State(Direction direction, int x, int y) {}

    public static void main(String[] args) {
        var instructions = Helper.getResourceAsStringList("day12/input.txt")
                .stream()
                .map(l -> {
                    var action = Action.valueOf(l.substring(0, 1));
                    var value = Integer.parseInt(l.substring(1));
                    return new Instruction(action, value);
                })
                .collect(Collectors.toList());

        var state = new State(Direction.E, 0, 0);

        for (var instruction : instructions) {
            state = switch (instruction.action) {
                case N -> new State(state.direction, state.x, state.y + instruction.value);
                case S -> new State(state.direction, state.x, state.y - instruction.value);
                case E -> new State(state.direction, state.x + instruction.value, state.y);
                case W -> new State(state.direction, state.x - instruction.value, state.y);
                case L -> new State(state.direction.turn(-instruction.value), state.x, state.y);
                case R -> new State(state.direction.turn(instruction.value), state.x, state.y);
                case F -> moveForward(state, instruction.value);
            };
        }

        System.out.println("Manhattan distance from start: " + (Math.abs(state.x) + Math.abs(state.y)));
    }

    private static State moveForward(State state, int value) {
        return switch (state.direction) {
            case N -> new State(state.direction, state.x, state.y + value);
            case S -> new State(state.direction, state.x, state.y - value);
            case E -> new State(state.direction, state.x + value, state.y);
            case W -> new State(state.direction, state.x - value, state.y);
        };
    }
}
