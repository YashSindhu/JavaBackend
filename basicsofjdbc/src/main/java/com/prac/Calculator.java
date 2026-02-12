package com.prac;

public class Calculator {
	public static int add(int a, int b) {
		return a+b;
	}
	
	public static String reverseString(String data) {
//		if(data == null) {
//			return "llun";
//		}
		String rev = "";
		for(int i = data.length()-1;i>=0;i--) {
			rev += data.charAt(i);
		}
		return rev;
	}
	
	public static int div(int a, int b) {
		return a/b;
	}
	// Junit:-(Unit testing framework)
	// 
	
}
