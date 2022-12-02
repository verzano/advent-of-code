package dev.verzano.adventofcode.twenty21.day04;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public record GameInput(List<Integer> nums, List<GameBoard> boards) {
    public static GameInput fromStringList(List<String> inputStrings) {
        var nums = Arrays.stream(inputStrings.get(0).split(","))
                .map(Integer::parseInt)
                .toList();

        List<GameBoard> boards = new LinkedList<>();
        List<List<Integer>> rows = new LinkedList<>();
        for (var line : inputStrings.subList(2, inputStrings.size())) {
            if (line.isBlank()) {
                boards.add(new GameBoard(rows));
                rows.clear();
            } else {
                rows.add(Arrays.stream(line.trim().split("\\s+"))
                        .map(Integer::parseInt)
                        .toList());
            }
        }

        return new GameInput(nums, boards);
    }
}
