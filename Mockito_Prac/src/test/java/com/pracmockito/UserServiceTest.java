package com.pracmockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;

import com.users.Calculator;
import com.users.MathService;
import com.users.UserDao;
import com.users.UserService;

public class UserServiceTest {
	@Test
	public void testGetTypeOfCustomer() {
		UserDao userdao=new UserDao();
		UserService userService=new UserService(userdao);
		String actual= userService.typeOfUser(1);
		assertEquals("regular user",actual);
	}
	
//	@Test
//	public void testDoubleAddition() {
//		//Step 1: createFakeObject
//		Calculator calmock=mock(Calculator.class);
//		//Step 2: what mock object should return
//		when(calmock.add(5, 5)).thenReturn(20);
//		//Step 3: inject the mock ref
//		MathService service = new MathService(calmock);
//		int res = service.doubleAddition(5, 5);
//		
//		assertEquals(20,res);
//		
//	}
}
