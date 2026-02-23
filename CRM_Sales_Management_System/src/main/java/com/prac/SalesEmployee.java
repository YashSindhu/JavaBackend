package com.prac;

import javax.persistence.*;
import java.util.List;

@Entity
public class SalesEmployee {

    @Id
    private long empId;

    private String name;
    private String department;

    @OneToMany(mappedBy = "employee")
    private List<Lead> leads;

    // Getters & Setters
    public long getEmpId() { return empId; }
    public void setEmpId(long empId) { this.empId = empId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getDepartment() { return department; }
    public void setDepartment(String department) { this.department = department; }

    public List<Lead> getLeads() { return leads; }
    public void setLeads(List<Lead> leads) { this.leads = leads; }
}