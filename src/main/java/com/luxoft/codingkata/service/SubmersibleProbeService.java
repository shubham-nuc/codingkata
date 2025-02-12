package com.luxoft.codingkata.service;

import com.luxoft.codingkata.model.OceanGrid;
import com.luxoft.codingkata.model.SubmersibleProbe;
import org.springframework.stereotype.Service;

@Service
public class SubmersibleProbeService {
    private SubmersibleProbe probe;
    private OceanGrid oceanGrid;

    public String initializeProbe(int x, int y, char direction) {
        oceanGrid = new OceanGrid(5, 5);
        oceanGrid.addObstacle(2, 2);
        probe = new SubmersibleProbe(x, y, direction,oceanGrid);
        return "Probe initialized at (" + x + ", " + y + ") facing " + direction;
    }

    public String moveProbe(String probeCommand) {
        char[] commands = probeCommand.toCharArray();
        for (char eachCommand : commands) {
            switch (eachCommand) {
                case 'F' -> probe.moveForward();
                case 'B' -> probe.moveBackward();
                case 'L' -> probe.turnLeft();
                case 'R' -> probe.turnRight();
                default -> {
                    return "Invalid command: " + eachCommand;
                }
            }

        }
        return "Probe moved to (" + probe.x() + ", " + probe.y() + ") facing " + probe.direction();
    }
    public String getProbeStatus() {
        if (probe == null) {
            return "Probe not initialized";
        }
        return "Current position: (" + probe.x() + ", " + probe.y() + ") facing " + probe.direction() + ", visited: " + probe.visitedCoordinates();
    }
}
