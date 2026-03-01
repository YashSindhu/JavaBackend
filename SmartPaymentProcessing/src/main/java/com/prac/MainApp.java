package com.prac;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        PaymentProcessor processor = context.getBean(PaymentProcessor.class);
        processor.pay(5000);

//        context.close();
    }
}