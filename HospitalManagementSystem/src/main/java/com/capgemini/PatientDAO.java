package com.capgemini;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class PatientDAO {

    public void save(Patient p) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(p);
        tx.commit();
        em.close();
    }

    public Patient find(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Patient p = em.find(Patient.class, id);
        em.close();
        return p;
    }

    public void update(Patient p) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(p);
        tx.commit();
        em.close();
    }

    public void delete(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        Patient p = em.find(Patient.class, id);
        if (p != null) {
            tx.begin();
            em.remove(p);
            tx.commit();
        }
        em.close();
    }

    public List<Patient> findAll() {
        EntityManager em = JPAUtil.getEntityManager();
        List<Patient> list = em.createQuery("from Patient", Patient.class).getResultList();
        em.close();
        return list;
    }
}
