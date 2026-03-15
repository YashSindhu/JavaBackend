package com.prac.order_service.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prac.order_service.entity.BookOrder;
import com.prac.order_service.producer.OrderProducer;
import com.prac.order_service.repository.OrderRepository;

@Service
public class OrderService {

    @Autowired
    private OrderRepository repository;

    @Autowired
    private OrderProducer producer;

    public BookOrder createOrder(BookOrder order) {

        order.setStatus("CREATED");

        BookOrder saved = repository.save(order);

        producer.sendOrder(saved);

        return saved;
    }
}
