package com.capgemini.library_task_spring_security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.capgemini.library_task_spring_security.entity.User;
import com.capgemini.library_task_spring_security.service.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @PostMapping
    public User addUser(@RequestBody User user) {
        return service.addUser(user);
    }
}