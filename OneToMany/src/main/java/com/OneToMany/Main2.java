package com.OneToMany;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class Main2 {
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		String sqlDelete = "DELETE FROM coll_studentt WHERE student_sid = ?1";
		String sql1 = "DELETE FROM studentt WHERE sid = ?1";
		Query del_coll_student = em.createNativeQuery(sqlDelete);
		Query delete_student = em.createNativeQuery(sql1);
		del_coll_student.setParameter(1, 101);
		delete_student.setParameter(1, 101);
		et.begin();
		del_coll_student.executeUpdate();
		delete_student.executeUpdate();
		et.commit();
	}
}
