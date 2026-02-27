package com.prac;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy
public class CreditCardPayment implements PaymentService {

    public CreditCardPayment() {
        System.out.println("CreditCardPayment Bean Created");
    }

    public void processPayment(double amount) {
        System.out.println("Processing Credit Card Payment: " + amount);
    }
}