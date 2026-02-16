package com.prac;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	public static void main(String[] args) {
		  EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	      EntityManager em = emf.createEntityManager();
	      EntityTransaction et = em.getTransaction();
	      
	      Passport passport = new Passport();
	      passport.setId(101);
	      passport.setName("Miller");
	      passport.setCitizen("Indian");
	      passport.setDob("23/09/1995");
	      
	      Person person = new Person();
	      person.setId(1);
	      person.setName("Allen");
	      
	      
	      person.setPassport(passport);
	      passport.setPerson(person);
	      
	      et.begin();
	      em.persist(person);
	      et.commit();
	      
	}
}
