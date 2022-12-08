package dev.verzano.adventofcode.twenty21.day08;

import java.util.List;

class Day08 {
    protected static int part1(List<SignalLine> signals) {
        var _1s4s7sAnd8s = 0;
        for (var outputs : signals.stream().map(SignalLine::outputs).toList()) {
            _1s4s7sAnd8s += outputs.stream().filter(Signal::is147or8).count();
        }
        return _1s4s7sAnd8s;
    }

    protected static Day08State part2(List<SignalLine> signals) {
        var state = new Day08State();
        for (var sl : signals) {
            var one = sl.get1();
            var four = sl.get4();
            var seven = sl.get7();
            var eight = sl.get8();

            var a = SignalMapping.getA(one, seven);

            var nine = sl.get9(four, a);

            var g = SignalMapping.getG(four, nine, a);

            var e = SignalMapping.getE(eight, nine);

            var three = sl.get3(one, a, g);

            var b = SignalMapping.getB(three, nine);
            var d = SignalMapping.getD(one, four, b);

            var six = sl.get6(nine, a, b, d, e, g);
            var c = SignalMapping.getC(six, eight);

            var f = SignalMapping.getF(one, c);

            var sm = new SignalMapping(a, b, c, d, e, f, g);
            state.addState(sl, sm);
        }
        return state;
    }
}
