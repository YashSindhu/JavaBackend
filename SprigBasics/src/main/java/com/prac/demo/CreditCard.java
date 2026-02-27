package com.prac.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
//@Primary
public class CreditCard implements Payment{

	@Override
	public void send() {
		// TODO Auto-generated method stub
		System.out.println("Sent by CC");
	}

}
