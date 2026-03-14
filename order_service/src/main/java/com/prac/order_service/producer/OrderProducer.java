package com.prac.order_service.producer;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.prac.order_service.entity.BookOrder;

@Component
public class OrderProducer {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void sendOrder(BookOrder order) {

        rabbitTemplate.convertAndSend("orderQueue", order);

    }
}
