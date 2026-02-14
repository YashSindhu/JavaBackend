package com.OneToMany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Main {
	
	
	public static void main(String[] args) {
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres");
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		Student s1 = new Student();
		s1.setSid(105);
		s1.setBranch("CSE");
		s1.setName("Virat");
		
		Student s2 = new Student();
		s2.setSid(106);
		s2.setBranch("ECE");
		s2.setName("Mohit");
		
		Student s3 = new Student();
		s3.setSid(107);
		s3.setBranch("Mech");
		s3.setName("Rohit");
		
		College c = new College();
		
		c.setId(2);
		c.setName("XYZ");
		c.setLocation("Jalandhar");
		c.setPincode("0001");
		
		List<Student> list = new ArrayList<>();
		list.add(s1);
		list.add(s2);
		list.add(s3);
		c.setStudent(list);
		
		et.begin();
		em.persist(c);
		em.persist(s1);
		em.persist(s2);
		em.persist(s3);
		et.commit();
		
		
		
	}
}
