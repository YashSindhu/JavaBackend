package com.securityPractice.SpringSecurityDBConnection.Service;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.securityPractice.SpringSecurityDBConnection.DTO.AccountRequestDTO;
import com.securityPractice.SpringSecurityDBConnection.DTO.AccountResponseDTO;
import com.securityPractice.SpringSecurityDBConnection.Entity.Account;
import com.securityPractice.SpringSecurityDBConnection.Repo.AccountJpaRepository;

@Service
public class AccountService {
	
	private AccountJpaRepository jpa;
	
	private PasswordEncoder encode;

	public AccountService(AccountJpaRepository jpa, PasswordEncoder encode) {
		this.jpa = jpa;
		this.encode = encode;
	}
	
	public AccountResponseDTO createAccount(AccountRequestDTO dto) {
		if(jpa.existsByUsername(dto.getUsername())) {  //This is for if the username is already existing
			throw new RuntimeException("Username Exist");
		}
		if(jpa.existsByEmail(dto.getEmail())) {
			throw new RuntimeException("Email already exist");
		}
		
		Account account = new Account();
		account.setUsername(dto.getUsername());
		account.setCreatedAt(dto.getCreatedAt());
		account.setEmail(dto.getEmail());
		account.setFullname(dto.getFullname());
		account.setPassword(encode.encode(dto.getPassword()));
		account.setPhone(dto.getPhone());
		
		//For role there are only 2 role, admin and user, and Spring security understands the role in this format only (ROLE_USER,ROLE_ADMIN) so we need to convert the data that is sent from frontend to this type and then it needs to be saved in Database.
		//So we cannot pass like this, we have to do this separately
		//account.setRole(dto.getRole());
		account.setRole(normalizeAndValidateRole(dto.getRole()));
		
		//Till here we have created the Account now we want to send the response but not all the details should be send so we will create the request to response
		jpa.save(account);
		return toResponse(account);
		
		
	}
	
	public String normalizeAndValidateRole(String role) {
		if(role==null || role.trim().isEmpty()) {
			return "ROLE_USER";
		}
		
		String r = role.trim().toUpperCase();
		if(!r.startsWith("ROLE_")) {
			r="ROLE_"+r;
		}
		
		if(!(r.equalsIgnoreCase("ROLE_USER") || r.equalsIgnoreCase("ROLE_ADMIN"))) {
			throw new RuntimeException("Invalid Role for Authorization");
		}
		return r;
		
	}
	

	
	public AccountResponseDTO toResponse(Account a) {
		AccountResponseDTO response = new AccountResponseDTO();
		response.setUsername(a.getUsername());
		response.setEmail(a.getEmail());
		response.setPhone(a.getPhone());
		response.setFullname(a.getFullname());
		return response;
	}
	
	
	public AccountResponseDTO getById(long id) {
		Account a = jpa.findById(id).orElseThrow(()->new RuntimeException("Id not found"));
		return toResponse(a);
	}
}
