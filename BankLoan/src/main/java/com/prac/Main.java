package com.prac;


import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(BankAppConfig.class);

        LoanService loanService = context.getBean(LoanService.class);

        loanService.applyLoan(300000);

        context.close();
    }
}