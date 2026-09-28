package com.bts.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bts.models.User;
import com.bts.models.UserType;
import com.bts.repos.UserRepo;

@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Value("${file.upload.directory}")
	private String uploadPath;

	public User userSignup(User user) {
		user.setUserType(UserType.PASSENGER);
		user = userRepo.save(user);
		user.setPassword(null);
		
		String userId = user.getUserId().toString();
		Path path = Paths.get(uploadPath + userId);
		
		try {
			Files.createDirectories(path);
		}catch(IOException exp) {
			System.out.println("User Directory " + userId + " already exsits");
		}
		
		return user;
	}

	public boolean checkEmailExist(String email) {
		return userRepo.existsByEmail(email);
	}

	public boolean checkPhoneExist(String phone) {
		return userRepo.existsByPhone(phone);
	}
}
