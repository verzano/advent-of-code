package dev.verzano.adventofcode.twenty15.day05;

import java.util.List;

class Day05 {
    protected static int part1(List<String> strings) {
        var niceCount = 0;
        for (var s : strings) {
            if (doesNotContainForbiddenSequences(s) && containsAtLeast3Vowels(s) && hasDoubleCharacter(s)) {
                niceCount++;
            }
        }

        return niceCount;
    }

    protected static int part2(List<String> strings) {
        var niceCount = 0;
        for (var s : strings) {
            if (containsDuplicatePair(s) && containsSandwichedLetter(s)) {
                niceCount++;
            }
        }

        return niceCount;
    }

    private static boolean doesNotContainForbiddenSequences(String s) {
        for (var i = 0; i < s.length() - 1; i++) {
            switch (s.substring(i, i + 2)) {
                case "ab", "cd", "pq", "xy" -> {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean containsAtLeast3Vowels(String s) {
        var vowelCount = 0;
        for (var c : s.toCharArray()) {
            switch (c) {
                case 'a', 'e', 'i', 'o', 'u' -> vowelCount++;
            }
        }
        return vowelCount >= 3;
    }

    private static boolean hasDoubleCharacter(String s) {
        for (var i = 0; i < s.length() - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsSandwichedLetter(String s) {
        for (var i = 0; i < s.length() - 2; i++) {
            if (s.charAt(i) == s.charAt(i + 2)) {
                return true;
            }
        }
        return false;
    }

    private static boolean containsDuplicatePair(String s) {
        for (var i = 0; i < s.length() - 2; i++) {
            var pair = s.substring(i, i + 2);
            if (s.substring(i + 2).contains(pair)) {
                return true;
            }
        }
        return false;
    }
}
