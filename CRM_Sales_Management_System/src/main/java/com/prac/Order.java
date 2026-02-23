package com.prac;

import javax.persistence.*;
import java.util.List;

@Entity
public class Order {

    @Id
    private long orderId;

    private String orderDate;
    private double totalAmount;

    @ManyToOne
    private Customer customer;

    @ManyToMany
    private List<Product> products;

    @OneToOne(mappedBy = "order")
    private SupportTicket ticket;

    // Getters & Setters
    public long getOrderId() { return orderId; }
    public void setOrderId(long orderId) { this.orderId = orderId; }

    public String getOrderDate() { return orderDate; }
    public void setOrderDate(String orderDate) { this.orderDate = orderDate; }

    public double getTotalAmount() { return totalAmount; }
    public void setTotalAmount(double totalAmount) { this.totalAmount = totalAmount; }

    public Customer getCustomer() { return customer; }
    public void setCustomer(Customer customer) { this.customer = customer; }

    public List<Product> getProducts() { return products; }
    public void setProducts(List<Product> products) { this.products = products; }

    public SupportTicket getTicket() { return ticket; }
    public void setTicket(SupportTicket ticket) { this.ticket = ticket; }
}