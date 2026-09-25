package com.user.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.user.dtos.ApiResponse;
import com.user.dtos.UserDto;
import com.user.models.User;
import com.user.services.UserService;

@RestController
public class AuthRestController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/signup")
	public ApiResponse<User> signup(@RequestBody UserDto userDto) {
		
		User user = new User();
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPhone(userDto.getPhone());
		user.setPassword(userDto.getPassword());
		
		user = userService.userSignup(user);
		
		ApiResponse<User> response = new ApiResponse<User>();
		response.setMessage("Signup Successful");
		response.setResponse(user);
		
		return response;
	}
	
}
