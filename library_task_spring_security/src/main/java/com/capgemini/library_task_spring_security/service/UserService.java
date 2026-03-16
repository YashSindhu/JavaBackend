package com.capgemini.library_task_spring_security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.library_task_spring_security.entity.User;
import com.capgemini.library_task_spring_security.repository.UserRepository;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public List<User> getAllUsers() {
        return repo.findAll();
    }

    public User addUser(User user) {
        return repo.save(user);
    }
}