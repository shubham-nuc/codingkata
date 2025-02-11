package com.luxoft.codingkata.model;

import java.util.ArrayList;
import java.util.List;

public class SubmersibleProbe {
    private int x;
    private int y;
    private char direction;
    private final List<String> visitedCoordinates = new ArrayList<>();

    public SubmersibleProbe(int x, int y, char direction) {
        this.x = x;
        this.y = y;
        this.direction = direction;
        visitedCoordinates.add("(" + x + ", " + y + ")");
    }

    public void moveForward() {
        switch (direction) {
            case 'N': y++; break;
            case 'S': y--; break;
            case 'E': x++; break;
            case 'W': x--; break;
        }
        visitedCoordinates.add("(" + x + ", " + y + ")");
    }

    public void moveBackward() {
        switch (direction) {
            case 'N': y--; break;
            case 'S': y++; break;
            case 'E': x--; break;
            case 'W': x++; break;
        }
        visitedCoordinates.add("(" + x + ", " + y + ")");
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
