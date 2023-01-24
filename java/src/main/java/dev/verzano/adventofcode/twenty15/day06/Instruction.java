package dev.verzano.adventofcode.twenty15.day06;

import static dev.verzano.adventofcode.twenty15.day06.Operation.*;
import static java.lang.Integer.parseInt;

record Instruction(Operation operation, Coordinate start, Coordinate end) {
    private static Instruction forStrings(Operation operation, String startS, String endS) {
        var startParts = startS.split(",");
        var start = new Coordinate(parseInt(startParts[0]), parseInt(startParts[1]));

        var endParts = endS.split(",");
        var end = new Coordinate(parseInt(endParts[0]), parseInt(endParts[1]));

        return new Instruction(operation, start, end);
    }

    static Instruction toggle(String startS, String endS) {
        return forStrings(TOGGLE, startS, endS);
    }

    static Instruction turnOn(String startS, String endS) {
        return forStrings(TURN_ON, startS, endS);
    }

    static Instruction turnOff(String startS, String endS) {
        return forStrings(TURN_OFF, startS, endS);
    }
}
