package com.prac;

import javax.persistence.*;

@Entity
public class Lead {

    @Id
    private long id;

    private String name;
    private String source;
    private String contactInfo;

    @ManyToOne
    private SalesEmployee employee;

    // Getters & Setters
    public long getId() { return id; }
    public void setId(long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }

    public SalesEmployee getEmployee() { return employee; }
    public void setEmployee(SalesEmployee employee) { this.employee = employee; }
}