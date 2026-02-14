package com.mappingAssignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class DoctorDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveDoctor(Doctor doctor) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(doctor);
        et.commit();
        em.close();
    }

    public Doctor findDoctor(int id) {
        EntityManager em = emf.createEntityManager();
        Doctor d = em.find(Doctor.class, id);
        em.close();
        return d;
    }
}
