package com.prac;

import java.util.Arrays;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        College college = new College();
        college.setId(1);
        college.setName("LPU");
        college.setLocation("Punjab");

        Student s1 = new Student();
        s1.setId(101);
        s1.setName("Yash");
        s1.setEmail("yash@gmail.com");

        Student s2 = new Student();
        s2.setId(102);
        s2.setName("Rohit");
        s2.setEmail("rohit@gmail.com");

        // VERY IMPORTANT
        s1.setCollege(college);
        s2.setCollege(college);

        et.begin();
        em.persist(college);
        em.persist(s1);
        em.persist(s2);
        et.commit();

        em.close();
        emf.close();
    }
}
