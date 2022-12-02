package dev.verzano.adventofcode.twenty21.day08;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public record Signal(String pattern) {
    public char[] getPatternChars() {
        return pattern.toCharArray();
    }

    public List<Character> getPatternCharList() {
        var cs = new LinkedList<Character>();
        for (char c : getPatternChars()) {
            cs.add(c);
        }
        return cs;
    }

    public boolean is1() {
        return pattern.length() == 2;
    }

    public boolean is4() {
        return pattern.length() == 4;
    }

    public boolean is7() {
        return pattern.length() == 3;
    }

    public boolean is8() {
        return pattern.length() == 7;
    }

    public boolean is147or8() {
        return is1() || is4() || is7() || is8();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Signal signal = (Signal) o;
        return Objects.equals(pattern, signal.pattern);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pattern);
    }
}
