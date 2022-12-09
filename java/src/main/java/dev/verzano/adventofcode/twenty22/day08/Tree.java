package dev.verzano.adventofcode.twenty22.day08;

class Tree {
    private final int height;
    private Visibility visibility;
    private int scenicScore;

    public Tree(int height, Visibility visibility, int scenicScore) {
        this.height = height;
        this.visibility = visibility;
        this.scenicScore = scenicScore;
    }

    public Tree(int height) {
        this(height, Visibility.UNKNOWN, 0);
    }

    public int getHeight() {
        return height;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public int getScenicScore() {
        return scenicScore;
    }

    public void setScenicScore(int scenicScore) {
        this.scenicScore = scenicScore;
    }

    enum Visibility {
        UNKNOWN, VISIBLE, NOT_VISIBLE
    }
}
