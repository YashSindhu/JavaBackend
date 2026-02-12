package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo2 {
	public static void main(String[] args) {
EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		
		EntityManager em = emf.createEntityManager();
		
		// Entity Transaction
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, 1);
		
		et.begin();
		em.remove(s);
		et.commit();
		emf.close();
	}
}
