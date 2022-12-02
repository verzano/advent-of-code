package dev.verzano.adventofcode.twenty21.day08;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public record SignalLine(List<Signal> inputs, List<Signal> outputs) {
    public Signal get1() {
        return inputs.stream().filter(Signal::is1).findFirst().orElseThrow();
    }

    public Signal get3(Signal one, Character a, Character g) {
        return inputs.stream()
                .filter(s -> s.pattern().length() == 5)
                .filter(s -> s.getPatternCharList().containsAll(one.getPatternCharList()))
                .filter(s -> s.getPatternCharList().contains(a))
                .filter(s -> s.getPatternCharList().contains(g))
                .findFirst()
                .orElseThrow();
    }

    public Signal get4() {
        return inputs.stream().filter(Signal::is4).findFirst().orElseThrow();
    }

    public Signal get6(Signal nine, Character a, Character b, Character d, Character e, Character g) {
        return inputs.stream()
                .filter(s -> s.pattern().length() == 6)
                .filter(s -> !s.equals(nine))
                .filter(s -> s.pattern().indexOf(a) != -1)
                .filter(s -> s.pattern().indexOf(b) != -1)
                .filter(s -> s.pattern().indexOf(d) != -1)
                .filter(s -> s.pattern().indexOf(e) != -1)
                .filter(s -> s.pattern().indexOf(g) != -1)
                .findFirst()
                .orElseThrow();
    }

    public Signal get7() {
        return inputs.stream().filter(Signal::is7).findFirst().orElseThrow();
    }

    public Signal get8() {
        return inputs.stream().filter(Signal::is8).findFirst().orElseThrow();
    }

    public Signal get9(Signal four, Character a) {
        return inputs.stream()
                .filter(s -> s.pattern().length() == 6)
                .filter(s -> s.getPatternCharList().contains(a))
                .filter(s -> containsAll(s, four))
                .findFirst()
                .orElseThrow();
    }

    public String prettyPrint(SignalMapping map) {
        var pp = inputs.stream().map(Signal::pattern).collect(Collectors.joining(" "));
        pp += ": ";
        pp += convertOutputs(map);
        return pp;
    }

    public Integer convertOutputs(SignalMapping map) {
        var sb = new StringBuilder();
        for (var s : outputs) {
            sb.append(map.valueOf(s));
        }
        return Integer.parseInt(sb.toString());
    }

    public static boolean containsAll(Signal a, Signal b) {
        for (Character c : b.getPatternChars()) {
            if (a.pattern().indexOf(c) == -1) {
                return false;
            }
        }

        return true;
    }

    public static SignalLine fromString(String signalsString) {
        var parts = signalsString.split(" \\| ");
        return new SignalLine(Arrays.stream(parts[0].split(" ")).map(Signal::new).toList(),
                Arrays.stream(parts[1].split(" ")).map(Signal::new).toList());
    }
}
