package com.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.dtos.UserDto;
import com.user.models.User;
import com.user.services.UserService;

@RestController
public class AuthRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public String signup(@RequestBody UserDto userDto) {
		
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());
		user.setPassword(userDto.getPassword());
		
		userService.userSignup(user);
		
		return "signup succesful";
	}
	
}
