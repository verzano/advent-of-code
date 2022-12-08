package dev.verzano.adventofcode.twenty21.day04;

import java.util.LinkedList;

class Day04 {
    protected static WinningState part1(GameInput input) {
        for (var num : input.nums()) {
            for (var board : input.boards()) {
                var winningState = board.addNumAndCheckWinner(num);
                if (winningState != WinningState.NULL) {
                    return winningState;
                }
            }
        }

        return WinningState.NULL;
    }

    protected static WinningState part2(GameInput input) {
        var finalWinningState = WinningState.NULL;
        var boards = new LinkedList<>(input.boards());
        for (var num : input.nums()) {
            for (var board : boards.stream().filter(GameBoard::hasNotWon).toList()) {
                var winningState = board.addNumAndCheckWinner(num);
                if (winningState != WinningState.NULL) {
                    board.setWon(true);
                    finalWinningState = winningState;
                }

                if (input.boards().size() == 0) {
                    return finalWinningState;
                }
            }
        }
        return finalWinningState;
    }
}
