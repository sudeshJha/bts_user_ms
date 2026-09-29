package com.bts.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bts.models.User;
import com.bts.models.UserType;
import com.bts.repos.UserRepo;
import com.bts.utils.FileUtil;
import com.bts.utils.PasswordUtil;
import com.bts.utils.RandomUUID;


@Service
public class UserService {
	
	@Value("${api.url.path}")
	private String apiLink;
	
	@Autowired
	private EmailService emailService; 
	
	@Autowired
	private PasswordUtil passwordUtil;
	
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private FileUtil fileUtil;
	
	@Value("${file.upload.directory}")
	private String uploadPath;

	public User userSignup(User user) {
//		encrypting password
		String encryptedPassword = passwordUtil.encode(user.getPassword());
		user.setPassword(encryptedPassword);
		
//		generate verification link for user
		String verificationCode= RandomUUID.get();
		user.setVerificationCode(verificationCode);
		String verificationLink = apiLink + "verify?email=" + user.getEmail() + "&verificationCode=" + verificationCode;
		
//		send email to the user
		emailService.sendVerificationMail(user.getName(), user.getEmail(), verificationLink);
 		
//		save user in database
		user = userRepo.save(user);
		
		
//		creating user directory
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
