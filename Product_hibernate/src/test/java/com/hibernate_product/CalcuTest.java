package com.hibernate_product;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.producthibernate.Calculate;

public class CalcuTest {
	@Test
	public void divideTest() {
		Calculate c = new Calculate();
		int actualRes = c.divide(10, 2);
		assertEquals(5,actualRes);
	}
	@Test
	public void divideZeroTest() {
		Calculate c = new Calculate();
		int actualRes = c.divide(10, 0);
		assertEquals(0,actualRes);
	}
}
