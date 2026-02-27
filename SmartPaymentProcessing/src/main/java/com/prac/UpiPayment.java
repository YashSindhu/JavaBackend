package com.prac;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
@Scope("prototype")
public class UpiPayment implements PaymentService {

    public UpiPayment() {
        System.out.println("UpiPayment Bean Created");
    }

    //@Override
    public void processPayment(double amount) {
        System.out.println("Processing UPI Payment: " + amount);
    }
}