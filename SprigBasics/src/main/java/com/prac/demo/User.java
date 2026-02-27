package com.prac.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.prac.DemoConfiguration;

@Component
public class User {
	@Autowired
	@Qualifier("creditCard") // This is having more priority
	private Payment payment;
	
	public void display() {
		payment.send();
	}
	public static void main(String[] args) {
		ApplicationContext ioc = new AnnotationConfigApplicationContext(DemoConfiguration.class);
		User u = ioc.getBean(User.class);
		System.out.println(u);
		u.display();
	}
	
}
