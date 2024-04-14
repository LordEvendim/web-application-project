package com.uep.wap.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class ServerController {
    public ServerController() {
    }

    @GetMapping(path = "/ping")
    public String pingEndpoint() {
        return "pong";
    }
}
