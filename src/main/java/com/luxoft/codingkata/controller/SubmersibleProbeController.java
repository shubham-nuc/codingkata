package com.luxoft.codingkata.controller;

import com.luxoft.codingkata.service.SubmersibleProbeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/probe")
public class SubmersibleProbeController {

    @Autowired
    private SubmersibleProbeService probeService;

    @PostMapping("/init")
    public String initializeProbe(@RequestParam int x, @RequestParam int y, @RequestParam char direction) {
        return probeService.initializeProbe(x, y, direction);
    }

    @PostMapping("/move")
    public String moveProbe(@RequestParam String command) {
        return probeService.moveProbe(command);
    }

    @GetMapping("/status")
    public String getProbeStatus() {
        return probeService.getProbeStatus();
    }
}
