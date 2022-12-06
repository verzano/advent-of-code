package dev.verzano.adventofcode.twenty15.day04;

import java.math.BigInteger;
import java.security.MessageDigest;

public class Day04 {
    protected static int part1(String prefix) {
        return findSuffix(prefix, "00000");
    }

    protected static int part2(String prefix) {
        return findSuffix(prefix, "000000");
    }

    private static int findSuffix(String prefix, String expectedHashPrefix) {
        try {
            var md = MessageDigest.getInstance("MD5");
            var hash = "";
            var suffix = 0;
            do {
                suffix++;
                var bytes = md.digest((prefix + suffix).getBytes());
                var bi = new BigInteger(1, bytes);
                hash = String.format("%0" + (bytes.length << 1) + "X", bi);
            } while (!hash.startsWith(expectedHashPrefix));

            return suffix;
        } catch (Exception e) {
            throw new RuntimeException("Failed to get MessageDigest", e);
        }
    }
}
