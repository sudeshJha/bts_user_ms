package com.bts.services;

import java.io.File;
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
import com.bts.utils.FileUtil;


@Service
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private FileUtil fileUtil;
	
	@Value("${file.upload.directory}")
	private String uploadPath;

	public User userSignup(User user) {
		user.setUserType(UserType.PASSENGER);
		user = userRepo.save(user);
		
		fileUtil.createUserDirectory(user.getUserId());
		
		return user;
	}

	public boolean checkEmailExist(String email) {
		return userRepo.existsByEmail(email);
	}

	public boolean checkPhoneExist(String phone) {
		return userRepo.existsByPhone(phone);
	}
}
