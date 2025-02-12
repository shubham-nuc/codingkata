package com.luxoft.codingkata.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SubmersibleProbeServiceTest {

    @Test
    void testInitializeProbe() {
        SubmersibleProbeService service = new SubmersibleProbeService();
        String result = service.initializeProbe(2, 3, 'N');
        assertEquals("Probe initialized at (2, 3) facing N", result);
    }

    @Test
    void testMoveProbe() {
        SubmersibleProbeService service = new SubmersibleProbeService();
        service.initializeProbe(0, 0, 'N');
        String result = service.moveProbe("FFRFF");
        assertEquals("Probe moved to (1, 2) facing E", result);
    }

    @Test
    void testInvalidCommand() {
        SubmersibleProbeService service = new SubmersibleProbeService();
        service.initializeProbe(0, 0, 'N');
        String result = service.moveProbe("FX");
        assertEquals("Invalid command: X", result);
    }

    @Test
    void testProbeStatus() {
        SubmersibleProbeService service = new SubmersibleProbeService();
        service.initializeProbe(1, 1, 'S');
        String status = service.getProbeStatus();
        assertTrue(status.contains("Current position: (1, 1) facing S"));
    }

    @Test
    void testObstacleAvoidance() {
        SubmersibleProbeService service = new SubmersibleProbeService();
        service.initializeProbe(1, 1, 'E');
        String result = service.moveProbe("FF");
        assertEquals("Probe moved to (3, 1) facing E", result);
    }

    @Test
    void testBoundaryCondition() {
        SubmersibleProbeService service = new SubmersibleProbeService();
        service.initializeProbe(0, 0, 'S');
        String result = service.moveProbe("F");
        assertEquals("Probe moved to (0, 0) facing S", result);
    }

    @Test
    void testFullCommandSequence() {
        SubmersibleProbeService service = new SubmersibleProbeService();
        service.initializeProbe(0, 0, 'N');
        String result = service.moveProbe("FFRFFLBB");
        assertEquals("Probe moved to (1, 0) facing N", result);
    }
}