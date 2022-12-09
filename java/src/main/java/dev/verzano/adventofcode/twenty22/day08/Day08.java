package dev.verzano.adventofcode.twenty22.day08;

class Day08 {
    protected static TreeGrid part1(int[][] treeHeightGrid) {
        var treeGrid = TreeGrid.fromInput(treeHeightGrid);
        treeGrid.calculateVisible();
        return treeGrid;
    }

    protected static TreeGrid part2(int[][] treeHeightGrid) {
        var treeGrid = TreeGrid.fromInput(treeHeightGrid);
        treeGrid.calculateHighestScenicScore();
        return treeGrid;
    }
}
