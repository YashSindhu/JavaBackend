package com.capgemini;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DoctorDAO {

    public void save(Doctor d) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(d);
        tx.commit();
        em.close();
    }

    public Doctor find(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Doctor d = em.find(Doctor.class, id);
        em.close();
        return d;
    }

    public void update(Doctor d) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(d);
        tx.commit();
        em.close();
    }
}
