package com.luxoft.codingkata.model;

import java.util.ArrayList;
import java.util.List;

public class SubmersibleProbe {
    private int x;
    private int y;
    private char direction;
    private final List<String> visitedCoordinates = new ArrayList<>();
    private OceanGrid oceanGrid;

    public SubmersibleProbe(int x, int y, char direction,OceanGrid oceanGrid) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        this.oceanGrid = oceanGrid;
        visitedCoordinates.add("(" + x + ", " + y + ")");

    }

    public void moveForward() {
        int newX = x;
        int newY = y;
        switch (direction) {
            case 'N': newY++; break;
            case 'S': newY--; break;
            case 'E': newX++; break;
            case 'W': newX--; break;
        }
        if (oceanGrid.isValidPosition(newX, newY) && !oceanGrid.isObstacle(newX, newY)) {
            x = newX;
            y = newY;
            visitedCoordinates.add("(" + x + ", " + y + ")");
        }
    }

    public void moveBackward() {
        int newX = x;
        int newY = y;
        switch (direction) {
            case 'N': newY--; break;
            case 'S': newY++; break;
            case 'E': newX--; break;
            case 'W': newX++; break;
        }
        if (oceanGrid.isValidPosition(newX, newY) && !oceanGrid.isObstacle(newX, newY)) {
            x = newX;
            y = newY;
            visitedCoordinates.add("(" + x + ", " + y + ")");
        }
    }

    public void turnLeft() {
        direction = switch (direction) {
            case 'N' -> 'W';
            case 'W' -> 'S';
            case 'S' -> 'E';
            case 'E' -> 'N';
            default -> direction;
        };
    }

    public void turnRight() {
        direction = switch (direction) {
            case 'N' -> 'E';
            case 'E' -> 'S';
            case 'S' -> 'W';
            case 'W' -> 'N';
            default -> direction;
        };
    }

    public int x() {
        return x;
    }

    public int y() {
        return y;
    }

    public char direction() {
        return direction;
    }

    public List<String> visitedCoordinates() {
        return visitedCoordinates;
    }
}
