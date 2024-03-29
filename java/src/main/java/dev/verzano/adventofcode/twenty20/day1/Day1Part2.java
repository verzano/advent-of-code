package dev.verzano.adventofcode.twenty20.day1;

import static dev.verzano.adventofcode.Helper.getResourceAsIntegerList;

class Day1Part2 {
    public static void main(String[] args) {
        var lines = getResourceAsIntegerList("twenty20/day1/input.txt");

        for (var i = 0; i < lines.size() - 1; i++) {
            for (var j = i + 1; j < lines.size(); j++) {
                for (var k = j + 1; k < lines.size(); k++) {
                    var l = lines.get(i);
                    var m = lines.get(j);
                    var r = lines.get(k);
                    if (l + m + r == 2020) {
                        System.out.println("Found it! l = " + l + " and m = " + m + " and r = " + r + " and l * r = " + (l * r * m));
                        return;
                    }
                }
            }
        }
    }
}
