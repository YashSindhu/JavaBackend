package com.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Create Department
        Department dept = new Department();
        dept.setId(1);
        dept.setName("IT");
        dept.setManagerName("Sharma");
        dept.setNoOfEmployee(3);

        // Create Employee 1
        Employee e1 = new Employee();
        e1.setId(101);
        e1.setName("Yash");
        e1.setSal(50000);
        e1.setDesignation("Developer");
        e1.setDepartment(dept);

        // Create Employee 2
        Employee e2 = new Employee();
        e2.setId(102);
        e2.setName("Rohit");
        e2.setSal(45000);
        e2.setDesignation("Tester");
        e2.setDepartment(dept);

        // Create Employee 3
        Employee e3 = new Employee();
        e3.setId(103);
        e3.setName("Virat");
        e3.setSal(55000);
        e3.setDesignation("Manager");
        e3.setDepartment(dept);

        // Save to DB
        et.begin();
        em.persist(dept);   // save department first
        em.persist(e1);
        em.persist(e2);
        em.persist(e3);
        et.commit();

        em.close();
        emf.close();

    }
}
