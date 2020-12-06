package dev.verzano.aoc2020.day2;

import static dev.verzano.aoc2020.Helper.getResourceAsStringList;

public class Day2Part2 {
    public static void main(String[] args) {
        record PasswordThing(int i1, int i2, char c, String password) {
            public boolean isValid() {
                return password.charAt(i1 - 1) == c ^ password.charAt(i2 - 1) == c;
            }
        }

        var nValid = getResourceAsStringList("day2/input.txt")
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
