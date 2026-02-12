package com.learnjdbc;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import com.connectdatabase.EvenOrOdd;
import com.connectdatabase.Program;

public class ProgramTest {
	
//	@Test // we are having parameter in test so use paramaterized test
//	@ParameterizedTest
//	@ValueSource(strings= {"tenet","radar","aba","abcd"})
//	public void isPalindromeTest(String str) {
//		Program p = new Program();
//		assertTrue(p.isPalindrome(str));
//	}
	
//	@ParameterizedTest
//	@CsvSource({
//		"1,2,3",
//		"5,5,10",
//		"5,3,8"
//	})
//	public void addTest(int a, int b, int expectedRes) {
//		Program p = new Program();
//		int actualRes = p.add(a, b);
//		assertEquals(expectedRes, actualRes);
//	}
	
	@ParameterizedTest
	@CsvFileSource(resources = "/capgemini.csv",numLinesToSkip = 1)
	public void evenoroddTest(String input, String expectedRes) {
		EvenOrOdd eoo = new EvenOrOdd();
		String actualres = eoo.evenOrOdd(Integer.parseInt(input));
		assertEquals(expectedRes,actualres);
	}
}
