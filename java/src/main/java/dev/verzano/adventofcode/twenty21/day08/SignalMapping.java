package dev.verzano.adventofcode.twenty21.day08;

import java.util.List;

public record SignalMapping(Character a, Character b, Character c, Character d, Character e, Character f, Character g) {
    public Character valueOf(Signal signal) {
        var cs = signal.getPatternCharList();

        if (signal.is1()) {
            return '1';
        } else if (signal.is4()) {
            return '4';
        } else if (signal.is7()) {
            return '7';
        } else if (signal.is8()) {
            return '8';
        } else if (cs.size() == 6) {
            if (cs.contains(d)) {
                if (cs.contains(c)) {
                    return '9';
                } else {
                    return '6';
                }
            } else {
                return '0';
            }
        } else if (cs.contains(c)) {
            if (cs.contains(f)) {
                return '3';
            } else {
                return '2';
            }
        } else {
            return '5';
        }
    }

    protected static Character getA(Signal one, Signal seven) {
        for (var c : seven.pattern().toCharArray()) {
            if (one.pattern().indexOf(c) == -1) {
                return c;
            }
        }

        throw new RuntimeException("Failed to get a");
    }

    protected static Character getB(Signal three, Signal nine) {
        List<Character> threeCs = three.getPatternCharList();
        List<Character> nineCs = nine.getPatternCharList();

        nineCs.removeAll(threeCs);

        if (nineCs.size() != 1) {
            throw new RuntimeException("Failed to get b");
        }

        return nineCs.get(0);
    }

    protected static Character getC(Signal six, Signal eight) {
        List<Character> sixCs = six.getPatternCharList();
        List<Character> eightCs = eight.getPatternCharList();
        eightCs.removeAll(sixCs);

        if (eightCs.size() != 1) {
            throw new RuntimeException("Failed to get c");
        }

        return eightCs.get(0);
    }

    protected static Character getD(Signal one, Signal four, Character b) {
        List<Character> oneCs = one.getPatternCharList();
        List<Character> fourCs = four.getPatternCharList();

        fourCs.removeAll(oneCs);
        fourCs.remove(b);

        if (fourCs.size() != 1) {
            throw new RuntimeException("Failed to get d");
        }

        return fourCs.get(0);
    }

    protected static Character getE(Signal eight, Signal nine) {
        List<Character> eightCs = eight.getPatternCharList();
        List<Character> nineCs = nine.getPatternCharList();

        eightCs.removeAll(nineCs);

        if (eightCs.size() != 1) {
            throw new RuntimeException("Failed to get e");
        }

        return eightCs.get(0);
    }

    protected static Character getF(Signal one, Character c) {
        List<Character> oneCs = one.getPatternCharList();

        oneCs.remove(c);

        if (oneCs.size() != 1) {
            throw new RuntimeException("Failed to get f");
        }

        return oneCs.get(0);
    }

    protected static Character getG(Signal four, Signal nine, Character a) {
        List<Character> fourCs = four.getPatternCharList();
        List<Character> nineCs = nine.getPatternCharList();

        nineCs.remove(a);
        nineCs.removeAll(fourCs);

        if (nineCs.size() != 1) {
            throw new RuntimeException("Failed to get g");
        }

        return nineCs.get(0);
    }
}
