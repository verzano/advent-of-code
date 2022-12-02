package dev.verzano.adventofcode.twenty20.day2;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;

public class Day2Part1 {
    public static void main(String[] args) {
        record PasswordThing(int min, int max, char c, String password) {
            public boolean isValid() {
                var cCount = password.chars().filter(ch -> ch == c).count();
                return cCount >= min && cCount <= max;
            }
        }

        var nValid = getResourceAsStringList("twenty20/day2/input.txt")
                .stream()
                .map(s -> s.split(" "))
                .map(parts -> {
                    var minMax = parts[0].split("-");
                    return new PasswordThing(
                            Integer.parseInt(minMax[0]),
                            Integer.parseInt(minMax[1]),
                            parts[1].charAt(0),
                            parts[2]);
                })
                .filter(PasswordThing::isValid)
                .count();

        System.out.println("Number of valid passwords: " + nValid);
    }
}
