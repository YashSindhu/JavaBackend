package com.capgemini;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class DepartmentDAO {

    public void save(Department d) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.persist(d);
        tx.commit();
        em.close();
    }

    public Department find(Long id) {
        EntityManager em = JPAUtil.getEntityManager();
        Department d = em.find(Department.class, id);
        em.close();
        return d;
    }

    public void update(Department d) {
        EntityManager em = JPAUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();

        tx.begin();
        em.merge(d);
        tx.commit();
        em.close();
    }
}
