package com.capgemini.library_task_spring_security.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.capgemini.library_task_spring_security.entity.Book;
import com.capgemini.library_task_spring_security.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository repo;

    public BookService(BookRepository repo) {
        this.repo = repo;
    }

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book addBook(Book book) {
        return repo.save(book);
    }

    public void deleteBook(Long id) {
        repo.deleteById(id);
    }
}