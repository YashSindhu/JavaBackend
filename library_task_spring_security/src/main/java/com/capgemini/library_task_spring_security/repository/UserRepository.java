package com.capgemini.library_task_spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.library_task_spring_security.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
}