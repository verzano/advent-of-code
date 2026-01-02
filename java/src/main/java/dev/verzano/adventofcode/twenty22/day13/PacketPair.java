package dev.verzano.adventofcode.twenty22.day13;

import java.util.List;

record PacketPair(Packet.ListPacket left, Packet.ListPacket right) {
    static PacketPair fromStrings(String leftString, String rightString) {
        return new PacketPair(Packet.fromString(leftString), Packet.fromString(rightString));
    }

    /**
     * If both values are integers, the lower integer should come first. If the left integer is lower than the right integer, the inputs are in the right order. If the left integer is higher than the right integer, the inputs are not in the right order. Otherwise, the inputs are the same integer; continue checking the next part of the input.
     * If both values are lists, compare the first value of each list, then the second value, and so on. If the left list runs out of items first, the inputs are in the right order. If the right list runs out of items first, the inputs are not in the right order. If the lists are the same length and no comparison makes a decision about the order, continue checking the next part of the input.
     * If exactly one value is an integer, convert the integer to a list which contains that integer as its only value, then retry the comparison. For example, if comparing [0,0,0] and 2, convert the right value to [2] (a list containing 2); the result is then found by instead comparing [0,0,0] and [2].
     **/
    static boolean compare(Packet.ListPacket left, Packet.ListPacket right, int i) {
        if (i >= left.size() && i >= right.size()) {

        } else if (i >= left.size()) {
            return true;
        } else if (i >= right.size()) {
            return false;
        }

        var currLeft = left.get(i);
        var currRight = right.get(i);

        if (currLeft instanceof Packet.IntPacket && currRight instanceof Packet.IntPacket) {
            var intLeft = ((Packet.IntPacket) currLeft).value();
            var intRight = ((Packet.IntPacket) currRight).value();

            if (intLeft > intRight) return false;
            else if (intLeft < intRight) return true;
            else compare(left, right, i + 1);
        } else if (currLeft instanceof Packet.ListPacket && currRight instanceof Packet.ListPacket) {
            return compare((Packet.ListPacket) currLeft, (Packet.ListPacket) currRight, 0);
        } else if (currLeft instanceof Packet.IntPacket && currRight instanceof Packet.ListPacket) {
            return compare(new Packet.ListPacket(List.of(currLeft), left), (Packet.ListPacket) currRight, 0);
        } else { // currLeft instanceof Packet.ListPacket && currRight instanceof Packet.IntRight
            return compare((Packet.ListPacket) currLeft, new Packet.ListPacket(List.of(currRight), right), 0);
        }

        // TODO remove this and fix
        return false;
    }

    @Override
    public String toString() {
        return left + "\n" + right;
    }
}
