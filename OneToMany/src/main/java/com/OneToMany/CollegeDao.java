package com.OneToMany;

import java.util.List;
import javax.persistence.*;

public class CollegeDao {

    EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");

    // CREATE
    public void saveCollege(College college) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        et.begin();
        em.persist(college);
        et.commit();

        em.close();
    }

    // READ
    public College findCollege(int id) {
        EntityManager em = emf.createEntityManager();
        College college = em.find(College.class, id);
        em.close();
        return college;
    }

    // UPDATE
    public void updateCollege(int id, String newName) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        College college = em.find(College.class, id);

        et.begin();
        college.setName(newName);
        et.commit();

        em.close();
    }

    // DELETE
    public void deleteCollege(int id) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        College college = em.find(College.class, id);

        et.begin();
        em.remove(college);
        et.commit();

        em.close();
    }
}
