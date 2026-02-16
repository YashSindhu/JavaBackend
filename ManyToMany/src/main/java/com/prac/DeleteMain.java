package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DeleteMain {

    public static void main(String[] args) {

        EntityManagerFactory emf =
                Persistence.createEntityManagerFactory("postgres");

        EntityManager em = emf.createEntityManager();

        SubjectDAO dao = new SubjectDAO(em);

        // Check actual id in DB before deleting
        int subjectIdToDelete = 2;

        dao.deleteSubjectById(subjectIdToDelete);

        em.close();
        emf.close();

        System.out.println("Subject deleted successfully");
    }
}
