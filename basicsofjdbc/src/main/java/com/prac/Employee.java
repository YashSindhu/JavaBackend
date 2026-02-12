package com.prac;

public class Employee {
	private int id;
	private String name;
	private int age;
	private String branch;
	public Employee(int id, String name, int age, String branch) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.branch = branch;
	}
	public boolean isValidAge() {
		if(age > 17) {
			return true;
		}else {
			return false;
		}
	}
	
	public boolean isValidBranch() {
		if (branch.length() <= 1) {
			return false;
		}for (char c : branch.toCharArray()) {
	        if (!Character.isLetter(c)) {
	            return false;
	        }
		}
		return true;
	}
}
