package com.prac.book_service.consumer;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prac.book_service.dto.BookOrder;
import com.prac.book_service.entity.Book;
import com.prac.book_service.repository.BookRepository;

@Component
public class OrderConsumer {

    @Autowired
    private BookRepository repository;

    @RabbitListener(queues = "orderQueue")
    public void consumeOrder(BookOrder order) {

        Book book = repository.findById(order.getBookId()).orElseThrow();

        book.setStock(book.getStock() - order.getQuantity());

        repository.save(book);
    }
}