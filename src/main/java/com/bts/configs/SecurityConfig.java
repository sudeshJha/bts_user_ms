package com.bts.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
		http
	    .csrf(csrf -> csrf.disable()) 
	    .formLogin(form -> form.disable()) // Ye line is login page ko hata degi
	    .authorizeHttpRequests(auth -> auth
	        .requestMatchers("/**").permitAll() // Abhi ke liye sab open karne ke liye
	    );
		
		return http.build();
	}
}
