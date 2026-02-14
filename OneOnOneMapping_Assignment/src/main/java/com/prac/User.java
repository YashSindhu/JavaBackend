package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class User {
    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();

        // Save AadharCard
        AadharCard aadhar = new AadharCard();
        aadhar.setAadharId(102);
        aadhar.setAadharNumber("1234-5678-9999");
        aadhar.setAddress("Haryana");
        aadhar.setIssueDate("2018");
        em.persist(aadhar);

        // Save HostelRoom
        HostelRoom room = new HostelRoom();
        room.setRoomId(202);
        room.setRoomNumber("B-611");
        room.setBlockName("B");
        room.setFloorNumber(6);
        em.persist(room);

        // Create Student and associate
        Student student = new Student();
        student.setStudentId(2);
        student.setName("Aryan");
        student.setEmail("aryan@gmail.com");
        student.setBranch("CSE");
        student.setAadhar(aadhar);
        student.setHostelRoom(room);

        em.persist(student);
        tx.commit();

        // Fetch Student
        Student s = em.find(Student.class, 2);

        s.getStudentId();
        s.getName();
        s.getEmail();
        s.getBranch();

        AadharCard a = s.getAadhar();
        a.getAadharId();
        a.getAadharNumber();
        a.getAddress();
        a.getIssueDate();

        HostelRoom h = s.getHostelRoom();
        h.getRoomId();
        h.getRoomNumber();
        h.getBlockName();
        h.getFloorNumber();

        System.out.println(s.getName());
        System.out.println(a.getAadharNumber());
        System.out.println(h.getRoomNumber());

//         Delete Student ONLY
        Student s1 = em.find(Student.class, student.getStudentId());

        tx.begin();
        em.remove(s1);
        tx.commit();

        em.close();
        emf.close();
    }
}
