package dev.verzano.adventofcode.twenty22.day13;

import java.util.LinkedList;
import java.util.List;

sealed interface Packet<T> {
    static ListPacket fromString(String packetString) {
        var rootPacket = new ListPacket(new LinkedList<>(), null);
        var currPacket = rootPacket;

        var intBuilder = new StringBuilder();
        // starting 1 in and ending one away to not deal with enclosing brackets
        for (var i = 1; i < packetString.length() - 1; i++) {
            switch (packetString.charAt(i)) {
                case '[' -> currPacket = new ListPacket(new LinkedList<>(), currPacket);
                case ']' -> currPacket = currPacket.parent;
                case ',' -> {
                    currPacket.addIntPacketFromString(intBuilder.toString());
                    intBuilder = new StringBuilder();
                }
                default -> intBuilder.append(packetString.charAt(i));
            }
        }
        return rootPacket;
    }

    T getValue();

    ListPacket getParent();

    final class IntPacket implements Packet<Integer> {
        final int value;
        final ListPacket parent;

        public IntPacket(int value, ListPacket parent) {
            this.value = value;
            this.parent = parent;
        }

        @Override
        public Integer getValue() {
            return value;
        }

        @Override
        public ListPacket getParent() {
            return parent;
        }
    }

    final class ListPacket implements Packet<List<Packet<?>>> {
        final List<Packet<?>> value;
        final ListPacket parent;

        public ListPacket(List<Packet<?>> value, ListPacket parent) {
            this.value = value;
            this.parent = parent;
        }

        public void addIntPacketFromString(String intString) {
            value.add(new IntPacket(Integer.parseInt(intString), this));
        }

        @Override
        public List<Packet<?>> getValue() {
            return value;
        }

        @Override
        public ListPacket getParent() {
            return parent;
        }
    }
}
