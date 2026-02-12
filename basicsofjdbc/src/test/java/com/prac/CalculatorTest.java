package com.prac;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	public  void addTest() {
		int res = Calculator.add(20, 30);
	}
	
	
	//@Test
	public void reverseTest() {
		String actualres = Calculator.reverseString("Data");
		// ataD -> taD
		assertEquals("ataD",actualres);
	}
	
	//@Test
	public void reverseTestNull() {
		String actualRes = Calculator.reverseString(null);
		assertEquals("llun",actualRes);
	}
	
	@Test
	public void testValidAge() {
		Employee e = new Employee(10,"Allen",19,"CSE");
		
		assertTrue(e.isValidAge());
	}
	
	@Test
	public void testValidBranch() {
		Employee e = new Employee(10,"Allen",18,"C");
		assertFalse(e.isValidBranch());
	}
	
	@Test
	public void testAEEx() {
		Calculator c = new Calculator();
		assertThrows(ArithmeticException.class,() -> {c.div(10,0);});
	}
}
