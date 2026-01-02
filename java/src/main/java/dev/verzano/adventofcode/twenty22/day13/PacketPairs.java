package dev.verzano.adventofcode.twenty22.day13;

import java.util.LinkedList;
import java.util.List;

record PacketPairs(List<PacketPair> pairs) {
    long inOrderValue() {
        var value = 0L;
        for (var i = 0; i < pairs.size(); i++) {
            var pair = pairs.get(i);
            if (PacketPair.compare(pair.left(), pair.right())) {
                var pairId = i + 1;
                System.out.println("Pair:   " + pairId);
                System.out.println("Left:   " + pair.left());
                System.out.println("Right:  " + pair.right());

                value += pairId;
            }
        }
        return value;
    }

    static PacketPairs fromStrings(List<String> signalStrings) {
        var pairs = new LinkedList<PacketPair>();
        for (var i = 0; i < signalStrings.size(); i += 3) {
            pairs.add(PacketPair.fromStrings(signalStrings.get(i), signalStrings.get(i + 1)));
        }
        return new PacketPairs(pairs);
    }
}
