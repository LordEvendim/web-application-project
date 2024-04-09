package com.uep.wap.controller;

import com.uep.wap.dto.UserDTO;
import com.uep.wap.model.User;
import com.uep.wap.service.UsersService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/questions")
public class QuestionController {

    private final UsersService usersService;

    public QuestionController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(path = "/")
    public Iterable<User> getAllStudents(){
        return usersService.getAllStudents();
    }

    @PostMapping(path = "/")
    public String addQuestion(@RequestBody UserDTO userDTO){
        usersService.addStudent(userDTO);
        return "Student added!";
    }
}
