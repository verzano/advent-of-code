package dev.verzano.adventofcode.twenty21.day04;

import java.util.Map;
import java.util.Map.Entry;

public record WinningState(Map<Integer, State> boardState, int finalNum) {
    public static final WinningState NULL = new WinningState(null, 0);

    public int finalScore() {
        return boardState.entrySet().stream()
                .filter((e) -> !e.getValue().x())
                .map(Entry::getKey)
                .reduce(0, Integer::sum) * finalNum;
    }
}
