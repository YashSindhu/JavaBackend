package com.university;

import javax.persistence.*;

public class InstructorDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveInstructor(Instructor instructor) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(instructor);
        et.commit();
        em.close();
    }

    public Instructor findInstructor(int id) {
        EntityManager em = emf.createEntityManager();
        Instructor instructor = em.find(Instructor.class, id);
        em.close();
        return instructor;
    }

    public void updateInstructor(int id, String department) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        Instructor instructor = em.find(Instructor.class, id);
        instructor.setDepartment(department);
        et.commit();
        em.close();
    }

    public void deleteInstructor(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        Instructor instructor = em.find(Instructor.class, id);
        em.remove(instructor);
        et.commit();
        em.close();
    }
}
