package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UsersService usersService;

    public UserController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllStudents(){
        return usersService.getAllStudents();
    }

    @PostMapping(path = "/")
    public String addStudent(@RequestBody UserDTO userDTO){
        usersService.addStudent(userDTO);
        return "Student added!";
    }
}
