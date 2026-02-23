package com.prac;

import java.util.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        
        Student student1 = new Student();
        student1.setName("Miller");
        student1.setBranch("CSE");
        student1.setGender("Male");
        
        Student student2 = new Student();
        student2.setName("Rohit");
        student2.setBranch("ECE");
        student2.setGender("Male");
        
        Subject sub1 = new Subject();
        sub1.setName("Micro-Processor");
        sub1.setNoOfDays(30);
        
        Subject sub2 = new Subject();
        sub2.setName("ML");
        sub2.setNoOfDays(40);
        
        Subject sub3 = new Subject();
        sub3.setName("Software Engineering");
        sub3.setNoOfDays(25);

//        List<Student> stu = List.of(student1,student2);
//        List<Subject> subject = List.of(sub1,sub2,sub3);
        
        List<Student> stu = new ArrayList<>();
        stu.add(student1);
        stu.add(student2);

        List<Subject> subject = new ArrayList<>();
        subject.add(sub1);
        subject.add(sub2);
        subject.add(sub3);
        
        // student ---> subject
        student1.setSubjects(subject);
        student2.setSubjects(subject);
        
        // subject ---> student
        sub1.setStudent(stu);
        sub2.setStudent(stu);
        sub3.setStudent(stu);
        
        et.begin();
        em.persist(student1);
        em.persist(student1);
        et.commit();
        
        em.clear();
    }
}