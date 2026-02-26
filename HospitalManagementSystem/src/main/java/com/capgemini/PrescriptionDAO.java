package com.capgemini;


import javax.persistence.EntityManager;

public class PrescriptionDAO {

    public Prescription find(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Prescription p = em.find(Prescription.class, id);
        em.close();
        return p;
    }
}