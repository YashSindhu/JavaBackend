package com.practice;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class Demo {
	public static void main(String[] args) {
//		Persistence.createEntityManagerFactory("postgres");
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("postgres"); // opeining closing
		EntityManager mm =emf.createEntityManager();
		
		//Entity transaction interface
		EntityTransaction et= mm.getTransaction(); // data saving begin commit
		
		
		Student s= new Student();
		s.setId(2);
		s.setName("Yash");
		s.setPercentage(80.4);
		
		Employee e = new Employee();
		e.setId(1);
		e.setName("Yash");
		e.setPercentage(70);
		
		et.begin();
		mm.persist(s);
//		mm.persist(e);
		et.commit();
		emf.close();
	}
}
