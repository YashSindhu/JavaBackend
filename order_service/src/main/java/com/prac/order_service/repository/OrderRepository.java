package com.prac.order_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.prac.order_service.entity.BookOrder;

public interface OrderRepository extends JpaRepository<BookOrder, Long> {

}
