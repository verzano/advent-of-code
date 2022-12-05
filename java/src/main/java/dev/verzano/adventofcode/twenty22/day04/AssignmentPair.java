package dev.verzano.adventofcode.twenty22.day04;

public record AssignmentPair(Assignment assignment1, Assignment assignment2) {
    public boolean fullyOverlap() {
        return assignment1.start() <= assignment2.start() && assignment1.end() >= assignment2.end()
                || assignment2.start() <= assignment1.start() && assignment2.end() >= assignment1.end();
    }

    public boolean anyOverlap() {
        return fullyOverlap()
                || assignment1.start() <= assignment2.end() && assignment1.start() >= assignment2.start()
                || assignment1.end() >= assignment2.start() && assignment1.end() <= assignment2.end();
    }

    public static AssignmentPair fromString(String assignmentPairString) {
        var assignmentPairArray = assignmentPairString.split(",");
        return new AssignmentPair(
                Assignment.fromString(assignmentPairArray[0]),
                Assignment.fromString(assignmentPairArray[1]));
    }
}
