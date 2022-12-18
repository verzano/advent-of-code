package dev.verzano.adventofcode.twenty22.day13;

import java.util.LinkedList;
import java.util.List;

record PacketPairs(List<PacketPair> pairs) {
    static PacketPairs fromStrings(List<String> signalStrings) {
        var pairs = new LinkedList<PacketPair>();
        for (var i = 0; i < signalStrings.size(); i += 3) {
            pairs.add(PacketPair.fromStrings(signalStrings.get(i), signalStrings.get(i + 1)));
        }
        return new PacketPairs(pairs);
    }
}
