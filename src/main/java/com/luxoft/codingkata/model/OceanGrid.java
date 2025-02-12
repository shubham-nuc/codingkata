package com.luxoft.codingkata.model;

public class OceanGrid {
    private final int width;
    private final int length;
    private final boolean[][] obstacles;


    public OceanGrid(int width, int length) {
        this.width = width;
        this.length = length;
        this.obstacles = new boolean[width][length];;
    }

    public void addObstacle(int x, int y) {
        if (isValidPosition(x, y)) {
            obstacles[x][y] = true;
        }
    }

    public boolean isObstacle(int x, int y) {
        return isValidPosition(x, y) && obstacles[x][y];
    }

    public boolean isValidPosition(int x, int y) {
        return x >= 0 && x < width && y >= 0 && y < length;
    }


}
