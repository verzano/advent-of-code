package dev.verzano.adventofcode.twenty22.day13;

import java.util.List;

class Day13 {
    protected static long part1(List<String> packetStrings) {
        return PacketPairs.fromStrings(packetStrings).inOrderValue();
    }

    protected static long part2(List<String> packetStrings) {
        return 0L;
    }
}
