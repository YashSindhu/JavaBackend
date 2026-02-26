package com.capgemini;


import javax.persistence.EntityManager;

public class MedicalRecordDAO {

    public MedicalRecord find(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        MedicalRecord r = em.find(MedicalRecord.class, id);
        em.close();
        return r;
    }
}
