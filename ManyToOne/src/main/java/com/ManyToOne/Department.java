package com.ManyToOne;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "number_sequence")
    @SequenceGenerator(name = "number_squence",sequenceName = "number_sequence", initialValue = 100,allocationSize = 1)
    private int id;

    private String name;
    private String managerName;
    private int noOfEmployee;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManagerName() {
        return managerName;
    }

    public void setManagerName(String managerName) {
        this.managerName = managerName;
    }

    public int getNoOfEmployee() {
        return noOfEmployee;
    }

    public void setNoOfEmployee(int noOfEmployee) {
        this.noOfEmployee = noOfEmployee;
    }
}
