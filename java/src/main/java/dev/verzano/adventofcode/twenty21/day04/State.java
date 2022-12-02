package dev.verzano.adventofcode.twenty21.day04;

record State(Position p, boolean x) {
    public State picked() {
        return new State(p, true);
    }
}
