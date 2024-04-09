package com.uep.wap.service;

import com.uep.wap.model.User;
import com.uep.wap.repository.UserRepository;
import com.uep.wap.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    @Autowired
    private UserRepository userRepository;

    public void addStudent(UserDTO userDTO) {
        User user = new User(userDTO.getUsername(), userDTO.getEmail(), userDTO.getRole());
        userRepository.save(user);
        System.out.println("User added!");
    }

    public Iterable<User> getAllStudents() {
        return userRepository.findAll();
    }
}
