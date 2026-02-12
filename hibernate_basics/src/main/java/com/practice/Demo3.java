package com.practice;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo3 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Student s = em.find(Student.class, 2);
		
		if(s!=null) {
			s.setDob("01/07/2004");
			et.begin();
			em.merge(s);
			et.commit();
			emf.close();
			
		}
	}
}
