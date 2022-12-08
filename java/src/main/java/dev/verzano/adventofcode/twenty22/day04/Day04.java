package dev.verzano.adventofcode.twenty22.day04;

import java.util.List;

class Day04 {
    protected static long part1(List<String> assignmentsList) {
        return assignmentsList.stream()
                .map(AssignmentPair::fromString)
                .filter(AssignmentPair::fullyOverlap)
                .count();
    }

    protected static long part2(List<String> assignmentsList) {
        return assignmentsList.stream()
                .map(AssignmentPair::fromString)
                .filter(AssignmentPair::anyOverlap)
                .count();
    }
}
