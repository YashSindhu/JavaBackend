package com.onetoonemappinng;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class User {
	public static void main(String[] args) {
//		insertCarAndEngine();
//		findCarById();		
		deleteEngineById(200);

		
	}
	public static void findCarById() {
			EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
			EntityManager em = emf.createEntityManager();
			EntityTransaction et = em.getTransaction();
			Car c = em.find(Car.class, 1);
			System.out.println(c);
			System.out.println(c.getEngine().getCc());
	}
	
	public static void deleteEngineById(int id) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		et.begin();

	    Query q1 = em.createQuery(
	        "UPDATE Car c SET engine_id = NULL WHERE engine_id = ?1"
	    );
	    
	    q1.setParameter(1, id);
	    q1.executeUpdate();

	    Query q2 = em.createQuery(
	        "DELETE FROM Engine e  WHERE id = ?1"
	    );
	    q2.setParameter(1, id);
	    q2.executeUpdate();

	    et.commit();

	    System.out.println("Engine deleted successfully");	
	    
	}
		
	public static void insertCarAndEngine() {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Engine e = new Engine();
		e.setId(200);
		e.setType("V8");
		e.setFuelType("Petrol");
		e.setMileage("12");
		e.setCc("3000");
		
		Car c = new Car();
		c.setId(2);
		c.setModealYear("Volkswagan");
		c.setModel("Polo GT10");
		c.setModealYear("2019");
		c.setPrice(100000000);
		c.setEngine(e);
		
		et.begin();
		em.persist(e);
		em.persist(c);
		et.commit();
	}}
