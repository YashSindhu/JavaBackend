package com.prac;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {

    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Student s = em.find(Student.class, 1);
        System.out.println(s);
        
//        Subject s1 = new Subject();
////        s1.setId(1);
//        s1.setName("Java");
//        s1.setNoOfDays(30);
//
//        Subject s2 = new Subject();
////        s2.setId(2);
//        s2.setName("SQL");
//        s2.setNoOfDays(20);
//        
//        Subject s3 = new Subject();
////        s3.setId(3);
//        s3.setName("Web Technology");
//        s3.setNoOfDays(20);
//
//        Student student = new Student();
//        student.setName("Yash");
//        student.setGender("Male");
//        student.setBranch("CSE");
//        
//        Student student1 = new Student();
//        student1.setName("Mona");
//        student1.setGender("Female");
//        student1.setBranch("Medical");
//
//        List<Subject> list = new ArrayList<>();
//        list.add(s1);
//        list.add(s2);
//        list.add(s3);
//
//        student.setSubjects(list);
//        student1.setSubjects(list);
//
//        et.begin();
//        em.persist(s1);
//        em.persist(s2);
//        em.persist(s3);
//        em.persist(student);
//        em.persist(student1);
//        et.commit();
//        
//
//        em.close();
//        emf.close();
    }
}
