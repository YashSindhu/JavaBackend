package com.capgemini.library_task_spring_security.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.capgemini.library_task_spring_security.entity.Book;
import com.capgemini.library_task_spring_security.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public List<Book> getBooks() {
        return service.getAllBooks();
    }

    @PostMapping
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    @DeleteMapping("/{id}")
    public void deleteBook(@PathVariable Long id) {
        service.deleteBook(id);
    }
}