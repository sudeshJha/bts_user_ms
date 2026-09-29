package com.bts.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class PasswordUtil {
	
	@Autowired
	private PasswordEncoder passwordEncoder;

	public String encode(String password) {
		return passwordEncoder.encode(password);
	}
	
	public Boolean match(String password, String encryptedPassword) {
		return passwordEncoder.matches(password, encryptedPassword);
	}
}
