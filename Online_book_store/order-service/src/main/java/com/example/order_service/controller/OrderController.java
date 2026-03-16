package com.example.order_service.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.order_service.client.BookClient;
import com.example.order_service.dto.BookDTO;
import com.example.order_service.model.Order;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.transaction.Transactional;

@RestController
@RequestMapping("/api/orders")
public class OrderController {

    private final BookClient bookClient;

    @PersistenceContext
    private EntityManager entityManager;

    public OrderController(BookClient bookClient) {
        this.bookClient = bookClient;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Order> placeOrder(@RequestBody Order order) {
        BookDTO book = bookClient.getBookById(order.getBookId());
        order.setTotalPrice(book.getPrice() * order.getQuantity());
        order.setStatus("PLACED");
        order.setOrderDate(java.time.LocalDate.now());
        entityManager.persist(order);
        return ResponseEntity.status(201).body(order);
    }

    @GetMapping
    public ResponseEntity<List<Order>> getAllOrders() {
        List<Order> orders = entityManager.createQuery("FROM Order", Order.class).getResultList();
        return ResponseEntity.ok(orders);
    }
}
