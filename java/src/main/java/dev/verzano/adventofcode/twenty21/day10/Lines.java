package dev.verzano.adventofcode.twenty21.day10;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private final List<ErrorLine> errors = new LinkedList<>();
    private final List<IncompleteLine> incompletes = new LinkedList<>();

    public long errorPoints() {
        return errors.stream()
                .mapToLong(ErrorLine::points)
                .sum();
    }

    public long incompletePoints() {
        var points = incompletes.stream()
                .mapToLong(IncompleteLine::points)
                .sorted()
                .toArray();

        return points[points.length/2];
    }

    public void addLine(String line) {
        var expectedStack = new LinkedList<Character>();
        for (var c : line.toCharArray()) {
            switch (c) {
                case ')':
                    if (expectedStack.removeLast() != ')') {
                        errors.add(new ErrorLine(line, ')', c));
                        return;
                    }
                    break;
                case '(':
                    expectedStack.add(')');
                    break;
                case ']':
                    if (expectedStack.removeLast() != ']') {
                        errors.add(new ErrorLine(line, ']', c));
                        return;
                    }
                    break;
                case '[':
                    expectedStack.add(']');
                    break;
                case '}':
                    if (expectedStack.removeLast() != '}') {
                        errors.add(new ErrorLine(line, '}', c));
                        return;
                    }
                    break;
                case '{':
                    expectedStack.add('}');
                    break;
                case '>':
                    if (expectedStack.removeLast() != '>') {
                        errors.add(new ErrorLine(line, '>', c));
                        return;
                    }
                    break;
                case '<':
                    expectedStack.add('>');
                    break;
            }
        }

        Collections.reverse(expectedStack);
        incompletes.add(new IncompleteLine(line, expectedStack));
    }

    public String printErrors() {
        var sb = new StringBuilder();
        for (var e : errors) {
            sb.append(e.line())
                    .append(" - Expected '")
                    .append(e.expected())
                    .append("', but found '")
                    .append("' instead.\n");
        }
        return sb.toString();
    }

    public String printIncompletes() {
        var sb = new StringBuilder();
        for (var i : incompletes) {
            sb.append(i.line())
                    .append(" - Complete by adding '")
                    .append(i.requiredSuffix().stream().map(String::valueOf).collect(Collectors.joining()))
                    .append("'.\n");
        }
        return sb.toString();
    }
}
