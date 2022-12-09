package dev.verzano.adventofcode.twenty22.day08;

import static dev.verzano.adventofcode.twenty22.day08.Tree.Visibility.NOT_VISIBLE;
import static dev.verzano.adventofcode.twenty22.day08.Tree.Visibility.VISIBLE;

class TreeGrid {
    private final Tree[][] trees;
    private int visible = 0;
    private int highestScenicScore = 0;

    public TreeGrid(Tree[][] trees) {
        this.trees = trees;
    }

    public int getVisible() {
        return visible;
    }

    public int getHighestScenicScore() {
        return highestScenicScore;
    }

    public static TreeGrid fromInput(int[][] treeHeightGrid) {
        var trees = new Tree[treeHeightGrid.length][treeHeightGrid[0].length];
        for (int row = 0; row < treeHeightGrid.length; row++) {
            for (int col = 0; col < treeHeightGrid[row].length; col++) {
                trees[row][col] = new Tree(treeHeightGrid[row][col]);
            }
        }
        return new TreeGrid(trees);
    }

    private boolean lineOfSightBroken(Tree tree, int row, int col) {
        var otherTree = trees[row][col];
        return otherTree.getVisibility() != NOT_VISIBLE && otherTree.getHeight() >= tree.getHeight();
    }

    private boolean searchUp(Tree tree, int row, int col) {
        for (int r = row - 1; r >= 0; r--) {
            if (lineOfSightBroken(tree, r, col)) {
                return false;
            }
        }
        return true;
    }

    private boolean searchRight(Tree tree, int row, int col) {
        for (int c = col + 1; c < trees[row].length; c++) {
            if (lineOfSightBroken(tree, row, c)) {
                return false;
            }
        }
        return true;
    }

    private boolean searchDown(Tree tree, int row, int col) {
        for (int r = row + 1; r < trees.length; r++) {
            if (lineOfSightBroken(tree, r, col)) {
                return false;
            }
        }
        return true;
    }

    private boolean searchLeft(Tree tree, int row, int col) {
        for (int c = col - 1; c >= 0; c--) {
            if (lineOfSightBroken(tree, row, c)) {
                return false;
            }
        }
        return true;
    }

    public void calculateVisible() {
        for (int row = 0; row < trees.length; row++) {
            for (int col = 0; col < trees[row].length; col++) {
                var tree = trees[row][col];
                if (searchUp(tree, row, col) || searchDown(tree, row, col)
                        || searchRight(tree, row, col) || searchLeft(tree, row, col)) {
                    tree.setVisibility(VISIBLE);
                    visible++;
                } else {
                    tree.setVisibility(NOT_VISIBLE);
                }
            }
        }
    }

    private int lookUp(Tree tree, int row, int col) {
        var r = row - 1;
        for (; r >= 0; r--) {
            if (lineOfSightBroken(tree, r, col)) {
                break;
            }
        }
        return row - Math.max(r, 0);
    }

    private int lookRight(Tree tree, int row, int col) {
        var c = col + 1;
        for (; c < trees[row].length; c++) {
            if (lineOfSightBroken(tree, row, c)) {
                break;
            }
        }
        return Math.min(c, trees[row].length - 1) - col;
    }

    private int lookDown(Tree tree, int row, int col) {
        var r = row + 1;
        for (; r < trees.length; r++) {
            if (lineOfSightBroken(tree, r, col)) {
                break;
            }
        }
        return Math.min(r, trees.length - 1) - row;
    }

    private int lookLeft(Tree tree, int row, int col) {
        var c = col - 1;
        for (; c >= 0; c--) {
            if (lineOfSightBroken(tree, row, c)) {
                break;
            }
        }
        return col - Math.max(c, 0);
    }

    public void calculateHighestScenicScore() {
        for (int row = 0; row < trees.length; row++) {
            for (int col = 0; col < trees[row].length; col++) {
                var tree = trees[row][col];

                var upDistance = lookUp(tree, row, col);
                var downDistance = lookDown(tree, row, col);
                var rightDistance = lookRight(tree, row, col);
                var leftDistance = lookLeft(tree, row, col);

                var scenicScore = upDistance * rightDistance * downDistance * leftDistance;
                tree.setScenicScore(scenicScore);
                highestScenicScore = Math.max(scenicScore, highestScenicScore);
            }
        }
    }

    public void prettyPrintVisibility() {
        for (var row : trees) {
            for (var tree : row) {
                var c = switch (tree.getVisibility()) {
                    case UNKNOWN -> '?';
                    case VISIBLE -> 'O';
                    case NOT_VISIBLE -> ' ';
                };
                System.out.print(c);
            }
            System.out.println();
        }
    }

    public void prettyPrintScenicScore() {
        for (var row : trees) {
            for (var tree : row) {
                System.out.print(tree.getScenicScore() + "\t");
            }
            System.out.println();
        }
    }
}
