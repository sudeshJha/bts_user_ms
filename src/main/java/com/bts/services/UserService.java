package com.bts.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.bts.models.Status;
import com.bts.models.User;
import com.bts.models.UserType;
import com.bts.repos.UserRepo;
import com.bts.utils.FileUtil;
import com.bts.utils.PasswordUtil;
import com.bts.utils.RandomUUID;


@Service
public class UserService implements UserDetailsService{
	
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
		String verificationLink = apiLink + "/verify_user?email=" + user.getEmail() + "&verificationCode=" + verificationCode;
		
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
	
	public boolean verifyUser(String email, String verificationCode) {
		User user = userRepo.getByEmail(email);
		
		if(user.getVerificationCode().equals(verificationCode)) {
			user.setVerificationCode(null);
			user.setStatus(Status.ACTIVE);
			userRepo.save(user);
			return true;
		}else {
			System.out.println(user.getEmail());
			System.out.println(user.getVerificationCode());
			System.out.println(verificationCode);
			System.out.println("Cannot verify the user");
			return false;
		}
	}
	
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        
        User user = userRepo.findByEmail(username)
                .orElseThrow(() -> new UsernameNotFoundException("Email is not registered"));

        return new org.springframework.security.core.userdetails.User(
                user.getEmail(),           
                user.getPassword(),       
                Collections.emptyList()
        );
    }
    
    public User getUserByEmail(String email) {
    	return userRepo.getByEmail(email);
    }
}
