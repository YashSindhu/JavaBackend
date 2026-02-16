package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class FetchMain {
	public static void main(String[] args) {

		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();

		Person p = em.find(Person.class, 1);
		System.out.println(p.getPassport().getName());

		Passport pa = em.find(Passport.class, 101);
		System.out.println(pa.getPerson().getName());

	}
}
