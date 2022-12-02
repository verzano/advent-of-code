package dev.verzano.adventofcode.twenty20.day4;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;

public class Day4Part1 {
    public static void main(String[] args) {
        record Passport(
                String byr,
                String iyr,
                String eyr,
                String hgt,
                String hcl,
                String ecl,
                String pid,
                String cid) {
            public boolean isValid() {
                return byr != null
                        && iyr != null
                        && eyr != null
                        && hgt != null
                        && hcl != null
                        && ecl != null
                        && pid != null;
            }
        }

        var lines = getResourceAsStringList("twenty20/day4/input.txt");
        var nValid = 0;
        String byr = null,
                iyr = null,
                eyr = null,
                hgt = null,
                hcl = null,
                ecl = null,
                pid = null,
                cid = null;

        for (var line : lines) {
            if (line.isBlank()) {
                nValid += new Passport(byr, iyr, eyr, hgt, hcl, ecl, pid, cid).isValid() ? 1 : 0;
                byr = iyr = eyr = hgt = hcl = ecl = pid = cid = null;
            } else {
                for (String item : line.split(" ")) {
                    var kv = item.split(":");
                    switch (kv[0]) {
                        case "byr" -> byr = kv[1];
                        case "iyr" -> iyr = kv[1];
                        case "eyr" -> eyr = kv[1];
                        case "hgt" -> hgt = kv[1];
                        case "hcl" -> hcl = kv[1];
                        case "ecl" -> ecl = kv[1];
                        case "pid" -> pid = kv[1];
                        case "cid" -> cid = kv[1];
                    }
                }
            }
        }

        System.out.println("Number of valid passports: " + nValid);
    }
}
