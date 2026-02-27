package com.prac;

import java.util.ArrayList;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Person {
	// Dependency Injection
//	@Autowired // field Injection
	private Mobile mobile;
	
	@Autowired
	private Scanner scan;
	
	@Autowired
//	private ArrayList<String> items;
	
	// Constructor Injection
	public Person(Mobile mobile) {
		this.mobile = mobile;
	}
	
	
	
//	public ArrayList<String> getItems() {
//		return items;
//	}


//	public void setItems(ArrayList<String> items) {
//		this.items = items;
//	}


	public Scanner getScan() {
		return scan;
	}

	// we cam use @Autowired here that is known as Setter Injection
//	@Autowired
	public void setScan(Scanner scan) {
		this.scan = scan;
	}


	public Mobile getMobile() {
		return mobile;
	}


	public void setMobile(Mobile mobile) {
		this.mobile = mobile;
	}


	public void message() {
		System.out.println("Hi");
	}
	
}
