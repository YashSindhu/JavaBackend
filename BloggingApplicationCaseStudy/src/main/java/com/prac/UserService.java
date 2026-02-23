package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class UserService {

    private EntityManager em;

    public UserService(EntityManager em) {
        this.em = em;
    }

    public User registerUser(User user) {
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(user);
        tx.commit();
        return user;
    }

    public User getUser(Long id) {
        return em.find(User.class, id);
    }
}