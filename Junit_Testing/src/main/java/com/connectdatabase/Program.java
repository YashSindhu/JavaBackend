package com.connectdatabase;

public class Program {
	public boolean isPalindrome(String str) {
		StringBuilder r = new StringBuilder(str);
		
		return (r.reverse().toString().equals(str)) ? true : false;
	}
	
	public int add(int a, int b) {
		return a+b;
	}
	
}
