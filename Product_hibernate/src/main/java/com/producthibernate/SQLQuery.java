package com.producthibernate;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

public class SQLQuery {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
//		String sql = "Select * from product";
//		Query query = em.createNativeQuery(sql, Product.class);
//
//		List<Product> list = query.getResultList();
//
//		list.forEach(i->System.out.println(i.getName()));
		
		String jpql = "SELECT p FROM Product p WHERE p.price >=:a and p.quantity>=:b";
		Query query = em.createQuery(jpql);
		query.setParameter("a", 5.0);
		query.setParameter("b", 0);
		
		List<Product> list = query.getResultList();
		for(Product p:list) {
			System.out.println(p);
		
		em.close();
		emf.close();
		
		}
	}
}
