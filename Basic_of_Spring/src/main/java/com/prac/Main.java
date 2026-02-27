package com.prac;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ioc = new ClassPathXmlApplicationContext("config.xml");
		Person person = ioc.getBean("person", Person.class); // made generic type by doing comma person.class
		System.out.println(person);
		person.message();
		
		Employee e = ioc.getBean("employee",Employee.class);
		System.out.println(e);
		System.out.println(e.getId());
		System.out.println(e.getName());
		System.out.println(e.getSalary());
		
	}
}

