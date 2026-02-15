package com.university;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class InstructorProfileDAO {

    private EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("postgres");

    public void saveProfile(InstructorProfile profile) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(profile);
        et.commit();

        em.close();
    }

    public InstructorProfile findProfile(int id) {

        EntityManager em = emf.createEntityManager();

        InstructorProfile profile =
                em.find(InstructorProfile.class, id);

        em.close();
        return profile;
    }

    public void updatePhone(int id, String phone) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        InstructorProfile profile =
                em.find(InstructorProfile.class, id);

        if (profile != null) {
            profile.setPhone(phone);
        }

        et.commit();
        em.close();
    }

    public void deleteProfile(int id) {

        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();

        InstructorProfile profile =
                em.find(InstructorProfile.class, id);

        if (profile != null) {
            em.remove(profile);
        }

        et.commit();
        em.close();
    }
}
