package com.capgemini.library_task_spring_security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.capgemini.library_task_spring_security.entity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
}