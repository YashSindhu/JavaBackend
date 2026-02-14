package com.OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main3 {

    public static void main(String[] args) {

        EntityManagerFactory emf =Persistence.createEntityManagerFactory("postgres");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        // Delete from join table first
        String sql2 = "DELETE FROM coll_studentt WHERE College_id = ?1";

        // Then delete from college table
        String sql1 = "DELETE FROM coll WHERE id = ?1";

        Query q2 = em.createNativeQuery(sql2);
        Query q1 = em.createNativeQuery(sql1);

        q2.setParameter(1, 1);   // college id
        q1.setParameter(1, 1);

        et.begin();
        q2.executeUpdate();   // delete relationship rows
        q1.executeUpdate();   // delete college
        et.commit();

        em.close();
        emf.close();

        System.out.println("College deleted successfully");
    }
}
