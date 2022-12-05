package dev.verzano.adventofcode.twenty22.day04;

public record Assignment(int start, int end) {
    public static Assignment fromString(String assignmentString) {
        var assignmentArray = assignmentString.split("-");
        return new Assignment(
                Integer.parseInt(assignmentArray[0]),
                Integer.parseInt(assignmentArray[1]));
    }
}
