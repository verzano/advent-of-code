package dev.verzano.adventofcode.twenty22.day13;

record PacketPair(Packet<?> left, Packet<?> right) {
    static PacketPair fromStrings(String leftString, String rightString) {
        return new PacketPair(Packet.fromString(leftString), Packet.fromString(rightString));
    }

    public boolean compare() {
        
    }
}
