package com.mappingAssignment;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class AppointmentDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveAppointment(Appointment appointment) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(appointment);
        et.commit();
        em.close();
    }

    public List<Appointment> findAppointmentByDoctor(int doctorId) {
        EntityManager em = emf.createEntityManager();

        String jpql = "SELECT a FROM Doctor d JOIN d.appointments a WHERE d.id = :id";
        List<Appointment> list =
                em.createQuery(jpql, Appointment.class)
                  .setParameter("id", doctorId)
                  .getResultList();

        em.close();
        return list;
    }

    public void updateFee(int id, double newFee) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Appointment a = em.find(Appointment.class, id);
        et.begin();
        a.setFee(newFee);
        et.commit();
        em.close();
    }
}

