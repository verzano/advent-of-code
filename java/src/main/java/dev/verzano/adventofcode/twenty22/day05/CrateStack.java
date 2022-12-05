package dev.verzano.adventofcode.twenty22.day05;

import java.util.LinkedList;
import java.util.stream.IntStream;

public class CrateStack {
    private final LinkedList<Character> crates = new LinkedList<>();

    public void putOnBottom(Character character) {
        crates.add(character);
    }

    public void putOnTop(Character crate) {
        crates.addFirst(crate);
    }

    public void putOnTop(LinkedList<Character> cratesToAdd) {
        crates.addAll(0, cratesToAdd);
    }

    public Character takeFromTop() {
        return crates.removeFirst();
    }

    public LinkedList<Character> takeFromTop(int n) {
        var removedCrates = new LinkedList<Character>();
        IntStream.range(0, n).forEach(i -> removedCrates.add(crates.removeFirst()));
        return removedCrates;
    }

    public Character peekTopCrate() {
        return crates.peekFirst();
    }
}
