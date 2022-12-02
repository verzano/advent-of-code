package dev.verzano.adventofcode.twenty21.day04;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class GameBoard {
    private final Map<Integer, State> state = new HashMap<>();
    private final Map<Integer, Integer> rowCounts = new HashMap<>();
    private final Map<Integer, Integer> colCounts = new HashMap<>();
    private final List<List<Integer>> board;
    private final int winningCount;
    private boolean won = false;

    public GameBoard(List<List<Integer>> board) {
        this.board = board;
        this.winningCount = board.size();
        for (var r = 0; r < board.size(); r++) {
            for (var c = 0; c < board.get(r).size(); c++) {
                var num = board.get(r).get(c);
                this.state.put(num, new State(new Position(r, c), false));
            }
        }
    }

    public WinningState addNumAndCheckWinner(int num) {
        var state = this.state.get(num);
        if (state != null) {
            var position = state.p();
            this.state.put(num, state.picked());

            var rowCount = rowCounts.getOrDefault(position.r(), 0) + 1;
            rowCounts.put(position.r(), rowCount);

            var colCount = colCounts.getOrDefault(position.c(), 0) + 1;
            colCounts.put(position.c(), colCount);

            if (Objects.equals(rowCount, winningCount) || Objects.equals(colCount, winningCount)) {
                return new WinningState(this.state, num);
            }
        }

        return WinningState.NULL;
    }

    public boolean hasNotWon() {
        return !won;
    }

    public void setWon(boolean won) {
        this.won = won;
    }

    @Override
    public String toString() {
        var sb = new StringBuilder();
        for (var row : board) {
            for (var i : row) {
                sb.append(String.format("%2d:", i))
                        .append(state.get(i).x() ? 'X' : 'O')
                        .append(' ');
            }
            sb.append('\n');
        }

        return sb.toString();
    }
}
