package com.ManyToOne;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main1 {
	public static void main(String[] args) {
		 EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
	     EntityManager em = emf.createEntityManager();
	     EntityTransaction et = em.getTransaction();
	     String sql1 = "UPDATE employee SET department_id = null WHERE department_id = ?1";
	     String sql2 = "DELETE FROM department WHERE id = ?1";
	     
	     Query updateQuery = em.createNativeQuery(sql1);
	     updateQuery.setParameter(1,1);
	      
	     Query deleteQuery = em.createNativeQuery(sql2);
	     deleteQuery.setParameter(1, 1);
	     
	     et.begin();
	     updateQuery.executeUpdate();
	     deleteQuery.executeUpdate();
	     et.commit();
	     em.close();
	     emf.close();
	     
	        
	}
}
