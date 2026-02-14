package com.mappingAssignment;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class PatientDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void savePatient(Patient patient) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(patient);
        et.commit();
        em.close();
    }

    public Patient findPatient(int id) {
        EntityManager em = emf.createEntityManager();
        Patient p = em.find(Patient.class, id);
        em.close();
        return p;
    }

    public void updatePatient(int id, String contact) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Patient p = em.find(Patient.class, id);
        et.begin();
        p.setContact(contact);
        et.commit();
        em.close();
    }

    public void deletePatient(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Patient p = em.find(Patient.class, id);
        et.begin();
        em.remove(p);
        et.commit();
        em.close();
    }
}

