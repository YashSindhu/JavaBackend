package com.securityPractice.SpringSecurityDBConnection.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.securityPractice.SpringSecurityDBConnection.DTO.AccountRequestDTO;
import com.securityPractice.SpringSecurityDBConnection.DTO.AccountResponseDTO;
import com.securityPractice.SpringSecurityDBConnection.Entity.Account;
import com.securityPractice.SpringSecurityDBConnection.Service.AccountService;

@RestController
public class AccountController {
	private AccountService service;

	public AccountController(AccountService service) {
		this.service = service;
	}
	
	@PostMapping("/public")
	public AccountResponseDTO create(@RequestBody AccountRequestDTO dto) {
		System.out.println("Account created");
		return service.createAccount(dto);
	}
	
	@GetMapping("/find-id/{id}")
	public AccountResponseDTO getById(@PathVariable Long id) {
		AccountResponseDTO a=service.getById(id);
		return a;
	}
	
	

}
