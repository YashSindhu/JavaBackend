package com.capgemini;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class AppointmentDAO {

    public void save(Appointment a) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(a);
        tx.commit();
        em.close();
    }

    public Appointment find(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Appointment a = em.find(Appointment.class, id);
        em.close();
        return a;
    }

    public void update(Appointment a) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(a);
        tx.commit();
        em.close();
    }
}