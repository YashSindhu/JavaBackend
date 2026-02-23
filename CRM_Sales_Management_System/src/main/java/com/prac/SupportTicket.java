package com.prac;

import javax.persistence.*;

@Entity
public class SupportTicket {

    @Id
    private long ticketId;

    private String issueDescription;

    @OneToOne
    private Order order;

    // Getters & Setters
    public long getTicketId() { return ticketId; }
    public void setTicketId(long ticketId) { this.ticketId = ticketId; }

    public String getIssueDescription() { return issueDescription; }
    public void setIssueDescription(String issueDescription) { this.issueDescription = issueDescription; }

    public Order getOrder() { return order; }
    public void setOrder(Order order) { this.order = order; }
}