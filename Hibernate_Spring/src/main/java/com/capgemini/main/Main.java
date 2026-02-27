package com.capgemini.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.capgemini.ProjectConfiguration;
import com.capgemini.dto.Employee;

public class Main {
	// single ton --> one object
	public static void main(String[] args) {
		
		ApplicationContext ioc= new AnnotationConfigApplicationContext(ProjectConfiguration.class);
		
//		Employee e1 = ioc.getBean(Employee.class);
//		Employee e2 = ioc.getBean(Employee.class);
//		e2.setName("Miller");
//		System.out.println(e1);
//		System.out.println(e2);
//		System.out.println(e1 == e2);
		
		AnnotationConfigApplicationContext ac=(AnnotationConfigApplicationContext)ioc;
		ac.close(); 
	}
}
