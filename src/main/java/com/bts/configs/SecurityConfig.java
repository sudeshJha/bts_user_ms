package com.bts.configs;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
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
	
	@Bean
	public AuthenticationProvider  authenticationProvider(UserDetailsService userDetailsService, PasswordEncoder passwordEncoder) {
	    DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider(userDetailsService);
	    authProvider.setPasswordEncoder(passwordEncoder);       // Aapka BCrypt yahan jud jayega
	    return authProvider;
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationProvider authenticationProvider) {
	    // Yeh direct ProviderManager return karega jisme koi loop/circular dependency nahi hoti
	    return new ProviderManager(authenticationProvider);
	}

}
