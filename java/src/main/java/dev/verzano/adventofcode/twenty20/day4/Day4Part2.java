package dev.verzano.adventofcode.twenty20.day4;

import static dev.verzano.adventofcode.Helper.getResourceAsStringList;

public class Day4Part2 {
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
                return validByr()
                        && validIyr()
                        && validEyr()
                        && validHgt()
                        && validHcl()
                        && validEcl()
                        && validPid();
            }

            /*
             *
             * byr (Birth Year) - four digits; at least 1920 and at most 2002.
             * iyr (Issue Year) - four digits; at least 2010 and at most 2020.
             * eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
             * hgt (Height) - a number followed by either cm or in:
             *     If cm, the number must be at least 150 and at most 193.
             *     If in, the number must be at least 59 and at most 76.
             * hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
             * ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
             * pid (Passport ID) - a nine-digit number, including leading zeroes.
             * cid (Country ID) - ignored, missing or not.
             */

            public boolean validByr() {
                return byr != null && byr.matches("^(19[2-9][0-9]|200[0-2])$");
            }

            public boolean validIyr() {
                return iyr != null && iyr.matches("^(201[0-9]|2020)$");
            }

            public boolean validEyr() {
                return eyr != null && eyr.matches("^(202[0-9]|2030)$");
            }

            public boolean validHgt() {
                return hgt != null && hgt.matches("^((1[5-8][0-9]|19[0-3])cm|(59|6[0-9]|7[0-6])in)$");
            }

            public boolean validHcl() {
                return hcl != null && hcl.matches("^#[a-f0-9]{6}$");
            }

            public boolean validEcl() {
                return ecl != null && ecl.matches("^(amb|blu|brn|gry|grn|hzl|oth)$");
            }

            public boolean validPid() {
                return pid != null && pid.matches("^[0-9]{9}$");
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
