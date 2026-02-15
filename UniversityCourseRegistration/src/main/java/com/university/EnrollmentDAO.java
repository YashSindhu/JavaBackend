package com.university;

import javax.persistence.*;

public class EnrollmentDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveEnrollment(Enrollment enrollment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(enrollment);
        et.commit();
        em.close();
    }

    public void updateGrade(int id, String grade) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        Enrollment enrollment = em.find(Enrollment.class, id);
        enrollment.setGrade(grade);
        et.commit();
        em.close();
    }
}
