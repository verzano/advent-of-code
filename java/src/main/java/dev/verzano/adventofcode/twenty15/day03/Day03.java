package dev.verzano.adventofcode.twenty15.day03;

import java.util.HashSet;

class Day03 {
    protected static int part1(String directions) {
        var location = new Location();
        var houses = new HashSet<String>();
        houses.add(location.asStringKey());
        for (char c : directions.toCharArray()) {
            location.move(c);
            houses.add(location.asStringKey());
        }

        return houses.size();
    }

    protected static int part2(String directions) {
        var santaLocation = new Location();
        var roboSantaLocation = new Location();
        var houses = new HashSet<String>();
        houses.add(santaLocation.asStringKey());
        char[] chars = directions.toCharArray();
        for (var i = 0; i < chars.length; i++) {
            var location = i % 2 == 0 ? santaLocation : roboSantaLocation;
            location.move(chars[i]);
            houses.add(location.asStringKey());
        }

        return houses.size();
    }

    private static final class Location {
        private int x = 0;
        private int y = 0;

        public void move(char c) {
            switch (c) {
                case '^' -> y--;
                case 'v' -> y++;
                case '<' -> x--;
                case '>' -> x++;
                default -> throw new RuntimeException("Unknown direction: " + c);
            }
        }

        public String asStringKey() {
            return x + ":" + y;
        }
    }
}
