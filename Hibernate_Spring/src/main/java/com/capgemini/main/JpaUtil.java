package com.capgemini.main;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.springframework.stereotype.Component;

@Component
public class JpaUtil {

	private EntityManagerFactory emf;
	private EntityManager entityManager;

	@PostConstruct
	public void createConnection() {
		emf = Persistence.createEntityManagerFactory("postgres");
		entityManager = emf.createEntityManager();
		System.out.println("Connected");
	}

//	@PostConstruct
	@PreDestroy
	public void print() {
		entityManager.close();
		emf.close();
		System.out.println("Connecton closed");
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

}