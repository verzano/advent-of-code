package dev.verzano.adventofcode.twenty22.day13;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

sealed interface Packet<T> {
    static ListPacket fromString(String packetString) {
        var rootList = new ListPacket(null);
        var currList = rootList;

        var intBuilder = new StringBuilder();
        for (var i = 1; i < packetString.length(); i++) {
            switch (packetString.charAt(i)) {
                case '[' -> {
                    var childList = currList.addChildList();
                    currList = childList;
                }
                case ']' -> {
                    if (!intBuilder.isEmpty()) {
                        currList.addIntPacketFromString(intBuilder.toString());
                        intBuilder = new StringBuilder();
                    }
                    currList = currList.parent;
                }
                case ',' -> {
                    if (!intBuilder.isEmpty()) {
                        currList.addIntPacketFromString(intBuilder.toString());
                        intBuilder = new StringBuilder();
                    }
                }
                default -> intBuilder.append(packetString.charAt(i));
            }
        }
        return rootList;
    }

    T value();

    record IntPacket(Integer value, ListPacket parent) implements Packet<Integer> {
        @Override
        public String toString() {
            return String.valueOf(value);
        }
    }

    record ListPacket(List<Packet<?>> value, ListPacket parent) implements Packet<List<Packet<?>>> {
        ListPacket(ListPacket parent) {
            this(new LinkedList<>(), parent);
        }

        Packet<?> get(int index) {
            return value.get(index);
        }

        int size() {
            return value.size();
        }

        ListPacket addChildList() {
            var childList = new ListPacket(this);
            value.add(childList);
            return childList;
        }

        void addIntPacketFromString(String intString) {
            value.add(new IntPacket(Integer.parseInt(intString), this));
        }

        @Override
        public String toString() {
            return "[" +
                    value.stream()
                            .map(Objects::toString)
                            .collect(Collectors.joining(",")) +
                    "]";
        }
    }
}
