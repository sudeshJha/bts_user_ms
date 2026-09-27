package com.bts.auth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bts.auth.models.User;
import com.bts.auth.models.UserType;
import com.bts.auth.repos.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User userSignup(User user) {
		user.setUserType(UserType.PASSENGER);
		user = userRepo.save(user);
		user.setPassword(null);
		return user;
	}
	
	public boolean checkEmailExist(String email) {
		return userRepo.existsByEmail(email);
	}
	
	public boolean checkPhoneExist(String phone) {
		return userRepo.existsByPhone(phone);
	}
}
