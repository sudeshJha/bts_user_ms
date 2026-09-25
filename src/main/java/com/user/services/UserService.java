package com.user.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.models.User;
import com.user.models.UserType;
import com.user.repos.UserRepo;

@Service
public class UserService {
	
	@Autowired
	private UserRepo userRepo;
	
	public User userSignup(User user) {
		user.setUserType(UserType.PASSENGER);
		user = userRepo.save(user);
		return user;
	}
	
	public boolean checkEmailExist(String email) {
		return userRepo.existsByEmail(email);
	}
	
	public boolean checkPhoneExist(String phone) {
		return userRepo.existsByPhone(phone);
	}
}
