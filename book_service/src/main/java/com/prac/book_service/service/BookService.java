package com.prac.book_service.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.book_service.entity.Book;
import com.prac.book_service.repository.BookRepository;

@Service
public class BookService {

    @Autowired
    private BookRepository repository;

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getBooks() {
        return repository.findAll();
    }

    public Book updateBook(Long id, Book book) {

        Book existing = repository.findById(id).orElseThrow();

        existing.setTitle(book.getTitle());
        existing.setAuthor(book.getAuthor());
        existing.setPrice(book.getPrice());
        existing.setStock(book.getStock());

        return repository.save(existing);
    }
}
