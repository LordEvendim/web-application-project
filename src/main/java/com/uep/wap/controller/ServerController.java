package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/")
public class ServerController {
    public ServerController() {    }

    @GetMapping(path = "/ping")
    public String pingEndpoint(){
        return "pong";
    }
}
