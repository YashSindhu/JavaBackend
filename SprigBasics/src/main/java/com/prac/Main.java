package com.prac;

import java.util.List;
import java.util.Map;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
//		Employee e = ioc.getBean(Employee.class);
//		System.out.println(e);
//		System.out.println(e.getId());
//		System.out.println(e.getName());
//		
		
		Person person = ioc.getBean(Person.class);
		System.out.println(person);
		System.out.println(person.getMobile());
		List<String> list = ioc.getBean(List.class);
		System.out.println(list);
		
		System.out.println(ioc.getBean("getMap",Map.class));
		
//		System.out.println(ioc.getBean(Mobile.class));
//		System.out.println(person.getScan());
		
//		System.out.println(person.getItems());
		
		
		
	}
}
