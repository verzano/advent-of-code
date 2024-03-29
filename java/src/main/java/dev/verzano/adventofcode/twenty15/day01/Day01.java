package dev.verzano.adventofcode.twenty15.day01;

class Day01 {
    protected static int part1(String directions) {
        int floor = 0;
        for (var c : directions.toCharArray()) {
            switch (c) {
                case '(' -> floor++;
                case ')' -> floor--;
                default -> throw new RuntimeException("Unknown character in directions: " + c);
            }
        }
        return floor;
    }

    protected static int part2(String directions) {
        int floor = 0;
        char[] chars = directions.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var c = chars[i];
            switch (c) {
                case '(' -> floor++;
                case ')' -> floor--;
                default -> throw new RuntimeException("Unknown character in directions: " + c);
            }

            if (floor == -1) {
                return i + 1;
            }
        }
        throw new RuntimeException("Never entered the basement (floor -1)");
    }
}
