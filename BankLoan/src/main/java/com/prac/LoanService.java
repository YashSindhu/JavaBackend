package com.prac;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class LoanService {

    private LoanValidator loanValidator;
    private AuditService auditService;

    // Constructor Injection (Override Primary)
    @Autowired
    public LoanService(@Qualifier("incomeValidator") LoanValidator loanValidator) {
        this.loanValidator = loanValidator;
    }

    // Setter Injection
    @Autowired
    public void setAuditService(AuditService auditService) {
        this.auditService = auditService;
    }

    public void applyLoan(double amount) {

        boolean approved = loanValidator.validateLoan(amount);

        if (approved) {
            auditService.log("Loan Approved for amount: " + amount);
            System.out.println("Loan Approved ");
        } else {
            auditService.log("Loan Rejected for amount: " + amount);
            System.out.println("Loan Rejected ");
        }
    }
}