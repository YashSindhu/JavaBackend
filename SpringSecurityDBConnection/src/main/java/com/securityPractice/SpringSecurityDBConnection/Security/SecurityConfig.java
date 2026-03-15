package com.securityPractice.SpringSecurityDBConnection.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
	
	@Bean
	public PasswordEncoder encode() {  //It is used to encrypt the password.
		return new BCryptPasswordEncoder();   
	}
	
	
	@Bean
	public SecurityFilterChain filter(HttpSecurity http) throws Exception {
		return http.
				cors(cors->{}).//cors enable
				csrf(csrf->csrf.disable())
				   .authorizeHttpRequests(auth->auth
				   .requestMatchers("/swagger-ui.html").permitAll()
				   .requestMatchers("/actuator/beans","/actuator/sessions").permitAll()
				   .requestMatchers("/actuator/**").permitAll() 
				   .requestMatchers("/public").permitAll()
				   .requestMatchers("/admin/**").hasRole("ADMIN")  //("/admin/**") this represents admin/anything that can be an endpoint
				   .anyRequest().authenticated())
				   .httpBasic(Customizer.withDefaults()).build();
	}

}
