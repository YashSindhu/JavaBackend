package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class SubjectDAO {

    private EntityManager em;

    public SubjectDAO(EntityManager em) {
        this.em = em;
    }

    public void deleteSubjectById(int id) {

        EntityTransaction et = em.getTransaction();
        et.begin();

        // Step 1: delete from join table
        em.createNativeQuery(
            "DELETE FROM stud1_subject WHERE subjects_id = ?")
          .setParameter(1, id)
          .executeUpdate();

        // Step 2: delete subject
        Subject subject = em.find(Subject.class, id);
        if (subject != null) {
            em.remove(subject);
        }

        et.commit();
    }
}
